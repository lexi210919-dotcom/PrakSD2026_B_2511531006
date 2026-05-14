package pekan6_2511531006S;

import java.util.Scanner;

public class Musik_2511531006 {

	private Lagu_2511531006 head_1006;
    private Lagu_2511531006 tail_1006;
    
    public Musik_2511531006() {
        head_1006 = null;
        tail_1006 = null;
    }
    
    // 1. tambahLagu_1006()
    public void tambahLagu_1006(String judul, String penyanyi) {
        Lagu_2511531006 baru = new Lagu_2511531006(judul, penyanyi);
        if (head_1006 == null) {
            head_1006 = tail_1006 = baru;
        } else {
            tail_1006.setNext_1006(baru);
            baru.setPrev_1006(tail_1006);
            tail_1006 = baru;
        }
        System.out.println("Lagu berhasil ditambahkan!");
    }
    
    // 2. hapusLaguAwal_1006()
    public void hapusLaguAwal_1006() {
        if (head_1006 == null) {
            System.out.println("Playlist kosong!");
            return;
        }
        if (head_1006 == tail_1006) {
            head_1006 = tail_1006 = null;
        } else {
            head_1006 = head_1006.getNext_1006();
            head_1006.setPrev_1006(null);
        }
        System.out.println("Lagu pertama berhasil dihapus!");
    }
    
    // 3. tampilMaju_1006()
    public void tampilMaju_1006() {
        if (head_1006 == null) {
            System.out.println("Playlist kosong!");
            return;
        }
        System.out.println("\n=== PLAYLIST MAJU ===");
        Lagu_2511531006 tmp = head_1006;
        int i = 1;
        while (tmp != null) {
            System.out.printf("%d. %s - %s%n", i++, tmp.getJudul_1006(), tmp.getPenyanyi_1006());
            tmp = tmp.getNext_1006();
        }
    }
    
    // 4. tampilMundur_1006() 
    public void tampilMundur_1006() {
        if (tail_1006 == null) {
            System.out.println("Playlist kosong!");
            return;
        }
        System.out.println("\n=== PLAYLIST MUNDUR ===");
        Lagu_2511531006 tmp = tail_1006;
        int i = 1;
        while (tmp != null) {
            System.out.printf("%d. %s - %s%n", i++, tmp.getJudul_1006(), tmp.getPenyanyi_1006());
            tmp = tmp.getPrev_1006();
        }
    }
    
    // 5. cariLagu_1006(judul)
    public void cariLagu_1006(String judul) {
        if (head_1006 == null) {
            System.out.println("Playlist kosong!");
            return;
        }
        Lagu_2511531006 tmp = head_1006;
        boolean found = false;
        while (tmp != null) {
            if (tmp.getJudul_1006().toLowerCase().contains(judul.toLowerCase())) {
                System.out.printf("Ditemukan: %s - %s%n", tmp.getJudul_1006(), tmp.getPenyanyi_1006());
                found = true;
            }
            tmp = tmp.getNext_1006();
        }
        if (!found) System.out.println("Lagu tidak ditemukan!");
    }
    
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Musik_2511531006 playlist = new Musik_2511531006();
        int pilihan;
        
        do {
            System.out.println("\n=== Playlist Musik NIM: 2511531006 ===");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Hapus Lagu Pertama");
            System.out.println("3. Lihat Playlist (Maju)");
            System.out.println("4. Lihat Playlist (Mundur)");
            System.out.println("5. Cari Lagu");
            System.out.println("6. Keluar");
            System.out.println();
            System.out.print("Pilihan: ");
            
            pilihan = sc.nextInt();
            sc.nextLine();
            
            switch (pilihan) {
                case 1:
                    System.out.print("Judul: ");
                    String judul = sc.nextLine();
                    System.out.print("Penyanyi: ");
                    String penyanyi = sc.nextLine();
                    playlist.tambahLagu_1006(judul, penyanyi);
                    break;
                case 2: playlist.hapusLaguAwal_1006(); break;
                case 3: playlist.tampilMaju_1006(); break;
                case 4: playlist.tampilMundur_1006(); break;
                case 5:
                    System.out.print("Judul lagu yang dicari: ");
                    playlist.cariLagu_1006(sc.nextLine());
                    break;
                case 6: System.out.println("Terima kasih!"); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 6);
        sc.close();
    }
}