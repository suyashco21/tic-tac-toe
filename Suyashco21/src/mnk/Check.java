
/**
 * @author Suyash
 *	 
 */

package mnk;

public interface Check {
	
	/**
	 * This method returns -infinity to +infinity range of values. 
	 * The implementation should vary for each heuristic implementation.
	 * The value returned should be an indicator for the state to be on winning end.
	 * @param gameState
	 * @return
	 */
	public int getHeuristicValue(Current current);
	
	/**
	 * Returns true if the gameState is terminal.
	 * @param gameState
	 * @return
	 */
	public boolean isTerminal(Current current);
}
