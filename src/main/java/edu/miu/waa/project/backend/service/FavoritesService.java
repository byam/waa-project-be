package edu.miu.waa.project.backend.service;

import edu.miu.waa.project.backend.domain.dto.PropertyDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesService {


    public void save(long propertyId);
    public List<PropertyDto> listOfAllFavorites();
    public void deleteFavoriteById(long PropertyId);
    public void deleteAll();
    public List<Long> findfavoritsIds();
}
