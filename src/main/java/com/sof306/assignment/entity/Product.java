package com.sof306.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Image", nullable = false, length = 50)
    private String image;

    @Column(name = "Price", nullable = false)
    private Double price;

    @Column(name = "Createdate", nullable = false)
    private LocalDate createDate;

    @Column(name = "Available", nullable = false)
    private Integer available;

    @ManyToOne
    @JoinColumn(name = "Categoryid")
    private Category category;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;
}