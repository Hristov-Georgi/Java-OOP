package inheritance.ex06animals;

public class ValidateInput {

    public static void validateText(String text) {
        if (text.isEmpty() || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public static void validateArrayLength(String[] array) {
        if (array.length != 3) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }
}
