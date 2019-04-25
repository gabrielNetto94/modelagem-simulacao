
import java.util.LinkedList;

public class Teste {

    public static void main(String args[]) {

//        LinkedList<Integer> a = new LinkedList<>();
//        a.add(1);
//        a.add(2);
//        a.add(3);
//        a.add(4);
//        a.add(5);
//
//        Integer r;
//        
//        r = a.removeFirst();
//        System.out.println(r);
//        r = a.removeFirst();
//        System.out.println(r);
//        r = a.removeFirst();
//        System.out.println(r);
//        System.out.println(a);
//
//        a.add(6);
//        a.add(7);
//        System.out.println("get " + a.get(0));
//        System.out.println(a);
        for (int i = 1; i <= 8; i++) {
            System.out.println(i);
            if (i % 2 == 0) {
                System.out.println("#" + i);
            }
            else if (i % 3 == 0) {
                System.out.println("@" + i);
            }
        }

    }

}
