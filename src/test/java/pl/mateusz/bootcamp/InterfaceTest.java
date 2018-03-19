package pl.mateusz.bootcamp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InterfaceTest {

    @Test
    public void anonymousObjects(){

        Formula formula = new Formula(){

            @Override
            public double calculate(int number) {
                return sqrt(number*number);
            }
        };

        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(100));
    }

    @Test
    public void comparatorLambda(){
        List<String> list = Arrays.asList("zxc", "abc", "cde", "asd", "ser");

        System.out.println(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(list);

        Collections.sort(list,(s1,s2) ->   s1.compareTo(s2));
        System.out.println(list);
    }

    @Test
    public void myInterface() {
        Integer i1 = 10;
        Integer i2 = 20;

        MyComparatorImpl myComparator = new MyComparatorImpl();

        System.out.println(myComparator.compare(i1, i2));

        MyComparator<Integer, Long> myComparator1 = ((x1, x2) -> x1 < x2 ? 1L : 2L);
        System.out.println(myComparator1.compare(i1,i2));
    }

    @Test
    public void compareDiferentType(){
        Integer integer = 10;
        String string = "20";

        BiComparator<Integer, String, Integer> biComparator = (in, st) -> in > Integer.valueOf(st) ? 1 : (in < Integer.valueOf(st) ? -1 : 0);

        System.out.println(biComparator.comper(integer,string));

        BiComparator biComparator1 = new BiComparatorImpl();

        System.out.println(biComparator1.comper(integer,string));
    }
}
