package pekan4_2511531006S;

public class QueueArrayDriver_2511531006 {

	public static void main(String[] args) {
		QueueArray_2511531006 queue = new QueueArray_2511531006(1000);
		queue.enqueue_2511531006(10);
		queue.enqueue_2511531006(20);
		queue.enqueue_2511531006(30);
		queue.enqueue_2511531006(40);
		System.out.println("Item di depan "+ queue.front_2511531006());
		System.out.println("Item di belakang "+ queue.front_2511531006());
		System.out.println("tampilan queue");
		queue.display_2511531006();
		System.out.println(queue.dequeue_2511531006() +" dihapus dari queue");
		System.out.println("item di depan:" + queue.front_2511531006());
		System.out.println("item di belakang: " + queue.front_2511531006());
		System.out.println("tampilan queue setelah satu data dihapus");
		queue.display_2511531006();
		
	}

}
