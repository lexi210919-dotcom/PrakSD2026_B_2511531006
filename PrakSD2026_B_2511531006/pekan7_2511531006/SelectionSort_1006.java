package pekan7_2511531006;

public class SelectionSort_1006 {

    public static void selectionSort_1006(int[] arr_1006) {
      int n_1006 = arr_1006.length;
      for (int i_1006 = 0; i_1006 < n_1006; i_1006++) {
           int minIndex_1006 = i_1006;
           for (int j_1006 = i_1006 + 1; j_1006 < n_1006; j_1006++) {
               if (arr_1006[j_1006] < arr_1006[minIndex_1006]) {
                   minIndex_1006 = j_1006;
                }
            }

            int temp_1006 = arr_1006[i_1006];
            arr_1006[i_1006] = arr_1006[minIndex_1006];
            arr_1006[minIndex_1006] = temp_1006;
        }
    }
     public static void main(String[] args) {
    	 int arr_1006[] = {23, 78, 45, 8, 32, 56, 1};

        int n_1006 = arr_1006.length;
         System.out.print("array yang belum terurut:\n");
         for (int i_1006 = 0; i_1006 < n_1006; i_1006++) {

            System.out.print(arr_1006[i_1006] + " ");
        }

        System.out.println("");
        selectionSort_1006(arr_1006);
        System.out.print("array yang terurut:\n");
        for (int i_1006 = 0; i_1006 < n_1006; i_1006++) {
          System.out.print(arr_1006[i_1006] + " ");
        }

        System.out.println("");
    }
}