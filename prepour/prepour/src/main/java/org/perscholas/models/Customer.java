package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Entity @FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer implements Serializable {

    private static final long serialVersionUID = 2460832464129743819L;
    //Fields
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED", name = "customerId", nullable = false)
    Long customerId;
    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "username", nullable = false)
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

    @ToString.Exclude @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tab")
    Tabs customerTab;

}
