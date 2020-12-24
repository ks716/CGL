import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Input size of board: ");
		int size = scan.nextInt();
		Board game = new Board();
		game.size =size;
		game.createBoard();
		//System.out.print(game.board[0][0].status);
		System.out.println("How many live cells to start: ");
		int t = scan.nextInt();
		for (int i=0;i<t;i++) {
			if (i==0) {
				System.out.print("Enter x,y of first cell: ");
				String s = scan2.nextLine();
				String s1[] = s.split(",");
				int x = Integer.parseInt(s1[0]);
				int y = Integer.parseInt(s1[1]);
				game.board[x][y].setStatus(true);
//				game.live[x][y] = (true);
			}else {
				System.out.print("Enter x,y of next cell: ");
				String s = scan2.nextLine();
				String s1[] = s.split(",");
				int x = Integer.parseInt(s1[0]);
				int y = Integer.parseInt(s1[1]);
				game.board[x][y].setStatus(true);
//				game.live[x][y] = (true);
				
			}
		}
		game.printBoard();
		System.out.println("Game ready, start? Y/N");
		String reply = scan3.nextLine();
		//System.out.print(reply.getClass().getName());
		if (reply.equals("Y") || reply.equals("y")) {
			System.out.println("***** Game started *****");
			while(game.checkEnd()) {
				if (game.iter==500) {
					break;
				}
//				System.out.println("Generation: "+game.iter+"\r");
				game.nextGen();
				try {
					Thread.sleep((long) 1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("***** Game stopped after "+game.iter+" iterations *****");
			
			//start game
		}else {
			System.out.println("***** Game stopped *****");
		}
		scan3.close();
		scan2.close();
		scan.close();
	}
	
//	static void startgame(Board game) {
//		
//		while(game.checkEnd()) {
//			if (game.iter==500) {
//				break;
//			}
//			System.out.println("Generation: "+game.iter);
//			game.nextGen();
//		}
//		
//		System.out.println("***** Game stopped after "+game.iter+" iterations *****");
//	}
}
