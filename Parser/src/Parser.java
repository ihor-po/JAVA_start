import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parser {
    public  static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, enter the text");
        String str = reader.readLine();
        run(str);
    }
    private static void run(String str) {
        str = str.trim();
        String result = "";
        String[] arr = str.split("\\s+");
        for(String item : arr){

            String tempStr = item.toLowerCase();
            result += tempStr.substring(0, 1).toUpperCase() + tempStr.substring(1) + " ";

        }
        System.out.println(result);
    }
}
