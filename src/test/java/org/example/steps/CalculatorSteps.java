package org.example.steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.example.Calculator;
import org.testng.Assert;

public class CalculatorSteps {

    private Calculator calculator;
    private Object actualResult;
    private Exception caughtException;

    @Допустим("у меня есть калькулятор")
    public void createCalculator() {
        System.out.println("[Cucumber] Создаем новый калькулятор");
        calculator = new Calculator();
        caughtException = null;
    }

    @Когда("я складываю {int} и {int}")
    public void add(int a, int b) {
        System.out.printf("[Cucumber] Складываю: %d + %d%n", a, b);
        actualResult = calculator.add(a, b);
    }

    @Когда("я делю {int} на {int}")
    public void divide(int a, int b) {
        System.out.printf("[Cucumber] Делю: %d / %d%n", a, b);
        try {
            actualResult = calculator.divide(a, b);
        } catch (IllegalArgumentException e) {
            caughtException = e;
        }
    }

    @Тогда("результат должен быть равен {int}")
    public void resultShouldBe(int expected) {
        System.out.printf("[Cucumber] Проверяю результат: ожидаю %d, факт %s%n",
                expected, actualResult);
        Assert.assertEquals(actualResult, expected);
    }

    @Тогда("результат должен быть {double}")
    public void resultShouldBe(double expected) {
        System.out.printf("[Cucumber] Проверяю результат: ожидаю %.1f, факт %s%n",
                expected, actualResult);
        Assert.assertEquals((Double) actualResult, expected, 0.001);
    }

    @Тогда("выбрасывается исключение с текстом {string}")
    public void exceptionShouldBeThrown(String expectedMessage) {
        System.out.printf("[Cucumber] Проверяю исключение: '%s'%n", expectedMessage);
        Assert.assertNotNull(caughtException, "Ожидалось исключение, но его не было!");
        Assert.assertEquals(caughtException.getMessage(), expectedMessage);
    }
}