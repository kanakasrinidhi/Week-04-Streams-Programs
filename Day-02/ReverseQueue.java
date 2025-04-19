import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        reverseQueue(queue);
        System.out.println(queue);
    }

    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) return;
        int item = queue.remove();
        reverseQueue(queue);
        queue.add(item);
    }
}
