package pekan2_2511531006;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist_2311531006 {
    private ArrayList<Musik_2511531006> playlist_1006;
    private Scanner input_1006;
    
    // Constructor
    public Playlist_2311531006() {
        playlist_1006 = new ArrayList<>();
        input_1006 = new Scanner(System.in);
    }
    
    // Method tambah lagu
    public void tambahLagu_1006() {
        System.out.print("Masukkan Judul: ");
        String judul = input_1006.nextLine();
        
        System.out.print("Masukkan Penyanyi: ");
        String penyanyi = input_1006.nextLine();
        
        System.out.print("Masukkan Durasi (detik): ");
        int durasi = input_1006.nextInt();
        input_1006.nextLine(); // consume newline
        
        Musik_2511531006 laguBaru_1006 = new Musik_2511531006(judul, penyanyi, durasi);
        playlist_1006.add(laguBaru_1006);
        
        System.out.println("Data berhasil ditambahkan!");
        System.out.println();
    }
    
    // Method lihat playlist
    public void lihatPlaylist_1006() {
        if (playlist_1006.isEmpty()) {
            System.out.println("Playlist masih kosong!");
        } else {
            System.out.println("=== DAFTAR LAGU ===");
            for (int i = 0; i < playlist_1006.size(); i++) {
                System.out.print((i + 1) + ". ");
                playlist_1006.get(i).tampilkan_1006();
            }
        }
        System.out.println();
    }
    
    // Method hapus lagu
    public void hapusLagu_1006() {
        lihatPlaylist_1006();
        
        if (!playlist_1006.isEmpty()) {
            System.out.print("Masukkan nomor lagu yang ingin dihapus (1-" + playlist_1006.size() + "): ");
            int indeks = input_1006.nextInt() - 1;
            input_1006.nextLine(); // consume newline
            
            if (indeks >= 0 && indeks < playlist_1006.size()) {
                String judulHapus = playlist_1006.get(indeks).getJudul_1006();
                playlist_1006.remove(indeks);
                System.out.println("Lagu '" + judulHapus + "' berhasil dihapus!");
            } else {
                System.out.println("Indeks tidak valid!");
            }
        }
        System.out.println();
    }
    
    // Method cek kapasitas (pake .size())
    public void cekKapasitas_1006() {
        System.out.println("Jumlah lagu di playlist: " + playlist_1006.size());
        System.out.println();
    }
    
    // Method menu utama 
    public void menuUtama_1006() {
        int pilihan;
        
        do {
            System.out.println("=== Playlist Musik NIM: 2511531006 ===");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Lihat Playlist");
            System.out.println("3. Hapus Lagu");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");
            
            pilihan = input_1006.nextInt();
            input_1006.nextLine(); // consume newline
            System.out.println();
            
            switch (pilihan) {
                case 1:
                    tambahLagu_1006();
                    break;
                case 2:
                    lihatPlaylist_1006();
                    break;
                case 3:
                    hapusLagu_1006();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    System.out.println();
            }
        } while (pilihan != 4);
    }
    
    // Main method
    public static void main(String[] args) {
        Playlist_2311531006 playlist = new Playlist_2311531006();
        playlist.menuUtama_1006();
    }
}
