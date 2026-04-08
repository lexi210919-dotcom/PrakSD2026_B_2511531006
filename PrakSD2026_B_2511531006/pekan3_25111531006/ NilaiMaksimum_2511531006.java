package pekan3_2511531006;

import java.util.Stack;

public class NilaiMaksimum_2511531006 {

	public static int max (Stack<Integer> s) {
		Stack<Integer> backup = new Stack<Integer> ();
		int maxValue_2511531006 = s.pop();
		backup.push(maxValue_2511531006);
		while (!s.empty()) {
			int next = s.pop();
			backup.push(next);
			maxValue_2511531006 = Math.max(maxValue_2511531006, next);
		}
		while (!backup.isEmpty()) {
			s.push(backup.pop());
		}
		return maxValue_2511531006;
	}
	public static void main (String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(70);
		s.push(12);
		s.push(20);
		System.out.println("isi stack");
		System.out.println("Stack Teratas"+s);
		System.out.println("Nilai Maksimum"+max(s));
		}
		

	}


