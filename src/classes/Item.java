package classes;

/**
 * This is a  simple Item to be used to push into a Heap
 * @author mosea3@bfh.ch
 *
 * @param <E>
 */
public class Item<E> {
	/**
	 * key
	 */
	public int key;
	/**
	 * element
	 */
	public E element;
	
	/**
	 * simple constructor
	 * @param key key to be used
	 * @param element generic Element
	 */
	public Item(int key, E element){
		this.key = key;
		this.element = element;
	}
}
