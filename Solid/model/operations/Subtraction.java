package Solid.model.operations;

import Solid.model.ComplexNumber;
import Solid.model.Operation;

public class Subtraction implements Operation {
    @Override
    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        double realResult = a.getReal() - b.getReal();
        double imaginaryResult = a.getImaginary() - b.getImaginary();
        return new ComplexNumber(realResult, imaginaryResult);
    }
}