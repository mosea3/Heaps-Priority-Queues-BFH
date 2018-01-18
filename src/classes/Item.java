package classes;

public class Item<E> {
	public int key;
	public E element;
	
	public Item(int key, E element){
		this.key = key;
		this.element = element;
	}
}
