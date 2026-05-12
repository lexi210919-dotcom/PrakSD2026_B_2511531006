package pekan6_2511531006S;

public class PenelusuranDLL_2511531006 {
	// Ffungsi penelusuran maju
	static void forwardTraversal(NodeDLL_2511531006 head_1006) {
		// memulai penelusuran dari head
		NodeDLL_2511531006 curr_1006 = head_1006;
		// lanjutan sampai akhir 
		while (curr_1006 != null) {
			//print data
			System.out.print(curr_1006.data_2511531006 + " <->");
			// pindah ke node berikutnya
			curr_1006 = curr_1006.next_2511531006;
		}
		//print spasi
		System.out.println();
		
	}
	//fungsi penelusuran mundur
	static void backwardTraversal(NodeDLL_2511531006 tail) {
		//mulai dari akhir
		NodeDLL_2511531006 curr_1006 = tail;
		//lanjut sampai head
		while (curr_1006 !=null) {
			//cetak data
			System.out.print(curr_1006.data_2511531006 + " <->");
			//pindah ke node sebelumnya
			curr_1006 = curr_1006.prev_2511531006;
		}
		//cetak spasi
		System.out.println();
	}
	public static void main(String[] args) {
		//cetak DLL
		NodeDLL_2511531006 head_1006 = new NodeDLL_2511531006(1);
		NodeDLL_2511531006 second_2511531006 = new NodeDLL_2511531006(2);
		NodeDLL_2511531006 third_2511531006 = new NodeDLL_2511531006(3);
		
		head_1006.next_2511531006 = second_2511531006;
		second_2511531006.prev_2511531006 = head_1006;
		second_2511531006.next_2511531006 = third_2511531006;
		third_2511531006.prev_2511531006 = second_2511531006;
		
		System.out.println("Penelusuran  maju:");
		forwardTraversal(head_1006);
		
		System.out.println("Penelusuran  mundur");
		backwardTraversal(third_2511531006);
		
	}
		
	}


