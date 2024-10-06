package assn06;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Fields
    private T _value;
    private AVLTree<T> _left;
    private AVLTree<T> _right;
    private int _height;
    private int _size;
    
    public AVLTree() {
        _value = null;
        _left = null;
        _right = null;
        _height = -1;
        _size = 0;
    }

    /**
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */
     private AVLTree<T> rotateLeft() {
         // You should implement left rotation and then use this 
         // method as needed when fixing imbalances.
    	 // TODO
         AVLTree<T> newRoot = _right;
         this._right = newRoot._left;
         this.updateHeightandSize();
         newRoot._left = this;
         newRoot.updateHeightandSize();
         return newRoot;
     }
    
    /**
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */
     private AVLTree<T> rotateRight() {
         // You should implement right rotation and then use this 
         // method as needed when fixing imbalances.
    	 // TODO
         AVLTree<T> newRoot = _left;
         this._left = newRoot._right;
         this.updateHeightandSize();
         newRoot._right = this;
         newRoot.updateHeightandSize();
         return newRoot;
     }

     public void updateHeightandSize() {
         int lSize, rSize, lHeight, rHeight;
         if (_left.isEmpty()){
             lHeight = -1;
         } else {
             lHeight = _left._height;
         }
         if (_right.isEmpty()){
             rHeight = -1;
         } else {
             rHeight = _right._height;
         }
         if (lHeight > rHeight) {
             _height = lHeight + 1;
         } else {
             _height = rHeight + 1;
         }
         if (_left.isEmpty()) {
             lSize = 0;
         } else {
             lSize = _left.size();
         }
         if (_right.isEmpty()) {
             rSize = 0;
         } else {
             rSize = _right.size();
         }
         _size = lSize + rSize + 1;
     }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int height() {
        return _height;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public SelfBalancingBST<T> insert(T element) {
    	// TODO
        AVLTree<T> insertTree = new AVLTree<T>();
        insertTree._value = element;
        if (isEmpty()) {
            _value = element;
            _size = 1;
            _height = 0;
            _right = new AVLTree<>();
            _left = new AVLTree<>();
        }
        if (element.compareTo(this.getValue()) == 0){
            return this;
        }
        if (element.compareTo(this.getValue()) < 0) {
            if (getLeft() != null){
                _left = (AVLTree<T>) getLeft().insert(element);
            } else {
                this._left = new AVLTree<T>();
                this._left._value = element;
                this._left._size = 1;
                this._left._height = 0;
                this._left._left = new AVLTree<>();
                this._left._right = new AVLTree<>();
            }
        } else if (element.compareTo(this.getValue()) > 0) {
            if (getLeft() != null){
                _right = (AVLTree<T>) getRight().insert(element);
            } else {
                this._right = new AVLTree<T>();
                this._right._value = element;
                this._right._size = 1;
                this._right._height = 0;
                this._right._right = new AVLTree<>();
                this._right._left = new AVLTree<>();
            }
        }
        // Update height and size
        this.updateHeightandSize();
        return balance();
    }
    public SelfBalancingBST<T> balance() {
        int BF = this.getLeftHeight() - this.getRightHeight();
        //RR - rotate left
        if (BF < -1 && _right.getRightHeight() >= _right.getLeftHeight()) {
            return this.rotateLeft();
        }
        //LL - rotate right
        if (BF > 1 && _left.getLeftHeight() >= _left.getRightHeight()) {
            return this.rotateRight();
        }
        //RL - rotate right left
        if (BF < -1 && _right.getLeftHeight() > _right.getRightHeight()){
            this._right = this._right.rotateRight();
            return this.rotateLeft();
        }
        //LR - rotate left right
        if (BF > 1 && _left.getRightHeight() > _left.getLeftHeight()){
            this._left = this._left.rotateLeft();
            return this.rotateRight();
        }
        return this;
    }
    @Override
    public SelfBalancingBST<T> remove(T element) {
    	// TODO
        if (isEmpty()) {
            return this;
        }
        if (!contains(element)) {
            return this;
        }
        if (element.compareTo(this.getValue()) < 0 && this._left != null) {
            this._left = (AVLTree<T>) this._left.remove(element);
        } else if (element.compareTo(this.getValue()) > 0 && this._right != null) {
            this._right = (AVLTree<T>) this._right.remove(element);
        } else {
            if (this._left.isEmpty() && this._right.isEmpty()){
                return new AVLTree<>();
            } else if (this._left.isEmpty() || this._right.isEmpty()){
                if (this._left != null){
                    return this._left;
                } else {
                    return this._right;
                }
            } else {
                this._value = this._right.findMin();
                this._right = (AVLTree<T>) this._right.remove(this._value);
            }
        }
        if (this.getValue() != null) {
            this.updateHeightandSize();
            return balance();
        }
        return new AVLTree<>();
    }

    @Override
    public T findMin() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        // TODO
        if (_left.isEmpty()){
            return this.getValue();
        } else {
            return _left.findMin();
        }
    }

    @Override
    public T findMax() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        // TODO
        if (_right.isEmpty()){
            return this.getValue();
        } else {
            return _right.findMax();
        }
    }

    @Override
    public boolean contains(T element) {
    	// TODO
        if (isEmpty()) {
            return false;
        }
        if (this.getValue().compareTo(element) == 0) {
            return true;
        } else if (this.getValue().compareTo(element) > 0){
            if (!this._left.isEmpty()){
                return this._left.contains(element);
            }
        } else {
            if (!this._right.isEmpty()){
                return this._right.contains(element);
            }
        }
        return false;
    }


    @Override
    public boolean rangeContain(T start, T end) {
        // TODO
        if (isEmpty()) {
            return false;
        }
        if (this.getValue().compareTo(start) >= 0 && this.getValue().compareTo(end) <= 0){
            return true;
        } else if (this.getValue().compareTo(start) < 0) {
            if (this._right.isEmpty()){
                return false;
            }
            return _right.rangeContain(start, end);
        } else{
            if (this._left.isEmpty()){
                return false;
            }
            return _left.rangeContain(start, end);
        }
    }

    @Override
    public T getValue() {
        return _value;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        if (isEmpty()) {
            return null;
        }
        return _left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        if (isEmpty()) {
            return null;
        }
         return _right;
    }
    public int getRightHeight() {
        if (_right.isEmpty()){
            return -1;
        } else {
            return _right._height;
        }
    }
    public int getLeftHeight() {
        if (_left.isEmpty()){
            return -1;
        } else {
            return _left._height;
        }
    }
}

