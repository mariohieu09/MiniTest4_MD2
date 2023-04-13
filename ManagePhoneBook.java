import java.util.Scanner;

public class ManagePhoneBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneBookManage apps = new PhoneBookManage();
        while (true){
            System.out.println("Choose: \n1.Display \n2.Insert new Phone \n3.Remove Phone \n4.Update Phone \n5.Search Phone \n6.Sort the list \n0.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Choose: \n1.Display the List \n2.Display the contact ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    if(n == 1) {
                        apps.display();
                    }else{
                        System.out.println("Enter id: ");
                        int display_id = sc.nextInt();
                        System.out.println("Enter Type name: ");
                        String typeName = sc.nextLine();
                        apps.display(new Type(display_id, typeName));
                    }
                    break;
                case 2:
                    System.out.println("Enter contact name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter contact phone number: ");
                    String phone = sc.nextLine();
                    apps.insertPhone(name, phone);
                    break;
                case 3:
                    System.out.println("Enter contact name: ");
                    apps.removePhone(sc.nextLine());
                    break;
                case 4:
                    System.out.println("Enter contact name: ");
                    String updateName = sc.nextLine();
                    System.out.println("Enter new number: ");
                    String updateNum = sc.nextLine();
                    apps.updatePhone(updateName, updateNum);
                    break;
                case 5:
                    System.out.println("Enter contact name: ");
                    apps.searchPhone(sc.nextLine());
                    break;
                case 6:
                    apps.sort();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
