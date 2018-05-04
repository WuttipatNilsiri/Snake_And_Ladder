
public class Main {
	public static void main(String[] a) {
		Board b = new Board(10);
		Piece p1 = new Piece("p1");
		Piece p2 = new Piece("p2");
		Piece p3 = new Piece("p3");
		b.addWarp(1, new Warp(16));
		b.addWarp(2, new Warp(0));
		b.addFreezePoint(5);
		b.addUnluckyPoint(4);
		
		b.addPlayerToStartPoint(p1);
		b.addPlayerToStartPoint(p2);
		b.addPlayerToStartPoint(p3);
		b.print();
		
		b.movePieceAt( p1, 1);
		b.movePieceAt( p2, 5);
		b.movePieceAt( p3, 4);
		b.print();
		
		b.movePieceAt( p1, 6);
		b.movePieceAt( p2, 5);
		b.movePieceAt( p3, 4);
		b.print();
		
		b.movePieceAt( p1, 6);
		b.movePieceAt( p2, 5);
		b.movePieceAt( p3, 4);
		b.print();
	}
}
