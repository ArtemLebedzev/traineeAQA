public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Lebedev Artem Olegovich", "AQA Engineer", "work1@gmail.com",
                "+375295127047", 40000, 21);
        employees[1] = new Employee("Lebedev Anton Olegovich", "AQA Engineer", "work2@gmail.com",
                "+375295127049", 40000, 20);
        employees[2] = new Employee("Anikeev Denis Igorevich", "Java Engineer", "work3@gmail.com",
                "+375333219813", 60000, 22);
        employees[3] = new Employee("Anikeev Valeriy Igorevich", "JavaScript Engineer", "work4@gmail.com",
                "+375333219818", 70000, 23);
        employees[4] = new Employee("Somoilova Anna Igorevna", "SA/BA", "work5@gmail.com",
                "+375333219832", 120000, 18);

        for(Employee employee: employees){
            System.out.println(employee.toString());
        }

        Park.Attraction parkAttraction = new Park("New-York Park").new Attraction("Dead swing", "24/7",10.5);
        System.out.println(parkAttraction.toString());
    }
}
