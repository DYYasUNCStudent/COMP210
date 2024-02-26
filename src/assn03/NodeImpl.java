package assn03;


public class NodeImpl<T> implements Node<T> {

    private T _value;
    private Node<T> _next;

    public NodeImpl(T value, Node<T> next) {
        _value = value;
        _next = next;
    }

    @Override
    public T getValue() {
        return _value;
    }

    @Override
    public void setValue(T value) {
        _value = value;
    }

    @Override
    public Node<T> getNext() {
        return _next;
    }

    @Override
    public void setNext(Node<T> next) {
        _next = next;
    }
}
