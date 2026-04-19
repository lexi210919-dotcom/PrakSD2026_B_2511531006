package pekan3_2511531006;

import java.util.Stack;
import java.util.Scanner;

public class Browser_2511531006 {
    private Stack<Website_2511531006> history_1006;
    
    /**
     * Constructor untuk menginisialisasi stack
     */
    public Browser_2511531006() {
        history_1006 = new Stack<>();
    }
    
    /**
     * Method untuk mengunjungi website (PUSH)
     */
    public void kunjungiWebsite_1006() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan Judul: ");
        String judul = input.nextLine();
        
        System.out.print("Masukkan URL: ");
        String url = input.nextLine();
        
        // Membuat objek Website dan push ke stack
        Website_2511531006 website = new Website_2511531006(judul, url);
        history_1006.push(website);
        
        System.out.println("\nBerhasil mengunjungi halaman!");
        System.out.println("=== Halaman Aktif ===");
        System.out.println(website);
        System.out.println("==\n");
    }
    
    /**
     * Method Tombol Back (POP) - dengan pengecekan stack kosong
     */
    public void tombolBack_1006() {
        if (history_1006.isEmpty()) {
            System.out.println("History kosong! Tidak ada halaman untuk kembali.\n");
            return;
        }
        
        Website_2511531006 halaman = history_1006.pop();
        System.out.println("Kembali dari halaman:");
        System.out.println(halaman);
        System.out.println("Halaman berhasil ditutup!\n");
    }
    
    /**
     * Method Lihat Halaman Aktif (PEEK) - dengan pengecekan stack kosong
     */
    public void lihatHalamanAktif_1006() {
        if (history_1006.isEmpty()) {
            System.out.println("History kosong! Tidak ada halaman aktif.\n");
            return;
        }
        
        Website_2511531006 halamanAktif = history_1006.peek();
        System.out.println("\n=== Halaman Aktif Saat Ini ===");
        System.out.println(halamanAktif);
        System.out.println("==\n");
    }
    
    /**
     * Method cek status history
     */
    public void cekStatusHistory_1006() {
        System.out.println("Status History");
        System.out.println("Jumlah halaman: " + history_1006.size());
        System.out.println("History kosong: " + (history_1006.isEmpty() ? "Ya" : "Tidak"));
        System.out.println("==\n");
    }
    
    /**
     * Method main untuk menjalankan program
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Browser_2511531006 browser = new Browser_2511531006();
        
        System.out.println("=== Browser History NIM: 2511531006 ===\n");
        
        int pilihan;
        do {
            System.out.println("1. Kunjungi Website (Push)");
            System.out.println("2. Tombol Back (Pop)");
            System.out.println("3. Lihat Halaman Aktif (Peek)");
            System.out.println("4. keluar");
            System.out.print("Pilihan: ");
            
            pilihan = input.nextInt();
            input.nextLine(); // consume newline
            
            System.out.println(); // empty line
            
            switch (pilihan) {
                case 1:
                    browser.kunjungiWebsite_1006();
                    break;
                case 2:
                    browser.tombolBack_1006();
                    break;
                case 3:
                    browser.lihatHalamanAktif_1006();
                    break;
                case 4:
                    browser.cekStatusHistory_1006();
                    break;
                case 5:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-5.\n");
            }
        } while (pilihan != 5);
        
        input.close();
    }
}
