import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MixArray {
    static int MIN = 10;
    static int MAX = 99;
    static int ARRAY_SIZE = 25;

    public static void main(String[] args) {
        showMessage("Creating new array...");

        int[] array = createNewArray(ARRAY_SIZE);

        showMessage(Arrays.toString(array));

        array = mixArray(array);

        showMessage(Arrays.toString(array));
    }

    /**
     * Show message in console
     *
     * @param message - message for showing
     */
    private static void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Get random integer number from range
     *
     * @param min - the number from
     * @param max - the number to
     * @return integer number
     */
    private static int getRandomIntNumberFromRange(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Create new array;
     *
     * @param size - size of new array
     * @return int[] array
     */
    private static int[] createNewArray(int size) {
        int[] newArray = new int[size];

        for (int i = 0; i < size; i++) {
            newArray[i] = getRandomIntNumberFromRange(MIN,MAX);
        }

        return newArray;
    }

    private static int[] mixArray(int[] array) {
        List<Integer> position = getNewElementPosition(array.length);
        int[] newArray = new int[ARRAY_SIZE];
        int i = 0;

        for(int element:array) {
            newArray[position.get(i)] = element;
            i++;
        }

        return newArray;
    }

    private static List<Integer> getNewElementPosition(int length) {
        List<Integer> positions = new ArrayList<Integer>();

        while(positions.size() < length) {
            if (positions.size() == 0) {
                positions.add(getRandomIntNumberFromRange(0, length - 1));
            } else {
                int n = getRandomIntNumberFromRange(0, length - 1);
                if (!positions.contains(n) && n != positions.size()) {
                    positions.add(n);
                }
            }
        }
        return positions;
    }
}
