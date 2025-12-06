package Linked_List_Examples;

public class Doubly_Linked_List {
    Dnode root;//only data member we have

    //insert_left:Research new element to the left of the current Dnode.
    void insert_left(int data) {
        Dnode n = new Dnode(data);//created Dnode
        if (root == null)//no root
            root = n;//1st becomes root
        else {
            n.right = root;//1
            root.left = n;//2
            root = n;//3
        }
    }

    void insert_right(int data) {
        Dnode n = new Dnode(data);//created Dnode
        if (root == null)//no root
            root = n;//1st becomes root
        else {
            Dnode t = root;//1
            while (t.right != null)//2
                t = t.right;
            t.right = n;//3 connected
            n.left = t;//4
        }
    }

    void delete_left() {
        if (root == null)//no root
            System.out.println("List is empty");
        else {
            Dnode t = root;//1
            root = root.right;//2
            if (root != null)
                root.left = null;//3
            System.out.println("Deleted:" + t.data);//3 response message of deletion
        }
    }

    void delete_right() {
        if (root == null)//no root
            System.out.println("List is empty");
        else {
            Dnode t, t2;
            t = root;//1
            while (t.right != null)//
                t = t.right;

            if (t == root)//single Dnode
                root = null;//manual deletion
            else {
                t2 = t.left;//3 move back
                t2.right = null;//4 break link
            }
            System.out.println("Deleted:" + t.data);//3 response message of deletion
        }
    }


    void print_list() {
        if (root == null)//no root
            System.out.println("List is empty");
        else {
            Dnode t = root;//1
            while (t != null) {
                System.out.print("<-| " + t.data + " |->");
                t = t.right;
            }
        }
    }


    void print_list_rev() {
        if (root == null)//no root
            System.out.println("List is empty");
        else {
            Dnode t = root;//1
            while (t.right != null)
                       t = t.right;
            while(t!=null)
            {
                System.out.print("<-| " + t.data + " |->");
                t=t.left;
            }
        }
    }
}
