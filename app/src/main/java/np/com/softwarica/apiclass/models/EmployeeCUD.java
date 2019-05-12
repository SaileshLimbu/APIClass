package np.com.softwarica.apiclass.models;

public class EmployeeCUD {
    private String name;
    private String salary;
    private String age;

    public EmployeeCUD(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String toString(){
        return "Name=" + name + "\nSalary=" + salary + "\nAge=" + age;
    }
}
