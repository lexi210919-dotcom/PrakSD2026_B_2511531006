package pekan8_2511531006;

public class MergeSort_2511531006 {

    void merge_1006(int arr_1006[], int l_1006, int m_1006, int r_1006) {
        // Find size of two subarrays to be merged
    	int n1_1006 = m_1006 - l_1006 + 1;
        int n2_1006 = r_1006 - m_1006;
        /* Create temp arrays*/
        int L_1006[] = new int[n1_1006];
        int R_1006[] = new int[n2_1006];
        /* Copy data to temp arrays*/
        for (int i_1006 = 0; i_1006 < n1_1006; ++i_1006)
            L_1006[i_1006] = arr_1006[l_1006 + i_1006];
        for (int j_1006 = 0; j_1006 < n2_1006; ++j_1006)
            R_1006[j_1006] = arr_1006[m_1006 + 1 + j_1006];
        int i_1006 = 0, j_1006 =0;
        // Initial index of merged subarrays array
        int k_1006 = l_1006;
        while (i_1006 < n1_1006 && j_1006 < n2_1006) {
            if (L_1006[i_1006] <= R_1006[j_1006]) {
                     arr_1006[k_1006] = L_1006[i_1006];
                     i_1006++;
            } else {
                     arr_1006[k_1006] = R_1006[j_1006];
                     j_1006++;
            }
            k_1006++;
        }
        /* Copy remaining elements of L[] if any */
        while (i_1006 < n1_1006) {
           arr_1006[k_1006] = L_1006[i_1006];
            i_1006++;
            k_1006++;
        }
       /* Copy remaining elements of R[] if any */
        while (j_1006 < n2_1006) {
           arr_1006[k_1006] = R_1006[j_1006];
            j_1006++;
            k_1006++;
        }
    }
    void sort_1006(int arr_1006[], int l_1006, int r_1006) {
       if (l_1006 < r_1006) {
          // Find the middle point
          int m_1006 = l_1006 + (r_1006 - l_1006) / 2;
          // Sort first and second halves
          sort_1006(arr_1006, l_1006, m_1006);
          sort_1006(arr_1006, m_1006 + 1, r_1006);
          // Merge the sorted halves
          merge_1006(arr_1006, l_1006, m_1006, r_1006);
    }
}

   /* Utility function to print array of size n*/
   static void printArray_1006(int arr_1006[]) {
        int n_1006 = arr_1006.length;
        for (int i_1006 = 0; i_1006 < n_1006; ++i_1006)
           System.out.print(arr_1006[i_1006] + " ");
        System.out.println();
   }
   public static void main(String[] args_1006) {
        int arr_1006[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Sebelum terurut:");
        printArray_1006(arr_1006);
        MergeSort_2511531006 ob_1006 = new MergeSort_2511531006();
        ob_1006.sort_1006(arr_1006, 0, arr_1006.length - 1);
        System.out.println("\nSesudah Terurut menggunakan Merge Sort:");
        printArray_1006(arr_1006);
}
}