package pekan4_2511531006S;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedList_2511531006 {


	public static void main(String[] args) {
		Queue<Integer> q_2511531006 = new LinkedList<>();
		// tambah elemen {0, 1, 2, 3, 4,5} ke anterian
		for (int i = 0; i < 6; i++)
			q_2511531006.add(i);
		// menampilkan isi antrian.
		System.out.println("Elemen Antrian " + q_2511531006);
		// Untuk menghapus kepala antrian.
		int hapus = q_2511531006.remove();
		System.out.println("Hapus elemen = " + hapus);
		System.out.println(q_2511531006);
		// Untuk melihat antrian terdepan
		int depan = q_2511531006.peek();
		System.out.println("Kepalan antrian " + depan);
		
		int banyak = q_2511531006.size();
		System.out.println("Size antrian = " + banyak);
		

	}

}
