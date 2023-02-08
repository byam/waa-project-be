package edu.miu.waa.project.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(FavioritePK.class)

public class FavoriteProperty {
        @Id
        @Column(name = "customer_id")
        private long userid;

        @Id
        @Column(name = "property_id")
        private long propertyId;

        @ManyToOne
        @JoinColumn(name = "customer_id", insertable = false, updatable = false)
        private User user;

        @ManyToOne
        @JoinColumn(name = "property_id", insertable = false, updatable = false)
        private Property property;
}
