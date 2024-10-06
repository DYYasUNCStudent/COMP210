package assn07;

public class Account <K,V> {
    private K _website;
    private V _password;
    private Account _next;

    public Account(K website, V password) {
        _website = website;
        _password = password;
        _next = null;
    }

    public K getWebsite() {
        return _website;
    }

    public void setWebsite(K website) {
        this._website = website;
    }

    public V getPassword() {
        return _password;
    }

    public void setPassword(V password) {
        this._password = password;
    }

    public Account getNext() {
        return _next;
    }

    public void setNext(Account next) {
        _next = next;
    }

}
