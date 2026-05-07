package pekan5_2511531006;

public class Pasien_2411531006 {
    // Atribut kelas Pasien
    private String namaPasien_1006;
    private String penyakit_1006;
    private int nomorAntrian_1006;
    private Pasien_2411531006 next_1006;
    
    // Constructor
    public Pasien_2411531006(String namaPasien_1006, String penyakit_1006, int nomorAntrian_1006) {
        this.namaPasien_1006 = namaPasien_1006;
        this.penyakit_1006 = penyakit_1006;
        this.nomorAntrian_1006 = nomorAntrian_1006;
        this.next_1006 = null;
    }
    
    // Getter (Selektor)
    public String getNamaPasien_1006() {
        return namaPasien_1006;
    }
    
    public String getPenyakit_1006() {
        return penyakit_1006;
    }
    
    public int getNomorAntrian_1006() {
        return nomorAntrian_1006;
    }
    
    public Pasien_2411531006 getNext_1006() {
        return next_1006;
    }
    
    // Setter (Mutator)
    public void setNamaPasien_1006(String namaPasien_1006) {
        this.namaPasien_1006 = namaPasien_1006;
    }
    
    public void setPenyakit_1006(String penyakit_1006) {
        this.penyakit_1006 = penyakit_1006;
    }
    
    public void setNomorAntrian_1006(int nomorAntrian_1006) {
        this.nomorAntrian_1006 = nomorAntrian_1006;
    }
    
    public void setNext_1006(Pasien_2411531006 next_1006) {
        this.next_1006 = next_1006;
    }
}