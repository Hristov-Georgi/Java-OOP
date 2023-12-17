package encapsulation.lab02SalaryIncreaselab03ValidationData;

import java.text.DecimalFormat;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public Person(String firstName, String lastName, int age) {
        this(firstName, lastName, age, 0.0);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge (int age) {

        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary () {
        return this.salary;
    }

    public void setSalary (double salary) {

        if (salary < 460.0) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    public void setFirstName(String firstName) {

        checkNameLength(firstName, "First");
        this.firstName = firstName;
    }

    public void setLastName (String lastName) {
        checkNameLength(lastName, "Last");
        this.lastName = lastName;

    }

    public void increaseSalary (double bonus) {

        if (this.age < 30) {
            this.setSalary(this.getSalary() + this.getSalary() * (bonus / 200));
        } else {
            this.setSalary(this.getSalary() + this.getSalary() * (bonus / 100));
        }
    }

    private void checkNameLength (String name, String prefix) {

        if (name.length() < 3) {
            throw new IllegalArgumentException(prefix + " name cannot be less than 3 symbols");
        }
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.0#####");
        return String.format("%s %s gets %s leva",
                this.firstName, this.lastName, decimalFormat.format(this.salary));
    }
}

