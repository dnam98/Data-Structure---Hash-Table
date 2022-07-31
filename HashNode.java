
public class HashNode<K, V> {
  private K key;
  private V val;
  private int hashVal;
  private HashNode<K, V> next;

  public HashNode(K key, V val) {
    this.key = key;
    this.val = val;
    next = null;
  }

  public int getHashCode() {
    return hashVal;
  }

  public void setHashCode(int capacity) {
    this.hashVal = Math.abs(key.hashCode() % capacity);
  }

  public K getKeyType() {
    return key;
  }

  public V getValueType() {
    return this.val;
  }

  public HashNode<K, V> getNext() {
    return next;
  }

  public boolean hasNext() {
    if (next != null) {
      return true;
    }
    return false;
  }

  public void setNext(HashNode<K, V> next) {
    this.next = next;
  }
}
