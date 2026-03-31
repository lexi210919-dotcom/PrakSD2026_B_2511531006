package pekan1_2511531006;

import java.util.Scanner;

public class JamDriver2_2511531006 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.println("=== Program Driver Objek Jam ===");
        // 1. Input Jam Pertama
        System.out.println("\n--- Input Jam 1 ---");
        Jam_2511531006 j1 = buatJamDariInput(input);
       
        // 2. Input Jam Kedua
        System.out.println("\n--- Input Jam 2 ---");
        Jam_2511531006 j2 = buatJamDariInput(input);
      
        // 3. Menampilkan Data
        System.out.println("\n--- Hasil Operasi ---");
        System.out.println("Jam 1 (String): " + j1.toString());
        System.out.println("Jam 2 (String): " + j2.toString());
        System.out.println("Jam 1 dalam detik: " + j1.toSeconds());
        System.out.println("Jam 2 dalam detik: " + j2.toSeconds());
       
        // 4. Operasi Relasional (Perbandingan)
        int perbandingan = j1.compareTo(j2);
        if (perbandingan > 0) {
            System.out.println("Status: Jam 1 lebih lambat (setelah Jam 2");
        } else if (perbandingan < 0) {
            System.out.println("Status: Jam 1 lebih awal (sebelum Jam 2");
        } else {
            System.out.println("Status: Jam 1 dan Jam 2 sama persis");
        }
      
        // 5. Operasi Aritmatika
        System.out.println("Durasi (J1 ke J2) : " + Jam_2511531006.durasiDetik(j1, j2) + " detik");

        Jam_2511531006 jNext = j1.nextSecond();
        System.out.println("Jam 1 detik berikutnya: " + jNext);

        Jam_2511531006 jPrev = j2.previousSecond();
        System.out.println("Jam 1 detik sebelumnya: " + jPrev);
       
        // 6. Operasi Penjumlahan Jam
        Jam_2511531006 jHasilPlus = j1.plus(j2);
        System.out.println("Hasil J1 + J2: " + jHasilPlus);

        input.close();
        System.out.println("\nProgram Selesai");
    }
    /**
     * Prosedur pembantu untuk melakukan input dan validasi secara berulang
     * sampai user memasukan angka yang benar (0..23, 0..59).
     */
      private static Jam_2511531006 buatJamDariInput(Scanner sc) {
      
    	int h, m, s;
        while (true) {
            System.out.print("Masukan Jam (0-23): ");
            h = sc.nextInt();
            System.out.print("Masukan Menit (0-59): ");
            m = sc.nextInt();
            System.out.print("Masukan Detik (0-59): ");
            s = sc.nextInt();

            // Memanggil method static isValid dari kelas jam
            if (Jam_2511531006.isValid(h, m, s)) {
                return new Jam_2511531006 (h, m, s);
            } else {
                System.out.println("[Error] Input tidak valid! Silahkan ulangi.\n");
            }

        }

	}

}
