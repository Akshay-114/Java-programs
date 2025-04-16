import java.util.*;

public class LinkedList {
    Node head;

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
        public void insertAtBegin(int data){
            Node newnode = new Node(data);
            newnode.next = head;
            head = newnode;
        }

        public void insertAtEnd(int data){
            Node newnode = new Node(data);
            if(head==null){
                head=newnode;
                return;
            }
            Node temp = head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;
        }

        public void insertAtMid(int data,int position){
            if(position<1){
                System.out.println("Invalid position.");
                return;
            }
            Node newnode = new Node(data);
            if (position == 1) {
                newnode.next = head;
                head = newnode;
                return;
            }
            Node temp = head;
            for(int i=1;temp!=null && i<position-1;i++){
                temp=temp.next;
            }
            if(temp==null){
                System.out.println("Position out of range.");
                return;
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }

        public void deleteAtBegin(){
            if(head==null){
                System.out.println("List is Empty");
                return;
            }
            head=head.next;
        }

        public void deleteAtMid(int pos){
            if(pos<1 || head==null){
                System.out.println("Invalid position or empty list");
                return;
            }
            if(pos==1){
                head=head.next;
                return;
            }
            Node temp = head;
            for(int i=1;temp!=null && i<pos-1;i++){
                temp=temp.next;
            }
            if(temp==null || temp.next==null){
                System.out.println("Out of range.");
                return;
            }
            temp.next=temp.next.next;
        }

        public void deleteAtEnd(){
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node temp = head;
        while(temp.next!=null && temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
        }

        public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " -> ");
            temp=temp.next;
        }
            System.out.println("null");
        }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList l = new LinkedList();
        while(true){
        System.out.println("************************************************");
        System.out.println("Choose any option:");
        System.out.println("1.Insert at Beginning");
        System.out.println("2.Insert at Middle");
        System.out.println("3.Insert at End");
        System.out.println("4.Delete at Beginning");
        System.out.println("5.Delete at Middle");
        System.out.println("6.Delete at End");
        System.out.println("7.Exit");
        System.out.println("************************************************");

        int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter element to insert at beginning:");
                    int i = sc.nextInt();
                    l.insertAtBegin(i);
                    l.display();
                    break;

                case 2:
                    System.out.println("Enter element to insert at middle:");
                    int j = sc.nextInt();
                    System.out.println("Enter position where to insert:");
                    int p = sc.nextInt();
                    l.insertAtMid(j,p);
                    l.display();
                    break;

                case 3:
                    System.out.println("Enter element to insert at end:");
                    int k = sc.nextInt();
                    l.insertAtEnd(k);
                    l.display();
                    break;

                case 4:
                    System.out.println("Deleting element at beginning...");
                    l.deleteAtBegin();
                    l.display();
                    break;

                case 5:
                    System.out.println("Enter position where to delete:");
                    int x = sc.nextInt();
                    System.out.println("Deleting element at middle...");
                    l.deleteAtMid(x);
                    l.display();
                    break;

                case 6:
                    System.out.println("Deleting element at end...");
                    l.deleteAtEnd();
                    l.display();
                    break;

                case 7:
                    System.exit(0);
                default:
                    System.out.println("Enter valid option");
            }
        }
    }
}
