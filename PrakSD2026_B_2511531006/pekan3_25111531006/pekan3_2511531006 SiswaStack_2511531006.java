package pekan3_2511531006;

import java.util.ArrayList;

public class SiswaStack_2511531006 {
	String nama;
	int nim;
	
	public SiswaStack_2511531006(String nama, int nim) {
		this.nama = nama;
		this.nim = nim;
	}
	
	@Override
	public String toString() {
		return "Nim: "+ nim +", Nama: " +nama;
	}
}

class SiswaStack {
	private ArrayList<SiswaStack_2511531006> stack;  
	
	public SiswaStack() {
		stack = new ArrayList<>();  
	}

	public void push(SiswaStack_2511531006 mhs) {  
		stack.add(mhs);
	}
	
	public SiswaStack_2511531006 pop() { 
		if (!isEmpty()) {
			return stack.remove(stack.size() -1);
		}
		return null;
	}
	
	public SiswaStack_2511531006 peek() {  
		if (!isEmpty()) {
			return stack.get(stack.size() - 1);
		}
		return null;
	}
    
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public void tampilkanSiswa() {
		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.println(stack.get(i));
		}
	}
	
	public static void main(String[] args) {
		SiswaStack studentStack = new SiswaStack();
		
		SiswaStack_2511531006 mhs1 = new SiswaStack_2511531006("Ali", 1);
		SiswaStack_2511531006 mhs2 = new SiswaStack_2511531006("Boby", 2);
		SiswaStack_2511531006 mhs3 = new SiswaStack_2511531006("Charles", 3);
		
		studentStack.push(mhs1);
		studentStack.push(mhs2);
		studentStack.push(mhs3);
		
		System.out.println("Siswa di dalam stack:");
		System.out.println("mengeluarkan siswa teratas dari stack: " + studentStack.pop());
		System.out.println("daftar siswa setelah di stack:");
		studentStack.tampilkanSiswa();
	}
}

