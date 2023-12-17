package abstraction.lab03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        studentOperation(scanner);

    }

    public static void studentOperation (Scanner scanner) {
        String input = scanner.nextLine();

        StudentSystem studentSystem = new StudentSystem();

        while (!input.equals("Exit")) {

            String[] data = input.split("\\s+");

            switch (data[0]) {

                case "Create":
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    double grade = Double.parseDouble(data[3]);

                    Student student = new Student(name, age, grade);

                    studentSystem.addStudent(student);

                    break;

                case "Show":
                    String nameToShow = data[1];

                    studentSystem.showStudent(nameToShow);

                    break;
            }

            input = scanner.nextLine();
        }
    }

}

