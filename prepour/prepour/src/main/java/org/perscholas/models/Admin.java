package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Admin implements Serializable {
    private static final long serialVersionUID = 2744003841305736030L;

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED", name = "customerId", nullable = false)
    Long adminId;

    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "first", nullable = false)
    String firstName;

    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "last", nullable = false)
    String lastName;

    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "username", nullable = false)
    String username;

    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "email", nullable = false)
    String email;

    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "phone", nullable = false)
    String phone;

    @NotBlank @Column(columnDefinition = "VARCHAR(250)", name = "password", nullable = false)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Must contain at least 8 characters\n" +
            "At least 1 upper case letter\n" +
            "At least 1 lower case letter\n" +
            "At least 1 number\n" +
            "At least 1 special character")
    String password;

    public Admin(String firstName, String lastName,String username, String email, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
