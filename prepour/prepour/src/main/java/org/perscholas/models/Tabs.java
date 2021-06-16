package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @FieldDefaults(level = AccessLevel.PRIVATE)
public class Tabs implements Serializable {

    private static final long serialVersionUID = 6399217378552505377L;
    //Fields
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED", name = "id", nullable = false)
    Long tabId;
    @NotNull @Column(columnDefinition = "INT(11) UNSIGNED" , name = "subtotal", nullable = false)
    double subtotal;
    @NotNull
    final double taxRate = .07;
    @NotNull
    double total;
    //Add a date column

    @ToString.Exclude
    @OneToOne(mappedBy = "customerTab", fetch = FetchType.LAZY)
    Customer cTab;

    @ToString.Exclude
    @OneToMany (mappedBy = "tabItems", fetch = FetchType.LAZY)
    List<Items> tabItems;

}
