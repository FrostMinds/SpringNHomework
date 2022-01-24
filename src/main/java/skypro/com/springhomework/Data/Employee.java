package skypro.com.springhomework.Data;


import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String secondName;
    private int department;
    private int salary;

    public Employee (String firstName, String secondName) {
        this(firstName, secondName, 0, 0);
    }

    public Employee(String firstName, String secondName, int department, int salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.department = department;
        this.salary = salary;
    }

    public boolean inDepartment(int department) {
        return this.department == department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(secondName, employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, department, salary);
    }
}
