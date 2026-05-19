package pekan7_2511531006;

public class InsertionSort_2511531006 {
   public static void insertionSort_1006(int[] arr_1006) {
       int n_1006 = arr_1006.length;
       for (int i_1006 = 1; i_1006 < n_1006; i_1006++) {
            int key_1006 = arr_1006[i_1006];
            int j_1006 = i_1006 - 1;
            while (j_1006 >= 0 && arr_1006[j_1006] > key_1006) {
                  arr_1006[j_1006 + 1] = arr_1006[j_1006];
                  j_1006--;
            }
           arr_1006[j_1006 + 1] = key_1006;
        }
    }
   public static void main(String[] args) {
       int arr_1006[] = {23, 70, 45, 8, 32, 56, 1};
       int n_1006 = arr_1006.length;
       System.out.print("array yang belum terurut:\n");
       for (int i_1006 = 0; i_1006 < n_1006; i_1006++) {
           System.out.print(arr_1006[i_1006] + " ");
        }
       System.out.println("");
       insertionSort_1006(arr_1006);
       System.out.print("array yang terurut:\n");
       for (int i_1006 = 0; i_1006 < n_1006; i_1006++) {
       System.out.print(arr_1006[i_1006] + " ");
        }
      System.out.println("");
    }
}