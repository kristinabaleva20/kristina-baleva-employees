package model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class EmployeeBuilder {
    private Integer empId;
    private Integer projectId;
    private int workDays;
    private Date dateFrom;
    private Date dateTo;

    public EmployeeBuilder setEmpId(String empId){
        this.empId = Integer.valueOf(empId);
        return this;
    }

    public EmployeeBuilder setProjectId(String projectId){
        this.projectId = Integer.valueOf(projectId);
        return this;
    }

    public EmployeeBuilder setDateFrom(Date date){
        this.dateFrom =  date;
        return this;
    }

    public EmployeeBuilder setDateTo(Date date){
        this.dateTo =  date;
        return this;
    }

    private int setWorkDays(Date dateFrom, Date dateTo){
        long diffInMillies = Math.abs(dateTo.getTime() - dateFrom.getTime());
        int workDays = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return workDays;
    }

    public Employee build() {
        this.workDays = setWorkDays(dateFrom, dateTo);
        return new Employee(empId, projectId, workDays, dateFrom, dateTo);
    }


}
