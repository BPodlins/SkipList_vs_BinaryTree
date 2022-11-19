import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SkipList skipList = new SkipList();
        BinaryTree tree = new BinaryTree();

        add1000a(skipList, tree);
        for (int i = 1; i < 1001; i+=10) {
            skipList.search(i);
            tree.search(tree.root, i);
        }

        System.out.println("1000a skiplist numberOfJumps: " +skipList.numberOfJumps +", number of comparisons " +skipList.numberOfchecks +" | tree numberOfJumps: " +tree.numberOfJumps +", number of comparisons: " +tree.numberOfChecks);

        add1000b(skipList, tree);
        for (int i = 1; i < 1001; i+=10) {
            skipList.search(i);
            tree.search(tree.root, i);
        }

        System.out.println("1000b skiplist numberOfJumps: " +skipList.numberOfJumps +", number of comparisons " +skipList.numberOfchecks +" | tree numberOfJumps: " +tree.numberOfJumps +", number of comparisons: " +tree.numberOfChecks);
        add5000a(skipList, tree);
        for (int i = 1; i < 5001; i+=10) {
            skipList.search(i);
            tree.search(tree.root, i);
        }
        System.out.println("5000a skiplist numberOfJumps: " +skipList.numberOfJumps +", number of comparisons " +skipList.numberOfchecks +" | tree numberOfJumps: " +tree.numberOfJumps +", number of comparisons: " +tree.numberOfChecks);

        add5000b(skipList, tree);
        for (int i = 1; i < 5001; i+=10) {
            skipList.search(i);
            tree.search(tree.root, i);
        }
        System.out.println("5000b skiplist numberOfJumps: " +skipList.numberOfJumps +", number of comparisons " +skipList.numberOfchecks +" | tree numberOfJumps: " +tree.numberOfJumps +", number of comparisons: " +tree.numberOfChecks);

        add10000a(skipList, tree);
        for (int i = 1; i < 10001; i+=10) {
            skipList.search(i);
            tree.search(tree.root, i);
        }
        System.out.println("10000a skiplist numberOfJumps: " +skipList.numberOfJumps +", number of comparisons " +skipList.numberOfchecks +" | tree numberOfJumps: " +tree.numberOfJumps +", number of comparisons: " +tree.numberOfChecks);

        add10000b(skipList, tree);
        for (int i = 1; i < 10001; i+=10) {
            skipList.search(i);
            tree.search(tree.root, i);
        }
        System.out.println("10000b skiplist numberOfJumps: " +skipList.numberOfJumps +", number of comparisons " +skipList.numberOfchecks +" | tree numberOfJumps: " +tree.numberOfJumps +", number of comparisons: " +tree.numberOfChecks);
    }

    public static void add1000a(SkipList skipList, BinaryTree BST) throws IOException {
        File file = new File("C:\\Projekty\\SkipList\\src\\1000a.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            skipList.insert(Integer.parseInt(st));
            BST.addNode(Integer.parseInt(st));
        }
    }

    public static void add1000b(SkipList skipList, BinaryTree BST) throws IOException {
        File file = new File("C:\\Projekty\\SkipList\\src\\1000b.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            skipList.insert(Integer.parseInt(st));
            BST.addNode(Integer.parseInt(st));
        }
    }

    public static void add5000a(SkipList skipList, BinaryTree BST) throws IOException {
        File file = new File("C:\\Projekty\\SkipList\\src\\5000a.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            skipList.insert(Integer.parseInt(st));
            BST.addNode(Integer.parseInt(st));
        }
    }

    public static void add5000b(SkipList skipList, BinaryTree BST) throws IOException {
        File file = new File("C:\\Projekty\\SkipList\\src\\5000b.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            skipList.insert(Integer.parseInt(st));
            BST.addNode(Integer.parseInt(st));
        }
    }

    public static void add10000a(SkipList skipList, BinaryTree BST) throws IOException {
        File file = new File("C:\\Projekty\\SkipList\\src\\10000a.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            skipList.insert(Integer.parseInt(st));
            BST.addNode(Integer.parseInt(st));
        }
    }

    public static void add10000b(SkipList skipList, BinaryTree BST) throws IOException {
        File file = new File("C:\\Projekty\\SkipList\\src\\10000b.txt");
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null){
            skipList.insert(Integer.parseInt(st));
            BST.addNode(Integer.parseInt(st));
        }

    }
}
