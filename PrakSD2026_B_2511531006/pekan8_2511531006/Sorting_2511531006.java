package pekan8_2511531006;

public class Sorting_2511531006 {

    static class Lagu {
        String judul;
        String penyanyi;
        int durasi;

    Lagu(String judul, String penyanyi, int durasi) {
         this.judul = judul;
         this.penyanyi = penyanyi;
         this.durasi = durasi;
        }
    }

    Lagu[] dataLagu_1006 = new Lagu[7];
    int n = 0;

    // Method input data
    void inputData_1006() {
        dataLagu_1006[0] = new Lagu("Mio Cristo Piange Diamanti", "Il Giardino Dei Semplici", 270);
        dataLagu_1006[1] = new Lagu("La Rumba Del Perdon", "Diego Torres", 252);
        dataLagu_1006[2] = new Lagu("La Perla", "Chayanne", 196);
        dataLagu_1006[3] = new Lagu("Bambino", "Sergio Cammare", 150);
        dataLagu_1006[4] = new Lagu("Malaguena Salerosa", "Luis Miguel", 210);
        dataLagu_1006[5] = new Lagu("Corazon Espinado", "Santana", 245);
        dataLagu_1006[6] = new Lagu("Amarte Duele", "Jesse McCartney", 205);

        n = 7;
    }

    void tampilData_1006(String kondisi) {
        System.out.println("\n" + kondisi + ":");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + dataLagu_1006[i].judul + " - " + dataLagu_1006[i].durasi + " detik");
        }
    }

    void shellSort_1006() {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Lagu temp = dataLagu_1006[i];
                int j;
                for (j = i; j >= gap; j -= gap) {
                    if (dataLagu_1006[j - gap].judul.compareTo(temp.judul) > 0) {
                        dataLagu_1006[j] = dataLagu_1006[j - gap];
                    } else {
                        break;
                    }
                }
                dataLagu_1006[j] = temp;
            }
        }
    }

    void quickSort_1006(int low, int high) {
        if (low < high) {
            int pi = partition_1006(low, high);
            quickSort_1006(low, pi - 1);
            quickSort_1006(pi + 1, high);
        }
    }

    int partition_1006(int low, int high) {
        int pivot = dataLagu_1006[high].durasi;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (dataLagu_1006[j].durasi < pivot) {
                i++;
                Lagu temp = dataLagu_1006[i];
                dataLagu_1006[i] = dataLagu_1006[j];
                dataLagu_1006[j] = temp;
            }
        }
        Lagu temp = dataLagu_1006[i + 1];
        dataLagu_1006[i + 1] = dataLagu_1006[high];
        dataLagu_1006[high] = temp;
        return i + 1;
    }

    void mergeSort_1006(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort_1006(left, mid);
            mergeSort_1006(mid + 1, right);
            merge_1006(left, mid, right);
        }
    }

    void merge_1006(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Lagu[] leftArr = new Lagu[n1];
        Lagu[] rightArr = new Lagu[n2];

        for (int i = 0; i < n1; i++) leftArr[i] = dataLagu_1006[left + i];
        for (int j = 0; j < n2; j++) rightArr[j] = dataLagu_1006[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i].judul.compareTo(rightArr[j].judul) <= 0) {
                dataLagu_1006[k] = leftArr[i];
                i++;
            } else {
                dataLagu_1006[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < n1) dataLagu_1006[k++] = leftArr[i++];
        while (j < n2) dataLagu_1006[k++] = rightArr[j++];
    }

    public static void main(String[] args) {
        Sorting_2511531006 program = new Sorting_2511531006();
        java.util.Scanner scan = new java.util.Scanner(System.in);

        System.out.println("=== Sorting Playlist NIM: 2511531006 ===");
        System.out.print("\nPilih Algoritma (1=Shell, 2=Quick, 3=Merge): ");
        int pilihan = scan.nextInt();

        program.inputData_1006();
        program.tampilData_1006("Data Sebelum Sorting");

        if (pilihan == 1) {
            program.shellSort_1006();
            program.tampilData_1006("Data Setelah Shell Sort (Judul A-Z)");
        } else if (pilihan == 2) {
            program.quickSort_1006(0, program.n - 1);
            program.tampilData_1006("Data Setelah Quick Sort (Durasi Asc)");
        } else if (pilihan == 3) {
            program.mergeSort_1006(0, program.n - 1);
            program.tampilData_1006("Data Después Merge Sort (Judul A-Z)");
        }
    }
}