package assn06;

public class Main {
    public static void main(String[] args) {

        // Create a new empty tree.
        SelfBalancingBST<Integer> avl_bst = new AVLTree<Integer>();

        // Insert 50 random integers.
        // Note how we need to capture the result of insert back into
        // the variable avl_bst because the post-insertion root that is
        // returned may be different from the original root because of the insertion.
        // resulting height should be about 6.

        for (int i=0; i<50; i++) {
            avl_bst = avl_bst.insert((int) (Math.random()*100));
        }
        System.out.println(avl_bst.height());
        System.out.println(avl_bst.size());

        SelfBalancingBST<Integer> avl_bst2 = new AVLTree<Integer>();
        // Now insert 50 integers in increasing order which would
        // cause a simple BST to become very tall but for our
        // self-balancing tree won't be too bad (should be 5)

        for (int i=0; i<50; i++) {
            avl_bst2 = avl_bst2.insert(i);
        }
        System.out.println(avl_bst2.height());
        System.out.println(avl_bst2.size());

        SelfBalancingBST<Integer> avl_bst3 = new AVLTree<Integer>();
        avl_bst3 = avl_bst3.insert(47);
        avl_bst3 = avl_bst3.insert(52);
        avl_bst3 = avl_bst3.insert(60);
        avl_bst3 = avl_bst3.insert(3);
        avl_bst3 = avl_bst3.insert(7);
        avl_bst3 = avl_bst3.insert(10);
        avl_bst3 = avl_bst3.insert(58);
        System.out.println(avl_bst3.height());
        System.out.println(avl_bst3.size());
        System.out.println(avl_bst3.rangeContain(10,46));
        System.out.println(avl_bst3.rangeContain(4,6));
        System.out.println(avl_bst3.rangeContain(4,7));
    }
}
