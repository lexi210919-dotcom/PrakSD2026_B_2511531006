package pekan6_2511531006S;

public class HapusDLL_2511531006 {

    public static NodeDLL_2511531006 delHead(NodeDLL_2511531006 head_1006) {
        if (head_1006 == null) {
            return null;
        }

        NodeDLL_2511531006 temp_1006 = head_1006;
        head_1006 = head_1006.next_2511531006;

        if (head_1006 != null) {
            head_1006.prev_2511531006 = null;
        }

        return head_1006;
    }

    public static NodeDLL_2511531006 delLast(NodeDLL_2511531006 head_1006) {
        if (head_1006 == null) {
            return null;
        }

        if (head_1006.next_2511531006 == null) {
            return null;
        }

        NodeDLL_2511531006 curr_1006 = head_1006;

        while (curr_1006.next_2511531006 != null) {
            curr_1006 = curr_1006.next_2511531006;
        }

        if (curr_1006.prev_2511531006 != null) {
            curr_1006.prev_2511531006.next_2511531006 = null;
        }

        return head_1006;
    }

    public static NodeDLL_2511531006 delPos(NodeDLL_2511531006 head_1006, int pos_1006) {

        if (head_1006 == null) {
            return head_1006;
        }

        NodeDLL_2511531006 curr_1006 = head_1006;

        for (int i = 1; curr_1006 != null && i < pos_1006; i++) {
            curr_1006 = curr_1006.next_2511531006;
        }

        if (curr_1006 == null) {
            return head_1006;
        }

        if (curr_1006.prev_2511531006 != null) {
            curr_1006.prev_2511531006.next_2511531006 =
                    curr_1006.next_2511531006;
        }

        if (curr_1006.next_2511531006 != null) {
            curr_1006.next_2511531006.prev_2511531006 =
                    curr_1006.prev_2511531006;
        }

        if (head_1006 == curr_1006) {
            head_1006 = curr_1006.next_2511531006;
        }

        return head_1006;
    }

    public static void printList_1006(NodeDLL_2511531006 head_1006) {

        NodeDLL_2511531006 curr_1006 = head_1006;

        while (curr_1006 != null) {
            System.out.print(curr_1006.data_2511531006 + " ");
            curr_1006 = curr_1006.next_2511531006;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        NodeDLL_2511531006 head_1006 =
                new NodeDLL_2511531006(1);

        head_1006.next_2511531006 =
                new NodeDLL_2511531006(2);

        head_1006.next_2511531006.prev_2511531006 =
                head_1006;

        head_1006.next_2511531006.next_2511531006 =
                new NodeDLL_2511531006(3);

        head_1006.next_2511531006.next_2511531006.prev_2511531006 =
                head_1006.next_2511531006;

        head_1006.next_2511531006.next_2511531006.next_2511531006 =
                new NodeDLL_2511531006(4);

        head_1006.next_2511531006.next_2511531006.next_2511531006.prev_2511531006 =
                head_1006.next_2511531006.next_2511531006;

        head_1006.next_2511531006.next_2511531006.next_2511531006.next_2511531006 =
                new NodeDLL_2511531006(5);

        head_1006.next_2511531006.next_2511531006.next_2511531006.next_2511531006.prev_2511531006 =
                head_1006.next_2511531006.next_2511531006.next_2511531006;

        System.out.print("DLL Awal: ");
        printList_1006(head_1006);

        System.out.print("Setelah head dihapus: ");
        head_1006 = delHead(head_1006);
        printList_1006(head_1006);

        System.out.print("Setelah node terakhir dihapus: ");
        head_1006 = delLast(head_1006);
        printList_1006(head_1006);

        System.out.print("Menghapus node ke-2: ");
        head_1006 = delPos(head_1006, 2);
        printList_1006(head_1006);
    }
}