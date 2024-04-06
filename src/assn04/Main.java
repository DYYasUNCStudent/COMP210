package assn04;

public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values to it.
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new NonEmptyBST<Integer>(0);
      bst = bst.insert(1);
      bst = bst.insert(2);
      bst = bst.insert(3);
      bst = bst.insert(4);
      bst = bst.insert(5);
      bst = bst.insert(6);
      bst = bst.remove(3);
      bst = bst.remove_range(2, 5);
      bst.printPostOrderTraversal();
      bst.printPreOrderTraversal();
  }
}
