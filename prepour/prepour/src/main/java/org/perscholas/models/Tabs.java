package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "name", nullable = false)
    String customerName;
    @NotBlank @Column(columnDefinition = "INT(11) UNSIGNED" , name = "subtotal", nullable = false)
    int subtotal;
    @NotBlank
    final double taxRate = .07;
    @NotBlank
    double total;

    @ToString.Exclude
    @OneToMany (mappedBy = "tabItems", fetch = FetchType.LAZY)
    List<Items> tabItems;

}
