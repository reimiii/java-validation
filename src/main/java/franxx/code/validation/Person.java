package franxx.code.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Person {

    private List<@NotBlank(message = "Hobby is not blank") String> hobbies;

    @NotBlank(message = "first name cannot blank")
    @Size(max = 20, message = "first name length size is 20 char")
    private String firstName;

    @NotBlank(message = "last name cannot blank")
    @Size(max = 20, message = "last name length size is 20 char")
    private String lastName;

    @Valid
    @NotNull(message = "Address Cannot be null")
    private Address address;

    @Valid
    public Person() {
    }

    @Valid
    public Person(@NotBlank(message = "firstName blank") String firstName,
                  @NotBlank(message = "lastName blank") String lastName,
                  @NotNull(message = "address is null") @Valid Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }

    public void sayHello(@NotBlank(message = "cannot blank name") String name) {
        System.out.println("Hello " + name + ", my name is.. " + firstName);
    }

    @NotBlank(message = "full name cannot blank")
    public String fullName() {
        return firstName + " " + lastName;
    }
}
