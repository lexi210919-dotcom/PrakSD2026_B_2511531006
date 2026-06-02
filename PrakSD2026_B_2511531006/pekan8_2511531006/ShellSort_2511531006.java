package pekan8_2511531006;

public class ShellSort_2511531006 {

    public static void shellSort_1006(int[] A_1006) {
        int n_1006 = A_1006.length;
        int gap_1006 = n_1006 / 2;
        while (gap_1006 > 0) {
           for (int i_1006 = gap_1006; i_1006 < n_1006; i_1006++) {
                int temp_1006 = A_1006[i_1006];
                int j_1006 = i_1006;
                while (j_1006 >= gap_1006 && A_1006[j_1006 - gap_1006] > temp_1006) {
                       A_1006[j_1006] = A_1006[j_1006 - gap_1006];
                       j_1006 = j_1006 - gap_1006;
                }
                A_1006[j_1006] = temp_1006;
            }
            gap_1006 = gap_1006 / 2;
        }
    }

    public static void main(String[] args_1006) {
        int[] data_1006 = {1, 10, 4, 6, 8, 9, 7, 2, 1, 5};

        System.out.print("Sebelum : ");
        printArray_1006(data_1006);

        shellSort_1006(data_1006);

        System.out.print("Sesudah (Shell Sort): ");
        printArray_1006(data_1006);
    }

    public static void printArray_1006(int[] arr_1006) {
       for (int i_1006 : arr_1006) {
       System.out.print(i_1006 + " ");
       System.out.println();
    }

 }

}