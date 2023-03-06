package com.example.supermarketstore.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "supermarket")
@Data

public class Supermarket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "item_id_supermarket_fk"))
//    private Store store;
    @Column(name = "item_name")
    private String itemName;

    @Column(name = "date_received")
    private Date dateReceived;

    @Column(name = "price")
    private Double price;

}
