package Linked_List_Examples;

public class Circular_Linked_List
{
    Node root,last;//only data member we have

    //insert_left:Research new element to the left of the current node.
    void insert_left(int data) {
        Node n = new Node(data);//created node
        if (root == null)//no root
        {
            root = last=n;//1st becomes root
            last.next=root;
        }
        else {
            n.next = root;//1
            root = n;//2
            last.next=root;//3
        }
    }

    void insert_right(int data) {
        Node n = new Node(data);//created node
        if (root == null)//no root
        {
            root = last=n;//1st becomes root
            last.next=root;
        }
        else {
                last.next=n;//1
                last=n;//2
                last.next=root;//3
        }
    }

    void delete_left() {
        if (root == null)//no root
            System.out.println("List is empty");
        else {
            Node t = root;//1
            if (root == last)//single node
                root = last = null;//manual deletion
            else {
                root = root.next;//2
                last.next = root;//3
            }
                System.out.println("Deleted:" + t.data);//3 response message of deletion
            }
    }

    void delete_right() {
        if (root == null)//no root
            System.out.println("List is empty");
        else {
            Node t, t2;
            t = t2 = root;//1
            if(root==last)
                root=last=null;
            else
            {
                while (t != last)//2
                {
                    t2 = t;
                    t = t.next;
                }
                last=t2;//3
                last.next=root;//4
            }
            System.out.println("Deleted:" + t.data);//3 response message of deletion
        }
    }



    void print_list() {
        if (root == null)//no root
            System.out.println("List is empty");
        else {
            Node t = root;//1
            do{
                System.out.print("| " + t.data + " |->");
                t = t.next;
            }while (t != root);
        }
    }

}
