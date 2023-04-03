package JavaHW5;
/*  На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
И вывести Доску.
Пример вывода доски 8x8

0x000000
0000x000
00x00000  */

import java.util.Objects;

public class Ex3 {
    public static void getPos(String[][] chsBoard) {

        int random = (int) (Math.random() * chsBoard.length);
        chsBoard[0][random] = "X";
        for (int row = 1; row < chsBoard.length; row++) {
            random = (int) (Math.random() * chsBoard.length);
            int count = chsBoard.length - 1;
            while (checkLeft(chsBoard, random, row) || checkRight(chsBoard, random, row) || checkFront(chsBoard, random, row)) {
                random = (int) (Math.random() * chsBoard.length);
                count--;
                if (count < 0) {
                    clearPreStep(chsBoard, row - 1);
                    row--;
                }
            }
            chsBoard[row][random] = "X";
        }
    }

    public static void clearPreStep(String[][] stepBackRow, int preRow) {

        for (int i = 0; i < stepBackRow.length; i++) {
            stepBackRow[preRow][i] = null;
        }
    }

    public static Boolean checkRight(String[][] rightCol, int posRight, int currentRow) {

        for (int row = currentRow - 1; row >= 0; row--) {
            if (posRight < rightCol.length - 1) {
                posRight += 1;
                if (rightCol[row][posRight] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean checkLeft(String[][] leftCol, int posLeft, int currentRow) {

        for (int row = currentRow - 1; row >= 0; row--) {
            if (posLeft > 0) {
                posLeft -= 1;
                if (leftCol[row][posLeft] != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean checkFront(String[][] frontCol, int posFront, int currentRow) {

        for (int row = currentRow - 1; row >= 0; row--) {
            if (frontCol[row][posFront] != null) {
                return true;
            }
        }
        return false;
    }

    public static void printArray(String[][] board) {

        for (String[] row : board) {
            for (String col : row) {
                System.out.print(Objects.requireNonNullElse(col, "0") + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        String[][] ChessBoard = new String[8][8];
        getPos(ChessBoard);
        printArray(ChessBoard);

    }
}

