/**
 * 
 */
package mnk;

//import pandit.representations.GameState;

/**
 * @author Suyash
 *
 */
public class Node {
	private Current currentGameState;
	private Current childGameState;
	private int heuristicValue;
	public Node(Current currentGameState) {
		super();
		heuristicValue = 0;
		childGameState = null;
		this.currentGameState = currentGameState;
	}

	/**
	 * @return the childGameState
	 */
	public Current getChildGameState() {
		return childGameState;
	}

	/**
	 * @param childGameState 
	 * the childGameState to set
	 */
	public void setChildGameState(Current childGameState) {
		this.childGameState = childGameState;
	}

	/**
	 * @return the heuristicValue
	 */
	public int getHeuristicValue() {
		return heuristicValue;
	}

	/**
	 * @param heuristicValue the heuristicValue to set
	 */
	public void setHeuristicValue(int heuristicValue) {
		this.heuristicValue = heuristicValue;
	}

	/**
	 * @return the currentGameState
	 */
	public Current getCurrentGameState() {
		return currentGameState;
	}

	/**
	 * @param currentGameState 
	 * the currentGameState to set
	 */
	public void setCurrentGameState(Current currentGameState) {
		this.currentGameState = currentGameState;
	}


	@Override
	public String toString() {
		return "Node [currentGameState=" + currentGameState
				+ ", childGameState=" + childGameState + ", heuristicValue="
				+ heuristicValue + "]";
	}	
}
