import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean isVowel(char ch) {
        // write your code here
        List<String> vowelList = Arrays.asList("a", "e", "i", "o", "u");
        return vowelList.contains(Character.toString(ch).toLowerCase()) ? true : false;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);
        System.out.println(isVowel(letter) ? "YES" : "NO");
    }
}
