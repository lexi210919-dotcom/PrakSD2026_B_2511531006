package pekan1_2511531006;

public class Mobil_2511531006 {
	private String nama;
    private int tahun;
    private int cc;
    private long harga;
    private String merk;

    // Konstruktor (PENTING: pakai this. agar tidak null)
    public Mobil_2511531006(String nama, int tahun, int cc, long harga, String merk) {
        this.nama = nama;
        this.tahun = tahun;
        this.cc = cc;
        this.harga = harga;
        this.merk = merk;
    }

    // Selektor (Getter)
    public String getNama() { return nama; }
    public String getMerk() { return merk; }

    // Mutator (Setter)
    public void setNama(String nama) { this.nama = nama; }

    public void displayInfo() {
        System.out.println(nama + " [" + merk + "] - Thn: " + tahun + " - CC: " + cc + " - Harga: " + harga);
    }
}
