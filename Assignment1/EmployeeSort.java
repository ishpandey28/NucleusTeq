package Assignment1;/*1. Your company employs 200 people. They keep records of all the employee information in the Employees.csv file,
 which contains the following columns: first name, last name, department, position, and salary. However, they would
 like to sort the data; first, they would like to group the rows by department lexicographically, and then they would
 like to sort the rows by salary.
As a Java developer, you have been assigned to create a Java application that is capable of carrying out this task.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSort {
    public static void main(String[] args) throws Exception{
        List<Employee> employees = readEmployeesFromCSV("E:/untitled/src/Assignment1/Employees.csv");

        // Sort employees by department and then by salary
        Collections.sort(employees, Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary));


        // Print Employees
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static List<Employee> readEmployeesFromCSV(String filename) throws Exception{
        List<Employee> employees = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while (true) {
            String line=br.readLine();
            if(line==null)break;
            String[] data = line.split(",");
            String firstName = data[0].trim();
            String lastName = data[1].trim();
            String department = data[2].trim();
            String email = data[3].trim();
            double salary = 0.0;
            if (data.length >= 5 && !data[4].trim().isEmpty()) {
                try {
                    salary = Double.parseDouble(data[4].trim());
                } catch (NumberFormatException e) {
                    // Treat non-parsable salaries as 0.0
                    salary = 0.0;
                }
            }
            employees.add(new Employee(firstName, lastName, department, email, salary));
        }
        return employees;
    }

}


