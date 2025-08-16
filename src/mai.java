import java.util.Collections;

public class mai {
    public static void main(String[] args) {
        MyTree tree = new MyTree();
        int[] numbers = {10, 15, 2, 19, 25, 39, 1, 4, 11, 16, 20, 7, 0};
        for(int n:numbers)
            tree.add(n);

        tree.traverse();
        tree.remove(2,25);
        tree.traverse();

        MyTree subSet = tree.searchInterval(0,16);
        subSet.traverse();
    }
}
