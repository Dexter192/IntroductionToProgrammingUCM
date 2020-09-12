import java.util.Scanner;

/**
 * Credit for both the simple and advanced version goes to:
 * https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
 */
public class A2_simple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number < 1 || number >= 1000000) {
            throw new IllegalArgumentException("Invalid Roman Number Value");
        }

        String romanNumber = transformToRomanNumber(number);
        System.out.println("The number you have entered: " + romanNumber);
    }

    private static String transformToRomanNumber(int arabicNumber) {
        String romanNumber = "";
        while (arabicNumber >= 1000) {
            romanNumber += "M";
            arabicNumber -= 1000;        }
        while (arabicNumber >= 900) {
            romanNumber += "CM";
            arabicNumber -= 900;
        }
        while (arabicNumber >= 500) {
            romanNumber += "D";
            arabicNumber -= 500;
        }
        while (arabicNumber >= 400) {
            romanNumber += "CD";
            arabicNumber -= 400;
        }
        while (arabicNumber >= 100) {
            romanNumber += "C";
            arabicNumber -= 100;
        }
        while (arabicNumber >= 90) {
            romanNumber += "XC";
            arabicNumber -= 90;
        }
        while (arabicNumber >= 50) {
            romanNumber += "L";
            arabicNumber -= 50;
        }
        while (arabicNumber >= 40) {
            romanNumber += "XL";
            arabicNumber -= 40;
        }
        while (arabicNumber >= 10) {
            romanNumber += "X";
            arabicNumber -= 10;
        }
        while (arabicNumber >= 9) {
            romanNumber += "IX";
            arabicNumber -= 9;
        }
        while (arabicNumber >= 5) {
            romanNumber += "V";
            arabicNumber -= 5;
        }
        while (arabicNumber >= 4) {
            romanNumber += "IV";
            arabicNumber -= 4;
        }
        while (arabicNumber >= 1) {
            romanNumber += "I";
            arabicNumber -= 1;
        }
        return romanNumber;
    }
}
