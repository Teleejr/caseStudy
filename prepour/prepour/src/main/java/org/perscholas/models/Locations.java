package org.perscholas.models;



import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @FieldDefaults(level = AccessLevel.PRIVATE)
public class Locations implements Serializable {

    private static final long serialVersionUID = -1395968860927514664L;
    //Fields
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED", name = "location", nullable = false)
    Long locationId;
    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "name", nullable = false)
    String name;
    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "address", nullable = false)
    String address;
    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "phone", nullable =false)
    String phone;

    public Locations(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
