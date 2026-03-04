import java.io.*;
import java.util.Scanner;

public class SerializationDemo {
    private static final String FILE_NAME = "data.ser";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Діалоговий режим обчислень та серіалізації ---");
        System.out.print("Введіть катет A: ");
        double a = scanner.nextDouble();
        System.out.print("Введіть катет B: ");
        double b = scanner.nextDouble();

        // 1. Створення та обчислення
        CalculationData data = new CalculationData(a, b);
        Calculator calculator = new Calculator(data);
        calculator.calculate();

        System.out.println("\nОригінальний об'єкт після обчислення:");
        System.out.println(data);

        // 2. Серіалізація
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(data);
            System.out.println("\n[!] Об'єкт успішно серіалізовано у файл: " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Помилка серіалізації: " + e.getMessage());
        }

        System.out.println("Натисніть Enter для десеріалізації об'єкта...");
        scanner.nextLine(); // очищення буфера
        scanner.nextLine(); // очікування вводу

        // 3. Десеріалізація
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            CalculationData restoredData = (CalculationData) ois.readObject();
            System.out.println("\n[!] Відновлений об'єкт після десеріалізації:");
            System.out.println(restoredData);
            System.out.println("Зверніть увагу: calculationTime дорівнює 0, оскільки поле є transient.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка десеріалізації: " + e.getMessage());
        }

        scanner.close();
    }
}