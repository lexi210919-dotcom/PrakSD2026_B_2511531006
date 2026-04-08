package pekan3_2511531006;

public class stackArrayDriver_2511531006 {

	public static void main(String[] args) {
		stackArray_2511531006 s= new stackArray_2511531006();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() +"dikeluarkan dari stack");
		System.out.println("Elemen teratas adalah :" + s.peek());
		System.out.println("Elemen pada stack :");
	}

}
