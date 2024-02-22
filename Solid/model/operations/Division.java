package Solid.model.operations;

import Solid.model.ComplexNumber;
import Solid.model.Operation;

public class Division implements Operation {
    @Override
    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        double divisor = b.getReal() * b.getReal() + b.getImaginary() * b.getImaginary();
        double realResult = (a.getReal() * b.getReal() + a.getImaginary() * b.getImaginary()) / divisor;
        double imaginaryResult = (a.getImaginary() * b.getReal() - a.getReal() * b.getImaginary()) / divisor;
        return new ComplexNumber(realResult, imaginaryResult);
    }
}