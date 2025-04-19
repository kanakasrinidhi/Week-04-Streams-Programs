import java.util.*;

public class ReverseList {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> reversedArrayList = new ArrayList<>();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            reversedArrayList.add(arrayList.get(i));
        }
        System.out.println(reversedArrayList);

        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        LinkedList<Integer> reversedLinkedList = new LinkedList<>();
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            reversedLinkedList.add(linkedList.get(i));
        }
        System.out.println(reversedLinkedList);
    }
}
