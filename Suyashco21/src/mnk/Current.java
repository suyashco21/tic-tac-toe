/**
 * 
 */
package mnk;


import java.util.Arrays;
import java.util.BitSet;

/*
 * @author Suyash
 * 
 */
//this class take the note of the current state
public class Current implements Cloneable {
	private boolean[][] blackBlocks;
	private boolean[][] whiteBlocks;

	/**
	 * Constructor Initiates a state of n*m. Each row on the board is
	 * represented as a BitSet. There are m (number of rows) then we initialize
	 * an array of size m. Each BitSet in this array is of size 'n'
	 * (numberOfColumns)
	 */
	
	 public Current(int numberOfRows, int numberOfColumns) {
		super();

		// We use this representation as we can then exploit bitSet.get
		this.blackBlocks = new boolean[numberOfRows][numberOfColumns];
		this.whiteBlocks = new boolean[numberOfRows][numberOfColumns];

	}

	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		for(int i=0;i<blackBlocks.length;i++){
			for(int j=0;j<blackBlocks[0].length;j++){
				if(blackBlocks[i][j])
					{buffer.append(" X ");}
				else if(whiteBlocks[i][j])
					{buffer.append(" O ");
					Main.setw(i, j);
					}
				else
					buffer.append(" = ");
			}
			buffer.append("\n");
		}
		buffer.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		return buffer.toString();
		
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(blackBlocks);
		result = prime * result + Arrays.deepHashCode(whiteBlocks);
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Current other = (Current) obj;
		if (!Arrays.equals(blackBlocks, other.blackBlocks))
			return false;
		if (!Arrays.equals(whiteBlocks, other.whiteBlocks))
			return false;
		return true;
	}
	
	/**
	 * Sets the blackCoordinate
	 * @param rowCoordinate
	 * @param columnCoordinate
	 */
	
	public void setBlack(int rowCoordinate, int columnCoordinate){
		blackBlocks[rowCoordinate][columnCoordinate] = true;
	}
	
	/**
	 * Sets the whiteCoordinate
	 * @param rowCoordinate
	 * @param columnCoordinate
	 */
	public void setWhite(int rowCoordinate, int columnCoordinate){
		whiteBlocks[rowCoordinate][columnCoordinate] = true;
	}
	
	/**
	 * @return the blackBlocks
	 */
	public boolean[][] getBlackBlocks() {
		return blackBlocks;
	}

	/**
	 * @param blackBlocks
	 *            the blackBlocks to set
	 */
	public void setBlackBlocks(boolean[][] blackBlocks) {
		this.blackBlocks = blackBlocks;
	}

	/**
	 * @return the whiteBlocks
	 */
	public boolean[][] getWhiteBlocks() {
		return whiteBlocks;
	}

	/**
	 * @param whiteBlocks
	 *            the whiteBlocks to set
	 */
	public void setWhiteBlocks(boolean[][] whiteBlocks) {
		this.whiteBlocks = whiteBlocks;
	}

	/**
	 * Returns true if the block is set to white.
	 */
	public boolean isWhite(int rowCordinate, int columnCordinate) {
		return this.whiteBlocks[rowCordinate][columnCordinate];
	}

	/**
	 * Returns true if block is set to black.
	 */
	public boolean isBlack(int rowCordinate, int columnCordinate) {
		return this.blackBlocks[rowCordinate][columnCordinate];
	}

	/**
	 * returns true if the cell is empty
	 */
	public boolean isEmpty(int rowCordinate, int columnCordinate) {
		return !(isBlack(rowCordinate, columnCordinate) || isWhite(
				rowCordinate, columnCordinate));
	}

	
	@Override
	public Object clone() throws CloneNotSupportedException{
		Current current=new Current(this.blackBlocks.length, this.blackBlocks[0].length);
		boolean[][] newBlackBlocks = current.getBlackBlocks();
		boolean[][] newWhiteBlocks = current.getWhiteBlocks();
		for(int i=0;i<this.blackBlocks.length;i++){
			newBlackBlocks[i] = Arrays.copyOf(blackBlocks[i], blackBlocks[i].length);
			newWhiteBlocks[i] = Arrays.copyOf(whiteBlocks[i], whiteBlocks[i].length);
		}
		current.setBlackBlocks(newBlackBlocks);
		current.setWhiteBlocks(newWhiteBlocks);
		return current;
	}
       //gives the occupanymatrix
	public boolean[][] getOccupancyMatrix() {
		boolean[][] occupancyMatrix = new boolean[whiteBlocks.length][whiteBlocks[0].length];
		for (int i = 0; i < whiteBlocks.length; i++)
			for (int j = 0; j < whiteBlocks[0].length; j++)
				occupancyMatrix[i][j] = (whiteBlocks[i][j] || blackBlocks[i][j]);

		return occupancyMatrix;

	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Generate generate = new Generate(3, 3,3);
		Check check = new CustomCheck(generate);
		Current current= new Current(generate.getRowSize(),
				generate.getColumnSize());
		
		current.setBlack(0,0);
		current.setBlack(0,1);
		current.setWhite(0,2);
		
		current.setWhite(1,0);
		current.setWhite(1,1);
		current.setBlack(1,2);
		
		current.setBlack(2,0);
		current.setWhite(2,1);
		
		
		Prunning prunning = new Prunning(1, generate,
				check);
		//System.out.println("Root State : " + current);
		Current childCurrent = prunning.alphaBeta(current);
		//System.out.println("Next State: " + childCurrent);
		
	}
}

