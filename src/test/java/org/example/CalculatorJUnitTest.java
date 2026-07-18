//package org.example;
//
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class CalculatorJUnitTest {
//
//    private Calculator calculator;
//
//    // ========== SETUP / TEARDOWN ==========
//
//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("[JUnit] @BeforeAll: Запуск ОДИН раз перед всеми тестами");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("[JUnit] @AfterAll: Запуск ОДИН раз после всех тестов");
//    }
//
//    @BeforeEach
//    void setUp() {
//        System.out.println("[JUnit] @BeforeEach: Создаем новый экземпляр Calculator");
//        calculator = new Calculator(); // Чистый калькулятор перед каждым тестом
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("[JUnit] @AfterEach: Очистка после теста");
//        calculator = null;
//    }
//
//    // ========== ТЕСТЫ ==========
//
//    @Test
//    @DisplayName("Проверка сложения")
//    void testAdd() {
//        System.out.println("[JUnit] Запуск testAdd");
//        int result = calculator.add(5, 3);
//        assertEquals(8, result, "5 + 3 должно быть 8");
//    }
//
//    @Test
//    @DisplayName("Проверка деления")
//    void testDivide() {
//        System.out.println("[JUnit] Запуск testDivide");
//        double result = calculator.divide(10, 2);
//        assertEquals(5.0, result, 0.001, "10 / 2 должно быть 5.0");
//    }
//
//    @Test
//    @DisplayName("Проверка исключения при делении на ноль")
//    void testDivideByZero() {
//        System.out.println("[JUnit] Запуск testDivideByZero");
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            calculator.divide(10, 0);
//        });
//        assertEquals("Деление на ноль запрещено!", exception.getMessage());
//    }
//
//    // ========== ПАРАМЕТРИЗАЦИЯ (CsvSource) ==========
//
//    @ParameterizedTest(name = "{0} + {1} = {2}")
//    @CsvSource({
//            "2, 3, 5",
//            "0, 0, 0",
//            "-5, 5, 0",
//            "100, 200, 300"
//    })
//    @DisplayName("Параметризованный тест сложения")
//    void testAddWithData(int a, int b, int expected) {
//        System.out.printf("[JUnit] @CsvSource: %d + %d = %d%n", a, b, expected);
//        int result = calculator.add(a, b);
//        assertEquals(expected, result);
//    }
//
//    // ========== ТАЙМАУТ ==========
//
//    @Test
//    @Timeout(1) // Тест должен выполниться быстрее 1 секунды
//    @DisplayName("Проверка с таймаутом")
//    void testWithTimeout() {
//        int result = calculator.multiply(2, 5);
//        assertEquals(10, result);
//    }
//}
