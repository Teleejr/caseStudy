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
    Long oId;

    //Id for the actual order being requested
    Long oOrderId;

    int oQuantity;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY) @JoinColumn
    Customer oCustomer;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    Items oItems;

    public Orders(Items oItems) {
        this.oItems = oItems;
    }

}
