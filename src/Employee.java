public class Employee {
    private final int id;
    private final String fullName;
    private int department;
    private float salary;
    private static int counter = 0;

    public Employee(String fullName, int department, float salary) {
        id = ++counter;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Id:" + id + ", ФИО: " + fullName + ", отдел №" + department + ", зарплата: " + salary;
    }


}


