import java.util.Arrays;

public class Board {
	
	int size;
	int iter=0;

	Cell[][] board;
	Cell[][] board2;
	
	
	
	Board() {		
		}


	
	void createBoard() {

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
		String res = "";
		res+="*** Generation: "+this.iter+" ***\n";
		for (int i=0;i<board.length;i++) {
			for (int j=0;j<board.length;j++) {
				if (j<board.length-1) {
					if (board[i][j].status == false) {
						res+=". ";
					}else {
						res+="x ";
					}
				}else {
					if (board[i][j].status == false) {
						res+="."+"\n";
					}else {
						res+="x"+"\n";
					}
				}
			}
		}
		System.out.print(res);
	}
	
	
	
	void nextGen() {
		this.iter+=1;
		this.board2 = new Cell[this.size][this.size];

		for (int i=0;i<this.size;i++) {
			for (int j=0;j<this.size;j++) {

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

			}
		}
		this.board = null;
		this.board = Arrays.stream(this.board2).map(a -> Arrays.copyOf(a, a.length)).toArray(Cell[][]::new);
		
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
	
	
	
	
	void setSize(int size) {
		this.size = size;
	}

}
