import java.util.ArrayList;
import java.util.List;

public class Block {
	List<Piece> pieceList = new ArrayList<Piece>();
	Warp warp;
	boolean freezePoint = false;
	boolean unluckyPoint = false;
	
	public Block(){
	}
	
	public boolean removePiece(Piece p) {
		if (pieceList.contains(p)) {
			pieceList.remove(p);
			return true;
		}
		return false;
	}
	
	public void addPiece(Piece p) {
		pieceList.add(p);
	}
	
	public void addWarp(Warp warp) {
		this.warp = warp; 
	}
	
	public void addFreezePoint() {
		freezePoint = true;
	}
	
	public void addUnluckyPoint() {
		unluckyPoint = true;
	}
	
	
}

