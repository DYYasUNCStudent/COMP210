package assn06;

public interface SelfBalancingBST<T extends Comparable<T>> {

    /**
     * @return true if the tree is empty
     */
    boolean isEmpty();

    /**
     * @return height of the tree.
     */
    int height();
    
    /**
     * @return the number of elements in the tree
     */
    int size();

    /**
     * Inserts element into the tree and returns resulting
     * tree (i.e. root) after insertion. Depending on implementation,
     * this may or may not be the same object that you started with.
     * @param element to be added to the tree
     * @return resulting tree after insertion
     **/
    SelfBalancingBST<T> insert(T element);

    /**
     * Removes element from tree and returns resulting
     * tree after removal. Depending on implementation,
     * this may or may not be the same object that you
     * started with. If element is not in the tree, the
     * tree should remain unchanged and return itself.
     * @param element to be removed from the tree
     * @return resulting tree after removal
     **/
    SelfBalancingBST<T> remove(T element);

    /**
     * Throws a RuntimeException if called on an empty tree.
     * @return the smallest value in the tree
     */
    T findMin();

    /**
     * Throws a RuntimeException if called on an empty tree.
     * @return the max value in the tree.
     */
    T findMax();

    /**
     * @param element whose presence in this tree is to be tested
     * @return true if this tree contains the specified element
     */
    boolean contains(T element);


    /**
     * Tests whether this tree contains any elements within the specified range,
     * from start to end inclusive.
     * @param start the starting element of the range to check.
     * @param end the ending element of the range to check.
     * @return true if this tree contains one or more elements within the specified range,
     * including the start and end elements; false otherwise
     */
    boolean rangeContain(T start, T end);

    /**
     * @return value at the top of the tree.
     * If a tree is empty, its value is null.
     */
    T getValue();

    /**
     * @return the left child of the tree.
     * Throws a RuntimeException if the tree is empty.
     */
    SelfBalancingBST<T> getLeft();

    /**
     * @return the right child of the tree.
     * Throws a RuntimeException if the tree is empty.
     */
    SelfBalancingBST<T> getRight();

}
