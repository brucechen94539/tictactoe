import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String orig = sc.nextLine(); // reading a length

        System.out.println(orig.replaceAll("a", "b"));
    }
}