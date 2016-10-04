/*Name: Taha Rangwala
 * Date: September 30, 2016
 * Purpose: The purpose of this class is to be a generic type. This allows arrays of this class to be created using integers and sequences
 * because integers and sequences do use some of the same methods of this program. This class adds, changes, and deletes numbers in the
 * integer array list, and it adds sequences to the sequence array list.
 */

import java.util.*;//allows for the use of array lists and list iterator

//IteratorArrayList class header
public class IteratorArrayList <T>{

	//Declaring private instance variables
	private ArrayList <T> List;
	
	//Constructor method to declare private instance variables
	public IteratorArrayList(){
		List = new ArrayList <T> ();
	}
	
	/*Purpose: This gets the generic array and returns it
	 * @return This returns an arraylist of the generic array which could be of integers or sequences
	 */
	public ArrayList <T> getArray(){
		return List;
	}
	
	/*Purpose: The purpose of this method is to add generic types to the integer or sequence array list 
	 * @param Element This is the generic type being added to the integer of sequence array list
	 */
	public void Add(T Element){
		ListIterator <T> Iter = List.listIterator(); 
		while(Iter.hasNext()){
			Iter.next();
		}
		Iter.add(Element);
	}
	
	/*Purpose: The purpose of this method is to change numbers in the integer array list 
	 * @param Position This is the position of the number that is being changed
	 * @param Element This is the number replacing the current integer in the integer array list
	 */
	public void Change(int Position, T Element){
		ListIterator <T> Iter = List.listIterator(); 
		int Count = 0;
		while(Iter.hasNext() && Count != (Position + 1)){
			Iter.next();
			Count++;
		}
		Iter.set(Element);
	}
	
	/*Purpose: The purpose of this method is to delete numbers in the integer array list 
	 * @param Position This is the position of the number that is being deleted
	 */
	public void Delete(int Position){
		ListIterator <T> Iter = List.listIterator(); 
		int Count = 0;
		while(Iter.hasNext() && Count != (Position + 1)){
			Count++;
			Iter.next();
		}
		Iter.remove();
	}
	
}