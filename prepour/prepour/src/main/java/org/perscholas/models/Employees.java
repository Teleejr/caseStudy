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
public class Employees implements Serializable {
    private static final long serialVersionUID = 1734664307552724710L;

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED", name = "customerId", nullable = false)
    Long employeeId;
    @NotBlank
    @Column(columnDefinition = "VARCHAR(50)", name = "username", nullable = false)
    String username;
    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "email", nullable = false)
    String email;
    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "phone", nullable = false)
    String phone;
    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "password", nullable = false)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Must contain at least 8 characters\n" +
            "At least 1 upper case letter\n" +
            "At least 1 lower case letter\n" +
            "At least 1 number\n" +
            "At least 1 special character")
    String password;

    public Employees(String username, String email, String phone, String password) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
