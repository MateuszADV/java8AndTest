package pl.mateusz.bootcamp;

public interface Formula {
    double calculate(int number);

    default double sqrt(int number){
        return Math.sqrt(number);
    }
}
