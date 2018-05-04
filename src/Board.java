import java.util.HashMap;
import java.util.Map;

public class Board {
	Block[] blockArray;
	Map<Piece,Integer> mapCurrIndex;
	int size;

	public Board(int size) {
		blockArray = new Block[size*size];
		mapCurrIndex = new HashMap<Piece,Integer>();
		this.size = size;
		for (int i = 0; i < size*size; i++) {
			blockArray[i] = new Block();
		}

	}

	public boolean movePieceAt(Piece player,int gotoDisatance) {
		int index = mapCurrIndex.get(player);
		boolean isThatBlockHasPlayer = blockArray[index].removePiece(player);

		if (isThatBlockHasPlayer) {
			int newIndex = 0;
			if (player.isFreeze) {
				player.clearFreeze();
				blockArray[index].addPiece(player);
				return false;
			}
			else if (player.isUnlucky) {
				newIndex = index - gotoDisatance;	
				player.clearUnlicky();
			}
			else {
				newIndex = index + gotoDisatance;
			}
			
			if(blockArray[newIndex].warp != null) {
				newIndex = blockArray[newIndex].warp.getOutIndex();
			}

			blockArray[newIndex].addPiece(player);
			if (blockArray[newIndex].freezePoint != false) {
				player.setFreeze();
			}
			
			if (blockArray[newIndex].unluckyPoint != false) {
				player.setUnlucky();
			}
			mapCurrIndex.put(player, newIndex);
			return true;
		}
		return false;
	}

	public void addPlayerToStartPoint(Piece p) {
		blockArray[0].addPiece(p);
		mapCurrIndex.put(p, 0);
	}

	public int getCurrentIndexOf(Piece p) {
		return mapCurrIndex.get(p);
	}

	public void print() {
		for (int i = 0; i < size*size; i++) {
			if (blockArray[i].pieceList.isEmpty()) {
				System.out.print("__");
				System.out.print(",");
			}
			else {
				System.out.print("[");
				for (Piece p : blockArray[i].pieceList) {
					System.out.print(p.name);
				}
				System.out.print("],");
			}
			
		}
		System.out.println();
	}

	public void addWarp(int index,Warp wp) {
		blockArray[index].addWarp(wp);
	}

	public void addFreezePoint(int index) {
		blockArray[index].addFreezePoint();
	}
	
	public void addUnluckyPoint(int index) {
		blockArray[index].addUnluckyPoint();;
	}
}
