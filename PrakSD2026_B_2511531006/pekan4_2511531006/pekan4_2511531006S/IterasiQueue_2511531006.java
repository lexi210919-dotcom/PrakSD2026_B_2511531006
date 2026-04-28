package pekan4_2511531006S;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class IterasiQueue_2511531006 {

	private static Queue<String> q;

	public static void main(String[] args) {
		{
			Queue<String> q_2511531006 = new LinkedList<>();
			
			q_2511531006.add("Praktikum");
			q_2511531006.add("Struktur");
			q_2511531006.add("Data");
			q_2511531006.add("Dan");
			q_2511531006.add("Algoritma");
			Iterator<String> iterator = q_2511531006.iterator();
			while (iterator.hasNext()) {
				System.out.print(iterator.next() + " ");
			}
		}

	}

}
