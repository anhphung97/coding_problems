// Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
// For example,
// X X X X
// X O O X
// X X O X
// X O X X
// After running your function, the board should be:
// X X X X
// X X X X
// X X X X
// X O X X

public class SurroundedRegions 
{
    public void solve(char[][] board) 
    {
        // get the size of board
        int n = board.length;
        if (n == 0)
            return;
        int m = board[0].length;
        
        
        // mark all the 'O' regions that expand to one of 4 sides
        // of the board 'Y'
        for (int i = 0; i < m; i++)
            if (board[0][i] == 'O')
                explore(board, 0, i);
        for (int i = 0; i < m; i++)
            if (board[n-1][i] == 'O')
                explore(board, n-1, i);
        for (int i = 0; i < n; i++)
            if (board[i][0] == 'O')
                explore(board, i, 0);
        for (int i = 0; i < n; i++)
            if (board[i][m-1] == 'O')
                explore(board, i, m-1);
        
        // change back all the 'Y' to 'O'
        // and all the 'O' to 'X' (those are captured regions)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
            {
                if (board[i][j] == 'Y')
                    board[i][j] = 'O';
                else 
                    board[i][j] = 'X';
            }
        
    }
    
    private void explore(char[][] board, int row, int col)
    {
        // function to change all 'O' in a region to 'Y'
        int n = board.length;
        int m = board[0].length;
        
        // change the current location
        board[row][col] = 'Y';
        
        // check four of its neighbors
        int[] horizontal = new int[] {1,-1,0,0};
        int[] vertical = new int[] {0,0,1,-1};
        
        for (int i = 0; i < 4; i++)
        {
            int x = row + horizontal[i];
            int y = col + vertical[i];
            
            // calling recursively if its neighbor is an 'O'
            if (x < n-1 && x > 0 && y < m-1 && y > 0)
            {
                if (board[x][y] == 'O')
                    explore(board,x,y);
            }
        }
    }
}
