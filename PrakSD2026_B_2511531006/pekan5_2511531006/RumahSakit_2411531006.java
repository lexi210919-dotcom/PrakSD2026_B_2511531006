package pekan5_2511531006;

import java.util.Scanner;

 public class RumahSakit_2411531006 {
    private Pasien_2411531006 head_1006;
    private int counter_1006 = 0;
    
    // 1. Daftarkan Pasien (Insert at Tail)
    public void daftarkanPasien_1006() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Nama Pasien : ");
        String namaPasien_1006 = sc.nextLine();
        System.out.print("Masukkan Keluhan     : ");
        String penyakit_1006 = sc.nextLine();
        
        // Auto-increment nomor antrian
        counter_1006++;
        Pasien_2411531006 nodeBaru_1006 = new Pasien_2411531006(namaPasien_1006, penyakit_1006, counter_1006);
        
        // Jika list kosong, node baru langsung menjadi head
        if (head_1006 == null) {
            head_1006 = nodeBaru_1006;
        } else {
            // Menambahkan node pasien baru di akhir linked list
            Pasien_2411531006 current_1006 = head_1006;
            while (current_1006.getNext_1006() != null) {
                current_1006 = current_1006.getNext_1006();
            }
            current_1006.setNext_1006(nodeBaru_1006);
        }
        System.out.println("Pasien berhasil didaftarkan! Nomor Antrian: " + counter_1006 + "\n");
    }
    
    // 2. Panggil Pasien (Delete Head)
    public void panggilPasien_1006() {
        if (head_1006 == null) {
            System.out.println("Antrian kosong! Tidak ada pasien yang bisa dipanggil.\n");
            return;
        }
        
        // Menampilkan data pasien yang dipanggil
        System.out.println("\n=== PASIEN DIPANGGIL ===");
        System.out.println("Nomor Antrian: " + head_1006.getNomorAntrian_1006());
        System.out.println("Nama Pasien  : " + head_1006.getNamaPasien_1006());
        System.out.println("Keluhan      : " + head_1006.getPenyakit_1006());
        
        // Head digeser ke node berikutnya
        head_1006 = head_1006.getNext_1006();
        System.out.println("Pasien telah dipanggil dan keluar dari antrian.\n");
    }
    
    // 3. Tampilkan Antrian (Display)
    public void tampilkanAntrian_1006() {
        if (head_1006 == null) {
            System.out.println("Antrian kosong!\n");
            return;
        }
        
        System.out.println("\n=== DAFTAR ANTRIAN PASIEN ===");
        Pasien_2411531006 current_1006 = head_1006;
        int posisi_1006 = 1;
        
        // Menelusuri linked list dari head hingga null
        while (current_1006 != null) {
            System.out.println("Posisi " + posisi_1006 + ":");
            System.out.println("  No.Antri: " + current_1006.getNomorAntrian_1006());
            System.out.println("  Nama    : " + current_1006.getNamaPasien_1006());
            System.out.println("  Keluhan : " + current_1006.getPenyakit_1006());
            System.out.println();
            current_1006 = current_1006.getNext_1006();
            posisi_1006++;
        }
    }
    
    // 4. Cari Pasien (Search) - CaseInsensitive
    public void cariPasien_1006() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama pasien yang dicari: ");
        String namaCari_1006 = sc.nextLine().toLowerCase();
        
        Pasien_2411531006 current_1006 = head_1006;
        boolean ditemukan_1006 = false;
        
        // Pencarian berdasarkan nama pasien secara CaseInsensitive
        while (current_1006 != null) {
            if (current_1006.getNamaPasien_1006().toLowerCase().equals(namaCari_1006)) {
                System.out.println("\n=== PASIEN DITEMUKAN ===");
                System.out.println("No.Antri: " + current_1006.getNomorAntrian_1006());
                System.out.println("Nama    : " + current_1006.getNamaPasien_1006());
                System.out.println("Keluhan : " + current_1006.getPenyakit_1006());
                ditemukan_1006 = true;
                break;
            }
            current_1006 = current_1006.getNext_1006();
        }
        
        if (!ditemukan_1006) {
            System.out.println("Pasien tidak ditemukan!\n");
        }
    }
    
    // 5. Cek Status Antrian
    public void cekStatusAntrian_1006() {
        int jumlahPasien_1006 = 0;
        Pasien_2411531006 current_1006 = head_1006;
        
        // Menghitung jumlah total pasien
        while (current_1006 != null) {
            jumlahPasien_1006++;
            current_1006 = current_1006.getNext_1006();
        }
        
        if (jumlahPasien_1006 == 0) {
            System.out.println("Antrian kosong! Total pasien: 0\n");
        } else {
            System.out.println("Jumlah total pasien: " + jumlahPasien_1006);
            System.out.println("Pasien terdepan:");
            System.out.println("No.Antri: " + head_1006.getNomorAntrian_1006());
            System.out.println("Nama    : " + head_1006.getNamaPasien_1006());
            System.out.println("Keluhan : " + head_1006.getPenyakit_1006() + "\n");
        }
    }
    
    public static void main(String[] args) {
        RumahSakit_2411531006 rumahSakit_1006 = new RumahSakit_2411531006();
        Scanner scanner_1006 = new Scanner(System.in);
        int pilihan_1006;
        
        do {
            System.out.println("=== Antrian Rumah Sakit NIM: 2411531006===");
            System.out.println("1. Daftarkan Pasien (Insert)");
            System.out.println("2. Panggil Pasien   (Delete Head)");
            System.out.println("3. Tampilkan Antrian (Display)");
            System.out.println("4. Cari Pasien      (Search)");
            System.out.println("5. Cek Status Antrian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan: ");
            
            pilihan_1006 = scanner_1006.nextInt();
            scanner_1006.nextLine();
            
            switch (pilihan_1006) {
                case 1:
                    rumahSakit_1006.daftarkanPasien_1006();
                    break;
                case 2:
                    rumahSakit_1006.panggilPasien_1006();
                    break;
                case 3:
                    rumahSakit_1006.tampilkanAntrian_1006();
                    break;
                case 4:
                    rumahSakit_1006.cariPasien_1006();
                    break;
                case 5:
                    rumahSakit_1006.cekStatusAntrian_1006();
                    break;
                case 6:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!\n");
            }
        } while (pilihan_1006 != 6);
    }
}