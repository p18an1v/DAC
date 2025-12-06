package Tree_Examples;

public class Dnode
{
    int data;
    Dnode left,right;//self-ref pointer/reference
    Dnode(int data)
    {
        this.data=data;
        this.left=this.right=null;// not ref anyone
    }
}
