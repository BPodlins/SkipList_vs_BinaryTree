import java.util.Random;

public class SkipList {
    private Node head;
    private Node tail;

    private final int NEG_INFINITY = Integer.MIN_VALUE;
    private final int POS_INFINITY = Integer.MAX_VALUE;
    int numberOfJumps = 0;
    int numberOfchecks = 0;

    //ilosc pieter w liscie
    private int floors = 0;

    //losowanie czy wybieram
    public Random random = new Random();

    public SkipList(){
        head = new Node(NEG_INFINITY);
        tail = new Node(POS_INFINITY);
        head.next = tail;
        tail.prev = head;
    }

    public Node search(int key) {
        Node n = head;
        while (n.below != null){ //dopoki nie jestesmy na dole
            n = n.below;
            numberOfJumps++;
            numberOfchecks++;
            while (key >= n.next.key) { //dopoki nie jestesmy skrajnie na prawo
                n = n.next;
                numberOfJumps++;
                numberOfchecks++;
            }
        }
        return n; //dalej sie nie da
    }

    public Node insert(int key){
        Node position = search(key);
        Node n;

        int floor = -1;
        int numberOfHeads = -1;

        if (position.key == key){
            return position;
        }

        do {
            numberOfHeads++;
            floor++;

            canIncreaseFloor(floor);

            n = position;

            while (position.above == null){
                position = position.prev;
            }

            position = position.above;

            n = insertAbove(position, n, key);

        } while (random.nextBoolean());

        return n;
    }

    public Node remove(int key){
        Node nodeToBeRemoved = search(key);

        if(nodeToBeRemoved.key != key){
            return null;
        }

        removeReferences(nodeToBeRemoved);

        while (nodeToBeRemoved != null){
            removeReferences(nodeToBeRemoved);

            if (nodeToBeRemoved.above != null)
                nodeToBeRemoved = nodeToBeRemoved.above;
            else
                break;
        }

        return nodeToBeRemoved;
    }

    private void removeReferences(Node nodeRemove){
        Node afterNodeRemoved = nodeRemove.next;
        Node beforeNodeRemoved = nodeRemove.prev;

        beforeNodeRemoved.next = afterNodeRemoved;
        afterNodeRemoved.prev = beforeNodeRemoved;
    }

    private void canIncreaseFloor(int floor) {
        if(floor >= floors){
            floors++;
            addFloor();
        }
    }

    private void addFloor(){
        Node newHeadNode = new Node(NEG_INFINITY);
        Node newTailNode = new Node(POS_INFINITY);

        newHeadNode.next = newTailNode;
        newHeadNode.below = head;
        newTailNode.prev = newHeadNode;
        newTailNode.below = tail;

        head.above = newHeadNode;
        tail.above = newTailNode;

        head = newHeadNode;
        tail = newTailNode;
    }

    private Node insertAbove(Node position, Node n, int key) {
        Node newNode = new Node(key);
        Node nodeBeforeNewNode = position.below.below;

        setBeforeAndAfterRef(n, newNode);
        setAboveAndBelowRef(position, key, newNode, nodeBeforeNewNode);

        return newNode;
    }

    private void setBeforeAndAfterRef(Node n, Node newNode){
        newNode.next = n.next;
        newNode.prev = n;
        n.next.prev = newNode;
        n.next = newNode;
    }

    private void setAboveAndBelowRef(Node position, int key, Node newNode, Node nodeBeforeNewNode) {
        if (nodeBeforeNewNode != null) {
            while (true) {
                if (nodeBeforeNewNode.next.key != key)
                    nodeBeforeNewNode = nodeBeforeNewNode.next;
                else
                    break;
            }
            newNode.below = nodeBeforeNewNode.next;
            nodeBeforeNewNode.next.above = newNode;
        }

        if (position != null){
            if (position.next.key == key){
                newNode.above = position.next;
            }
        }
    }

    public void printSkipList(){
        StringBuilder sb = new StringBuilder();

        Node starting = head;

        Node highestfloor = starting;
        int floor = floors;

        while (highestfloor != null){

            while (starting!=null) {
                sb.append("\nFloor: " + floor + "\n");

                if (starting.next != null)
                    sb.append(" : ");

                starting = starting.next;
            }
            highestfloor = highestfloor.below;
            starting = highestfloor;
            floor--;
        }

        System.out.println(sb.toString());
    }

}

//klasa odpowiedzialna za przechowywanie danych o indeksach
class Node{
    public Node above;
    public Node below;
    public Node next;
    public Node prev;
    public int key;

    public Node(int key){
        this.key = key;
        this.above = null;
        this.below = null;
        this.next = null;
        this.prev = null;
    }

}
