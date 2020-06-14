import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // reading a length
        int n = sc.nextInt(); // reading a length

        int[][] matrix = new int[m][n];  // creating an matrix with the specified length
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int rowNo = -1;

        boolean zero = false;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n - k + 1; col++) {
                zero = true;
                for (int idx = col; idx < col + k; idx++) {
                    zero &= matrix[row][idx] == 0;
                }
                if (zero) {
                    rowNo = row;
                    break;
                }
            }
            if (zero) {
                break;
            }
        }

        if (rowNo == -1) {
            System.out.println(0);
        } else {
            System.out.println(rowNo + 1);
        }
    }
}