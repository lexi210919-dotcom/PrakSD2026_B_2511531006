package pekan2_2511531006;

public class Mahasiswa_2511531006 {
    String nim;
    String nama;
    String prodi;

    public Mahasiswa_2511531006(String nim2, String nama2, String prodi2) {
        this.nim = nim2;
        this.nama = nama2;
        this.prodi = prodi2;
    }

    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama + ", Prodi: " + prodi;
    }  
    
}