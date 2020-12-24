import java.util.Arrays;

public class Board {
	
	int size;
	int iter=0;
//	boolean[][] live;
//	boolean[][] live2;
	Cell[][] board;
	Cell[][] board2;
	
	
	Board() {
		
		
		
		}
		//this.board2 = new Cell[size][size];

	
	void createBoard() {
//		this.live = new boolean[size][size];
		this.board = new Cell[size][size];
		for (int i=0;i<this.size;i++) {
			for (int j=0;j<this.size;j++) {
				this.board[i][j] = new Cell();
				this.board[i][j].row = i;
				this.board[i][j].col = j;
			}
		}
		
		
		
		
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
		System.out.println(this.board.length);
		for (int i=0;i<this.size;i++) {
			for (int j=0;j<this.size;j++) {
//				this.board[i][j].row = i;
//				this.board[i][j].col = j;
		
//				System.out.println(this.board.length);
				int alive = this.aliveNCells(i, j);
				this.board2[i][j] = new Cell();

				if (this.board[i][j].status==false) {
					if (alive==3) {
						this.board2[i][j].setStatus(true);
					}else {
						this.board2[i][j].setStatus(false);
					}
				}else {
					if (alive==0 || alive==1) {
						this.board2[i][j].setStatus(false);
					}else if (alive==2 || alive==3) {
						this.board2[i][j].setStatus(true);
					}else {
						this.board2[i][j].setStatus(false);
					}
				}
				this.board2[i][j].row = i;
				this.board2[i][j].col = j;
//				this.board2[i][j] = this.board[i][j].nextGen_status();
//				this.live2[i][j] = this.board2[i][j].status;
			}
		}
		this.board = null;
		this.board = Arrays.stream(this.board2).map(a -> Arrays.copyOf(a, a.length)).toArray(Cell[][]::new);
		
//		this.live = null;
//		this.live = Arrays.stream(this.live2).map(a -> Arrays.copyOf(a, a.length)).toArray(boolean[][]::new);
		this.printBoard();
	}
	
	boolean checkEnd() {
		
		for(int i=0;i<this.size;i++) {
			for (int j=0;j<this.size;j++) {
				if (this.board[i][j].status == true) {
					return true;
				}
			}
		}
		
		return false;	
	}
	
	public int aliveNCells(int row,int col) {
		int count =0;
		//this.live_copy = super.board;
		//System.out.println(super.board.length);
		if (row == 0 && col == 0) {
			if (this.board[0][1].status == true) {count++;}
			if (this.board[1][0].status == true) {count++;}
			if (this.board[1][1].status == true) {count++;}
		}else if (row==0 && col==this.size-1) {
			if (this.board[0][this.size-2].status == true) {count++;}
			if (this.board[1][this.size-2].status == true) {count++;}
			if (this.board[1][this.size-1].status == true) {count++;}
		}else if (row==this.size-1 && col==0) {
			if (this.board[this.size-2][0].status == true) {count++;}
			if (this.board[this.size-2][1].status == true) {count++;}
			if (this.board[this.size-1][1].status == true) {count++;}
		}else if (row==this.size-1 && col==this.size-1) {
			if (this.board[this.size-2][this.size-2].status == true) {count++;}
			if (this.board[this.size-1][this.size-2].status == true) {count++;}
			if (this.board[this.size-2][this.size-1].status == true) {count++;}
		}else if (row==0) {
			for (int i=0;i<=1;i++) {
				for (int j=-1;j<=1;j++) {
					if (this.board[row+i][col+j].status==true) {count++;}
				}
			}
			if(this.board[row][col].status==true) {count-=1;}
		}else if (row==this.size-1) {
			for (int i=-1;i<1;i++) {
				for (int j=-1;j<=1;j++) {
					if (this.board[row+i][col+j].status==true) {count++;}
				}
			}
			if(this.board[row][col].status==true) {count-=1;}
		}else if (col==0) {
			for (int i=-1;i<=1;i++) {
				for (int j=0;j<=1;j++) {
					if (this.board[row+i][col+j].status==true) {count++;}
				}
			}
			if(this.board[row][col].status==true) {count-=1;}
		}else if (col==this.size-1) {
			for (int i=-1;i<=1;i++) {
				for (int j=-1;j<1;j++) {
					if (this.board[row+i][col+j].status==true) {count++;}
				}
			}
			if(this.board[row][col].status==true) {count-=1;}
		}else {
			for (int i=-1;i<=1;i++) {
				for (int j=-1;j<=1;j++) {
					if (this.board[row+i][col+j].status==true) {count++;}
				}
			}
			if(this.board[row][col].status==true) {count-=1;}
		}
		
		return count;
	}

}
