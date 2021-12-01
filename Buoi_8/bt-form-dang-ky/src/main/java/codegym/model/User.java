package codegym.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class User {
    @NotNull(message = "Khong de trong")
    @Size(min = 5, max = 45, message = "Do dai toi thieu 5, toi da 45 ky tu")
    private String firstName;
    @NotNull(message = "Khong de trong")
    @Size(min = 5, max = 45, message = "Do dai toi thieu 5, toi da 45 ky tu")
    private String lastName;
    @Range(min = 10, max = 11, message = "Do dai tu 10 den 11")
    @Pattern(regexp = "(^$|[0-9]*$)", message = "Chi chua so")
    private String phoneNumber;
    @Min(value = 18, message = "Tuoi lon hon hoac bang 18")
    private Integer age;
    @Email(message = "Nhap sai email")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
