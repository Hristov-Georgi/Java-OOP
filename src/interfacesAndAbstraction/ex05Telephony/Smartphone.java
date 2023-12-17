package interfacesAndAbstraction.ex05Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {

        return validateNumbers().toString();
    }

    @Override
    public String browse() {
        return validateUrls().toString();
    }

    public List<String> getNumbers() {
        return this.numbers;
    }

    public List<String> getUrls() {
        return urls;
    }

    private StringBuilder validateNumbers() {
        StringBuilder validNumbers = new StringBuilder();
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        for (String number : numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()) {
                validNumbers.append("Calling... ").append(number).append("\n");
            } else {
                validNumbers.append("Invalid number!").append("\n");
            }
        }

        return validNumbers;
    }

    private StringBuilder validateUrls() {
        StringBuilder validUrls = new StringBuilder();
        Pattern pattern = Pattern.compile("\\d+");
        for (String url : urls) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                validUrls.append("Invalid URL!").append("\n");
            } else {
                validUrls.append("Browsing: ").append(url).append("!").append("\n");
            }
        }

        return validUrls;
    }

}
