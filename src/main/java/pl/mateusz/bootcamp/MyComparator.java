package pl.mateusz.bootcamp;

@FunctionalInterface
public interface MyComparator<Typ, Ret> {
    Ret compare(Typ i1, Typ i2);
}
