package skypro.com.springhomework;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.com.springhomework.Data.Employee;
import skypro.com.springhomework.Exception.EmployeeNotFoundException;
import skypro.com.springhomework.Service.EmployeeService;
import skypro.com.springhomework.Service.Impl.DepartmentServiceImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static skypro.com.springhomework.Constants.EmployeeServiceImplTestConstants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    void setUp() {
        Mockito.when(employeeServiceMock.getAll()).thenReturn(List.of(
                new Employee(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1),
                new Employee(FIRST_NAME_2, SECOND_NAME_2, DEPARTMENT_2, SALARY_2)
        ));
    }

    @Test
    public void testMinSalary() {
        Employee actualResult = out.getEmployeeWithMinSalary(DEPARTMENT_1);
        Employee expectedResult = new Employee(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMinSalaryForEmptyDepartment() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.getEmployeeWithMinSalary(DEPARTMENT_2));
    }

    @Test
    public void testMaxSalary() {
        Employee actualResult = out.getEmployeeWithMaxSalary(DEPARTMENT_1);
        Employee expectedResult = new Employee(FIRST_NAME_2, SECOND_NAME_2, DEPARTMENT_2, SALARY_2);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMaxSalaryForEmptyDepartment() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.getEmployeeWithMaxSalary(DEPARTMENT_2));
    }

    @Test
    public void testGetEmployeeForDepartment() {
        Collection<Employee> actual = out.getEmployeesFor(DEPARTMENT_1);
        List<Employee> expected = List.of(
                new Employee(FIRST_NAME_1,SECOND_NAME_1,DEPARTMENT_1,SALARY_1),
                new Employee(FIRST_NAME_2,SECOND_NAME_2,DEPARTMENT_2,SALARY_2)
        );
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertTrue(expected.containsAll(actual));
    }

    @Test
    public void testGetEmployeeForEmptyDepartment() {
        Collection<Employee> actual = out.getEmployeesFor(DEPARTMENT_2);
        List<Employee> expected = Collections.emptyList();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllEmployeeBeDepartment() {
        Map<Integer, List<Employee>> actual = out.getAllEmployeesByDepartment();
        Map<Integer, List<Employee>> expected = Map.of(
                DEPARTMENT_1, List.of(
                        new Employee(FIRST_NAME_1,SECOND_NAME_1,DEPARTMENT_1,SALARY_1),
                        new Employee(FIRST_NAME_2,SECOND_NAME_2,DEPARTMENT_2,SALARY_2)
                )
        );
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllEmployeeByDepartmentNoDepartments() {
        Mockito.when(employeeServiceMock.getAll()).thenReturn(Collections.emptyList());
        Map<Integer, List<Employee>> actual = out.getAllEmployeesByDepartment();
        Map<Integer, List<Employee>> expected = Collections.emptyMap();
        Assertions.assertEquals(expected, actual);
    }
}