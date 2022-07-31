// --== CS400 Project One File Header ==--
// Name: Dong Won Nam
// Email: dnam9@wisc.edu
// Team: red
// Group: AD
// TA: Ilay
// Lecturer: Gary Dahl
// Notes to Grader: N/A

import java.util.NoSuchElementException;

public class HashtableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

  private int capacity; // Current capacity of the Hashtable
  private int size; // Current number of objects in the Hashtable
  private HashNode<KeyType, ValueType>[] mainArray;

  // Constructor
  @SuppressWarnings("unchecked")
  public HashtableMap(int capacity) {
    this.capacity = capacity;
    size = 0;
    mainArray = new HashNode[capacity];
    for (int i = 0; i < mainArray.length; i++) {
      mainArray[i] = null;
    }
  }

  // Constructor
  @SuppressWarnings("unchecked")
  public HashtableMap() {
    capacity = 20;
    size = 0;
    mainArray = new HashNode[capacity];
    for (int i = 0; i < mainArray.length; i++) {
      mainArray[i] = null;
    }
  }

  /*
   * If load factor >= 80%, then double capacity and rehash
   * 
   */
  @SuppressWarnings("unchecked")
  private void grow() {
    int oldCapacity = capacity;
    capacity = capacity * 2;

    HashNode<KeyType, ValueType>[] newArray = new HashNode[capacity];
    HashNode<KeyType, ValueType> currNode;

    // Rehashing
    for (int i = 0; i < oldCapacity; i++) {
      currNode = mainArray[i];
      while (currNode != null) {
        currNode.setHashCode(capacity);
        if (newArray[currNode.getHashCode()] == null) {
          newArray[currNode.getHashCode()] = currNode;
        }
        currNode = currNode.getNext();
      }
    }

    this.mainArray = newArray;
  }

  @Override
  public boolean put(KeyType key, ValueType value) {

    // Check load factor
    if ((double) size / capacity >= 0.8)
      this.grow();

    // Check if key is null
    if (key == null) {
      return false;
    }

    // Check if key has a duplicate
    {
      HashNode<KeyType, ValueType> currNode = mainArray[key.hashCode() % capacity];

      while (currNode != null) {
        if (currNode.getKeyType() == key) {
          return false;
        }
        currNode = currNode.getNext();
      }
    }

    // Put the object
    {
      HashNode<KeyType, ValueType> newNode = new HashNode<KeyType, ValueType>(key, value);
      newNode.setHashCode(capacity);
      int newIndex = newNode.getHashCode();
      HashNode<KeyType, ValueType> currNode = mainArray[newIndex];
      if (currNode == null) {
        mainArray[newIndex] = newNode;
      }

      else if (!currNode.hasNext()) {
        currNode.setNext(newNode);
      }

      else {
        currNode = currNode.getNext();
        while (currNode != null) {
          if (currNode.getNext() == null) {
            currNode.setNext(newNode);
            break;
          }
          currNode = currNode.getNext();
        }
      }
    }

    size++;

    // Check load factor again
    if ((double) size / capacity >= 0.8) {
      this.grow();
    }
    return true;
  }

  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    for (int i = 0; i < capacity; i++) {
      HashNode<KeyType, ValueType> currNode = mainArray[i];
      if (currNode == null) {
        continue;
      }
      do {
        if (currNode.getKeyType().equals(key)) {
          return currNode.getValueType();
        }

        else {
          currNode = currNode.getNext();
        }
      } while (currNode != null);
    }

    throw new NoSuchElementException();
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public boolean containsKey(KeyType key) {
    if ((key.hashCode() % capacity) > mainArray.length - 1 || (key.hashCode() % capacity) < 0) {
      return false;
    }
    
    HashNode<KeyType, ValueType> currNode = mainArray[key.hashCode() % capacity];
    
    if (currNode == null) {
      return false;
    }


    if (currNode.getKeyType().equals(key)) {
      return true;
    }

    currNode = currNode.getNext();
    while (currNode != null) {
      if (currNode.getKeyType().equals(key)) {
        return true;
      }
    }

    return false;
  }

  @Override
  public ValueType remove(KeyType key) {
    if (key == null) {
      return null;
    }
    HashNode<KeyType, ValueType> currNode = mainArray[key.hashCode() % capacity];
    if (currNode.getKeyType().equals(key)) {
      mainArray[key.hashCode() % capacity] = currNode.getNext();
      size--;
      return currNode.getValueType();
    }

    currNode = currNode.getNext();
    while (currNode != null) {
      if (currNode.getKeyType().equals(key)) {
        mainArray[key.hashCode() % capacity] = currNode.getNext();
        size--;
        return currNode.getValueType();
      }
      currNode = currNode.getNext();
    }

    return null;


    /*
     * for (int i = 0; i < mainArray.length; i++) { HashNode<KeyType, ValueType> currNode =
     * mainArray[i]; if (currNode != null && !currNode.hasNext()) { mainArray[i] = null; }
     * 
     * do { if (currNode == null) { break; } if (currNode.getKeyType().equals(key)) {
     * currNode.setNext(currNode.getNext().getNext());
     * 
     * return (ValueType) currNode.getValueType(); } } while (currNode.hasNext()); } return null;
     */
  }

  @SuppressWarnings("unchecked")
  @Override
  public void clear() {
    this.mainArray = new HashNode[capacity];
    this.size = 0;

  }

}
