package edu.miu.waa.project.backend.domain;

import edu.miu.waa.project.backend.enumSet.OfferStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String message;

    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;

    private Double price;

    @OneToOne
    private User user;

    @ManyToOne
    private Property property;


}
