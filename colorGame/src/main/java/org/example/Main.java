package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class ColorGame {
    private final Map<String, Set<String>> colorMap; // Maps items to their predefined colors
    private final Set<String> subscribedItems; // Set of currently subscribed items
    private final Scanner scanner;

    public ColorGame(Map<String, Set<String>> colorMap) {
        this.colorMap = colorMap;
        this.subscribedItems = new HashSet<>();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        // Pre-populate color options based on the first image (replace with actual data)
        Map<String, Set<String>> colorMap = new HashMap<>();
        colorMap.put("Banana", Set.of("Green", "Yellow"));
        colorMap.put("Blood", Set.of("Red"));
        colorMap.put("Ink", Set.of("Red", "Black"));
        colorMap.put("Frog", Set.of("Blue", "Yellow"));
        colorMap.put("Sky", Set.of("Blue", "Black"));
        colorMap.put("Salt", Set.of("White"));
        colorMap.put("Apple", Set.of("Green", "Red"));

        ColorGame game = new ColorGame(colorMap);
        game.run();
    }

    private void run() {
        while (true) {
            System.out.print("Enter command (+item, -item, list, color, or exit): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            processInput(input);
        }
    }

    private void processInput(String input) {
        if (input.startsWith("+")) {
            subscribe(input.substring(1));
        } else if (input.startsWith("-")) {
            unsubscribe(input.substring(1));
        } else if (input.equalsIgnoreCase("list")) {
            listSubscribedItems();
        } else if (isValidColor(input)) {
            notify(input);
        } else {
            System.out.println("Invalid command.");
        }
    }

    private boolean isValidColor(String color) {
        return colorMap.values().stream().anyMatch(colors -> colors.contains(color));
    }

    private void subscribe(String item) {
        if (!colorMap.containsKey(item)) {
            System.out.println("Invalid item. Available options: " + String.join(", ", colorMap.keySet()));
            return;
        }
        subscribedItems.add(item);
        System.out.println(item + " subscribed.");
    }

    private void unsubscribe(String item) {
        if (!subscribedItems.contains(item)) {
            System.out.println(item + " is not subscribed.");
            return;
        }
        subscribedItems.remove(item);
        System.out.println(item + " unsubscribed.");
    }

    private void listSubscribedItems() {
        if (subscribedItems.isEmpty()) {
            System.out.println("No items are currently subscribed.");
            return ;
        }
        System.out.println("Subscribed items: " + String.join(", ", subscribedItems));
    }

    private void notify(String color) {
        for (String item : subscribedItems) {
            if (colorMap.get(item).contains(color)) {
                String message = getMessage(item, color);
                System.out.println(message);
            }
        }
    }

    // Helper method to choose the appropriate message based on number of colors
    private String getMessage(String item, String color) {
        if (colorMap.get(item).size() > 1) {
            return String.format("I'm %s! I am %s today.", item, color);
        } else {
            return String.format("I'm %s! I'm sometimes %s.", item, color);
        }
    }
}