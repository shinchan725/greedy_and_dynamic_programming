import java.util.*;

class Item {
    int value, weight;
    Item(int v, int w) { value = v; weight = w; }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10), new Item(100, 20), new Item(120, 30)
        };
        int capacity = 50;

        Arrays.sort(items, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));

        double totalValue = 0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += (double)item.value * capacity / item.weight;
                break;
            }
        }

        System.out.println("Maximum value: " + totalValue);
    }
}
