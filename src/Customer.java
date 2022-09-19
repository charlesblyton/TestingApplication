public class Customer {
    private String givenName;
    private String surname;
    private String email;
    private int noOfGuests;

    public Customer(String givenName, String surname, String email, int noOfGuests) {
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
        this.noOfGuests = noOfGuests;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNoOfGuests() {
        return noOfGuests;
    }

    public void setNoOfGuests(int noOfGuests) {
        this.noOfGuests = noOfGuests;
    }
}
