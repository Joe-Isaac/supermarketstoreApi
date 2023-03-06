package com.example.supermarketstore.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "store")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "date_received")
    private Date dateProcured;

    @Column(name = "status")
    private String status;

    @OneToOne
    @JoinColumn( name = "vendor_id", foreignKey = @ForeignKey(name = "vendor_id_store_fk"))
    private Vendor vendor;




}
