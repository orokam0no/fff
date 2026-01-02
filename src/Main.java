import java.util.ArrayList;
import java.util.Collections;

interface Payable {
    double getPaymentAmount();
}

class Person implements Payable, Comparable<Person> {
    private static int nextId = 1;

    private final int id;
    private String name;
    private String surname;

    public Person() {
        this.id = nextId++;
        this.name = "";
        this.surname = "";
    }

    public Person(String name, String surname) {
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getPosition() {
        return "Student";
    }

    @Override
    public double getPaymentAmount() {
        return 0.0;
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + surname;
    }


    @Override
    public int compareTo(Person other) {
        return Double.compare(this.getPaymentAmount(), other.getPaymentAmount());
    }
}

class Employee extends Person {
    private String position;
    private double salary;

    public Employee() {
        super();
        this.position = "";
        this.salary = 0.0;
    }

    public Employee(String name, String surname, String position, double salary) {
        super(name, surname);
        this.position = position;
        this.salary = salary;
    }

    public String getPositionValue() {
        return position;
    }

    public void setPositionValue(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public double getPaymentAmount() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee: " + super.toString();
    }

    @Override
    public int compareTo(Person other) {
        return Double.compare(this.getPaymentAmount(), other.getPaymentAmount());
    }
}

class Student extends Person {
    private double gpa;

    private static final double STIPEND = 36660.00;
    private static final double MIN_GPA_FOR_STIPEND = 2.67;

    public Student() {
        super();
        this.gpa = 0.0;
    }

    public Student(String name, String surname, double gpa) {
        super(name, surname);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public double getPaymentAmount() {
        return (gpa > MIN_GPA_FOR_STIPEND) ? STIPEND : 0.0;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }

    @Override
    public int compareTo(Person other) {
        return Double.compare(this.getPaymentAmount(), other.getPaymentAmount());
    }
}

public class Main {
    public static void printData(Iterable<Person> people) {
        for (Person p : people) {
            System.out.printf("%s earns %.2f tenge%n", p.toString(), p.getPaymentAmount());
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();


        people.add(new Employee("John", "Lennon", "Manager", 27045.78));
        people.add(new Employee("George", "Harrison", "Developer", 50000.00));

        people.add(new Student("Ringo", "Starr", 2.50)); // no stipend
        people.add(new Student("Paul", "McCartney", 3.20)); // stipend

        Collections.sort(people);
        printData(people);
    }
}
