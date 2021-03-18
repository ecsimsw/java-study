package javaPracticing;

import java.util.LinkedList;

class HashTable {

    class Node {
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] table;

    public HashTable(int size) {
        table = new LinkedList[size];
    }

    Long getHashCode(String key) {
        Long hashCode = 0L;

        for (char c : key.toCharArray()) {
            hashCode += (long) c;
        }

        return hashCode;
    }

    public int getIndex(Long hashCode) {
        return (int) (hashCode % table.length);
    }

    Node searchNode(int index, String key) {
        LinkedList<Node> indexedList = table[index];

        for (Node n : indexedList) {
            if (n.key == key) {
                return n;
            }
        }

        return null;
    }

    public void put(String key, String value) {
        Long hashCode = getHashCode(key);
        int index = getIndex(hashCode);

        if (table[index] == null) {
            table[index] = new LinkedList<Node>();
            table[index].add(new Node(key, value));
        } else {
            Node searched = searchNode(index, key);

            if (searched != null) {
                searched.value = value;
            } else {
                table[index].add(new Node(key, value));
            }
        }
    }

    public String get(String key) {
        Long hashCode = getHashCode(key);
        int index = getIndex(hashCode);

        Node searched = searchNode(index, key);

        if (searched == null) {
            return "";
        } else {
            return searched.value;
        }
    }
}

class 해시테이블구현해보기 {
    public static void main(String[] args) {
        HashTable myHashTable = new HashTable(4);

        myHashTable.put("jinhwan", "A-Group");
        myHashTable.put("jinhwan", "B-Group");
        myHashTable.put("yeongpyo", "B-Group");
        myHashTable.put("jisoo", "C-Group");
        myHashTable.put("sangho", "C-Group");


        System.out.println(myHashTable.get("jinhwan"));
        System.out.println(myHashTable.get("jisoo"));
        System.out.println(myHashTable.get("ecsimsw"));
        System.out.println(myHashTable.get("sangho"));


        myHashTable.put("kim","C-Group");
        myHashTable.put("mik","D-Group");
        myHashTable.put("ikm","A-Group");

        System.out.println(myHashTable.get("kim"));
        System.out.println(myHashTable.get("mik"));
        System.out.println(myHashTable.get("ikm"));
    }
}



