import java.util.Random;
/* this class represent 2d for John Conway's Game Of Life*/
public class MyMatrix {

    private final int MAT_SIZE = 10;
    private boolean[][] board;

//----------------------------------------------------------------------------------------------------------------------
    // Ctor
    public MyMatrix() {
        this.board = new boolean[MAT_SIZE][MAT_SIZE];
        this.randNewMat();

    }
//----------------------------------------------------------------------------------------------------------------------
    // Generating boolean 2d matrix
    private void randNewMat() {
        Random r = new Random();
        for (int i = 0; i < MAT_SIZE; i++) {
            for (int j = 0; j < MAT_SIZE; j++) {
                if (r.nextInt(2) == 1) {
                    this.board[i][j] = true;

                } else {
                    this.board[i][j] = false;
                }
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // checks if cell is alive or dead, return true or false respectively
    public boolean isAlive(int i, int j) {
        if (i < 0 || j < 0 || i >= this.getMatSize() || j >= this.getMatSize()) {
            return false;
        }
        return this.board[i][j];
    }
//----------------------------------------------------------------------------------------------------------------------
    // return the size of the mat(one dimensional)
    public int getMatSize() {
        return this.MAT_SIZE;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the numbers of living neighbours
    public int getNumberOfLivingNeighbours(int x, int y) {
        int noln = 0;  // number of living neighbours

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (this.isAlive(i, j) && !((i == x) && (j == y))) {
                    noln += 1;
                }
            }
        }
        return noln;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Go next generation, changes the matrix accordingly
    public void goNextGeneration() {
        boolean[][] newBoard = new boolean[this.MAT_SIZE][this.MAT_SIZE];
        boolean isCellAlive = false;
        int countNeigh = 0;
        for (int i = 0; i < MAT_SIZE; i++) {
            for (int j = 0; j < MAT_SIZE; j++) {
                isCellAlive = this.isAlive(i, j);
                countNeigh = this.getNumberOfLivingNeighbours(i, j);
                newBoard[i][j] = this.setCellAccordingly(isCellAlive, countNeigh);
            }
        }
    this.board = newBoard;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns if cell should have life or death in next generation
    private boolean setCellAccordingly(boolean isCellAlive, int numOfNeighbours){
        if(isCellAlive){

            if (numOfNeighbours == 2 || numOfNeighbours == 3){
                return true;
            }
            else{// can be 0-1, 4 or more living neighbours
                return false;
            }
        }
        else // dead cell
            {
                if(numOfNeighbours  == 3){
                    return true;
                }
            }
        // dead cell and numOfNeighbours != 3
        return false;

    }
//----------------------------------------------------------------------------------------------------------------------
}
