package pekan9_2511531006;

public class BTree_1006 {
    private Node_1006 root_1006;
    private Node_1006 currentNode_1006;
    public BTree_1006() {
        root_1006 = null;
    }
    public boolean search(int data_1006) {
        return search(root_1006, data_1006);
    }
    private boolean search(Node_1006 node_1006, int data_1006) {
        if (node_1006.getData() == data_1006)
                return true;
        if (node_1006.getLeft() != null)
            if (search(node_1006.getLeft(), data_1006))
                return true;
        if (node_1006.getRight() != null)
            if (search(node_1006.getRight(), data_1006))
                return true;
        return false;
    } 
    public void printInorder() {
        root_1006.printInorder(root_1006);
    }
    public void printPreOrder() {
        root_1006.printPreorder(root_1006);
    }
    public void printPostOrder() {
        root_1006.printPostorder(root_1006);
    }
    public Node_1006 getRoot() {
        return root_1006;
    }
    public boolean isEmpty() {
        return root_1006 == null;
    }
    public int countNodes() {
        return countNodes(root_1006);
    }
    private int countNodes(Node_1006 node_1006) {
        int count_1006 = 1;
        if (node_1006 == null) {
            return 0;
        } else {
            count_1006 += countNodes(node_1006.getLeft());
            count_1006 += countNodes(node_1006.getRight());
            return count_1006;
        }
    }
    public void print() {
        root_1006.print();
    }
    public Node_1006 getCurrent() {
        return currentNode_1006;
    }
    public void setCurrent(Node_1006 node_1006) {
        this.currentNode_1006 = node_1006;
    }
    public void setRoot(Node_1006 root_1006) {
        this.root_1006 = root_1006;
    }
}