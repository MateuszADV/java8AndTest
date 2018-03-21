package pl.mateusz.bootcamp;

import org.junit.Test;

import java.util.*;

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
        Integer integer = 30;
        String string = "20";

        BiComparator<Integer, String, Integer> biComparator = (in, st) -> in > Integer.valueOf(st) ? -1 : (in < Integer.valueOf(st) ? 1 : 0);
        System.out.println(biComparator.comper(integer,string));

        BiComparator biComparator1 = new BiComparatorImpl();
        System.out.println(biComparator1.comper(integer,string));

        BiComparator<Integer, String, Integer> biComparator2 = (in, st) -> in - Integer.valueOf(st);
        System.out.println(biComparator2.comper(integer,string));
    }

    @Test
    public void convert(){
        String stringIn = "123";
        Converter<String, Integer> converter = s -> Integer.valueOf(s);
        System.out.println(converter.conver(stringIn));

        Converter<String, Integer> converter1 = Integer::valueOf;
    }

    @Test
    public void objectMethodReference(){
        String word = "słowo";

        StringUtils stringUtils = new StringUtils();

        Optional<String> str = stringUtils.getFirstLetterUppercase(word);
        if(str.isPresent()){
            str.get().length();
            System.out.println(str.get().length());
        }
                                                //Referencja do metody w obiekcie
        Converter<String, String> converter =  stringUtils::getFirestLatterUppercaseNotOptional;
        System.out.println(converter.conver(word));

        Converter<String, Optional<String>> converter1 = s -> stringUtils.getFirstLetterUppercase(s);
        System.out.println(converter1.conver(word).orElse(null+"Pusty string"));
    }

    @Test
    public void constuctorReference(){
        //Person p = new Person("a","b");

        PersonFactory<Person> personFactory = (fn, ln) -> new Person(fn, ln);
        Person p1 = personFactory.create("Jan", "Kowalski");
        System.out.println(p1);

        PersonFactory<Person> personFactory2 = Person::new;
        Person p2 = personFactory2.create("Mateusz", "Ruchała");

        System.out.println(p2);

    }
}
