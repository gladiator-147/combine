import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class BST {

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data) root.left = insert(root.left, val);
        else if (val > root.data) root.right = insert(root.right, val);
        return root;
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    static boolean search(Node root, int key) {
        if (root == null) return false;
        if (key == root.data) return true;
        if (key < root.data) return search(root.left, key);
        else return search(root.right, key);
    }

    static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static Node findMin(Node root) {
        while (root != null && root.left != null)
            root = root.left;
        return root;
    }

    static Node deleteNode(Node root, int key) {
        if (root == null) return null;
        if (key < root.data) root.left = deleteNode(root.left, key);
        else if (key > root.data) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            Node temp = findMin(root.right);
            root.data = temp.data;
            root.right = deleteNode(root.right, temp.data);
        }
        return root;
    }

    static void mirror(Node root) {
        if (root == null) return;
        mirror(root.left);
        mirror(root.right);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;

        System.out.println("Enter space-separated integers to insert into BST (-1 to stop):");
        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            if (val == -1) break;
            root = insert(root, val);
        }

        System.out.print("\nInorder Traversal: ");
        inorder(root);

        System.out.print("\nLevel Order Traversal: ");
        levelOrder(root);

        System.out.println("\nHeight of the Tree: " + height(root));

        System.out.print("\nEnter value to search: ");
        int key = sc.nextInt();
        System.out.println(search(root, key) ? "Found." : "Not Found.");

        System.out.print("\nEnter value to delete: ");
        key = sc.nextInt();
        root = deleteNode(root, key);

        System.out.print("After Deletion - Level Order: ");
        levelOrder(root);

        mirror(root);
        System.out.print("\nAfter Mirroring - Inorder Traversal: ");
        inorder(root);

        System.out.println();
        sc.close();
    }
}
