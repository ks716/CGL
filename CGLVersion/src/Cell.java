public class Cell {
	
	boolean status ;
	int row;
	int col;
	
	Cell() {		
		this.status = false;
	}
	
	
	void setStatus(boolean bool) {
		this.status = bool;		
	}
	
	boolean getStatus() {
		return this.status;
	}

}
