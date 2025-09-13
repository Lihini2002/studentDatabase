import java.util.InputMismatchException;
import java.util.Scanner;

public class Mainapplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                sc.nextLine(); // consume invalid input
                continue; // back to menu
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = 0;
                    try {
                        age = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid age! Please enter a number.");
                        sc.nextLine();
                        break;
                    }
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    dao.addStudent(name, age, email);
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int id = 0;
                    try {
                        id = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid ID! Please enter a number.");
                        sc.nextLine();
                        break;
                    }
                    System.out.print("Enter New Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter New Age: ");
                    try {
                        age = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid age! Please enter a number.");
                        sc.nextLine();
                        break;
                    }
                    System.out.print("Enter New Email: ");
                    email = sc.nextLine();
                    dao.updateStudent(id, name, age, email);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    try {
                        id = sc.nextInt();
                        sc.nextLine();
                        dao.deleteStudent(id);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid ID! Please enter a number.");
                        sc.nextLine();
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
    }
}
