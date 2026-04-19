package pekan2_2511531006;

public class Musik_2511531006 {
    // Atribut dengan akhiran 4 digit terakhir NIM (1006)
    private String judul_1006;
    private String penyanyi_1006;
    private int durasi_1006;
    
    // Constructor
    public Musik_2511531006(String judul_1006, String penyanyi_1006, int durasi_1006) {
        this.judul_1006 = judul_1006;
        this.penyanyi_1006 = penyanyi_1006;
        this.durasi_1006 = durasi_1006;
    }
    
    // Getter (Selektor)
    public String getJudul_1006() {
        return judul_1006;
    }
    
    public String getPenyanyi_1006() {
        return penyanyi_1006;
    }
    
    public int getDurasi_1006() {
        return durasi_1006;
    }
    
    // Setter (Mutator)
    public void setJudul_1006(String judul_1006) {
        this.judul_1006 = judul_1006;
    }
    
    public void setPenyanyi_1006(String penyanyi_1006) {
        this.penyanyi_1006 = penyanyi_1006;
    }
    
    public void setDurasi_1006(int durasi_1006) {
        this.durasi_1006 = durasi_1006;
    }
    
    // Method untuk menampilkan data lagu
    public void tampilkan_1006() {
        System.out.println("Judul: " + judul_1006);
        System.out.println("Penyanyi: " + penyanyi_1006);
        System.out.println("Durasi: " + durasi_1006 + " detik");
        System.out.println("-------------------");
    }
}
