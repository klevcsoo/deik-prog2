package eloadas10;

//
public class BinaryTree implements IBinaryTree {
    private final IBinaryTree left;
    private final IBinaryTree right;
    private final BinaryLabel data;

    public BinaryTree(BinaryLabel data) {
        this.data = data;
        this.left = new NullBinaryTree();
        this.right = new NullBinaryTree();
    }

    public BinaryTree(BinaryLabel data, IBinaryTree left, IBinaryTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return this.inOrderToString();
    }

    @Override
    public String inOrderToString() {
        return "%s %s %s".formatted(
                this.left.inOrderToString(),
                this.data,
                this.right.inOrderToString()
        );
    }

    @Override
    public String preOrderToString() {
        return null;
    }
}
