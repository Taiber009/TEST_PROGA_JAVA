package org.example;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTNGTest {

    private Calculator calculator;

    // ========== SETUP / TEARDOWN ==========

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("[TestNG] BeforeSuite: Запуск всего сьюта");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("[TestNG] BeforeTest: Подготовка тестового окружения");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("[TestNG] BeforeClass: Создание общих ресурсов для класса");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("[TestNG] BeforeMethod: Создаем новый экземпляр Calculator");
        calculator = new Calculator(); // Чистый калькулятор перед каждым тестом
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("[TestNG] AfterMethod: Очистка после теста");
        calculator = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println("[TestNG] AfterClass: Освобождение ресурсов класса");
    }

    // ========== ТЕСТЫ ==========

    @Test(description = "Проверка сложения")
    public void testAdd() {
        System.out.println("[TestNG] Запуск testAdd");
        int result = calculator.add(5, 3);
        Assert.assertEquals(result, 8, "5 + 3 должно быть 8");
    }

    @Test(description = "Проверка деления")
    public void testDivide() {
        System.out.println("[TestNG] Запуск testDivide");
        double result = calculator.divide(10, 2);
        Assert.assertEquals(result, 5.0, "10 / 2 должно быть 5.0");
    }

    @Test(description = "Проверка исключения при делении на ноль",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Деление на ноль запрещено!")
    public void testDivideByZero() {
        System.out.println("[TestNG] Запуск testDivideByZero");
        calculator.divide(10, 0);
    }

    // ========== ПАРАМЕТРИЗАЦИЯ (DataProvider) ==========

    @DataProvider(name = "additionData")
    public Object[][] additionData() {
        return new Object[][]{
                {2, 3, 5},
                {0, 0, 0},
                {-5, 5, 0},
                {100, 200, 300}
        };
    }

    @Test(dataProvider = "additionData", description = "Параметризованный тест сложения")
    public void testAddWithData(int a, int b, int expected) {
        System.out.printf("[TestNG] DataProvider: %d + %d = %d%n", a, b, expected);
        int result = calculator.add(a, b);
        Assert.assertEquals(result, expected);
    }

    // ========== ГРУППЫ ==========

    @Test(groups = {"smoke"})
    public void testSmoke() {
        System.out.println("[TestNG] Smoke-тест: калькулятор создается");
        Assert.assertNotNull(calculator);
    }
}
