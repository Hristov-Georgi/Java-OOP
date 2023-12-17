package abstraction.lab03StudentSystem;

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

        StringBuilder stringBuilder = new StringBuilder();

        if (repo.containsKey(name)) {
            stringBuilder.append(repo.get(name).getName())
                    .append(" is ")
                    .append(repo.get(name).getAge())
                    .append(" years old. ");

            if (repo.get(name).getGrade() >= 5.00) {
                stringBuilder.append("Excellent student.");

            } else if (repo.get(name).getGrade() >= 3.50) {
                stringBuilder.append("Average student.");

            } else {
                stringBuilder.append("Very nice person.");
            }

        }

        System.out.println(stringBuilder);

    }
}
