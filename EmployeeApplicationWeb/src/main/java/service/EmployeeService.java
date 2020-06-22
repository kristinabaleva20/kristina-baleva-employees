package service;

import exceptions.FileFormatException;
import model.Employee;
import model.EmployeeBuilder;
import utility.DataValidator;
import utility.DateGenerator;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import static constants.FileConstants.*;

public class EmployeeService {

    private Map<Integer, List<Employee>> employees = new HashMap<>();

    public Map<Integer, List<Employee>> readFile(String filePath) throws IOException, FileFormatException {
        File file = new File(filePath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while((line = bufferedReader.readLine())!=null){
                line = line.trim();
                List<String>properties = Arrays.stream(line.split(REGEX_CONTENT_SEPARATOR)).map(String::trim).collect(Collectors.toList());
                DataValidator.validateFileContent(properties);
                fillMap(properties);
            }
        return employees;
    }

    private void fillMap(List<String> properties) throws FileFormatException {
        List<Employee> employeeList;
        Employee employee = buildEmployee(properties);
        int projectId = employee.getProjectId();

        if(employees.containsKey(projectId)) {
            employeeList = employees.get(projectId);
            employeeList = updateEmployeeList(employeeList,employee);
            employees.put(projectId, employeeList);
        }
        else{
            employeeList = new ArrayList<>();
            employeeList.add(employee);
            employees.put(projectId,employeeList);
        }
    }

    private List<Employee> updateEmployeeList(List<Employee>employeeList, Employee employee){
        for (Employee e:employeeList) {
            if(e.getEmpId().equals(employee.getEmpId())){
                int workDays = e.getDays();
                workDays+=employee.getDays();
                e.setDays(workDays);
                Collections.sort(employeeList);
                return employeeList;
            }
        }
        employeeList.add(employee);
        Collections.sort(employeeList);
        return employeeList;
    }

    private Employee buildEmployee(List<String>properties) throws FileFormatException {
        Date dateFrom = DateGenerator.formatDate(properties.get(2));
        Date dateTo = DateGenerator.formatDate(properties.get(3));

        return new EmployeeBuilder()
                .setEmpId(properties.get(0))
                .setProjectId(properties.get(1))
                .setDateFrom(dateFrom)
                .setDateTo(dateTo)
                .build();
    }

    public List<Employee> findCoupleEmployee(Map<Integer, List<Employee>> employeeMap) {
        int maxDays = 0;
        int projectId = 0;
        int size;
        int finalSize=0;
        int calculatedDays;
        for(Map.Entry<Integer, List<Employee>> listEntry : employeeMap.entrySet()){
            calculatedDays = 0;
            size = listEntry.getValue().size();

            if(size>1){
                calculatedDays = listEntry.getValue().get(size-1).getDays();
                calculatedDays += listEntry.getValue().get(size-2).getDays();
            }

            if(maxDays<calculatedDays){
                maxDays = calculatedDays;
                projectId = listEntry.getKey();
                finalSize = listEntry.getValue().size();
            }
        }
        List<Employee>resultList = employeeMap.get(projectId).subList(finalSize-2, finalSize);
        return resultList;
    }

}
