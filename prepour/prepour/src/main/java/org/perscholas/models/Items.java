package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Items implements Serializable {
    private static final long serialVersionUID = 4368725404173225311L;

    //Fields
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED", name = "id", nullable = false)
    Long itemId;
    @NotBlank @Column(columnDefinition = "VARCHAR(255)", name = "name", nullable = false)
    String name;
    @NotBlank @Column(columnDefinition = "VARCHAR(255)", name = "type", nullable = false)
    String type;
    @NotNull @Column(columnDefinition = "DECIMAL (16,2)UNSIGNED", name = "abv", nullable = false)
    float abv;
    @NotNull @Column(columnDefinition = "DECIMAL (16,2)UNSIGNED", name = "price", nullable = false)
    float price;
    @NotNull @Column(columnDefinition = "INT(11) UNSIGNED", name = "quantity", nullable = false)
    int quantity;

    @ToString.Exclude @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tab")
    Orders tabItems;

    public Items(String name, String type, float abv, float price, int quantity) {
        this.name = name;
        this.type = type;
        this.abv = abv;
        this.price = price;
        this.quantity = quantity;
    }

    public Items(String name, float price) {
        this.name = name;
        this.price = price;
    }
}
