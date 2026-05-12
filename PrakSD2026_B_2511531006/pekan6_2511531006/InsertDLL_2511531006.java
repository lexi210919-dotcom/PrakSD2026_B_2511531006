package pekan6_2511531006S;

public class InsertDLL_2511531006 {

    // menambahkan node di awal DLL
    static NodeDLL_2511531006 insertBegin(NodeDLL_2511531006 head_1006, int data_2511531006) {
        // buat node baru
        NodeDLL_2511531006 new_node_1006 = new NodeDLL_2511531006(data_2511531006);

        // jadikan pointer next ke head
        new_node_1006.next_2511531006 = head_1006;

        // set prev head ke node baru
        if (head_1006 != null) {
            head_1006.prev_2511531006 = new_node_1006;
        }

        return new_node_1006;
    }

    // menambahkan node di akhir DLL
    public static NodeDLL_2511531006 insertEnd(NodeDLL_2511531006 head_1006, int newData_2511531006) {
        NodeDLL_2511531006 newNode_1006 = new NodeDLL_2511531006(newData_2511531006);

        if (head_1006 == null) {
            head_1006 = newNode_1006;
        } else {
            NodeDLL_2511531006 curr_1006 = head_1006;
            while (curr_1006.next_2511531006 != null) {
                curr_1006 = curr_1006.next_2511531006;
            }
            curr_1006.next_2511531006 = newNode_1006;
            newNode_1006.prev_2511531006 = curr_1006;
        }
        return head_1006;
    }

    // menambahkan node di posisi tertentu
    public static NodeDLL_2511531006 insertAtPosition(
            NodeDLL_2511531006 head_1006, int pos_1006, int new_data_1006) {

        NodeDLL_2511531006 new_node_1006 = new NodeDLL_2511531006(new_data_1006);

        if (pos_1006 == 1) {
            new_node_1006.next_2511531006 = head_1006;
            if (head_1006 != null) {
                head_1006.prev_2511531006 = new_node_1006;
            }
            return new_node_1006;
        }

        NodeDLL_2511531006 curr_1006 = head_1006;
        for (int i = 1; i < pos_1006 - 1 && curr_1006 != null; i++) {
            curr_1006 = curr_1006.next_2511531006;
        }

        if (curr_1006 == null) {
            System.out.println("Posisi tidak ada");
            return head_1006;
        }

        new_node_1006.next_2511531006 = curr_1006.next_2511531006;
        new_node_1006.prev_2511531006 = curr_1006;

        if (curr_1006.next_2511531006 != null) {
            curr_1006.next_2511531006.prev_2511531006 = new_node_1006;
        }

        curr_1006.next_2511531006 = new_node_1006;

        return head_1006;
    }

    public static void printList(NodeDLL_2511531006 head_1006) {
        NodeDLL_2511531006 curr_1006 = head_1006;
        while (curr_1006 != null) {
            System.out.print(curr_1006.data_2511531006 + " <-> ");
            curr_1006 = curr_1006.next_2511531006;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // membuat DLL: 2 <-> 3 <-> 5
        NodeDLL_2511531006 head_1006 = new NodeDLL_2511531006(2);
        head_1006.next_2511531006 = new NodeDLL_2511531006(3);
        head_1006.next_2511531006.prev_2511531006 = head_1006;

        head_1006.next_2511531006.next_2511531006 = new NodeDLL_2511531006(5);
        head_1006.next_2511531006.next_2511531006.prev_2511531006 =
                head_1006.next_2511531006;

        // cetak DLL awal
        System.out.print("DLL awal: ");
        printList(head_1006);

        // tambah 1 di awal
        head_1006 = insertBegin(head_1006, 1);
        System.out.print("Simpul 1 ditambah di awal: ");
        printList(head_1006);

        // tambah 6 di akhir
        head_1006 = insertEnd(head_1006, 6);
        System.out.print("Simpul 6 ditambah di akhir: ");
        printList(head_1006);

        // tambah 4 di posisi 4
        head_1006 = insertAtPosition(head_1006, 4, 4);
        System.out.print("Simpul 4 ditambah di posisi 4: ");
        printList(head_1006);
    }
}