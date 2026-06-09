package pekan9_2511531006;

public class BtreeDriver_1006 {
    public static void main(String[] args) {

        // Membuat Pohon
        BTree_1006 tree_1006 = new BTree_1006();
        System.out.print("Jumlah Simpul awal pohon: ");
        System.out.println(tree_1006.countNodes());
        // menambahkan simpul data 1
        Node_1006 root_1006 = new Node_1006(1);
        // menjadikan simpul 1 sebagai root
        tree_1006.setRoot(root_1006);
        System.out.println("Jumlah simpul jika hanya ada root");
        System.out.println(tree_1006.countNodes());
        Node_1006 node2_1006 = new Node_1006(2);
        Node_1006 node3_1006 = new Node_1006(3);
        Node_1006 node4_1006 = new Node_1006(4);
        Node_1006 node5_1006 = new Node_1006(5);
        Node_1006 node6_1006 = new Node_1006(6);
        Node_1006 node7_1006 = new Node_1006(7);
        Node_1006 node8_1006 = new Node_1006(8);
        Node_1006 node9_1006 = new Node_1006(9);
        root_1006.setLeft(node2_1006);
        node2_1006.setLeft(node4_1006);
        node2_1006.setRight(node5_1006);
        node4_1006.setRight(node8_1006);
        root_1006.setRight(node3_1006);
        node3_1006.setLeft(node6_1006);
        node3_1006.setRight(node7_1006);
        node6_1006.setLeft(node9_1006);

        // Set root
        tree_1006.setCurrent(tree_1006.getRoot());
        System.out.println("Menampilkan simpul terakhir: ");
        System.out.println(tree_1006.getCurrent().getData());
        System.out.println("Jumlah simpul; setelah simpul 7 ditambahkan");
        System.out.println(tree_1006.countNodes());
        System.out.println("InOrder: ");
        tree_1006.printInorder();
        System.out.println("\nPreorder: ");
        tree_1006.printPreOrder();
        System.out.println("\nPostorder : ");
        tree_1006.printPostOrder();
        System.out.println("\nMenampilkan simpuml dalam bentuk pohon");
        tree_1006.print();
    }
}