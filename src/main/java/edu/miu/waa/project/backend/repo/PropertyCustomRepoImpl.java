package edu.miu.waa.project.backend.repo;

import edu.miu.waa.project.backend.domain.Property;
import edu.miu.waa.project.backend.domain.dto.request.PropertyFilterRequest;
import edu.miu.waa.project.backend.enumSet.PropertyStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PropertyCustomRepoImpl implements PropertyCustomRepo {

    private final EntityManager entityManager;

    @Override
    public List<Property> findByFilters(PropertyFilterRequest propertyFilterRequest) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> cq = cb.createQuery(Property.class);
        Root<Property> property = cq.from(Property.class);


        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.notEqual(property.get("propertyStatus"), PropertyStatus.UNAVAILABLE));
        predicates.add(cb.notEqual(property.get("propertyStatus"), PropertyStatus.DEAL));


        if (propertyFilterRequest.getPropertyType() != null) {
            predicates.add(cb.equal(property.get("propertyType"), propertyFilterRequest.getPropertyType()));
        }

        if (propertyFilterRequest.getListingType() != null) {
            predicates.add(cb.equal(property.get("listingType"), propertyFilterRequest.getListingType()));
        }

        if (propertyFilterRequest.getMinPrice() != null) {
            predicates.add(cb.greaterThanOrEqualTo(property.get("price"), propertyFilterRequest.getMinPrice()));
        }
        if (propertyFilterRequest.getMaxPrice() != null) {
            predicates.add(cb.lessThanOrEqualTo(property.get("price"), propertyFilterRequest.getMaxPrice()));
        }
        cq.where(cb.and(predicates.toArray(new Predicate[0])));


        TypedQuery<Property> query = entityManager.createQuery(cq);
        return query.getResultList();

    }
}
