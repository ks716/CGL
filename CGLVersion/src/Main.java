import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Input size of board: ");
		int size = scan.nextInt();
		Board game = new Board();
		game.setSize(size);
		game.createBoard();

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

			}else {
				System.out.print("Enter x,y of next cell: ");
				String s = scan2.nextLine();
				String s1[] = s.split(",");
				int x = Integer.parseInt(s1[0]);
				int y = Integer.parseInt(s1[1]);
				game.board[x][y].setStatus(true);

				
			}
		}
		game.printBoard();
		System.out.println("Game ready, start? Y/N");
		String reply = scan3.nextLine();
		long timeout = 1500;
		if (reply.equals("Y") || reply.equals("y")) {
			System.out.println("***** Game started *****");
			while(game.checkEnd()) {
				if (game.iter==500) {
					break;
				}

				game.nextGen();
				
				
				try {
					Thread.sleep(timeout);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("***** Game stopped after "+game.iter+" iterations *****");

		}else {
			System.out.println("***** Game stopped *****");
		}
		scan3.close();
		scan2.close();
		scan.close();
	}
	

}
