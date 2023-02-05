import java.util.ArrayList;

public class Rental {
    private final ArrayList<Book> rentalBookList;
    private int rentalId;
    private String rentalDate;
    private UserAccount rentalUserAccount;

    public Rental(int rentalId, String rentalDate, UserAccount rentalUserAccount) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.rentalUserAccount = rentalUserAccount;
        this.rentalBookList = new ArrayList<>();
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public UserAccount getRentalUserAccount() {
        return rentalUserAccount;
    }

    public void setRentalUserAccount(UserAccount rentalUserAccount) {
        this.rentalUserAccount = rentalUserAccount;
    }

    public ArrayList<Book> getRentalBookList() {
        return rentalBookList;
    }

    public void addBook(Book book) {
        this.rentalBookList.add(book);
    }

    public void removeBook(Book book) {
        this.rentalBookList.remove(book);
    }

    @Override
    public String toString() {
        return "Rental ID: " + rentalId +
                " | Rental Date: " + rentalDate +
                " | User Account: " + rentalUserAccount.getFirstName() +
                " " + rentalUserAccount.getLastName();
    }
}
