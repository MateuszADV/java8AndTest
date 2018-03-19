package pl.mateusz.bootcamp;

public class BiComparatorImpl implements BiComparator<Integer, String , Integer> {


    @Override
    public Integer comper(Integer typ1, String typ2) {
        Integer t = Integer.valueOf(typ2);
        return (typ1 > t) ? -1 : ((typ1 < t) ? 1 : 0);
    }
}
