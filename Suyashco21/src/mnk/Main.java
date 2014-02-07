package mnk;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main implements ActionListener {
	public static int k;
	private static JFrame window = new JFrame("MNK");
    public static JButton buttons[] = new JButton[21];

   boolean computerturn;
   Generate generate;
   Check check;
   Current current;
   Prunning prunning;
   public static int count = 0;
   int row = 4;
   int column = 5;
   int lookupLevel;
   int connectN = 4;
   
   
   public Main(){
   /*Create Window*/
	   window.getContentPane().setBackground(Color.red); 
	   lookupLevel = Integer.parseInt(JOptionPane.showInputDialog("Select the difficulty level \n 0 = Easy 1 = Hard"));  
	   
	   generate = new Generate(connectN, row, column);
		 
		 current = new Current(generate.getRowSize(),
				generate.getColumnSize());
		 
   window.setPreferredSize(new Dimension(500,500));
   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   window.setLayout(new GridLayout(4,5));
   
   /*Add Buttons To The Window*/
   for(int i = 1; i<=20; i++){
       buttons[i] = new JButton();
       window.add(buttons[i]);
       buttons[i].addActionListener(this);
     
   }
   
   /*Make The Window Visible*/
   window.setVisible(true);
   window.pack();
   }
   
   
   public void actionPerformed(ActionEvent a) {
       /*Write the letter to the button and deactivate it*/
       for(int i = 1; i<= 20; i++){
           if(a.getSource() == buttons[i]){
               buttons[i].setText("X");
               buttons[i].setEnabled(false);
               k=i;
               break;
               
           }
         
           
       }
       count++;
       computerturn=true;
            
      try{ AI(k,computerturn);}
      catch(Exception e)
      {
    	  System.out.println("error");
      }
   }
   public static int click_index()
   {
   	return k;
   }
   public static void setb(int k, int j)
   {
   	int i=-1;
		if(k==0 && j==0)
			i=1;
		if(k==0 && j==1)
			i=2;
		if(k==0 && j==2)
			i=3;
		if(k==0 && j==3)
			i=4;
		if(k==0 && j==4)
			i=5;
		if(k==1 && j==0)
			i=6;
		if(k==1 && j==1)
			i=7;
		if(k==1 && j==2)
			i=8;
		if(k==1 && j==3)
			i=9;
		if(k==1 && j==4)
			i=10;
		if(k==2 && j==0)
			i=11;
		if(k==2 && j==1)
			i=12;
		if(k==2 && j==2)
			i=13;
		if(k==2 && j==3)
			i=14;
		if(k==2 && j==4)
			i=15;
		if(k==3 && j==0)
			i=16;
		if(k==3 && j==1)
			i=17;
		if(k==3 && j==2)
			i=18;
		if(k==3 && j==3)
			i=19;
		if(k==3 && j==4)
			i=20;
		 buttons[i].setText("x");
       
   }
   public static void setw(int k, int j)
   {
   	int i=-1;
   	if(k==0 && j==0)
		i=1;
	if(k==0 && j==1)
		i=2;
	if(k==0 && j==2)
		i=3;
	if(k==0 && j==3)
		i=4;
	if(k==0 && j==4)
		i=5;
	if(k==1 && j==0)
		i=6;
	if(k==1 && j==1)
		i=7;
	if(k==1 && j==2)
		i=8;
	if(k==1 && j==3)
		i=9;
	if(k==1 && j==4)
		i=10;
	if(k==2 && j==0)
		i=11;
	if(k==2 && j==1)
		i=12;
	if(k==2 && j==2)
		i=13;
	if(k==2 && j==3)
		i=14;
	if(k==2 && j==4)
		i=15;
	if(k==3 && j==0)
		i=16;
	if(k==3 && j==1)
		i=17;
	if(k==3 && j==2)
		i=18;
	if(k==3 && j==3)
		i=19;
	if(k==3 && j==4)
		i=20;
		 buttons[i].setText("O");
        buttons[i].setEnabled(false);
   }
   public static int getr(int j)
   {
   	int a=-1,b=-1;
   	switch (j)
		{
		 case 1:  a=0;
		          b=0;
        break;
case 2:  a=0;
b=1;
        break;
case 3:  a=0;
b=2;
        break;
case 4:  a=0;
b=3;
        break;
case 5:  a=0;
b=4;
        break;
case 6:  a=1;
b=0;
        break;
case 7:  a=1;
b=1;
        break;
case 8:  a=1;
b=2;
        break;
case 9:  a=1;
b=3;
        break;
case 10: a=1;
b=4;
        break;
case 11: a=2;
b=0;
        break;
case 12: a=2;
b=1;
        break;
case 13:  a=2;
b=2;
        break;
case 14:  a=2;
b=3;
        break;
case 15:  a=2;
b=4;
        break;
case 16:  a=3;
b=0;
        break;
case 17:  a=3;
b=1;
        break;
case 18:  a=3;
b=2;
        break;
case 19: a=3;
b=3;
        break;
case 20: a=3;
b=4;
        break;
        }
   	return a;
   }
   public static int getc(int j)
   {
   	int a=-1,b=-1;
   	switch (j)
		{
		case 1:  a=0;
        b=0;
break;
case 2:  a=0;
b=1;
break;
case 3:  a=0;
b=2;
break;
case 4:  a=0;
b=3;
break;
case 5:  a=0;
b=4;
break;
case 6:  a=1;
b=0;
break;
case 7:  a=1;
b=1;
break;
case 8:  a=1;
b=2;
break;
case 9:  a=1;
b=3;
break;
case 10: a=1;
b=4;
break;
case 11: a=2;
b=0;
break;
case 12: a=2;
b=1;
break;
case 13:  a=2;
b=2;
break;
case 14:  a=2;
b=3;
break;
case 15:  a=2;
b=4;
break;
case 16:  a=3;
b=0;
break;
case 17:  a=3;
b=1;
break;
case 18:  a=3;
b=2;
break;
case 19: a=3;
b=3;
break;
case 20: a=3;
b=4;
break;
}
        
   	return b;
   }
   
	public static void main(String[] args) throws IOException,
			CloneNotSupportedException {
		  new Main();
		 
	}
		public void AI(int r,boolean computerturn) throws IOException,CloneNotSupportedException{
	//	BufferedReader reader = new BufferedReader(new InputStreamReader(
		//		System.in));
		
		int col=Main.getc(r);
		int rowRead=Main.getr(r);
		current.setBlack(rowRead, col);
		if (count==1){
			check = new CustomCheck(generate);
			prunning = new Prunning(
					lookupLevel, generate, check);	
		}
		boolean notGameEnd = true;
		notGameEnd=wincheck( current, check, connectN);
		
				if (computerturn && notGameEnd) {
					//computer turn by calling alphabeta function
					current = prunning.alphaBeta(current);
					System.out.println("Board State after computer's move:");
					//display computer move
					System.out.println(current);
					notGameEnd=wincheck( current, check, connectN);
					//boolean notValidMove = true;
					
					computerturn = false;
				}
			}
		// check ending condition for the current state
		public boolean wincheck(Current current,Check check,int connectN)
		{
			if (check.isTerminal(current)) {
				int heuristicValue = check.getHeuristicValue(current);
				if (heuristicValue > Math.pow(10, (connectN)))
					
					JOptionPane.showMessageDialog(null, "Computer Wins ");
				
		
				else if (heuristicValue == 0)
					JOptionPane.showMessageDialog(null, "The game is drawn. No more possibe moves.");
					
		
				else if (heuristicValue < -(Math.pow(10, (connectN))))
					JOptionPane.showMessageDialog(null, "You win  ");
		
				else
					{
					
		
					}
			            return false;}
			return true;
		}
}
