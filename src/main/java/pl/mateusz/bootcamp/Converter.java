package pl.mateusz.bootcamp;

@FunctionalInterface
public interface Converter<F,I> {
    I conver(F from);
}
