import java.util.*;

public class ListRotation {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;
        List<Integer> rotated = new ArrayList<>();

        for (int i = rotateBy; i < list.size(); i++) {
            rotated.add(list.get(i));
        }
        for (int i = 0; i < rotateBy; i++) {
            rotated.add(list.get(i));
        }

        System.out.println(rotated);
    }
}
