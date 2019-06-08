import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DiffElements {

    public static void main(String[] args) {

        showMessage("Creating new array....");
        int[] array = createNewArray(12);

        showMessage(Arrays.toString(array));

        int count = getUniqueElementsCount(array);

        showMessage("Count of unique elements: " + Integer.toString(count));
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
            newArray[i] = getRandomIntNumberFromRange(0,6);
        }

        return newArray;
    }

    /**
     * Get unique array elements count
     *
     * @param arr - array
     * @return int count of unique elements
     */
    private static int getUniqueElementsCount(int[] arr) {
        List<Integer> uniqueElements = new ArrayList<Integer>();

        for (int i:arr) {
            if (uniqueElements.size() == 0) {
                uniqueElements.add(i);
            } else {
                boolean unique = false;
                for (int uniqueElement:uniqueElements) {
                    unique = uniqueElement == i;

                    if (unique) {
                        break;
                    }
                }
                if (!unique) {
                    uniqueElements.add(i);
                }
            }
        }

        showMessage("Unique elements are: ");
        System.out.println(uniqueElements);

        return uniqueElements.size();
    }
}
