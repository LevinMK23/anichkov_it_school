package tree;

public class Test {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        // O(NLogN)
        for (int i = 0; i < 11; i++) {
            tree.add((int) (Math.random() * 10));
        }
        System.out.println(tree);
        System.out.println(tree.contains(2));
        System.out.println(tree.contains(5));
        System.out.println(tree.contains(50));
    }
}
