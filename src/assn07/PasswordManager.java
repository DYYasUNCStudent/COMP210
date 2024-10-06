package assn07;
import java.util.*;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "password321";
    private Account[] _passwords;

    public PasswordManager() {
        _passwords = new Account[50];
    }

    // TODO: put
    @Override
    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % _passwords.length;
        if (_passwords[index] == null){
            _passwords[index] = new Account<>(key, value);
        } else {
            Account<K,V> currentAccount = _passwords[index];
            while (currentAccount.getNext() != null){
                if (currentAccount.getWebsite().equals(key)){
                    currentAccount.setPassword(value);
                    return;
                }
                currentAccount = currentAccount.getNext();
            }
            if (currentAccount.getWebsite().equals(key)){
                currentAccount.setPassword(value);
                return;
            }
            currentAccount.setNext(new Account<>(key, value));
        }
    }

    // TODO: get
    @Override
    public V get(K key) {
        int check = Math.abs(key.hashCode()) % getPasswords().length;
        if (_passwords[check] == null){
            return null;
        } else {
            Account<K,V> currentAccount = _passwords[check];
            while (currentAccount != null){
                if (currentAccount.getWebsite().equals(key)){
                    return currentAccount.getPassword();
                }
                currentAccount = currentAccount.getNext();
            }
        }
        return null;
    }

    // TODO: size
    @Override
    public int size() {
        int size = 0;
        Account<K,V> currentAccount;
        for (int i = 0; i < _passwords.length; i++){
            if (_passwords[i] != null){
                currentAccount = _passwords[i];
                while (currentAccount != null){
                    currentAccount = currentAccount.getNext();
                    size++;
                }
            }
        }
        return size;
    }


    // TODO: keySet
    @Override
    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        Account<K,V> currentAccount;
        for (int i = 0; i < 50; i++){
            if (_passwords[i] != null){
                currentAccount = _passwords[i];
                while (currentAccount != null){
                    keySet.add(currentAccount.getWebsite());
                    currentAccount = currentAccount.getNext();
                }
            }
        }
        return keySet;
    }

    // TODO: remove
    @Override
    public V remove(K key) {
        int index = Math.abs(key.hashCode()) % _passwords.length;
        Account<K,V> currentAccount = _passwords[index];
        Account<K,V> previousAccount = null;

        while (currentAccount != null) {
            if (currentAccount.getWebsite().equals(key)){
                V value = currentAccount.getPassword();
                if (previousAccount == null){
                    _passwords[index] = currentAccount.getNext();
                } else {
                    previousAccount.setNext(currentAccount.getNext());
                }
                return value;
            }
            previousAccount = currentAccount;
            currentAccount = currentAccount.getNext();
        }
        return null;
    }

    // TODO: checkDuplicate
    @Override
    public List<K> checkDuplicate(V value) {
        List<K> duplicates = new ArrayList<>();
        Account<K,V> currentAccount;

        for (int i = 0; i < _passwords.length; i ++){
            if (_passwords[i] != null){
                currentAccount = _passwords[i];
                while (currentAccount != null) {
                    if (currentAccount.getPassword().equals(value)){
                        duplicates.add(currentAccount.getWebsite());
                    }
                    currentAccount = currentAccount.getNext();
                }
            }
        }
        return duplicates;
    }

    // TODO: checkMasterPassword
    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        if (enteredPassword.equals(MASTER_PASSWORD)){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String generatesafeRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        // TODO: Ensure the minimum length is 4
        if (length < 4){
            targetStringLength = 4;
        }

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }
}
