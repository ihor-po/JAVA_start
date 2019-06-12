import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MathF {
    protected static int A;
    protected static int B;

    private static final char LEFT = '(';
    private static final char RIGHT = ')';
    private static final char COMA = ',';

    public static void main(String[] args) throws IOException {

        System.out.println("Enter your formula");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        verifyFormula(str);
    }

    /**
     * Verifying user formula
     *
     * @param formula - user formula for verifying
     */
    private static void verifyFormula(String formula) {
        int leftIndex;
        int rightIndex;

        boolean error = false;

        leftIndex = formula.indexOf(LEFT);
        rightIndex = formula.lastIndexOf(RIGHT);

        formula = formula.trim();

        while (true) {
            if (leftIndex == -1 && rightIndex > -1) {
                System.out.println("ERROR! In the formula is missing char ==>> " + LEFT);
                error = true;
                break;
            }

            if (rightIndex == -1 && leftIndex > -1) {
                System.out.println("ERROR! In the formula is missing char ==>> " + RIGHT);
                error = true;
                break;
            }

            leftIndex = formula.indexOf(LEFT, leftIndex + 1);
            rightIndex = formula.lastIndexOf(RIGHT, rightIndex - 1);

            if (leftIndex == -1 && rightIndex == -1) {
                System.out.println("Your formula is GOOD!");
                break;
            }
        }

        if (!error) {
            parsingMathFormula(formula);
        }
    }

    /**
     * Parsing math formula
     *
     * @param str result of math formula
     */
    private static void parsingMathFormula(String str) {
        int leftIndex;
        int rightIndex;
        int comaIndex;
        int result;
        String action;

        leftIndex = getLastLeftIndex(str, str.length());
        rightIndex = getFirstRightIndex(str, leftIndex);
        comaIndex = getComaIndex(str, leftIndex + 1);

        while(true) {
            action = str.substring(leftIndex - 3, leftIndex);
            A = getActionNumber(str, leftIndex + 1, comaIndex);
            B = getActionNumber(str, comaIndex + 1, rightIndex);

            if (A == -999999 || B == -999999) {
                System.out.println("ERROR! In the formula badNumber ==>> " + ((A == -999999) ? 'A' : 'B'));
            }

            result = getMathMethod(action, A, B);

            String oldData = action + LEFT + A + COMA + B + RIGHT;
            str = str.replace(oldData, Integer.toString(result));

            leftIndex = getLastLeftIndex(str, str.length());
            rightIndex = getFirstRightIndex(str, leftIndex);
            comaIndex = getComaIndex(str, leftIndex + 1);

            if (leftIndex == -1 && rightIndex == -1) {
                System.out.println("RESULT IS " + str);
                break;
            }
        }
    }

    /**
     * Get resulat of math method
     *
     * @param method method from user string
     * @param a number
     * @param b number
     * @return result of math method or -999999
     */
    private static int getMathMethod(String method, int a, int b) {
        int result = -999999;

        switch (method) {
            case "max":
                result = max(a, b);
                break;
            case "min":
                result = min(a, b);
                break;
        }
        return result;
    }

    /**
     * Get Max from two numbers
     *
     * @param a number
     * @param b number
     * @return result
     */
    private static int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * Get Min from two numbers
     *
     * @param a number
     * @param b number
     * @return result
     */
    private static int min(int a, int b) {
        return Math.min(a, b);
    }

    /**
     * Get last index of left bracket
     *
     * @param formula formula
     * @param startIndex start index for search
     * @return int index or -1
     */
    private static int getLastLeftIndex(String formula, int startIndex) {
        return formula.lastIndexOf(LEFT, startIndex);
    }

    /**
     * Get index of right bracket
     *
     * @param formula formula
     * @param startIndex start index for search
     * @return int index or -1
     */
    private static int getFirstRightIndex(String formula, int startIndex) {
        return formula.indexOf(RIGHT, startIndex);
    }

    /**
     * Get index of coma
     *
     * @param formula formula
     * @param startIndex start index for search
     * @return int index or -1
     */
    private static int getComaIndex(String formula, int startIndex) {
        return formula.indexOf(COMA, startIndex);
    }

    /**
     * Get action number
     *
     * @param formula formula
     * @param startIndex formula
     * @param endIndex start index for search
     * @return int index or -999999
     */
    private static int getActionNumber(String formula, int startIndex, int endIndex) {
        try
        {
            String a = formula.substring(startIndex, endIndex);
            return Integer.parseInt(a);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -999999;
        }
    }

}
