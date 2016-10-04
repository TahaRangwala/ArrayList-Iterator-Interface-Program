/*Name: Taha Rangwala
 * Date: September 30, 2016
 * Purpose: The purpose of the GUI class is to allow the user to use an interface in order to
 * actually interact with the program. This class allows the user to use input fields, scrolling lists,
 * output fields, and buttons. All the information from the other classes is relayed back to this class
 * to show to the user.
 */

import BreezySwing.*;//allows for more window objects

import javax.swing.*;//allows for more window objects

import java.awt.Color;//allows for more color options

//IteratorGUI class header
public class IteratorGUI extends GBFrame{

	//Declaring private instance variables
	private IteratorDatabase Numbers;
	//Declaring window objects
	private DefaultListModel listModel;
	private JLabel InputLabel;
	private IntegerField inputField;
	private JList theList;
	private JTextArea outputArea;
	private JButton inputButton, outputButton, changeButton, deleteButton, resetButton, exitButton;
	
	//Constructor method to initialize private instance variables and window objects
	public IteratorGUI(){
		//Initialize private instance variables
		Numbers = new IteratorDatabase();
		//Initialize window objects
		InputLabel = addLabel("Input",1,1,1,1);
		inputField = addIntegerField(0,1,2,1,1);
		theList = addList(2,1,2,1);
		listModel = (DefaultListModel)theList.getModel();
		inputButton = addButton("Input",3,1,1,1);
		resetButton = addButton("Reset",3,2,1,1);
		outputArea = addTextArea("",4,1,2,1);
		outputButton = addButton("Output",5,1,1,1);
		changeButton = addButton("Change",5,2,1,1);
		deleteButton = addButton("Delete",6,1,1,1);
		exitButton = addButton("Exit",6,2,1,1);
		outputArea.setEditable(false);
		inputField.grabFocus();
		inputField.selectAll();
		inputField.setText("");
	}
	
	/*Purpose: The purpose of this method is to allow the user to use different buttons in order
	 * to carry out functions in the program.
	 * @param buttonObj This button object allows the program to determine which button the user has 
	 * pressed and what action should be carried out.
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == inputButton){//input numbers
			if(validInteger()){
				try{
					Numbers.Add(inputField.getNumber());
					listModel.addElement(inputField.getNumber());
					inputField.grabFocus();
					inputField.selectAll();
					inputField.setText("");
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Please Input Valid Integers!", "Error Message", JOptionPane.ERROR_MESSAGE);
			inputField.grabFocus();
			inputField.selectAll();
		}
		else if(buttonObj == resetButton){//clear everything
			inputField.setText("");
			inputField.grabFocus();
			inputField.selectAll();
			outputArea.setText("");
			listModel.clear();
			Numbers = new IteratorDatabase();
		}
		else if(buttonObj == outputButton){//output longest non-decreasing sequences
			outputArea.setText(Numbers.getNonDecreasingSequencesInOrder());
		}
		else if(buttonObj == changeButton){//change numbers
			if(listModel.size() > 0 && !theList.isSelectionEmpty()){
				if(validInteger()){
					try{
						int f = theList.getSelectedIndex();
						Numbers.Change(theList.getSelectedIndex(),inputField.getNumber());
						listModel.set(theList.getSelectedIndex(),inputField.getNumber());
						inputField.grabFocus();
						inputField.selectAll();
					}
					catch(Exception E){
						JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
					JOptionPane.showMessageDialog(new JFrame(),"Please Input Valid Integers!", "Error Message", JOptionPane.ERROR_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Either No Numbers Are In The List or Nothing Is Selected!", "Error Message", JOptionPane.ERROR_MESSAGE);
			inputField.grabFocus();
			inputField.selectAll();
		}
		else if(buttonObj == deleteButton){//delete numbers
			if(listModel.size() > 0 && !theList.isSelectionEmpty()){
				Numbers.Delete(theList.getSelectedIndex());
				listModel.remove(theList.getSelectedIndex());
				inputField.grabFocus();
				inputField.selectAll();
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Either No Numbers Are In The List or Nothing Is Selected!", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else{//close the program
			this.dispose();
		}
		
	}
	
	/*Purpose: This method checks to make sure the integers inputed are valid integer values
	 * @return This method returns a boolean value that shows whether or not the number inputted
	 * is a valid integer
	 */
	private boolean validInteger(){
		return inputField.isValidNumber();
	}

	//Main method to set up the GUI
	public static void main (String [] args){
		IteratorGUI theMainGUI = new IteratorGUI();//GUI object
		theMainGUI.setSize(420,500);//size of the GUI interface
		theMainGUI.setTitle("Taha's Longest Non-Decreasing Sequence Program");//title of GUI interface
		theMainGUI.setVisible(true);//visibility of interface
		theMainGUI.setLocationRelativeTo(null);//Location is in center of screen
		theMainGUI.getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
	}
	
}