package perm.dao;

public class Employer {
    private String name;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    private int postalCode;
    private String phone;
    private int phoneExt;
    private int numOfEmployee;
    private int establishedYear;
    private boolean fwOwnershipInterest;

    public Employer(String name, String address1, String address2, String city, String state, String country, int postalCode, String phone, int phoneExt, int numOfEmployee, int establishedYear, boolean fwOwnershipInterest) {
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.phoneExt = phoneExt;
        this.numOfEmployee = numOfEmployee;
        this.establishedYear = establishedYear;
        this.fwOwnershipInterest = fwOwnershipInterest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPhoneExt() {
        return phoneExt;
    }

    public void setPhoneExt(int phoneExt) {
        this.phoneExt = phoneExt;
    }

    public int getNumOfEmployee() {
        return numOfEmployee;
    }

    public void setNumOfEmployee(int numOfEmployee) {
        this.numOfEmployee = numOfEmployee;
    }

    public int getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(int establishedYear) {
        this.establishedYear = establishedYear;
    }

    public boolean isFwOwnershipInterest() {
        return fwOwnershipInterest;
    }

    public void setFwOwnershipInterest(boolean fwOwnershipInterest) {
        this.fwOwnershipInterest = fwOwnershipInterest;
    }
}
