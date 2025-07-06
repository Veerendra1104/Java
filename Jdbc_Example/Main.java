package Jdbc.CRUD_JDBC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDemo dbuser1 = new UserDemo();
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        while (again){
            System.out.println("Enter the choice");
            System.out.println("Enter 1: View all \n 2 : Insert \n 3 : Update USer \n 4 : Delete user");
            int choice = sc.nextInt();
            if(choice==1){
                dbuser1.fetchData();
            } else if (choice == 2) {
                System.out.println("Enter the name");
                String name = sc.next();

                System.out.println("Enter the password");
                String  pass = sc.next();
                dbuser1.insertData(name, pass);
            } else if (choice == 3) {
                System.out.println("Enter the id");
                int id = sc.nextInt();

                System.out.println("Enter the password");
                String  pass = sc.next();
                dbuser1.UpdateData(id, pass);
            } else if (choice == 4) {
                System.out.println("Enter the id");
                int id = sc.nextInt();
                dbuser1.deleteUserById(id);

            }else {
                System.out.println("Enter the correct choice");
            }

            System.out.println("Dou want to repeat if yes press true or \n press false");
            again = sc.nextBoolean();
        }

    }
}
