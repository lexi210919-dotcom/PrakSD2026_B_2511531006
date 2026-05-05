package pekan5_2511531006;

public class PencarianSLL_2511531006 {
     static boolean searchKey(NodeSLL_2511531006 head, int key) {
    	 NodeSLL_2511531006 curr=head;
    	 while (curr !=null) {
    	    if (curr.data_2511531006 == key)
    	    	return true;
    	    curr = curr.next_2511531006; }
    	 return false;  }
     public static void traversal (NodeSLL_2511531006 head) {
    	 // mulai dari head
    	 NodeSLL_2511531006 curr = head;
    	 // telusuri sampai pointer null
    	 while(curr !=null) {
    		 System.out.print(" " + curr.data_2511531006);
    		 curr = curr.next_2511531006;   }
    	 System.out.println();     }
      public static void main(String[] args) {
    	  NodeSLL_2511531006 head = new NodeSLL_2511531006(4);
    	  head.next_2511531006 = new NodeSLL_2511531006(14);
    	  head.next_2511531006.next_2511531006 = new NodeSLL_2511531006(21);
    	  head.next_2511531006.next_2511531006.next_2511531006= new NodeSLL_2511531006(30);
    	  head.next_2511531006.next_2511531006.next_2511531006.next_2511531006 = new NodeSLL_2511531006(10);
    	  System.out.print("Penelusuran SLL:");
    	  traversal(head);
    	  // data yang kan dicari
    	  int key = 30;
    	  System.out.print("cari data " + key+ " = ");
    	  if (searchKey(head, key))
    		  System.out.println("ketemu");
    	  else
    		  System.out.println("tidak ada");
    	  	

	}

}
