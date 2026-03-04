import java.io.*;

public class CalculatorTest {

    public static void main(String[] args) {
        testCalculation();
        testSerialization();
        System.out.println("\nВсі тести пройдено успішно!");
    }

    /**
     * Тестує правильність математичних обчислень (Єгипетський трикутник 3-4-5).
     */
    private static void testCalculation() {
        CalculationData data = new CalculationData(3.0, 4.0);
        Calculator calc = new Calculator(data);
        calc.calculate();

        if (Double.compare(data.getResult(), 5.0) != 0) {
            throw new AssertionError("Тест обчислень провалено: очікувалось 5.0, отримано " + data.getResult());
        }
        System.out.println("Тест обчислень: ПРОЙДЕНО");
    }

    /**
     * Тестує процес збереження та відновлення об'єкта.
     */
    private static void testSerialization() {
        CalculationData original = new CalculationData(6.0, 8.0);
        original.setResult(10.0);
        original.setCalculationTime(99999L);

        String testFile = "test_data.ser";

        // Серіалізація
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(testFile))) {
            oos.writeObject(original);
        } catch (IOException e) {
            throw new AssertionError("Тест серіалізації провалено під час запису: " + e.getMessage());
        }

        // Десеріалізація
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(testFile))) {
            CalculationData restored = (CalculationData) ois.readObject();

            if (Double.compare(original.getA(), restored.getA()) != 0 ||
                    Double.compare(original.getResult(), restored.getResult()) != 0) {
                throw new AssertionError("Тест серіалізації провалено: дані не збігаються");
            }

            if (restored.getCalculationTime() != 0) {
                throw new AssertionError("Тест серіалізації провалено: transient поле не скинуто");
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new AssertionError("Тест серіалізації провалено під час читання: " + e.getMessage());
        } finally {
            new File(testFile).delete(); // Прибирання після тесту
        }

        System.out.println("Тест серіалізації/десеріалізації: ПРОЙДЕНО");
    }
}