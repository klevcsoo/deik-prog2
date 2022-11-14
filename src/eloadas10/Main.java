package eloadas10;

public class Main {
    public static void main(String[] args) {
        BinaryTree f1 = new BinaryTree(
                BinaryLabel.FALSE,
                new BinaryTree(
                        BinaryLabel.NO_IDEA,
                        new BinaryTree(BinaryLabel.TRUE),
                        new BinaryTree(BinaryLabel.FALSE)
                ),
                new BinaryTree(
                        BinaryLabel.FALSE,
                        new BinaryTree(BinaryLabel.TRUE),
                        new BinaryTree(BinaryLabel.TRUE)
                )
        );

        System.out.println(f1);
    }
}
