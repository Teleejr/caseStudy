package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @FieldDefaults(level = AccessLevel.PRIVATE)
public class Items implements Serializable {
    private static final long serialVersionUID = 4368725404173225311L;

    //Fields
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED", name = "id", nullable = false)
    Long itemId;
    @NotBlank @Column(columnDefinition = "VARCHAR(50)", name = "name", nullable = false)
    String name;
    @NotBlank @Column(columnDefinition = "INT(11) UNSIGNED", name = "price", nullable = false)
    int price;

    @ToString.Exclude @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tab")
    Tabs tabItems;
}
