package Leetcode.Backtracking;

public class NQueen {
    public static void main(String[] args) {
        int N=4;
        int[][] board = new int[N][N];  // Initialize the board

        if(nQueen(board, 0, N)){
            print(board, N);
        }else {
            System.out.println("No solution exists for " + N + " queens.");
        }


    }
    // Function to print the chessboard
    private static void print(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }


    static boolean isSafe(int arr[][], int x, int y,int n){

        //for column
        for(int row=0;row<x;row++){
            if(arr[row][y]==1){
                return false;
            }
        }

        //for left upper diagonal
        int row=x;
        int col=y;
        while (row>=0 && col>=0){
            if(arr[row][col]==1)
                return false;
            row--;
            col--;
        }

        //for right upper diagonal
        row=x;
        col=y;
        while (row>=0 && col<n){
            if(arr[row][col]==1){
                return false;
            }
            row--;
            col++;
        }
        return true;
    }

    static boolean nQueen(int arr[][], int x, int n){
        // If all queens are placed, return true
        if(x>=n){
            return true;
        }

        for(int col=0;col<n;col++){
            // Check if it's safe to place the queen here
            if(isSafe(arr, x, col, n)){
                arr[x][col]=1;// Place the queen

                // Recur to place the rest of the queens
                if(nQueen(arr, x+1, n)){
                    return true;
                }
                // If placing the queen here doesn't lead to a solution, backtrack
                arr[x][col]=0;//backtracking means remove the queen
            }
        }
        return false;// No place for a queen in this row
    }
}
