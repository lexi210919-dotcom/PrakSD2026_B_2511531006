package pekan1_2511531006;

public class Driver_2511531006 {
	
    static Mobil_2511531006[] listMobil = new Mobil_2511531006[10];
    static int jumlah = 0; 

    public static void main(String[] args) {
        System.out.println("=== PROGRAM MOBIL NIM 2511531006 ===");
        
        // 1. Tambah mobil 
        tambah("Avanza", 2020, 1300, 150000000L, "Toyota");
        tambah("Civic", 2022, 1500, 500000000L, "Honda");
        
        System.out.println("\n--- Data Awal ---");
        tampil();

        // 2. Hapus mobil 
        System.out.println();
        hapus(0);
        
        System.out.println("\n--- Data Setelah Dihapus ---");
        tampil();
    }

       // Method tambah mobil
         static void tambah(String nama, int thn, int cc, long harga, String merk) {
        if (jumlah < listMobil.length) {
            
            listMobil[jumlah] = new Mobil_2511531006 (nama, thn, cc, harga, merk);
            System.out.println("Berhasil input: " + nama);
            jumlah++;
        } else {
            System.out.println("Array sudah penuh!");
        }
    }

      // Method hapus mobil 
        static void hapus(int index) {
        if (index >= 0 && index < jumlah) {
            System.out.println("Menghapus: " + listMobil[index].getNama());
            
            
            for (int i = index; i < jumlah - 1; i++) {
                listMobil[i] = listMobil[i + 1];
            }
            
            listMobil[jumlah - 1] = null; 
            jumlah--;
        } else {
            System.out.println("Index salah!");
        }
    }

     // Method tampilkan data (Selektor)
       static void tampil() {
        if (jumlah == 0) {
            System.out.println("Data kosong.");
        } else {
            for (int i = 0; i < jumlah; i++) {
                System.out.println((i+1) + ". " + listMobil[i].getNama() + " [" + listMobil[i].getMerk() + "]");
            }
        }
    }
}
