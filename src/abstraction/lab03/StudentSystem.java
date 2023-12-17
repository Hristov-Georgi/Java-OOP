package abstraction.lab03;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void addStudent (Student student) {

        repo.putIfAbsent(student.getName(), student);

    }

    public void showStudent (String name) {

        String printText = "";

        if (repo.containsKey(name)) {
            printText = repo.get(name).getName()
                    + " is "
                     + repo.get(name).getAge()
                    + " years old. ";

            if (repo.get(name).getGrade() >= 5.00) {
                printText += "Excellent student.";

            } else if (repo.get(name).getGrade() >= 3.50) {
                printText += "Average student.";

            } else {
                printText += "Very nice person.";
            }

        }

        System.out.println(printText);

    }
}
