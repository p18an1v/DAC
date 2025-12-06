package Linked_List_Examples;

import java.util.LinkedList;
import java.util.Scanner;
public class Linked_List_Class
{
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LinkedList Operations Menu =====");
            System.out.println("1. Add at End");
            System.out.println("2. Add at Beginning");
            System.out.println("3. Remove First");
            System.out.println("4. Remove Last");
            System.out.println("5. Display List");
            System.out.println("6. Get Element by Index");
            System.out.println("7. Check if List Contains Element");
            System.out.println("8. List Size");
            System.out.println("9. Clear List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int ch;
            try {
                ch = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input, fam. Try again.");
                sc.nextLine();
                continue;
            }

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    list.add(sc.nextInt());
                    System.out.println("Added at end.");
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    list.addFirst(sc.nextInt());
                    System.out.println("Added at beginning.");
                    break;

                case 3:
                    if (!list.isEmpty()) {
                        System.out.println("Removed: " + list.removeFirst());
                    } else {
                        System.out.println("List is empty.");
                    }
                    break;

                case 4:
                    if (!list.isEmpty()) {
                        System.out.println("Removed: " + list.removeLast());
                    } else {
                        System.out.println("List is empty.");
                    }
                    break;

                case 5:
                    System.out.println("LinkedList: " + list);
                    break;

                case 6:
                    System.out.print("Enter index: ");
                    int idx = sc.nextInt();
                    if (idx >= 0 && idx < list.size()) {
                        System.out.println("Element: " + list.get(idx));
                    } else {
                        System.out.println("Index out of range.");
                    }
                    break;

                case 7:
                    System.out.print("Enter element to check: ");
                    int val = sc.nextInt();
                    System.out.println("Contains? " + list.contains(val));
                    break;

                case 8:
                    System.out.println("Size: " + list.size());
                    break;

                case 9:
                    list.clear();
                    System.out.println("List cleared.");
                    break;

                case 0:
                    System.out.println("Exiting program. Bye!");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

