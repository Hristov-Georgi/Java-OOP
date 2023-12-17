
package abstraction.ex06GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());

        String[] safeAmount = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> collectedItems = new LinkedHashMap<>();

        long goldAmount = 0;
        long gemAmount = 0;
        long cashAmount = 0;

        for (int i = 0; i < safeAmount.length; i += 2) {

            String itemName = safeAmount[i];
            long itemQuantity = Long.parseLong(safeAmount[i + 1]);

            String itemType = "";

            if (itemName.length() == 3) {
                itemType = "Cash";
            } else if (itemName.toLowerCase().endsWith("gem")) {
                itemType = "Gem";
            } else if (itemName.toLowerCase().equals("gold")) {
                itemType = "Gold";
            }

            if (itemType.equals("")) {
                continue;
            } else if (bagCapacity < collectedItems.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + itemQuantity) {
                continue;
            }

            switch (itemType) {
                case "Gem":
                    if (!collectedItems.containsKey(itemType)) {
                        if (collectedItems.containsKey("Gold")) {
                            if (itemQuantity > collectedItems.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (collectedItems.get(itemType).values().stream().mapToLong(e -> e).sum() + itemQuantity > collectedItems.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!collectedItems.containsKey(itemType)) {
                        if (collectedItems.containsKey("Gem")) {
                            if (itemQuantity > collectedItems.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (collectedItems.get(itemType).values().stream().mapToLong(e -> e).sum() + itemQuantity > collectedItems.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!collectedItems.containsKey(itemType)) {
                collectedItems.put((itemType), new LinkedHashMap<String, Long>());
            }

            if (!collectedItems.get(itemType).containsKey(itemName)) {
                collectedItems.get(itemType).put(itemName, 0L);
            }


            collectedItems.get(itemType).put(itemName, collectedItems.get(itemType).get(itemName) + itemQuantity);
            if (itemType.equals("Gold")) {
                goldAmount += itemQuantity;
            } else if (itemType.equals("Gem")) {
                gemAmount += itemQuantity;
            } else if (itemType.equals("Cash")) {
                cashAmount += itemQuantity;
            }
        }

        for (var x : collectedItems.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}