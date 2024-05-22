package customers;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Customer {
    public enum AccountStatus{ RISK, BAD, OK, GOOD }

    private @Id
    @GeneratedValue Long id;
    private String firstName; //ADD FUNCTIONS FOR NEW FIELDS
    private String lastName;
    private String bio;
    private int age;
    private Boolean isSubscribed;
    private AccountStatus status;

    Customer() {
    }

    Customer(String firstName, String lastName, String bio, int age, Boolean isSubscribed, AccountStatus status) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.age = age;
        this.isSubscribed = isSubscribed;
        this.status = status;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getBio() {
        return this.bio;
    }

    public int getAge(){ return this.age; }

    public Boolean getIsSubscribed(){ return this.isSubscribed; }

    public AccountStatus getStatus(){ return this.status; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setIsSubscribed(Boolean isSubscribed){
        this.isSubscribed = isSubscribed;
    }

    public void setStatus(AccountStatus status){
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Customer))
            return false;
        Customer Customer = (Customer) o;
        return Objects.equals(this.id, Customer.id) && Objects.equals(this.firstName, Customer.firstName)
                && Objects.equals(this.lastName, Customer.lastName) && Objects.equals(this.bio, Customer.bio)
                && Objects.equals(this.age, Customer.age) && Objects.equals(this.isSubscribed, Customer.isSubscribed)
                && Objects.equals(this.status, Customer.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.bio, this.age, this.isSubscribed, this.status);
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName
                + '\'' + ", bio='" + this.bio + '\'' + ", age='" + this.age
                + '\'' + ", isSubscribed='" + this.isSubscribed + '\'' + ", status='" + this.status + '\'' + '}';
    }
}
