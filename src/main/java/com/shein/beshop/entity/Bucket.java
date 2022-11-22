package com.shein.beshop.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "buckets")
public class Bucket {
    private final static String SEQ_NAME = "bucket_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(sequenceName = SEQ_NAME, name = SEQ_NAME, allocationSize = 1)
    private Long id;
//////////////////////////////////

//    @JoinColumn(name = "user_id")
    @OneToOne(mappedBy = "id")
    private User user;
 ////////////////////////////////////////////////

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "buckets_products",
            joinColumns = @JoinColumn(name = "bucket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product>products;
}

