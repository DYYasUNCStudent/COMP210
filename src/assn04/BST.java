package assn04;

public interface BST<T extends Comparable<T>> {
 
  /**
   * Inserts element into the tree in the appropriate position.
   * Either returns the mutated tree after insertion or a new tree
   * with the inserted element if necessary.
   *
   * @param element to be added to the tree
   * @return BST<T> after insertion
   **/
  BST<T> insert(T element);

  /**
   * Removes the element from the tree if it is present.
   * Either returns the possibly mutated tree after removal or an empty tree.
   *
   * @param element to be removed from tree
   * @return BST<T> after removal
   */
  BST<T> remove(T element);
  
  /**
   * Removes all elements within the specified range (both inclusive) from the tree.
   *
   * @param start the start of the range
   * @param end the end of the range
   * @return BST<T> after removing elements within the range
   */
  BST<T> remove_range(T start, T end);

  /**
   * Prints the tree in depth first pre order traversal.
   * Print the elements all in one line with a space after each element.
   */
  void printPreOrderTraversal();

  /**
   * Prints the tree in depth first post order traversal.
   * Print the elements all in one line with a space after each element.
   */
  void printPostOrderTraversal();

  // The findMin method should return the minimum value in the tree.
  T findMin();

  int getHeight();

  BST<T> getLeft();

  BST<T> getRight();

  T getElement();
  
  boolean isEmpty();
}
