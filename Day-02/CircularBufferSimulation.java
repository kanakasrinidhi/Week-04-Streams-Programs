import java.util.*;

public class CircularBufferSimulation {
    private int[] buffer;
    private int size, head, tail;

    public CircularBufferSimulation(int size) {
        this.size = size;
        buffer = new int[size];
        head = tail = 0;
    }

    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % size;
        if (tail == head) {
            head = (head + 1) % size;
        }
    }

    public void display() {
        for (int i = head; i != tail; i = (i + 1) % size) {
            System.out.print(buffer[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBufferSimulation buffer = new CircularBufferSimulation(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display();
        buffer.insert(4);
        buffer.display();
    }
}
