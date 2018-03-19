package pl.mateusz.bootcamp;

public class MyComparatorImpl implements MyComparator<Integer, Integer> {
    @Override
    public Integer compare(Integer i1, Integer i2) {
        return (i1>i2) ? 1 : ((i1<i2) ? -1 : 0);
    }
}
