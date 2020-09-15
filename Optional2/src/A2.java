import java.util.Scanner;

public class A2 {
    //We just have the subtractive notation for 900=CM, 400=CD, 90=XC, etc. I consider this to be few enough cases to
    //not come up with an algorithm to solve it but rather to do it by hand
    private static final int THOUSAND = 1000;
    private static final int NINE_HUNDRED = 900;
    private static final int FIVE_HUNDRED = 500;
    private static final int FOUR_HUNDRED = 400;
    private static final int ONE_HUNDRED = 100;
    private static final int NINETY = 90;
    private static final int FIFTY = 50;
    private static final int FOURTY = 40;
    private static final int TEN = 10;
    private static final int NINE = 9;
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int ONE = 1;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        String romanNumber = transformToRomanNumber(number);
        System.out.println("The number you have entered: " + romanNumber);
    }

    /**
     * We could make this more compact and algorithmic but this does the job. I will upload a more efficient solution
     * which is way shorter and uses a map (found on Stackoverflow https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java)
     *
     * The method works like this:
     * First check if we have any 1,000 digits and for each, we add a "M" to our romanNumber String
     * For each M we add, we subtract 1000 from our arabic number
     * We then check if we have to apply a subtractive notation for 900
     * We iteratively repeat this
     *
     * @param number the number in arabic format
     * @return the number in romanic format
     */
    private static String transformToRomanNumber(int number) {
        String romanNumber = "";
        //Get thousands (M):
        romanNumber += getStep(number, THOUSAND, NINE_HUNDRED);
        number = number%THOUSAND;
        number = number%NINE_HUNDRED;

        romanNumber += getStep(number, FIVE_HUNDRED, FOUR_HUNDRED);
        number = number%FIVE_HUNDRED;
        number = number%FOUR_HUNDRED;

        romanNumber += getStep(number, ONE_HUNDRED, NINETY);
        number = number%ONE_HUNDRED;
        number = number%NINETY;


        romanNumber += getStep(number, ONE_HUNDRED, NINETY);
        number = number%ONE_HUNDRED;
        number = number%NINETY;


        romanNumber += getStep(number, FIFTY, FOURTY);
        number = number%FIFTY;
        number = number%FOURTY;

        romanNumber += getStep(number, TEN, NINE);
        number = number%TEN;
        number = number%NINE;

        romanNumber += getStep(number, FIVE, FOUR);
        number = number%FIVE;
        number = number%FOUR;

        for(int i = 0; i < number; i++) {
            romanNumber += getSimpleRomanNumber(ONE);
        }

        return romanNumber;
    }

    private static String getStep(int number, int Stage, int specialCase) {
        String romanNumber = "";
        int countStage = number/Stage;
        for(int i = 0; i < countStage; i++) {
            romanNumber += getSimpleRomanNumber(Stage);
        }
        number = number%Stage;

        //Check if we have a special case for subtractive notation and if so, subtract 900 from our number
        if(number/specialCase == 1) {
            romanNumber += getSimpleRomanNumber(specialCase);
        }
        return romanNumber;
    }

    /**
     * Here we build our own implementation of a Map. We provide an arabic number and it returns the roman equivalent
     * @param number arabic number
     * @return roman number string
     */
    private static String getSimpleRomanNumber(int number) {
        //Notice how I don't use break statements in the cases. This is because every case simply returns a value and
        // thus the other cases are not reached either way
        //A nicer way would be to use a Map here but I use switch case to demonstrate the concept
        switch (number) {
            case THOUSAND:
                return "M";
            case NINE_HUNDRED:
                return "CM";
            case FIVE_HUNDRED:
                return "D";
            case FOUR_HUNDRED:
                return "CD";
            case ONE_HUNDRED:
                return "C";
            case NINETY:
                return "XC";
            case FIFTY:
                return "L";
            case FOURTY:
                return "XL";
            case TEN:
                return "X";
            case NINE:
                return "IX";
            case FIVE:
                return "V";
            case FOUR:
                return "IV";
            case ONE:
                return "I";
            default:
                //If we get an unexpected input, I throw an error which terminates the program
                throw new IllegalArgumentException("Wrong input");
        }
    }
}
