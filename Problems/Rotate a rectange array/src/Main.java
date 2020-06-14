import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // reading a length
        int y = sc.nextInt(); // reading a length

        int[][] matrix = new int[x][y];  // creating an matrix with the specified length
        int[][] matrix2 = new int[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                matrix2[j][i] = matrix[x - i - 1][j];
            }
        }

        for (int[] arr: matrix2) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }


    }
}
