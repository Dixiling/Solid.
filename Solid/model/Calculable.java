package Solid.model;

@FunctionalInterface
@Deprecated
public interface Calculable <T,N extends Number> {
        double calculate(T real,char ch, N imaginary);
}