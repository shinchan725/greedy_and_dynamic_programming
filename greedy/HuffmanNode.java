import java.util.*;

class HuffmanNode {
    char c;
    int freq;
    HuffmanNode left, right;

    HuffmanNode(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}

class HuffmanCoding {
    public static void printCodes(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && root.c != '-') {
            System.out.println(root.c + ": " + s);
            return;
        }
        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }

    public static void main(String[] args) {
        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freqs = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));

        for (int i = 0; i < chars.length; i++) {
            pq.add(new HuffmanNode(chars[i], freqs[i]));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode merged = new HuffmanNode('-', left.freq + right.freq);
            merged.left = left;
            merged.right = right;
            pq.add(merged);
        }

        HuffmanNode root = pq.poll();
        printCodes(root, "");
    }
}
