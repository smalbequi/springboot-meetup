package fr.valtech.meetup.domain.model.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue
    private Long id;

    @Email
    @NotBlank
    @NaturalId
    @Size(max = 125)
    private String email;

    @NotBlank
    @Size(max = 75)
    private String lastName;

    @NotBlank
    @Size(max = 75)
    private String firstName;

    @NotBlank
    @Size(max = 20)
    private String password;

    @Size(max = 20)
    private String role;

    public UserAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (email == null ? 0 : email.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) obj;
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        }
        else if (!email.equals(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("UserAccount [id=").append(id)
                .append(", email=").append(email)
                .append(", lastName=").append(lastName)
                .append(", firstName=").append(firstName)
                .append(", password=").append(password)
                .append(", role=").append(role)
                .append("]")
                .toString();
    }

}
