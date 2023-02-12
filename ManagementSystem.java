import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ManagementSystem {
    private ArrayList<AdminAccount> adminAccountList;
    private ArrayList<Rental> rentalList;
    private ArrayList<UserAccount> userAccountList;
    private ArrayList<Book> bookList;

    public ManagementSystem() {
        adminAccountList = new ArrayList<AdminAccount>();
        rentalList = new ArrayList<Rental>();
        userAccountList = new ArrayList<UserAccount>();
        bookList = new ArrayList<Book>();
    }

    public static void main(String[] args) {
        // dummy data to test the application
        AdminAccount admin = new AdminAccount((int) (Math.random() * 100), "admin", "admin", "admin");

        Book actionBook = new Book(
                (int) (Math.random() * 100),
                "book1",
                "this book is about action",
                "action",
                1.0
        );
        Book romanceBook = new Book(
                (int) (Math.random() * 100),
                "book2",
                "this book is about romance",
                "romance",
                2.0
        );
        Book horrorBook = new Book(
                (int) (Math.random() * 100),
                "book3",
                "this book is about horror",
                "horror",
                3.0
        );

        UserAccount user1 = new UserAccount(1, "aung nyan", "paing", "01/02/2023");
        UserAccount user2 = new UserAccount(2, "ryan", "clone", "06/02/2023");
        UserAccount user3 = new UserAccount(3, "rose", "smith", "04/012/2022");
        user1.addGenre("action");
        user2.addGenre("romance");
        user3.addGenre("horror");

        Rental rental1 = new Rental(1, "01/02/2023", user1);
        Rental rental2 = new Rental(2, "01/02/2023", user1);
        user1.addRental(rental1);
        Rental rental3 = new Rental(3, "01/02/2023", user2);
        user2.addRental(rental3);
        Rental rental4 = new Rental(4, "01/04/2023", user3);
        user3.addRental(rental4);


        ManagementSystem library = new ManagementSystem();
        library.adminAccountList.add(admin);

        library.bookList.add(actionBook);
        library.bookList.add(romanceBook);
        library.bookList.add(horrorBook);

        library.userAccountList.add(user1);
        library.userAccountList.add(user2);
        library.userAccountList.add(user3);

        library.rentalList.add(rental1);
        library.rentalList.add(rental2);
        library.rentalList.add(rental3);
        library.rentalList.add(rental4);

        library.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("1. Admin Account Sign In");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> run = signIn();
                case 6 -> {
                    System.out.println("Thank you for using the application!");
                    run = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private boolean signIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        for (AdminAccount admin : adminAccountList) {
            if (
                    admin.getAdminUsername().equals(username) &&
                            admin.getAdminPassword().equals(password)
            ) {
                boolean run = true;
                while (run) {
                    System.out.println("2. Admin Account");
                    System.out.println("3. Books");
                    System.out.println("4. User Accounts");
                    System.out.println("5. List all user rental records");
                    System.out.println("6. Top users that rent most books");
                    System.out.println("7. Show books matching user genre preference");
                    System.out.println("8. Sign out");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 2 -> manageAdminAccount();
                        case 3 -> manageBooks();
                        case 4 -> manageUserAccounts();
                        case 5 -> showAllRentalRecords();
                        case 6 -> showTopUsersThatRentMostBooks();
                        case 7 -> showBooksMatchingUserGenrePreference();
                        case 8 -> {
                            System.out.println("Signing out...");
                            run = false;
                        }
                        default -> System.out.println("Invalid choice. Please try again.");
                    }
                }
                return true;
            }
        }
        System.out.println("Invalid username or password. Please try again.");
        return true;
    }

    private void manageAdminAccount() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("1. Add admin account");
            System.out.println("2. Delete admin account");
            System.out.println("3. Show all admin accounts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addAdminAccount();
                case 2 -> deleteAdminAccount();
                case 3 -> showAllAdminAccounts();
                case 4 -> {
                    System.out.println("Exiting...");
                    run = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addAdminAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter adminName: ");
        String adminName = scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        int randomId = (int) (Math.random() * 1000);
        AdminAccount admin = new AdminAccount(
                randomId,
                adminName,
                username,
                password
        );
        adminAccountList.add(admin);
        System.out.println("Admin account added successfully.");
    }

    private void deleteAdminAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        for (AdminAccount admin : adminAccountList) {
            if (admin.getAdminUsername().equals(username)) {
                adminAccountList.remove(admin);
                System.out.println("Admin account deleted successfully.");
                return;
            }
        }
        System.out.println("Admin account not found.");
    }

    private void showAllAdminAccounts() {
        for (AdminAccount admin : adminAccountList) {
            System.out.println(admin.getAdminUsername());
        }
    }

    private void manageBooks() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("1. Add book");
            System.out.println("2. Delete book");
            System.out.println("3. Show all books");
            System.out.println("4. Show most expensive books");
            System.out.println("5. Show cheapest books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> deleteBook();
                case 3 -> showAllBooks();
                case 4 -> mostExpensiveBooks();
                case 5 -> leastExpensiveBooks();
                case 6 -> {
                    System.out.println("Exiting...");
                    run = false;
                    scanner.nextLine();
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBook() {
        Scanner scanner = new Scanner(System.in);
        int bookID = (int) (Math.random() * 1000);
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter book description: ");
        String bookDescription = scanner.nextLine();
        System.out.print("Enter book genre: ");
        String bookGenre = scanner.nextLine();
        System.out.print("Enter book price: ");
        double price = scanner.nextDouble();
        Book book = new Book(bookID, bookName, bookDescription, bookGenre, price);
        bookList.add(book);
        System.out.println("Book added successfully.");
    }

    private void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getBookName().equals(bookName)) {
                bookList.remove(book);
                System.out.println("Book deleted successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void showAllBooks() {
        for (Book book : bookList) {
            System.out.println(book.getBookName() + "(" + book.getBookGenre() + ")");
        }
    }

    private void mostExpensiveBooks() {
        double maxPrice = 0;
        for (Book book : bookList) {
            if (book.getBookRentalPrice() > maxPrice) {
                maxPrice = book.getBookRentalPrice();
            }
        }
        for (Book book : bookList) {
            if (book.getBookRentalPrice() == maxPrice) {
                System.out.println(book.getBookName() + "(" + book.getBookRentalPrice() + ")");
            }
        }
    }

    private void leastExpensiveBooks() {
        double minPrice = 10;
        for (Book book : bookList) {
            if (book.getBookRentalPrice() < minPrice) {
                minPrice = book.getBookRentalPrice();
            }
        }
        for (Book book : bookList) {
            if (book.getBookRentalPrice() == minPrice) {
                System.out.println(book.getBookName() + "(" + book.getBookRentalPrice() + ")");
            }
        }
    }

    private void manageUserAccounts() {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("1. Add user account");
            System.out.println("2. Delete user account");
            System.out.println("3. Show all user accounts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addUserAccount();
                case 2 -> deleteUserAccount();
                case 3 -> showAllUserAccounts();
                case 4 -> {
                    System.out.println("Exiting...");
                    run = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addUserAccount() {
        Scanner scanner = new Scanner(System.in);
        int id = (int) (Math.random() * 1000);
        System.out.print("Enter firstName: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter lastName: ");
        String lastName = scanner.nextLine();
        String createdDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        UserAccount user = new UserAccount(id, firstName, lastName, createdDate);
        userAccountList.add(user);
        System.out.println("User account added successfully.");
    }

    private void deleteUserAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter lastName: ");
        String lastName = scanner.nextLine();
        for (UserAccount user : userAccountList) {
            if (user.getLastName().equals(lastName)) {
                userAccountList.remove(user);
                System.out.println("User account deleted successfully.");
                return;
            }
        }
        System.out.println("User account not found.");
    }

    private void showTopUsersThatRentMostBooks() {
        int max = 0;
        for (UserAccount user : userAccountList) {
            if (user.getRentalList().size() > max) {
                max = user.getRentalList().size();
            }
        }
        for (UserAccount user : userAccountList) {
            if (user.getRentalList().size() == max) {
                System.out.println(user.getFirstName() + " " + user.getLastName());
            }
        }
    }

    private void showBooksMatchingUserGenrePreference() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user's last name: ");
        String lastName = scanner.nextLine();
        for (UserAccount user : userAccountList) {
            if (user.getLastName().equals(lastName)) {
                for (Book book : bookList) {
                    if (user.getGenrePreferences().contains(book.getBookGenre())) {
                        System.out.println(user.getFirstName() + " " + user.getLastName() + "(" + book.getBookName() + ")");
                    }
                }
                return;
            }
        }
        System.out.println("User not found.");
    }

    private void showAllRentalRecords() {
        for (Rental record : rentalList) {
            System.out.println(record.getRentalUserAccount().getFirstName()
                    + " " + record.getRentalUserAccount().getLastName()
                    + " " + record.getRentalDate());
        }
    }

    private void showAllUserAccounts() {
        for (UserAccount user : userAccountList) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
    }
}
