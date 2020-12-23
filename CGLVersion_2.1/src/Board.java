import java.util.Arrays;

public class Board {
	
	int size;
	int iter=0;
	int[] live;
	Cell[][] board = null;
	Cell[][] board2 = null;
	
	
	Board(int size) {
		this.size = size;
		this.board = new Cell[size][size];
		//this.board2 = new Cell[size][size];
	}
	
	void createBoard() {
		this.board = new Cell[size][size];
		
	}
	
	void printBoard() {
		for (int i=0;i<board.length;i++) {
			for (int j=0;j<board.length;j++) {
				if (j<board.length-1) {
					if (board[i][j].status == false) {
						System.out.print(".");
					}else {
						System.out.print("*");
					}
				}else {
					if (board[i][j].status == false) {
						System.out.print("."+"\n");
					}else {
						System.out.print("*"+"\n");
					}
				}
			}
		}
		
	}
	
	void nextGen() {
		this.iter+=1;
		this.board2 = new Cell[this.size][this.size];
		for (int i=0;i<this.size;i++) {
			for (int j=0;j<this.size;j++) {
				this.board2[i][j] = this.board[i][j].nextGen_status();
			}
		}
		this.board = null;
		this.board = Arrays.stream(this.board2).map(a -> Arrays.copyOf(a, a.length)).toArray(Cell[][]::new);
	}
	
	boolean checkEnd() {
		if (this.live.length==0) {
			return true;
		}else {
			return false;
		}		
	}

}
