import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // reading a length
        int y = sc.nextInt(); // reading a length

        int[][] matrix = new int[x][y];  // creating an matrix with the specified length
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int max = matrix[0][0];
        int idxX = 0;
        int idxY = 0;
        for (int xx = 0; xx < x; xx++) {
            for (int yy = 0; yy < y; yy++) {
                if (matrix[xx][yy] > max) {
                    //max = Math.max(matrix[xx][yy], max);
                    idxX = xx;
                    idxY = yy;
                }
            }
        }

        System.out.println(idxX + " " + idxY);
    }
}
