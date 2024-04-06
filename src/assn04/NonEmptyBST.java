package assn04;
import java.util.LinkedList;
import java.util.Queue;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	// TODO: insert
	@Override
	public BST<T> insert(T element){
		if (element.compareTo(this._element) < 0) {
			if (this.getLeft().isEmpty()) {
				this._left = this.getLeft().insert(element); // Utilize the EmptyBST insert method.
			} else {
				this.getLeft().insert(element); // Automatically recursion while not reaching the empty BST.
			}
		}
		else if (element.compareTo(this._element) > 0) { // The right case, the same logic as the left case.
			if (this.getRight().isEmpty()) {
				this._right = this.getRight().insert(element);
			} else {
				this._right.insert(element);
			}
		}
		return this;
	}
	
	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		if (element.compareTo(_element) < 0) {
			_left = getLeft().remove(element);
		} else if (element.compareTo(_element) > 0) {
			_right = getRight().remove(element);
		} else {
			//No children at all
			if (_left.isEmpty() && _right.isEmpty()) {
				return new EmptyBST<T>();
			}
			//One child
			else if (_left.isEmpty()) {
				return _right;
			}
			else if (_right.isEmpty()) {
				return _left;
			}
			//Two children
			else {
				T smallestValue = _right.findMin();
				_element = smallestValue;
				_right = getRight().remove(smallestValue);
			}
		}
		return this;
	}
	
	// TODO: remove all in range (inclusive)
	@Override
	public BST<T> remove_range(T start, T end) {
		if (this.isEmpty()) {
			return this;
		}
		if (start.compareTo(getElement()) < 0) {
			_left = getLeft().remove_range(start, end);
		}
		if (end.compareTo(getElement()) > 0) {
			_right = getRight().remove_range(start, end);
		}
		if (start.compareTo(getElement()) <= 0 && end.compareTo(getElement()) >= 0) {
			return this.remove(getElement());
		}
		return this;
	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		System.out.print(getElement() + " ");
		if (!getLeft().isEmpty()) {
			getLeft().printPreOrderTraversal();
		}
		if (!getRight().isEmpty()) {
			getRight().printPreOrderTraversal();
		}
	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		if (!getLeft().isEmpty()) {
			getLeft().printPostOrderTraversal();
		}
		if (!getRight().isEmpty()) {
			getRight().printPostOrderTraversal();
		}
		System.out.print(getElement() + " ");
	}

	// The findMin method returns the minimum value in the tree.
	@Override
	public T findMin() {
		if(_left.isEmpty()) {
			return _element;
		}
		return _left.findMin();
	}

	@Override
	public int getHeight() {
		   return Math.max(_left.getHeight(), _right.getHeight())+1;
	}

	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
}