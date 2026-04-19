package pekan3_2511531006;

public class Website_2511531006 {
    private String judul_1006;
    private String url_1006;
    
    /**
     * Constructor untuk menginisialisasi atribut
     */
    public Website_2511531006(String judul_1006, String url_1006) {
        this.judul_1006 = judul_1006;
        this.url_1006 = url_1006;
    }
    
    /**
     * Getter untuk judul website
     */
    public String getJudul_1006() {
        return judul_1006;
    }
    
    /**
     * Getter untuk URL website
     */
    public String getUrl_1006() {
        return url_1006;
    }
    
    /**
     * Setter untuk judul website
     */
    public void setJudul_1006(String judul_1006) {
        this.judul_1006 = judul_1006;
    }
    
    /**
     * Setter untuk URL website
     */
    public void setUrl_1006(String url_1006) {
        this.url_1006 = url_1006;
    }
    
    /**
     * Method toString untuk menampilkan informasi website
     */
    @Override
    public String toString() {
        return "Judul: " + judul_1006 + "\nURL: " + url_1006;
    }
}

