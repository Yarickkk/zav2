import java.util.Scanner;

public class NumberSystemsTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Введення десяткового числа
        System.out.print("Введіть ціле десяткове число: ");
        int number = scanner.nextInt();

        // Зберігаємо копії числа для розрахунків, щоб не змінювати оригінал
        int tempHex = Math.abs(number);
        int tempOct = Math.abs(number);

        // --- Підрахунок цифр для 16-річної системи ---
        int hexDigitsCount = 0;
        if (tempHex == 0) {
            hexDigitsCount = 1; // Число 0 має одну цифру
        } else {
            while (tempHex > 0) {
                tempHex = tempHex / 16; // Ділимо на основу системи
                hexDigitsCount++;       // Збільшуємо лічильник цифр
            }
        }

        // --- Підрахунок цифр для 8-річної системи ---
        int octDigitsCount = 0;
        if (tempOct == 0) {
            octDigitsCount = 1; // Число 0 має одну цифру
        } else {
            while (tempOct > 0) {
                tempOct = tempOct / 8;  // Ділимо на основу системи
                octDigitsCount++;       // Збільшуємо лічильник цифр
            }
        }

        // 3. Виведення результату
        System.out.println("\nРезультати для числа " + number + ":");
        System.out.println("Кількість 16-річних цифр: " + hexDigitsCount);
        System.out.println("Кількість 8-річних цифр:  " + octDigitsCount);

        System.out.println("\n--- Перевірка ---");
        System.out.println("У Hex: " + Integer.toHexString(number).toUpperCase());
        System.out.println("В Oct: " + Integer.toOctalString(number));
    }
}