import java.util.ArrayList;

public class UserAccount {
    private int userId;
    private String firstName;
    private String lastName;
    private String createdDate;
    private ArrayList<String> genrePreferences;
    private ArrayList<Rental> rentalList;

    public UserAccount(int userId, String firstName, String lastName, String createdDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdDate = createdDate;
        this.genrePreferences = new ArrayList<String>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public ArrayList<String> getGenrePreferences() {
        return genrePreferences;
    }

    public void setGenrePreferences(ArrayList<String> genrePreferences) {
        this.genrePreferences = genrePreferences;
    }

    public void addGenre(String genre) {
        genrePreferences.add(genre);
    }

    public void removeGenre(String genre) {
        genrePreferences.remove(genre);
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public ArrayList<Rental> getRentalList() {
        return rentalList;
    }
}
