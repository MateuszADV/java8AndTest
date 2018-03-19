package pl.mateusz.bootcamp;

@FunctionalInterface
public interface BiComparator<I, S, R> {
    R comper(I typ1, S typ2);
}
