package collectionstudy;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<Integer> users = new ArrayList<>();
     /*   users.add(1);
        users.add(2);
        users.add(3);
        users.add(4);
*/
        for (Integer user : users) {
            if (user.equals(2)) {
                users.remove(user);
                break;
            }
        }
        for (Integer user : users) {
            System.out.print(user + " ");
        }
        System.out.println();
    }
}
