package JavaHW5;
/*  На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
И вывести Доску.
Пример вывода доски 8x8

0x000000
0000x000
00x00000  */

public class Ex3 {
    public static void getPos(String[][] chsBoard) {

        int random = (int) (Math.random() * chsBoard.length);
        chsBoard[0][random] = "X";
        for (int i = 1; i < chsBoard.length; i++) {
            random = (int) (Math.random() * chsBoard.length);
            int count = chsBoard.length - 1;
            while (checkLeft(chsBoard, random, i) || checkRight(chsBoard, random, i) || checkFront(chsBoard, random, i)) {
                random = (int) (Math.random() * chsBoard.length);
                count--;
                if (count < 0) {
                    clearPreStep(chsBoard, i - 1);
                    i--;
                }
            }
            chsBoard[i][random] = "X";
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

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == null) {
                    board[i][j] = "0";
                }
                System.out.print(board[i][j] + " ");
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

