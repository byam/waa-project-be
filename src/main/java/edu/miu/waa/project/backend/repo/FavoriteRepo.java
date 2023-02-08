package edu.miu.waa.project.backend.repo;

import edu.miu.waa.project.backend.domain.FavoriteProperty;
import edu.miu.waa.project.backend.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FavoriteRepo extends CrudRepository<FavoriteProperty, Long>  {
    void deleteFavoritesById(long userid, long propertyId);
    List<FavoriteProperty> listFaviriots(User user);
    @Query("SELECT property.id FROM FavoriteProperty WHERE user.id=:userid")
    List<Long> findfavoritsByUserId (long userid);





}
