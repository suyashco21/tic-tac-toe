/*
 * @author Suyash
 * 
 */

package mnk;


import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.text.GapContent;



public class Generate {
	private int blockSizeToWin = 4;
	private int columnSize = 4;
	private int rowSize = 3;

	
	public Generate(int blockSizeToWin, int rowSize, int columnSize) {
		super();
		this.blockSizeToWin = blockSizeToWin;
		this.columnSize = columnSize;
		this.rowSize = rowSize;
	}
    //check wheather if all the places are filled
	public int findTopIndex(boolean[][] occupancyMatrix,int columnNumber){
		for(int i = 0; i < occupancyMatrix.length; i++){
			for(int j=0; j < occupancyMatrix[0].length;j++)
			if(!occupancyMatrix[i][j])
				return i;
		}
		return -1;
	}
	
	public List<Current> generateChildStates(Current current, boolean aiTurn) throws CloneNotSupportedException{
		List<Current> childList = new LinkedList<Current>();
		Current tempState;
		int index;
		boolean[][] bitSets = current.getOccupancyMatrix();
		//for(int i=0;i<4;i++)
	//	{
			//for (int j=0;j<5;j++)
			//{
				//if(bitSets[i][j])
					//	System.out.print("1 ");
				//else
					//System.out.print("0 ");
			//}
			//System.out.println();
		//}
		//System.out.println("end");
		
		
		for(int i=0; i<columnSize;i++){
			for(int j=0; j<rowSize;j++)
			{
		
			try {
				tempState = (Current) current.clone();
				if(bitSets[j][i])
				{
					continue;
				}
				index = j;
				if(index>-1 && index<rowSize){
					if(aiTurn)
						tempState.setWhite(index, i);
					else
						tempState.setBlack(index, i);
					childList.add(tempState);
				}
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			}
			
		}
		
		
		return childList;
		
	}
	
	/**
	 * @return the blockSizeToWin
	 */
	public int getBlockSizeToWin() {
		return blockSizeToWin;
	}

	/**
	 * @param blockSizeToWin the blockSizeToWin to set
	 */
	public void setBlockSizeToWin(int blockSizeToWin) {
		this.blockSizeToWin = blockSizeToWin;
	}

	/**
	 * @return the columnSize
	 */
	public int getColumnSize() {
		return columnSize;
	}

	/**
	 * @param columnSize the columnSize to set
	 */
	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}

	/**
	 * @return the rowSize
	 */
	public int getRowSize() {
		return rowSize;
	}

	/**
	 * @param rowSize the rowSize to set
	 */
	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public Generate() {
		super();
	}
}
