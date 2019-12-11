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

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
