import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Changer {
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter text");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String reg_exUrl = "(ftp:\\/\\/|www\\.|https?:\\/\\/){1}[a-zA-Z0-9u00a1-\\uffff0-]{2,}\\.[a-zA-Z0-9u00a1-\\uffff0-]{2,}(\\S*)";
        String reg_exEmail = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";

        System.out.println("User text");
        System.out.println(str);

        String result = "";
        String[] arr = str.split("\\s+");
        for(String item : arr){

            if  (item.matches(reg_exUrl) ||item.matches(reg_exEmail) ){
                result += CharChanger(item.length()) + " ";
            }else{
                result += item + " ";
            }
        }
        System.out.println("Text after");
        System.out.println(result);
    }

    private static String CharChanger(int size){
        String result = "";
        for (int i = 0; i < size; i++){
            result += '*';
        }
        return result;
    }
}
