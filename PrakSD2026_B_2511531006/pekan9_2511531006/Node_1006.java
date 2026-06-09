package pekan9_2511531006;

public class Node_1006 {
    int data_1006;
    Node_1006 left;
    Node_1006 right;

    public Node_1006(int data_1006) {
        this.data_1006 = data_1006;
        left = null;
        right = null;
    }
    public void setLeft(Node_1006 node_1006) {
        if (left == null)
            left = node_1006;
    }
    public void setRight(Node_1006 node_1006) {
        if (right == null)
            right = node_1006;
    }
    public Node_1006 getLeft() {
        return left;
    }
    public Node_1006 getRight() {
        return right;
    }
    public int getData() {
        return data_1006;
    }
    public void setData(int data_1006) {
        this.data_1006 = data_1006;
    }

    void printPreorder(Node_1006 node_1006) {
        if (node_1006 == null)
            return;
        System.out.print(node_1006.data_1006 + " ");
        printPreorder(node_1006.left);
        printPreorder(node_1006.right);
    }
   void printPostorder(Node_1006 node_1006) {
        if (node_1006 == null)
            return;
        printPostorder(node_1006.left);
        printPostorder(node_1006.right);
        System.out.print(node_1006.data_1006 + " ");
    }
    void printInorder(Node_1006 node_1006) {
        if (node_1006 == null)
            return;
        printInorder(node_1006.left);
        System.out.print(node_1006.data_1006 + " ");
        printInorder(node_1006.right);
    }
    public String print() {
        return this.print("", true, "");
    }
    public String print(String prefix, boolean isTail, String sb) {
        if (right != null) {
        right.print(prefix + (isTail ? "|   " : "    "),false, sb);
        }
        System.out.println(prefix +(isTail ? "\\-- " : "/-- ")+ data_1006);
        if (left != null) {
        left.print(prefix +(isTail ? "    " : "|   "),true, sb);
        }
        return sb;
    }
}