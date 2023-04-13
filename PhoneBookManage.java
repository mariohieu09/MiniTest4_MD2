import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class PhoneBookManage extends Phone implements IPhone {
   Scanner sc = new Scanner(System.in);
   File book = new File("Book");
  public  void insertPhone(String name, String phone) {
    ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(book);
    Contact p = list.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
    if(p != null){
      System.out.println("Do you want to keep the curren Type? \n1.Yes \n2.No");
      int n = sc.nextInt();
      sc.nextLine();
      if(n == 1){
        p.setPhoneNumber(phone);
      }else {
        System.out.println("Enter new id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new name: ");
        String typeName = sc.nextLine();
        p.setPhoneNumber(phone);
        p.setType(new Type(id, typeName));
      }
    }else{
        System.out.println("Enter new id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new name: ");
        String typeName = sc.nextLine();
        p = new Contact(name, phone, new Type(id, typeName));
        list.add(p);
    }
    WriteFile<Contact> wf = new WriteFile<>();
    wf.WriteFile(list,book);
  }
  public void searchPhone(String name){
    List<Contact> list = new ReadFile<Contact>().ReadFile(new File("Book"));
    Contact p = list.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
    if(p == null){
      System.out.println("Khong ton tai");
    }else{
      System.out.println(p);
    }
  }
  @Override
  public void insertPhone(Contact contact){
    ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(new File("Book"));
    System.out.println("Enter new name: ");
    String name = sc.nextLine();
    contact.setName(name);
    System.out.println("Enter new number ");
    String number = sc.nextLine();
    contact.setPhoneNumber(number);
    System.out.println("Enter new id: ");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter new type name: ");
    String typeName = sc.nextLine();
    contact.setType(new Type(id, typeName));
    list.add(contact);
  }

  @Override
  public void display(Type type) {
      ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(new File("Book"));
      Contact p = list.stream().filter(x -> x.getType().toString().equals(type.toString())).findAny().orElse(null);
      if(p == null){
          System.out.println("Khong ton tai nguoi nay!");
      }else{
          System.out.println(p);
      }
  }
  @Override
  public void sort() {
    ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(new File("Book"));
    list.stream().sorted(Comparator.comparing(Contact::getName));
    WriteFile wf = new WriteFile();
    wf.WriteFile(list, book);
  }
   public void removePhone(String name){
       ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(new File("Book"));
       Contact p = list.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
       if(p != null) {
           list.remove(p);
           System.out.println("Xoa thanh cong");
       }else{
           System.out.println("khong ton tai");
       }
       WriteFile wf = new WriteFile();
       wf.WriteFile(list, book);
   }
   public void updatePhone(String name, String newPhone){
       ArrayList<Contact> list = new ReadFile<Contact>().ReadFile(new File("Book"));
       Contact p = list.stream().filter(x -> x.getName().equals(name)).findAny().orElse(null);
       if(p != null){
           p.setPhoneNumber(newPhone);
           System.out.println("Cap nhat thanh cong");
       }else{
           System.out.println("Khong ton tai");
       }
       WriteFile wf = new WriteFile();
       wf.WriteFile(list, book);
   }

}
