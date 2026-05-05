package pekan5_2511531006;



public class TambahSLL_2511531006 {

	public static NodeSLL_2511531006 insertAtfront_2511531006(NodeSLL_2511531006 head_2511531006, int value_2511531006) {
		NodeSLL_2511531006 new_node_2511531006 = new NodeSLL_2511531006(value_2511531006);
		new_node_2511531006.next_2511531006 = head_2511531006;
		return new_node_2511531006;
	}
	// fungsi menambah node di akhir SLL
	public static NodeSLL_2511531006 insertAtEnd_2511531006(NodeSLL_2511531006 head_2511531006, int value_2511531006) {
	{
		// buat sebuah node dengan sebuah nilai
		NodeSLL_2511531006 newNode_2511531006= new NodeSLL_2511531006(value_2511531006);
		// jika list kosong maka node jadi head
		if (head_2511531006 == null) {
			return newNode_2511531006;
		}
		// simpan head ke variabel sementara
		NodeSLL_2511531006 last_2511531006 = head_2511531006;
		// telurusi ke node akhir
		while (last_2511531006.next_2511531006 !=null) {
			last_2511531006 = last_2511531006.next_2511531006;
		}
		// ubah pointer
		last_2511531006.next_2511531006 = newNode_2511531006;
		return head_2511531006;
	}
	}
	static NodeSLL_2511531006 GetNode_2511531006(int data_2511531006) {
		return new NodeSLL_2511531006(data_2511531006);
	}
	
	static NodeSLL_2511531006 insertPos_2511531006(NodeSLL_2511531006 headNode_2511531006, int position_2511531006,int value_2511531006) {
		NodeSLL_2511531006 head_2511531006 = headNode_2511531006;
		if (position_2511531006 < 1)
			System.out.print("invalid position");
		if (position_2511531006 == 1 ) {
			NodeSLL_2511531006 new_node_2511531006 = new NodeSLL_2511531006(value_2511531006);
			new_node_2511531006.next_2511531006 = head_2511531006;
			return new_node_2511531006;
		} else {
			while (position_2511531006-- != 0) {
				if (position_2511531006 == 1) {
					NodeSLL_2511531006 newNode_2511531006 = GetNode_2511531006(value_2511531006);
					newNode_2511531006.next_2511531006 = headNode_2511531006.next_2511531006;
					headNode_2511531006.next_2511531006 = newNode_2511531006;
					break;	
				}
				headNode_2511531006 = headNode_2511531006.next_2511531006;
			}
			if (position_2511531006 != 1)
		 System.out.print("Posisi di luar jangkuan");
			return head_2511531006;
		}
	}
	public static void printList_2511531006(NodeSLL_2511531006 head_2511531006) {
			NodeSLL_2511531006 curr_2511531006 = head_2511531006;
		while (curr_2511531006.next_2511531006 !=null) {
			System.out.print(curr_2511531006.data_2511531006+ "-->");  
	        curr_2511531006 = curr_2511531006.next_2511531006;
		}   
		if (curr_2511531006.next_2511531006==null) {
			System.out.print(curr_2511531006.data_2511531006);       }
		System.out.println();
	}
	
	public static void main(String[] args) {
			// buat linked list 2->3->5->6
			NodeSLL_2511531006 head_2511531006 = new NodeSLL_2511531006(2);
			head_2511531006.next_2511531006 = new NodeSLL_2511531006(3);
			head_2511531006.next_2511531006.next_2511531006 = new NodeSLL_2511531006(5);
			head_2511531006.next_2511531006.next_2511531006.next_2511531006 = new NodeSLL_2511531006(6);
			// cetak list asli
			System.out.print("Senarai berantai awal:");
			printList_2511531006(head_2511531006);
			// tambahkan node baru di depan
			System.out.print("tambah 1 simpul di depan:");
			int data_2511531006 = 1;
			head_2511531006 = insertAtfront_2511531006(head_2511531006, data_2511531006);
			// tambahkan node baru di belakang 
			System.out.print("tambah 1 simpul di belakang:");
			int data2_2511531006 = 7;
			head_2511531006 =insertAtEnd_2511531006(head_2511531006, data2_2511531006);
			// cetak update list
			printList_2511531006(head_2511531006);
			System.out.print("tambah 1 simpul ke data 4:");
			int data3_2511531006 = 4;
			int pos_2511531006=4;
			head_2511531006 = insertPos_2511531006(head_2511531006,pos_2511531006,data3_2511531006);
			// cetak update list
			printList_2511531006(head_2511531006);
		}
		
		}


	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
