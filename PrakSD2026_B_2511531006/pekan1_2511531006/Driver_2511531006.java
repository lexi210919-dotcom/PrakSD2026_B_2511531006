package pekan1_2511531006;

public class Driver_2511531006 {
    static Mobil_2511531006[] listMobil = new Mobil_2511531006[10];
    static int jumlah = 0;

    public static void main(String[] args) {
        
        // Method Tambah Mobil
        tambah("Avanza", 2020, 1300, 150000000L, "Toyota");
        tambah("Civic", 2022, 1500, 500000000L, "Honda");
        
        System.out.println("\n--- Data Awal ---");
        tampil();

        // Method Hapus Mobil
        System.out.println();
        hapus(0); // Hapus index 0
        
        System.out.println("\n--- Data Akhir ---");
        tampil();
    }

    static void tambah(String n, int t, int c, long h, String m) {
        if (jumlah < listMobil.length) {
            listMobil[jumlah] = new Mobil_2511531006(n, t, c, h, m);
            System.out.println("Berhasil tambah: " + n);
            jumlah++;
        }
    }

    static void hapus(int index) {
        if (index >= 0 && index < jumlah) {
            System.out.println("Menghapus: " + listMobil[index].getNama());
            for (int i = index; i < jumlah - 1; i++) {
                listMobil[i] = listMobil[i + 1];
            }
            listMobil[jumlah - 1] = null;
            jumlah--;
        }
    }

    static void tampil() {
        for (int i = 0; i < jumlah; i++) {
            System.out.print((i+1) + ". ");
            listMobil[i].displayInfo();
        }
    }
}

