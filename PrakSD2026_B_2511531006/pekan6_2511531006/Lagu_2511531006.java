package pekan6_2511531006S;

public class Lagu_2511531006 {

	   public String judul_1006;
	   public String penyanyi_1006;
	   public Lagu_2511531006 next_1006;
	   public Lagu_2511531006 prev_1006;
	    
	    // Constructor
	    public Lagu_2511531006(String judul_1006, String penyanyi_1006) {
	        this.judul_1006 = judul_1006;
	        this.penyanyi_1006 = penyanyi_1006;
	        this.next_1006 = null;
	        this.prev_1006 = null;
	    }
	    
	    // Getter
	    public String getJudul_1006() { return judul_1006; }
	    public String getPenyanyi_1006() { return penyanyi_1006; }
	    public Lagu_2511531006 getNext_1006() { return next_1006; }
	    public Lagu_2511531006 getPrev_1006() { return prev_1006; }
	    
	    // Setter
	    public void setJudul_1006(String judul_1006) { this.judul_1006 = judul_1006; }
	    public void setPenyanyi_1006(String penyanyi_1006) { this.penyanyi_1006 = penyanyi_1006; }
	    public void setNext_1006(Lagu_2511531006 next_1006) { this.next_1006 = next_1006; }
	    public void setPrev_1006(Lagu_2511531006 prev_1006) { this.prev_1006 = prev_1006; }
	
}
