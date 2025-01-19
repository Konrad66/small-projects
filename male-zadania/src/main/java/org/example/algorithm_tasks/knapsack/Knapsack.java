//package org.example.algorithm_tasks.knapsack;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//
//
//public class Knapsack {
//
//
//}
//
//public class StockCuttingGUI extends JFrame {
//    private final int sheetWidth;
//    private final int sheetHeight;
//    private final List<Rectangle> rectangles;
//    private final int[][] sheet;
//
//    public StockCuttingGUI(int sheetWidth, int sheetHeight, List<Rectangle> rectangles) {
//        this.sheetWidth = sheetWidth;
//        this.sheetHeight = sheetHeight;
//        this.rectangles = new ArrayList<>(rectangles);
//        this.sheet = new int[sheetHeight][sheetWidth];
//
//        this.rectangles.sort(Comparator.comparingInt(r -> -r.width * r.height)); // Sort by area descending
//
//        setTitle("Stock Cutting Problem");
//        setSize(800, 800);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        add(new SheetPanel());
//        solve();
//    }
//
//    private boolean canPlace(int x, int y, int width, int height) {
//        if (x + width > sheetWidth || y + height > sheetHeight) {
//            return false;
//        }
//        for (int i = y; i < y + height; i++) {
//            for (int j = x; j < x + width; j++) {
//                if (sheet[i][j] != 0) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    private void placeRectangle(int x, int y, int width, int height, int rectId) {
//        for (int i = y; i < y + height; i++) {
//            for (int j = x; j < x + width; j++) {
//                sheet[i][j] = rectId;
//            }
//        }
//    }
//
//    private void solve() {
//        int rectId = 1;
//        for (Rectangle rect : rectangles) {
//            boolean placed = false;
//            for (int y = 0; y < sheetHeight; y++) {
//                for (int x = 0; x < sheetWidth; x++) {
//                    if (canPlace(x, y, rect.width, rect.height)) {
//                        placeRectangle(x, y, rect.width, rect.height, rectId);
//                        rectId++;
//                        placed = true;
//                        break;
//                    }
//                }
//                if (placed) {
//                    break;
//                }
//            }
//        }
//        repaint();
//    }
//
//    private class SheetPanel extends JPanel {
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            int cellWidth = getWidth() / sheetWidth;
//            int cellHeight = getHeight() / sheetHeight;
//
//            for (int y = 0; y < sheetHeight; y++) {
//                for (int x = 0; x < sheetWidth; x++) {
//                    if (sheet[y][x] != 0) {
//                        g.setColor(new Color((sheet[y][x] * 50) % 256, (sheet[y][x] * 80) % 256, (sheet[y][x] * 100) % 256));
//                        g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
//                    }
//                    g.setColor(Color.BLACK);
//                    g.drawRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int sheetWidth = 10;
//        int sheetHeight = 10;
//        List<Rectangle> rectangles = new ArrayList<>();
//        rectangles.add(new Rectangle(3, 2));
//        rectangles.add(new Rectangle(5, 3));
//        rectangles.add(new Rectangle(2, 2));
//        rectangles.add(new Rectangle(1, 4));
//        rectangles.add(new Rectangle(4, 3));
//
//        SwingUtilities.invokeLater(() -> {
//            StockCuttingGUI gui = new StockCuttingGUI(sheetWidth, sheetHeight, rectangles);
//            gui.setVisible(true);
//        });
//    }
//
//    private static class Rectangle {
//        int width;
//        int height;
//
//        public Rectangle(int width, int height) {
//            this.width = width;
//            this.height = height;
//        }
//    }
//}
//
//
//
//
//
//public class DiscreteKnapsackProblem {
//    private final int capacity;
//    private final List<Item> items;
//
//    public DiscreteKnapsackProblem(int capacity, List<Item> items) {
//        this.capacity = capacity;
//        this.items = new ArrayList<>(items);
//        this.items.sort(Comparator.comparingDouble(i -> -((double) i.value / i.weight))); // Sort by value-to-weight ratio
//    }
//
//    public int solve() {
//        int totalValue = 0;
//        int remainingCapacity = capacity;
//
//        for (Item item : items) {
//            if (item.weight <= remainingCapacity) {
//                remainingCapacity -= item.weight;
//                totalValue += item.value;
//            }
//        }
//        return totalValue;
//    }
//
//    public static void main(String[] args) {
//        int capacity = 50;
//        List<Item> items = new ArrayList<>();
//        items.add(new Item(10, 60)); // weight, value
//        items.add(new Item(20, 100));
//        items.add(new Item(30, 120));
//
//        DiscreteKnapsackProblem knapsack = new DiscreteKnapsackProblem(capacity, items);
//        int maxValue = knapsack.solve();
//
//        System.out.println("Maximum value: " + maxValue);
//    }
//
//    private static class Item {
//        int weight;
//        int value;
//
//        public Item(int weight, int value) {
//            this.weight = weight;
//            this.value = value;
//        }
//    }
//}
//
//public class Knapsack {
//
//    // Function to solve the Knapsack problem using dynamic programming
//    public static int knapsack(int[] weights, int[] values, int capacity) {
//        int n = weights.length;
//        // Create a 2D array to store the maximum value for each weight capacity
//        int[][] dp = new int[n + 1][capacity + 1];
//
//        // Build the table in a bottom-up manner
//        for (int i = 1; i <= n; i++) {
//            for (int w = 0; w <= capacity; w++) {
//                if (weights[i - 1] <= w) {
//                    // Include the item and see if it gives a better value
//                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
//                } else {
//                    // Exclude the item
//                    dp[i][w] = dp[i - 1][w];
//                }
//            }
//        }
//
//        // The maximum value is found at dp[n][capacity]
//        return dp[n][capacity];
//    }
//
//    public static void main(String[] args) {
//        // Example input
//        int[] weights = {2, 3, 4, 5}; // Weights of items
//        int[] values = {3, 4, 5, 6};  // Values of items
//        int capacity = 5;            // Capacity of the knapsack
//
//        // Solve the problem
//        int maxValue = knapsack(weights, values, capacity);
//
//        // Output the result
//        System.out.println("Maximum value in knapsack: " + maxValue);
//    }
//}