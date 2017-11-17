import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        List<Employee> employees = readEmployees(reader);
        String department = getHighestAverageSalaryDepartment(employees);
        String departmentEmployees = getDepartmentEmployees(employees, department);

        System.out.println(departmentEmployees);
    }

    private static List<Employee> readEmployees(BufferedReader reader) throws IOException {
        List<Employee> employees = new ArrayList<>();

        Integer inputLineNumber = Integer.parseInt(reader.readLine());
        for (int i = 0; i < inputLineNumber; i++) {
            String[] splitInput = reader.readLine().split("\\s+");
            String name = splitInput[0];
            Double salary = Double.parseDouble(splitInput[1]);
            String position = splitInput[2];
            String department = splitInput[3];

            Employee employee = null;
            if (splitInput.length == 4){
                employee = new Employee(name, salary, position, department);
            }
            else if(splitInput.length == 5){
                if (isNumber(splitInput[4])){
                    Integer age = Integer.parseInt(splitInput[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
                else{
                    employee = new Employee(name, salary, position, department, splitInput[4]);
                }
            }
            else if(splitInput.length == 6){
                String email = splitInput[4];
                Integer age = Integer.parseInt(splitInput[5]);

                employee = new Employee(name, salary, position, department, email, age);
            }
            else{
                // error
            }

            employees.add(employee);
        }

        return employees;
    }
    private static boolean isNumber(String text){
        boolean isNumber = true;

        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))){
                isNumber = false;
                break;
            }
        }
        return isNumber;
    }
    private static String getHighestAverageSalaryDepartment(List<Employee> employees){
        Map<String, Double> averageDepartmentSalary =
                employees
                        .stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)));

        String department =
                averageDepartmentSalary
                .entrySet()
                .stream()
                .max((a, b) -> a.getValue().compareTo(b.getValue()))
                .get()
                .getKey();

        return department;
    }
    private static String getDepartmentEmployees(List<Employee> employees, String department) {
        StringBuilder sb = new StringBuilder();

        sb
        .append("Highest Average Salary: ")
        .append(department)
        .append(System.lineSeparator());

        List<Employee> departmentEmployees =
                employees
                        .stream()
                        .filter(e -> e.getDepartment().equals(department))
                        .sorted((a, b) -> b.getSalary().compareTo(a.getSalary()))
                        .collect(Collectors.toList());
        for (Employee employee : departmentEmployees) {
            sb
                    .append(employee)
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
