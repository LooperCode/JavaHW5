package JavaHW5;
/*  На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
И вывести Доску.
Пример вывода доски 8x8

0x000000
0000x000
00x00000  */

public class Ex3 {
    public static void getPos(String[][] chsBoard) {

        //int i = 1;
        int random = (int) (Math.random() * chsBoard.length);
        int tmp = random;
        chsBoard[0][random] = "X";
        for (int i = 1; i < chsBoard.length; i++) {
            random = (int) (Math.random() * chsBoard.length);
            while (tmp + 1 == random || tmp - 1 == random || tmp == random) {
                random = (int) (Math.random() * chsBoard.length);

            }
            chsBoard[i][random] = "X";
            tmp = random;
        }
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
        String[] ChessBoard[] = new String[8][8];
        getPos(ChessBoard);
        printArray(ChessBoard);

    }
}

