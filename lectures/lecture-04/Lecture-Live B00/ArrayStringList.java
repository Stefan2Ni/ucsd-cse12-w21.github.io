public class ArrayStringList implements StringList {

  String[] elements;
  int size;				// How many elements are in the list?

  // How will we construct it?
  public ArrayStringList() {
	  this.elements = new String[2];	// Capacity of 2
	  this.size = 0;					// Number of elements added
  }

  public ArrayStringList(int capacity) {
	  this.elements = new String[capacity];
	  this.size = 0;
  }

  // How will it implement the methods?
  public void add(String s) {
	  expandCapacity();
	  this.elements[this.size] = s;
	  this.size += 1;
  }
  
  public void insert(int index, String s) {
	  expandCapacity();
	  for (int i = size - 1; i >= index; i--) {
		  //i --> (i+1)
		  elements[i+1] = elements[i];
	  }
	  //put s into location index
	  elements[index] = s;
	  //don't forget to increase size
	  size++;
  
  }  
  
  public void remove(int index) {
	  //shift elements
	  for (int i = index; i <= size - 2; i++ ) {
		  //from i + 1 to i
		  elements[i] = elements[i+1];
	  }
	  elements[size-1] = null;
	  //don't forget to decrease size
	  size--;
	  

  }
  
  public String get(int index) {
	  return this.elements[index];
  }
  
  public int size() {
	  return this.size;
  }
  
  private void expandCapacity() {
	  int currentCapacity = this.elements.length;
	  if(this.size < currentCapacity) { return; }

	  String[] expanded = new String[currentCapacity * 2];

	  for(int i = 0; i < this.size; i += 1) {
		  expanded[i] = this.elements[i];
	  }

	  this.elements = expanded;
  }
  
  public void foo(){
      String[] tmp = elements;
      add("a");
      add("b");
      add("c");
      expandCapacity();
      System.out.println(tmp == elements);
  }
  public static void main(String[] args){
      ArrayStringList ref = new ArrayStringList();
      ref.foo();
  }
}
