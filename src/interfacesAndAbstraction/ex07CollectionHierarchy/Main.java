package interfacesAndAbstraction.ex07CollectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] items = scanner.nextLine().split("\\s+");
        int removedOperationsAmount = Integer.parseInt(scanner.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        printAddItems(items, addCollection);
        printAddItems(items, addRemoveCollection);
        printAddItems(items, myList);

        printRemovedItems(removedOperationsAmount, addRemoveCollection);
        printRemovedItems(removedOperationsAmount, myList);

    }

    private static void printAddItems(String[] items, Addable collection) {

        for (String item : items) {
            System.out.print(collection.add(item) + " ");
        }
        System.out.println();

    }

    private static void printRemovedItems(int removedOperationsAmount, AddRemovable collection) {

        for (int i = 1; i <= removedOperationsAmount; i++ ) {
            System.out.print(collection.remove() + " ");
        }
        System.out.println();
    }
}
