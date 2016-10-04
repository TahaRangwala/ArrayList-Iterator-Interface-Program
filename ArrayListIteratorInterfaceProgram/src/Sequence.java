/*Name: Taha Rangwala
 * Date: September 30, 2016
 * Purpose: The purpose of this class is to hold all of the information for each of the non-decreasing sequences
 */

import java.util.*;//allows for the use of array lists

//Sequence class header
public class Sequence {

	//Declaring private instance variables
	private String numberSequence;
	private int Count;
	
	//Constructor method to initialize private instance variables
	public Sequence(String numberSequence, int Count){
		this.numberSequence = numberSequence;
		this.Count = Count;
	}
	
	/*Purpose: The purpose of this method is to return the number of integers in the sequence
	 * @return This returns a integer value of the number of integers in the sequence
	 */
	public int getCount(){
		return Count;
	}
	
	/*Purpose: The purpose of this method is to return the non-decreasing sequence
	 * @return This returns a string value of the non-decreasing sequence
	 */
	public String toString(){
		return numberSequence;
	}
	
}