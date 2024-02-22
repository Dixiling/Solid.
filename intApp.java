import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import Solid.controller.CalculatorController;
import Solid.model.CalculatorModel;
import Solid.model.ComplexNumber;
import Solid.model.operations.Addition;
import Solid.model.operations.Division;
import Solid.model.operations.Multiplication;
import Solid.model.operations.Subtraction;
import Solid.view.CalculatorView;
import Solid.view.ConsoleViewFactory;

public class intApp {

    private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static {
        try(FileInputStream in = new FileInputStream("E:\\VS\\Java\\Solid2\\logging.properties")){
            LogManager.getLogManager().readConfiguration(in);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    void init() {
        LOGGER.info("Запуск программы");
        CalculatorModel model = new CalculatorModel();
        LOGGER.info("Запуск модели");
        CalculatorController controller = new CalculatorController();
        LOGGER.info("Запуск управления");
        CalculatorView calculatorView = new CalculatorView(new ConsoleViewFactory());
        LOGGER.info("Загрузка интерфейса");
        controller.registerOperation("+", new Addition());
        controller.registerOperation("-", new Subtraction());
        controller.registerOperation("*", new Multiplication());
        controller.registerOperation("/", new Division());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Введите требуемое вам действие из следующего списка: \n").trimToSize();
        stringBuilder.append(" + Сложение.\n - Вычитание.\n * Умножение.\n / Деление.\n Укажите символом что вам требуется сделать: ");
        System.out.println(stringBuilder);
        String operation = calculatorView.getInput();
        LOGGER.info("Пользователь ввел следующий параметр " + operation + " в данной операции");
        System.out.println("Введите реальное число А:");
        double realComplexA = Double.parseDouble(calculatorView.getInput().trim());
        System.out.println("Введите мнимое число А:");
        double imaginaryComplexA = Double.parseDouble(calculatorView.getInput().trim());
        ComplexNumber a = new ComplexNumber(realComplexA,imaginaryComplexA);
        System.out.println("Введите реальное число B:");
        double realComplexB = Double.parseDouble(calculatorView.getInput().trim());
        System.out.println("Введите мнимое число B:");
        double imaginaryComplexB = Double.parseDouble(calculatorView.getInput().trim());
        ComplexNumber b = new ComplexNumber(realComplexB,imaginaryComplexB);
        ComplexNumber result = controller.performOperation(operation, a, b);
        model.setResult(result);
        calculatorView.displayResult(model.getResult());
    }
}