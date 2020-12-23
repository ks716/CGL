

public class Cell {
	
	boolean status;
	
	
	void setStatus(boolean bool) {
		this.status = bool;
	}
	
	public int aliveNCells() {
		
		return 0;
	}
	
	public Cell nextGen_status() {
		Cell cell2 = new Cell();
		int alive = this.aliveNCells();
		if (this.status==false) {
			if (alive==3) {
				cell2.setStatus(true);
			}else {
				cell2.setStatus(false);
			}
		}else {
			if (alive==0 || alive==1) {
				cell2.setStatus(false);
			}else if (alive==2 || alive==3) {
				cell2.setStatus(true);
			}else {
				cell2.setStatus(false);
			}
		}
		return cell2;
		
	}
	

}
