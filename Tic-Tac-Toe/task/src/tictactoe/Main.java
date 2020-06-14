package tictactoe;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
        final int x =3;
        final int y = 3;
        String who = "X";
        String[][] _2DMatrix = new String[x][y];
        List<Integer> andScoreList;
        Set<String> resultSet = new HashSet<>(Arrays.asList("Draw", "X wins", "O wins"));
        String result = "unfinished";
        Scanner sc = new Scanner(System.in);
        final String initialGame = "         ";
        _2DMatrix = toMatrix(initialGame);
        printGame(_2DMatrix);
        andScoreList = getAndScoreList(getScoringCellList(_2DMatrix));
        result = getGameOutput2(_2DMatrix, andScoreList);

        while (!resultSet.contains(result)) {
            _2DMatrix = getInput(_2DMatrix, who);
            printGame(_2DMatrix);
            andScoreList = getAndScoreList(getScoringCellList(_2DMatrix));
            result = getGameOutput2(_2DMatrix, andScoreList);
            switch (who) {
                case "X":
                    who = "O";
                    break;
                case "O":
                    who = "X";
                    break;
                default:
                    who = "X";
            }
        }

        System.out.print(getGameOutput2(_2DMatrix, andScoreList));
    }

    static List<String[]> getScoringCellList(String[][] _2DMatrix) {
        List<String[]> scoringCellList = new ArrayList<>(8);
        scoringCellList.add(_2DMatrix[0]); // row1
        scoringCellList.add(_2DMatrix[1]); // row2
        scoringCellList.add(_2DMatrix[2]); // row3
        scoringCellList.add(new String[] {_2DMatrix[0][0], _2DMatrix[1][1], _2DMatrix[2][2]}); // diag1
        scoringCellList.add(new String[] {_2DMatrix[0][2], _2DMatrix[1][1], _2DMatrix[2][0]}); // diag2
        scoringCellList.add(new String[] {_2DMatrix[0][0], _2DMatrix[1][0], _2DMatrix[2][0]}); // col1
        scoringCellList.add(new String[] {_2DMatrix[0][1], _2DMatrix[1][1], _2DMatrix[2][1]}); // col2
        scoringCellList.add(new String[] {_2DMatrix[0][2], _2DMatrix[1][2], _2DMatrix[2][2]}); // col3

        return scoringCellList;
    }

    static String getGameOutput2(String[][] _2Dmatrix, List<Integer> scoreList) {
        List<String> gameSeq = Arrays.stream(_2Dmatrix)  //'array' is two-dimensional
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        int xCount = Collections.frequency(gameSeq, "X");
        int oCount = Collections.frequency(gameSeq, "O");

        String result = Math.abs(xCount - oCount) > 1 || (scoreList.contains(88) && scoreList.contains(79)) ? "Impossible"
                : scoreList.contains(79) ? "O wins"
                : scoreList.contains(88) ? "X wins"
                : !(scoreList.contains(79) || scoreList.contains(88) || gameSeq.contains(" ")) ? "Draw"
                : "Game not finished";
        return result;
    }

    static List<Integer> getAndScoreList(List<String[]> gameList) {
        List<Integer> andScoreList = new ArrayList<>(gameList.size());
        for (String[] row: gameList) {
            andScoreList.add(andRow(row));
        }

        return andScoreList;
    }

    static int andRow(String[] arr) {
        int and = (int)arr[0].charAt(0);
        for (int i = 1; i < arr.length; i++) {
            and &= (int) arr[i].charAt(0) ;
        }
        return and;
    }

    static void printGame(String game) {
        System.out.print("---------\n| ");
        for (int x = 0; x < game.length(); x++) {
            if (x == game.length() - 1) {
                System.out.print(game.charAt(x) + " |");
            } else if (x % 3 == 2) {
                System.out.print(game.charAt(x) + " |\n| ");
            } else {
                System.out.print(game.charAt(x) + " ");
            }
        }
        System.out.println("\n---------");
    }

    static String[][] toMatrix(String game) {
        String[] matrix = game.split("");
        String[][] mx = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mx[i][j] = matrix[3 * i + j];
            }
        }

        return mx;
    }

    static void printGame(String[][] _2DMatrix) {
        System.out.print("---------\n");
        for (int i = 0; i < _2DMatrix.length ; i++ ) {
            System.out.print("|");
            for (int j = 0; j < _2DMatrix[i].length ; j++) {
                System.out.print(" " + _2DMatrix[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    static String[][] getInput(String[][] _2DMatrix, String who) throws InputMismatchException {
        boolean taken = false;
        int maxX = 3, maxY = 3;
        int x, y;
        String input;
        List<Object> list = new ArrayList<>();
        Object[] objArr;


        System.out.println("Enter the coordinates:");

        while (!taken) {
            boolean occupied = false;
            boolean notNumber = false;
            boolean outOfBound = false;
            try {
                Scanner sc = new Scanner(System.in);
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
                int xx = maxY - y - 1;
                int yy = x;

                if (x >= 3 || y >= 3 || x < 0 || y < 0) {
                    outOfBound = true;
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.println("Enter the coordinates:");
                } else {
                    if (!_2DMatrix[xx][yy].equals(" ")) {
                        occupied = true;
                    } else {
                        _2DMatrix[xx][yy] = who;
                        taken = true;
                    }
                }

                if (occupied) {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.println("Enter the coordinates:");
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                System.out.println("Enter the coordinates:");
            }
        }
        return _2DMatrix;
    }
}
