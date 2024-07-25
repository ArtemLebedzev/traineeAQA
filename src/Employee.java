public class Employee {
    private String FIO;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public Employee(String FIO, String position, String email, String telephone, int salary, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    //I think getters and setters is optional here and in the Park file

    @Override
    public String toString() {
        return "FIO:'" + FIO + '\'' +
                ", position:'" + position + '\'' +
                ", email:'" + email + '\'' +
                ", telephone:'" + telephone + '\'' +
                ", salary:" + salary +
                ", age:" + age;
    }
}
