import java.util.*;
import java.lang.*;

public class Tree {
    public class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
        public Node root;

        public void binary(Scanner sc) {
            System.out.println("Enter root element: ");
            int data = sc.nextInt();
            root = new Node(data);
            binary(root, sc);
        }

        private void binary(Node node, Scanner sc) {
            System.out.println("Do u wanna add to left of " + node.data + "? [y/n]");
            char left = sc.next().charAt(0);
            if (left == 'y') {
                System.out.println("Enter left element: ");
                int data = sc.nextInt();
                node.left = new Node(data);
                binary(node.left, sc);
            }
            System.out.println("Do u wanna add to right of " + node.data + "? [y/n]");
            char right = sc.next().charAt(0);
            if (right == 'y') {
                System.out.println("Enter right element: ");
                int data = sc.nextInt();
                node.right = new Node(data);
                binary(node.right, sc);
            }
        }

        public void display() {
            display(root, " ");
        }

        private void display(Node root, String space) {
            if (root == null) {
                return;
            }
            System.out.println(root.data + space);
            display(root.left, space + "\t");
            display(root.right, space + "\t");
        }

        void preorder(Node node){
            if(node==null) return;
            System.out.println(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    void inorder(Node node){
        if(node==null) return;
        inorder(node.left);
        System.out.println(node.data + " ");
        inorder(node.right);
    }
    void postorder(Node node){
        if(node==null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.data + " ");
    }
    int height(Node node){
            if(node!=null){
                return 1+Math.max(height(node.left),height(node.right));
            }
            return -1;
    }
    void level(Node node){
        if (node == null) {
            System.out.println("The tree is empty.");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.println(curr.data+" ");
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tree tree = new Tree();
        System.out.println("***** Creating a tree *****");
        tree.binary(sc);
        tree.display();

    while(true){
        System.out.println("************************************************");
        System.out.println("Choose any option:");
        System.out.println("1.Preorder");
        System.out.println("2.Inorder");
        System.out.println("3.Postorder");
        System.out.println("4.Height of the tree");
        System.out.println("5.Level order traversal");
        System.out.println("6.Exit");
        System.out.println("************************************************");

        int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    tree.preorder(tree.root);
                    break;
                case 2:
                    tree.inorder(tree.root);
                    break;
                case 3:
                    tree.postorder(tree.root);
                    break;
                case 4:
                    System.out.println("Height of the tree: " + tree.height(tree.root));
                    break;

                case 5:
                    tree.level(tree.root);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter valid option");
            }
        }
    }
}