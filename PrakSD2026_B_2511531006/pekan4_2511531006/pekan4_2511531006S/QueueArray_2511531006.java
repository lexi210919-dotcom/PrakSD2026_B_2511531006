package pekan4_2511531006S;

public class QueueArray_2511531006<QueueArray> {
	int front, rear, size;
	int capacity;
	int array[];
	
	public QueueArray_2511531006(int capacity) {
		this.capacity = capacity;
		front = this.size = 0;
		rear = capacity - 1 ;
		array = new int[this.capacity];
	}

	boolean isFull(QueueArray_2511531006 queue) {
		return (queue.size == queue.capacity);
		}
	
	boolean isEmpty(QueueArray_2511531006 queue) {
		return (queue.size == 0);
	}
	
	void enqueue_2511531006(int item) {
		if (isFull(this))
			return;
		this.rear = (this.rear + 1) % this.capacity;
		this.array[this.rear] = item;
		this.size = this.size + 1;
		System.out.println(item +" enqueued to queue");
	}

    int dequeue_2511531006() {
    	if (isEmpty(this))
    		return Integer.MIN_VALUE;
    	int item = this.array[this.front];
    	this.front = (this.front + 1) % this.capacity;
    	this.size = this.size - 1;
    	return item;
    }
    int front_2511531006() {
    	if (isEmpty(this))
    		return Integer.MIN_VALUE;
    	
      return this.array[this.front];
    }
    int rear_2511531006() {
    	if (isEmpty(this))
    		return Integer.MIN_VALUE;
    	return this.array[this.rear];
    }
      //mencetak elemen antrian
    void display_2511531006() {
    	int i;
    	if (front == rear) {
    		System.out.print("\nAntrian Kosong\n");
    		return;
    }
     //Kunjungi dari belakang dan cetak
    	for (i = front; i < rear; i++) {
    		System.out.printf(" %d <--", array[i]);
    }
    	return;
    }
    
}
    	
    