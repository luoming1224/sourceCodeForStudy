package basicstudy;

import org.junit.Test;

public class IntegerCmpTest {
    @Test
    public void integerCmpTest1() {
        Integer a = 128;
        Integer b = 128;
        if (a == b) {
            System.out.println("a 等于 b");
        } else {
            System.out.println("a 不等于 b");
        }
    }

    @Test
    public void integerIntValueCmpTest1() {
        Integer a = 128;
        Integer b = 128;
        if (a.intValue() == b.intValue()) {
            System.out.println("a 等于 b");
        } else {
            System.out.println("a 不等于 b");
        }
    }

    @Test
    public void integerEqualsCmpTest1() {
        Integer a = 128;
        Integer b = 128;
        if (a.equals(b)) {
            System.out.println("a 等于 b");
        } else {
            System.out.println("a 不等于 b");
        }
    }

    @Test
    public void integerEqualCmpTest1() {
        Integer a = 128;
        int b = 128;
        if (a == b) {
            System.out.println("a 等于 b");
        } else {
            System.out.println("a 不等于 b");
        }
    }

    @Test(expected = NullPointerException.class)
    public void integerNullTest1() {
        Integer a = null;
        int b = a;
    }
}
