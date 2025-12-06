package Tree_Examples;

public class Tree_Class
{
    static Dnode root;//root--->null

     static void insert_node(Dnode r,Dnode n)//root---->r    new node---->n
    {
        if (root == null)//root not init
        {
            root = n;
            System.out.println("\n"+n.data+" inserted");
        }
        else {
            if (n.data < r.data) {
                if (r.left == null) {
                    r.left = n;
                    System.out.println("\n"+n.data+" inserted");
                }
                else
                    insert_node(r.left, n);

            }
            else//right
            {
                if (r.right == null) {
                    r.right = n;
                    System.out.println("\n"+n.data+" inserted");
                }
                else
                    insert_node(r.right, n);
            }
        }
    }
    static void inorder(Dnode r)
    {
        if(r!=null)
        {
            inorder(r.left);	//L
            System.out.print(r.data+",");	//P
            inorder(r.right);//R
        }
    }
    static Dnode get_root()
    {
        return Tree_Class.root;
    }
    public static void main(String[] args) {
        Tree_Class.insert_node(Tree_Class.get_root(),new Dnode(10));
        Tree_Class.insert_node(Tree_Class.get_root(),new Dnode(5));
        Tree_Class.insert_node(Tree_Class.get_root(),new Dnode(20));
        Tree_Class.insert_node(Tree_Class.get_root(),new Dnode(15));
        Tree_Class.inorder(Tree_Class.get_root());
    }
}

