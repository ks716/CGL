import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestJunit {

   @Test
   public void testMainOne() {
//	   ComplexNumber cn1 = new ComplexNumber(3, 4);
//	   ComplexNumber cn2 = new ComplexNumber(3, -8);
	   Board board = new Board(5);
       System.out.println("======TEST ONE EXECUTED=======");
       Assertions.assertEquals(5, board.size);
   }
   
   @Test
   public void testMainTwo() {
	   Cell cell = new Cell();
	   cell.setStatus(true);
//	   ComplexNumber cn1 = new ComplexNumber(3, 4);
//	   ComplexNumber cn2 = new ComplexNumber(4, -1);
	   System.out.println("======TEST TWO EXECUTED=======");
       Assertions.assertEquals(true, cell.status);
   }
   
   @Test
   public void testMainThree() {
	   Board obj = new Board(10);
//	   ComplexNumber cn1 = new ComplexNumber(3, 4);
//	   ComplexNumber cn2 = new ComplexNumber(5, 6);
	   System.out.println("======TEST THREE EXECUTED=======");
       Assertions.assertEquals(10, obj.board.length);
       Assertions.assertEquals(10, obj.board[0].length);
   }
}


