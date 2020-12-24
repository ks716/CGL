

public class Cell extends Board{
	
	


	boolean status ;
	int row;
	int col;
	//Cell live_copy[][] = null;
	
	Cell() {
		
		this.status = false;
		//Size not used anywhere
	}
	
//	Cell(){
//		live_copy = super.live;
//		
//	}
//	
	
	void setStatus(boolean bool) {
		this.status = bool;
		
	}
	
//	public int aliveNCells() {
//		int count =0;
//		//this.live_copy = super.board;
//		System.out.println(super.board.length);
//		if (this.row == 0 && this.col == 0) {
//			if (this.board[0][1].status == true) {count++;}
//			if (this.board[1][0].status == true) {count++;}
//			if (this.board[1][1].status == true) {count++;}
//		}else if (this.row==0 && this.col==super.size-1) {
//			if (super.board[0][super.size-2].status == true) {count++;}
//			if (super.board[1][super.size-2].status == true) {count++;}
//			if (super.board[1][super.size-1].status == true) {count++;}
//		}else if (this.row==super.size-1 && this.col==0) {
//			if (super.board[super.size-2][0].status == true) {count++;}
//			if (super.board[super.size-2][1].status == true) {count++;}
//			if (super.board[super.size-1][1].status == true) {count++;}
//		}else if (this.row==super.size-1 && this.col==super.size-1) {
//			if (super.board[super.size-2][super.size-2].status == true) {count++;}
//			if (super.board[super.size-1][super.size-2].status == true) {count++;}
//			if (super.board[super.size-2][super.size-1].status == true) {count++;}
//		}else if (this.row==0) {
//			for (int i=0;i<=1;i++) {
//				for (int j=-1;j<=1;j++) {
//					if (super.board[this.row+i][this.col+j].status==true) {count++;}
//				}
//			}
//			if(this.status==true) {count-=1;}
//		}else if (this.row==super.size-1) {
//			for (int i=-1;i<1;i++) {
//				for (int j=-1;j<=1;j++) {
//					if (super.board[this.row+i][this.col+j].status==true) {count++;}
//				}
//			}
//			if(this.status==true) {count-=1;}
//		}else if (this.col==0) {
//			for (int i=-1;i<=1;i++) {
//				for (int j=0;j<=1;j++) {
//					if (super.board[this.row+i][this.col+j].status==true) {count++;}
//				}
//			}
//			if(this.status==true) {count-=1;}
//		}else if (this.col==super.size-1) {
//			for (int i=-1;i<=1;i++) {
//				for (int j=-1;j<1;j++) {
//					if (super.board[this.row+i][this.col+j].status==true) {count++;}
//				}
//			}
//			if(this.status==true) {count-=1;}
//		}else {
//			for (int i=-1;i<=1;i++) {
//				for (int j=-1;j<=1;j++) {
//					if (super.board[this.row+i][this.col+j].status==true) {count++;}
//				}
//			}
//			if(this.status==true) {count-=1;}
//		}
//		
//		return count;
//	}
//	
//	public Cell nextGen_status() {
//		Cell cell2 = new Cell();
//		int alive = this.aliveNCells();
//		if (this.status==false) {
//			if (alive==3) {
//				cell2.setStatus(true);
//			}else {
//				cell2.setStatus(false);
//			}
//		}else {
//			if (alive==0 || alive==1) {
//				cell2.setStatus(false);
//			}else if (alive==2 || alive==3) {
//				cell2.setStatus(true);
//			}else {
//				cell2.setStatus(false);
//			}
//		}
//		cell2.row = this.row;
//		cell2.col = this.col;
//		return cell2;
//		
//	}
	

}
