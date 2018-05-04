
public class Piece {
	String name;
	boolean isFreeze = false;
	boolean isUnlucky = false;
	
	public Piece(String n) {
		name = n;
	}
	
	public void setFreeze() {
		isFreeze = true;
	}
	
	public void clearFreeze() {
		isFreeze = false;
	}
	
	public void setUnlucky() {
		isUnlucky = true;
	}
	
	public void clearUnlicky() {
		isUnlucky = false;
	}
	
	
	
}
