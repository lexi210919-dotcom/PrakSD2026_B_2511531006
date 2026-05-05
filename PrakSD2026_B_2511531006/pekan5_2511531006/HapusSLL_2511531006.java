package pekan5_2511531006;

public class HapusSLL_2511531006 {
	// fungsi untuk menghapus head
	public static  NodeSLL_2511531006 deleteHead(NodeSLL_2511531006 head) {
		// jika SLL kosong
		if (head == null)
			return null;
		// pindahkan head ke node berikutnya
		head = head.next_2511531006;
		return head;}
	
	// fungsi menghapus node terakhir  SLL
		public static NodeSLL_2511531006 removeLastNode(NodeSLL_2511531006 head) {
			// jika list kosong , return null
			if (head == null) {
				return null;
			}
			// jika list satu node , hapus node dan return null
			if (head.next_2511531006 == null) {
				return null;
			}
			// temukan node tarkhir ke dua
			NodeSLL_2511531006 secondLast = head;
			while (secondLast.next_2511531006.next_2511531006 != null) {
				secondLast = secondLast.next_2511531006;
			}
			// hapus node terakhir
			secondLast.next_2511531006 = null;
			return head;   }
		
		
          // fungsi menghapus node di posisi tertentu
	        public static NodeSLL_2511531006 deleteNode(NodeSLL_2511531006 head, int position) {
	        	NodeSLL_2511531006 temp = head;
	        	NodeSLL_2511531006 prev = null;
	      // jika  linked list null
	        if (temp == null)
	        	return head;
	      // kasus 1: head dihapus
	      if (position == 1) {
	    	  head = temp.next_2511531006;
	    	  return head;}
	      
	    	// kasus 2: menghapus  node di tengah 
	    	// telusuri ke node yang di hapus
	     for (int  i=  1; temp != null && i < position ; i++) {
	    	 prev = temp;
	    	 temp = temp.next_2511531006;}
	    	//  jika ditemukan,hapus node
	    	 if (temp != null) {
	    		 prev.next_2511531006 = temp.next_2511531006;
	    	 } else {
	    		 System.out.println("Data tidak ada");}
	    		 return head;
	      
	     }
	     
	    	 // fungsi mencetak SLL
	    	 public  static  void printList(NodeSLL_2511531006 head) {
	    		 NodeSLL_2511531006 curr = head;
	    		 while (curr.next_2511531006 != null) {
	    			 System.out.print(curr.data_2511531006+"-->");
	    			 curr = curr.next_2511531006;
	    		if (curr.next_2511531006==null) {
	    			System.out.print(curr.data_2511531006);     }
	    		System.out.println(); }
	    	 }
	    	// kelas main
	    		 
	    	public  static void main(String[] args) {
	       //  buat SLL  1 -> 2 -> 3-> 4-> 5-> 6-> null
	    		NodeSLL_2511531006 head = new NodeSLL_2511531006(1);
	    		head.next_2511531006 = new NodeSLL_2511531006(2);
	    		head.next_2511531006.next_2511531006 = new NodeSLL_2511531006(3);
	    		head.next_2511531006.next_2511531006.next_2511531006 = new NodeSLL_2511531006(4);
	    		head.next_2511531006.next_2511531006.next_2511531006.next_2511531006 = new NodeSLL_2511531006(5);
	    		head.next_2511531006.next_2511531006.next_2511531006.next_2511531006.next_2511531006 = new NodeSLL_2511531006(6);
	    	// cetak list awal 
	    	System.out.println("list awal:");
	    	printList(head);
	    	// hapus head
	    	head = deleteHead(head);
	    	System.out.print("List setelah head dihapus:");
	    	printList(head);
	    	// hapus node terakhir 
	    	head = removeLastNode(head);
	    	System.out.println("List setelah simpul  terakhir di hapus:");
	    	printList(head);
	    	// Deleting node at position 2
	    	int position =2;
	    	head = deleteNode(head, position);
	    	// Print list after deletion
	    	System.out.println("List setelah posisi 2 dihapus:");
	    	printList(head);
	    }
    }


		
	    		
	    		
	    		
	    		
	    		 
	    		 
	    	
	    	 
	    	 
	   
	


