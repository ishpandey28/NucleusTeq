package Assignment1;

class Employee{
    String firstName;
    String lastName;
    String department;
    String email;
    double salary;

    public Employee(String firstName, String lastName, String department, String email, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = email;
        this.salary = salary;
    }
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + department + ", " + email + ", " + salary;
    }

}