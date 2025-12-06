package Linked_List_Examples;
import java.util.Scanner;
public class Linked_List_Main {

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int ch=0;
        Linear_Linked_List list = new Linear_Linked_List();

        do {
            System.out.println("\n======== LINKED LIST MENU ========");
            System.out.println("1. Insert Left");
            System.out.println("2. Insert Right");
            System.out.println("3. Delete Left");
            System.out.println("4. Delete Right");
            System.out.println("5. Print List");
            System.out.println("6. Search Element");
            System.out.println("7. Delete Element");
            System.out.println("8. Insert After");
            System.out.println("9. Sort List");
            System.out.println("0. Exit");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {

                case 1:
                    System.out.print("Enter data to insert left: ");
                    list.insert_left(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter data to insert right: ");
                    list.insert_right(sc.nextInt());
                    break;

                case 3:
                    list.delete_left();
                    break;

                case 4:
                    list.delete_right();
                    break;

                case 5:
                    list.print_list();
                    break;

                case 6:
                    System.out.print("Enter element to search: ");
                    list.search_list(sc.nextInt());
                    break;

                case 7:
                    System.out.print("Enter element to delete: ");
                    list.delete_element(sc.nextInt());
                    break;

                case 8:
                    System.out.print("Enter key after which to insert: ");
                    int key = sc.nextInt();
                    System.out.print("Enter data to insert: ");
                    int data = sc.nextInt();
                    list.insert_after(key, data);
                    break;

                case 9:
                    list.sort_list();
                    break;

                case 0:
                    System.out.println("Exiting .. coded by amar.career👋");
                    return;

                default:
                    System.out.println("invalid choice. Please select from the menu.");
            }
        }while(ch!=0);
    }
}
