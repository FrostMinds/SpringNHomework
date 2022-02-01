package skypro.com.springhomework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skypro.com.springhomework.Data.Employee;
import skypro.com.springhomework.Exception.EmployeeExistsException;
import skypro.com.springhomework.Exception.EmployeeNotFoundException;
import skypro.com.springhomework.Service.EmployeeService;
import skypro.com.springhomework.Service.Impl.EmployeeServiceImpl;

import java.util.Collection;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static skypro.com.springhomework.Constants.EmployeeServiceImplTestConstants.*;

public class EmployeeServiceImplTest {

    private EmployeeService out;

    @BeforeEach
    void setUp() {
        out = new EmployeeServiceImpl();
    }

    @Test
    void testAdd() {
        Employee actualEmployee = out.add(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1);
        Employee expectedEmployee = new Employee(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void testAdd2Employees() {
        Employee actualEmployee = out.add(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1);
        Employee expectedEmployee = new Employee(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1);
        assertEquals(expectedEmployee, actualEmployee);
        actualEmployee = out.add(FIRST_NAME_2, SECOND_NAME_2, DEPARTMENT_2, SALARY_2);
        expectedEmployee = new Employee(FIRST_NAME_2, SECOND_NAME_2, DEPARTMENT_2, SALARY_2);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    public void testAddDuplicate() {
        out.add(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1);
        Assertions.assertThrowsExactly(EmployeeExistsException.class, () -> out.add(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1));
    }

    @Test
    void testRemoveAddedEmployee() {
        out.add(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1);
        Employee actualEmployee = out.add(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1);
        Employee expectedEmployee = new Employee(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void testRemoveNotExistingEmployee() {
        Assertions.assertThrowsExactly(EmployeeNotFoundException.class, () -> out.remove(FIRST_NAME_1, SECOND_NAME_1));
    }

    @Test
    void testFindAddedEmployee() {
        out.add(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1);
        Employee actualEmployee = out.find(FIRST_NAME_1, SECOND_NAME_1);
        Employee expectedEmployee = new Employee(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1);
        assertEquals(expectedEmployee, actualEmployee);
    }
    @Test
    void testFindNotExisting() {
        Assertions.assertThrowsExactly(EmployeeNotFoundException.class, () -> out.find(FIRST_NAME_1, SECOND_NAME_1));
    }

    @Test
    void testGetAllForAddedEmployee() {
        out.add(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1);
        out.add(FIRST_NAME_2, SECOND_NAME_2, DEPARTMENT_2, SALARY_2);
        Collection<Employee> actual = out.getAll();
        List<Employee> expected = List.of(
                new Employee(FIRST_NAME_1, SECOND_NAME_1, DEPARTMENT_1, SALARY_1),
                new Employee(FIRST_NAME_2, SECOND_NAME_2, DEPARTMENT_2, SALARY_2)
        );

        assertEquals(actual.size(), expected.size());
        assertTrue(expected.containsAll(actual));
    }
}
