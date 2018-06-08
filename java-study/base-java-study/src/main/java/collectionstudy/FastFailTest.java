package collectionstudy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FastFailTest {
//    private static List<String> list = new ArrayList<String>();
    private static List<String> list = new CopyOnWriteArrayList<String>();
    public static void main(String[] args) {

        int[] a = {0, 1, 2, 3, 4, 5};

        final int[] b= a;

        a = new int[]{200};
        for (int i = 0; i < b.length; ++i) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

/*

        for (int i = 0; i < 6; i++) {
            list.add(String.valueOf(i));
        }

        Iterator iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
            list.remove("3");
        }
        System.out.println();

        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
*/


        /*
        // 同时启动两个线程对list进行操作！
        new ThreadOne().start();
        new ThreadTwo().start();*/
    }


    private static void printAll() {
        System.out.println("");
        String value = null;
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
            System.out.print(value+", ");
        }
    }

    /**
      * 向list中依次添加0,1,2,3,4,5，每添加一个数之后，就通过printAll()遍历整个list
      */
    private static class ThreadOne extends Thread {
        public void run() {
        int i = 0;
        while (i<6) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

    /**
      * 向list中依次添加10,11,12,13,14,15，每添加一个数之后，就通过printAll()遍历整个list
      */

    private static class ThreadTwo extends Thread {
        public void run() {
         int i = 10;
         while (i<16) {
                 list.add(String.valueOf(i));
                 printAll();
                 i++;
             }
        }
    }
}
