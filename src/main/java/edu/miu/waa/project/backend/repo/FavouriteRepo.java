package edu.miu.waa.project.backend.repo;

import edu.miu.waa.project.backend.domain.FavouriteProperty;
import edu.miu.waa.project.backend.domain.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavouriteRepo extends CrudRepository<FavouriteProperty, Long> {
    @Query("select f.property from FavouriteProperty f join f.customer u where u.id=:userId and f.property.propertyStatus!='UNAVAILABLE'")
    List<Property> findFavouritesByCustomer(@Param("userId") long userId);

    void deleteFavouritePropertyByPropertyIdAndAndCustomerId(long propertyId, long customerId);

}
