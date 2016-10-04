/*Name: Taha Rangwala
 * Date: September 30, 2016
 * Purpose: The purpose of this class is to take all the information from all the other classes
 * and do some calculations and relay them back to the gui class for the user to see. This class essentially
 * holds all the information that the user wants to see and does necessary calculations as well.
 */

import java.util.*;//allows for the use of array lists and list iterators

//IteratorDatabase class header
class IteratorDatabase {

	//Declaring private instance variables
	private IteratorArrayList <Integer> allNumbers;
	private IteratorArrayList <Sequence> allSequences;
	private int seqCount;
	
	//Constructor method to initialize private instance variables
	public IteratorDatabase(){
		allNumbers = new IteratorArrayList <Integer>();
		allSequences = new IteratorArrayList <Sequence>();
		seqCount = 0;
	}
	
	/*Purpose: The purpose of this method is to add numbers to the integer array list using the add method
	 * in the generic type class
	 * @param Number This is the number being added to the array list of integers
	 */
	public void Add(int Number){
		allNumbers.Add(Number);
	}
	
	/*Purpose: The purpose of this method is to change numbers in the integer array list using the change method
	 * in the generic type class
	 * @param Position This is the position of the number that is being changed
	 * @param Number This is the number replacing the current number in the array list of integers
	 */
	public void Change(int Position, int Number){
		allNumbers.Change(Position, Number);
	}
	
	/*Purpose: The purpose of this method is to delete numbers in the integer array list using the delete method in
	 * the generic type class
	 * @param Position This is the position of the number that is being deleted
	 */
	public void Delete(int Position){
		allNumbers.Delete(Position);
	}
	
	
	/*Purpose: The purpose of this method is to return the longest non-decreasing sequences back to the gui
	 * and this method checks to see which sequences match the max count and add them to the output
	 * @return This method returns a string value of all of the longest non-decreasing sequences of numbers
	 */
	public String getNonDecreasingSequencesInOrder(){
		determineNonDecreasingSequences();
		ListIterator <Sequence> seqIter = allSequences.getArray().listIterator();
		int Max = getLongestCount();
		int Count = 0;
		if(Max == 0 || Max == 1)
			return "There Are No Non-Decreasing Sequences!";
		String Output = "";
		while(Max > 1){
			while(seqIter.hasNext() && Count <= seqCount){
				if(seqIter.next().getCount() == Max){
					Output += seqIter.previous().toString() + " Count: " + seqIter.next().getCount() + "\n";
				}
			}
			Max--;
			Count = 0;
			seqIter = allSequences.getArray().listIterator();
		}
		return "Non-Decreasing Sequence(s) In Order Of Size: \n" + Output;
	}
	
	/*Purpose: The purpose of this method is to find the longest sequences length in the array list of
	 * sequences
	 * @return This method returns an integer value of the longest sequence length 
	 */
	private int getLongestCount(){
		ListIterator <Sequence> seqIter = allSequences.getArray().listIterator();
		int Max = 0;
		while(seqIter.hasNext()){
			if(seqIter.next().getCount() > Max){
				Max = seqIter.previous().getCount();
				seqIter.next();
			}
		}
		return Max;
	}
	
	/*Purpose: The purpose of this method is to create non-decreasing sequences 
	 */
	private void determineNonDecreasingSequences(){
		allSequences = new IteratorArrayList <Sequence>();
		seqCount = 0;
		ListIterator <Integer> Iter = allNumbers.getArray().listIterator();
		String Component = "";
		int Previous = 0;
		int Count = 0;
		while(Iter.hasNext()){
			if(seqCount == 0){
				seqCount++;
				Count++;
				Previous = Iter.next().intValue();
				Component = "" + Previous + " ";
			}
			else if(Previous <= Iter.next()){
				Count++;
				Iter.previous();
				Previous = Iter.next().intValue();
				Component += "" + Previous + " ";
			}
			else{
				seqCount++;
				allSequences.Add(new Sequence(Component,Count));
				Iter.previous();
				Previous = Iter.next().intValue();
				Component = "" + Previous + " ";
				Count = 1;
			}
		}
		seqCount++;
		allSequences.Add(new Sequence(Component,Count));
	}
	
}