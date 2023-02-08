package edu.miu.waa.project.backend.domain;

import edu.miu.waa.project.backend.enumSet.OfferStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "inquiries")
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String message;

    @OneToOne
    private User user;

    @ManyToOne
    private Property property;
}
