public class Customer {
    private String ssn;
    private String name;
    private String address;
    private String telephoneNumber;

    public String getSsn() {
        return ssn;
    }

    @Override
    public String toString() {
        return "Ssn: " + ssn + ", Name: " + name +
                ", Address: " + address + ", Telephone-number: " + telephoneNumber;
    }

    public Customer(String ssn, String name, String address, String telephoneNumber) {
        this.ssn = ssn;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }
}
