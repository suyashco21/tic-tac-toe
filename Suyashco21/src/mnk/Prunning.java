/**
 * 
 */
package mnk;

import java.util.List;
import java.util.Set;


/**
 * @author suyash
 *
 */
public class Prunning {
	private int counter = 0;
	private int maxDepth;
	private Generate generate;
	private Check check;
	private int nodeCounter =0;
	private int alphaPruningCounter = 0;
	private int betaPruningCounter = 0;
	
	
	
	public Prunning(int maxDepth, Generate generate,
			Check check) {
		super();
		this.maxDepth = maxDepth;
		this.generate = generate;
		this.check = check;
		this.nodeCounter =0; 
		this.alphaPruningCounter =0;
		this.betaPruningCounter =0;
	}

	public Current alphaBeta(Current current) throws CloneNotSupportedException{
		Node rootNode = new Node(current);
		alphaBeta(rootNode, maxDepth, -2147483646,  2147483646, true);
		//System.out.println("Total Nodes in Alpha-Beta Search : "+ nodeCounter);
		//System.out.println("Number of times Alpha-Pruning Occured : "+ alphaPruningCounter);
		//System.out.println("Number of times Beta-Pruning Occured : "+ betaPruningCounter);
		return rootNode.getChildGameState();
		
	}
	
	
	
	private int alphaBeta(Node node, int depth, int alpha, int beta, boolean aiTurn) throws CloneNotSupportedException {
		
		
        //We call this to depth limit the search and check if things are in our favour.
		nodeCounter++;
		if (check.isTerminal(node.getCurrentGameState())) {
			return check.getHeuristicValue(node.getCurrentGameState());
        } else if (depth < 0) {
        	return check.getHeuristicValue(node.getCurrentGameState());
        }

        List<Current> children = generateChildren(node.getCurrentGameState(), aiTurn); // generates children. also rates them and applies move to copy of field. 

        if (aiTurn) { // ai tries to maximize the score
            
            
        	for (Current child : children) {
        		int score = alphaBeta(new Node(child), depth - 1, alpha, beta, false);
        	
        		//System.out.println("This is Heauristic "+ check.getHeuristicValue(node.getCurrentGameState()));
        		//System.out.println("This is Score "+ score);
        		if(score>alpha){
        			node.setChildGameState(child);
        			alpha = score;
        		}
        		
                if (beta <= alpha) {
                    betaPruningCounter++;
            
                    break; // beta cutoff
                }
                
            }
            return alpha;
        } else { // enemy tries to minimize the score
            
        	for (Current child : children) {
            	int score = alphaBeta(new Node(child), depth - 1, alpha, beta, true);
        		if(score<beta){
        			node.setChildGameState(child);
        			beta = score;
        		}
            	
        		if (beta <= alpha) {
                    alphaPruningCounter++;
        	
                    break; // alpha cutoff
                }
            }
            return beta;
        }
    }	

	private List<Current> generateChildren(Current current, boolean aiTurn) throws CloneNotSupportedException {
		return generate.generateChildStates(current, aiTurn);
	}
}
