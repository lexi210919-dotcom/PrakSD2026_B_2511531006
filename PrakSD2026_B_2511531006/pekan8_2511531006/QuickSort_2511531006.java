package pekan8_2511531006;

public class QuickSort_2511531006 {

    static void swap_1006(int[] arr_1006, int i_1006, int j_1006)
    {
        int temp_1006 = arr_1006[i_1006];
        arr_1006[i_1006] = arr_1006[j_1006];
        arr_1006[j_1006] = temp_1006;
    }

    // Metode untuk mengatur pivot menggunakan Median-of-Three
    static void medianOfThree_1006(int[] arr_1006, int low_1006, int high_1006) 
    {
        int mid_1006 = low_1006 + (high_1006 - low_1006) / 2;

        // Urutkan elemen low, mid, dan high
        if (arr_1006[low_1006] > arr_1006[mid_1006]) {
            swap_1006(arr_1006, low_1006, mid_1006);
        }
        if (arr_1006[low_1006] > arr_1006[high_1006]) {
            swap_1006(arr_1006, low_1006, high_1006);
        }
        if (arr_1006[mid_1006] > arr_1006[high_1006]) {
            swap_1006(arr_1006, mid_1006, high_1006);
        }
       swap_1006(arr_1006, mid_1006, high_1006);
    }
    static int partition_1006(int[] arr_1006, int low_1006, int high_1006) 
    {
        // tampil fungsi medianOfthree sebelum menentukan pivot
        medianOfThree_1006(arr_1006, low_1006, high_1006);

        int pivot_1006 = arr_1006[high_1006]; // Sekarang arr [high] sudah  berisi nilai median 
        int i_1006 = (low_1006 - 1);

        for (int j_1006 = low_1006; j_1006 <= high_1006 - 1; j_1006++) {
            //  jika elemen  saat ini  lebih kecil dari  atau sama dengan pivot
            if (arr_1006[j_1006] < pivot_1006) {
                // Increment indeks  elemen yang lebih kecil
                i_1006++;
                swap_1006(arr_1006, i_1006, j_1006);
            }
        }

        swap_1006(arr_1006, i_1006 + 1, high_1006);
        return (i_1006 + 1);
    }

    static void quickSort_1006(int[] arr_1006, int low_1006, int high_1006) {

        if (low_1006 < high_1006) {
            int pi_1006 = partition_1006(arr_1006, low_1006, high_1006);
            quickSort_1006(arr_1006, low_1006, pi_1006 - 1);
            quickSort_1006(arr_1006, pi_1006 + 1, high_1006);
        }
    }

    static void printArray_1006(int[] arr_1006) {

     for (int i_1006 = 0; i_1006 < arr_1006.length; i_1006++) {
    	 System.out.print(arr_1006[i_1006] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args_1006)
    {
        int[] arr_1006 = {10, 7, 8, 9, 1, 5};
        int N_1006 = arr_1006.length;
        System.out.print(" Data Sebelum  diurutkan: ");
        printArray_1006(arr_1006);

        quickSort_1006(arr_1006, 0, N_1006 - 1);
        
        System.out.print("Data Terurut Quick Sort : ");
        printArray_1006(arr_1006);
    }
}