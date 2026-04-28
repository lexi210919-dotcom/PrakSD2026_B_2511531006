package pekan4_2511531006S;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseData_2511531006 {

	

	public static void main(String[] args) {
			Queue<Integer> q_2511531006 = new LinkedList<Integer>();
			q_2511531006.add(1);
			q_2511531006.add(2);
			q_2511531006.add(3); // [1, 2, 3]
			System.out.println("sebelum reverse" + q_2511531006);
			Stack<Integer> s = new Stack<Integer>();
			while (!q_2511531006.isEmpty()) { // Q -> S
				s.push(q_2511531006.remove());
			}
			while (!s.isEmpty()) { // S -> Q
				q_2511531006.add(s.pop());
			}
			System.out.println("sesudah reverse= " + q_2511531006); // [3, 2, 1]

	}

}
