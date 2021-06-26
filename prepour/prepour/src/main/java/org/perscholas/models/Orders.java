package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

////Use JsonIgnoreProperties so the class name will be excluded make it possible to conform to exact JSON format:
//@JsonIgnoreProperties(ignoreUnknown = true)

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @FieldDefaults(level = AccessLevel.PRIVATE)
public class Orders implements Serializable {

    private static final long serialVersionUID = 6399217378552505377L;
    //Fields
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED", name = "id", nullable = false)
    Long tabId;
    /*@NotNull @Column(columnDefinition = "DECIMAL (16,2)UNSIGNED" , name = "subtotal", nullable = false)
    float subtotal;

    final double TAXRATE = 0.07D;
    @NotNull
    double total;
    *///Add a date column

    @ToString.Exclude
    @OneToOne(mappedBy = "customerTab", fetch = FetchType.LAZY)
    Customer cTab;

    @ToString.Exclude
    @OneToMany (mappedBy = "tabItems", fetch = FetchType.LAZY)
    List<Items> tabItems;

    public Orders(List<Items> tabItems) {
        this.tabItems = tabItems;
    }

    //Parses the javascript object to be transformed into a list
    public List<Items> getTab() {
        return tabItems;
    }

    //Sets the javascript object to be parsed into a list
    public void setTab(List<Items> tabItems) {
        this.tabItems = tabItems;

    }
}
