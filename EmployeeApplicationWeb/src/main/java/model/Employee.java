package model;

import java.util.Date;
import java.util.Objects;


public class Employee implements Comparable<Employee>{
    private final Integer empId;
    private final Integer projectId;
    private int days;
    private final Date dateFrom;
    private final Date dateTo;

    public Employee(Integer empId, Integer projectId, int days, Date dateFrom, Date dateTo) {
        this.empId = empId;
        this.projectId = projectId;
        this.days = days;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
    public void setDays(int days){
        this.days = days;
    }

    public Integer getEmpId() {
        return empId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public int getDays() {
        return days;
    }

    public Integer getProjectId() {
        return projectId;
    }

    @Override
    public int compareTo(Employee employee) {
        return this.days - employee.days;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, projectId, days, dateFrom, dateTo);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", projectId=" + projectId +
                ", days=" + days +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
