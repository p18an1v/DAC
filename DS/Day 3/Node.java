package Linked_List_Examples;

public class Node
{
    int data;
    Node next;//self-ref pointer/reference
    Node(int data)
    {
        this.data=data;
        this.next=null;// not ref anyone
    }
}