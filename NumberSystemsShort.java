import java.util.Scanner;

public class NumberSystemsShort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ціле десяткове число: ");
        int number = scanner.nextInt();

        // Переводимо в рядок 16-річної системи та беремо довжину
        int hexLength = Integer.toHexString(number).length();

        // Переводимо в рядок 8-річної системи та беремо довжину
        int octLength = Integer.toOctalString(number).length();

        System.out.println("Кількість 16-річних цифр: " + hexLength);
        System.out.println("Кількість 8-річних цифр: " + octLength);
    }
}