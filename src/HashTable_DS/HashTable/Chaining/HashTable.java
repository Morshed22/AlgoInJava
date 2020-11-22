package Chaining;

public class HashTable {
    private HashItem[] hashTable;

    public HashTable() {
        hashTable = new HashItem[Constants.TABLE_SIZE];
    }

    public int get(int key){
        int hashIndex = hash(key);
        if(hashTable[hashIndex] == null) return -1;
        HashItem hashItem = hashTable[hashIndex];
        while (hashItem != null && hashItem.getKey() != key){
            hashItem = hashItem.getNextHashItem();
        }
        return  hashItem == null ? -1 : hashItem.getValue();
    }

    public void put(int key, int value){
        int hashArrayIndex = hash(key);

        if( hashTable[hashArrayIndex] == null ) {
            System.out.println("No collision simple insertion...");
            hashTable[hashArrayIndex] = new HashItem(key, value);
        } else {

            System.out.println("Collision when inserting with key "+key);
            HashItem hashItem = hashTable[hashArrayIndex];

            while( hashItem.getNextHashItem() != null )  {
                hashItem = hashItem.getNextHashItem();
                System.out.println("Considering the next item in linked list "+hashItem.getValue());
            }

            System.out.println("Finally we have found the place to insert...");
            hashItem.setNextHashItem(new HashItem(key, value));
        }
    }

    private int hash(int key){
        return key % Constants.TABLE_SIZE;
    }
}
