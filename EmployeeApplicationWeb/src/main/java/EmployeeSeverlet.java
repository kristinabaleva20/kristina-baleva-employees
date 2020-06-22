import exceptions.FileFormatException;
import model.Employee;
import service.EmployeeService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import static constants.FileConstants.*;
import static constants.JSPConastants.*;

public class EmployeeSeverlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String filePath = (String) req.getSession().getAttribute(FILE_PATH);
        List<Employee> coupleEmployee = getEmployees(filePath);
        req.setAttribute(EMPLOYEES, coupleEmployee);
        final RequestDispatcher rd = req.getRequestDispatcher(EMPLOYEE_JSP);
        rd.forward(req, resp);

    }
    private List<Employee> getEmployees(final String filePath) throws IOException, FileFormatException {
        EmployeeService employeeService = new EmployeeService();
        Map<Integer, List<Employee>> employeesMap = employeeService.readFile(filePath);
        return employeeService.findCoupleEmployee(employeesMap);
    }

}

