package pekan4_2511531006S;

import java.util.Scanner;

public class AntrianLoket_2511531006 {
    private String[] queue;
    private int front;
    private int rear;
    private int max;
    
    public AntrianLoket_2511531006(int size) {
        max = size;
        queue = new String[max];
        front = -1;
        rear = -1;
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        return rear == max - 1;
    }
    
    
    public void enqueue_2511531006(String nama) {
        if (isFull()) {
            System.out.println("Antrian penuh!");
            return;
        }
        if (front == -1) front = 0;
        queue[++rear] = nama;
        System.out.println("Data berhasil ditambahkan ke antrian");
    }
    
    public void dequeue_2511531006() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println(queue[front] + " telah dilayani");
        for (int i = front; i < rear; i++) {
            queue[i] = queue[i + 1];
        }
        rear--;
        if (rear < 0) {
            front = rear = -1;
        }
    }
    
    public void display_2511531006() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("Isi antrian:");
        for (int i = front, nomor = 1; i <= rear; i++, nomor++) {
            System.out.println(nomor + ". " + queue[i]);
        }
    }
    
    public void Reverse_2511531006() {
        if (!isEmpty()) {
            for (int i = front, j = rear; i < j; i++, j--) {
                String temp = queue[i];
                queue[i] = queue[j];
                queue[j] = temp;
            }
        }
        display_2511531006();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianLoket_2511531006 antrian = new AntrianLoket_2511531006(10);
        
        System.out.println("=== PROGRAM ANTRIAN LOKET ===\n");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Hapus Antrian");
        System.out.println("3. Tampilkan Antrian");
        System.out.println("4. Reverse");
        System.out.println("5. Keluar\n");
        
        int pilihan;
        do {
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();
            
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    antrian.enqueue_2511531006(sc.nextLine());
                    break;
                case 2:
                    antrian.dequeue_2511531006();
                    break;
                case 3:
                    antrian.display_2511531006();
                    break;
                case 4:
                    antrian.Reverse_2511531006();
                    break;
                case 5:
                    System.out.println("Program selesai");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
        
        sc.close();
    }
}
