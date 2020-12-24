import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestJunit {

   @Test
   public void testMainOne() {
	   Board board = new Board();
	   board.setSize(5);
       System.out.println("======TEST ONE EXECUTED=======");
       Assertions.assertEquals(5, board.size);
   }
   
   @Test
   public void testMainTwo() {
	   Cell cell = new Cell();
	   cell.setStatus(true);
	   System.out.println("======TEST TWO EXECUTED=======");
       Assertions.assertEquals(true, cell.getStatus());
   }
   
   @Test
   public void testMainThree() {
	   Board obj = new Board();
	   obj.setSize(10);
	   obj.createBoard();
	   System.out.println("======TEST THREE EXECUTED=======");
       Assertions.assertEquals(10, obj.board.length);
       Assertions.assertEquals(10, obj.board[0].length);
   }
}


