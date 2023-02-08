package edu.miu.waa.project.backend.service.impl;

import edu.miu.waa.project.backend.domain.FavoriteProperty;
import edu.miu.waa.project.backend.domain.User;
import edu.miu.waa.project.backend.domain.dto.PropertyDto;
import edu.miu.waa.project.backend.repo.FavoriteRepo;
import edu.miu.waa.project.backend.service.FavoritesService;
import edu.miu.waa.project.backend.service.PropertyService;
import edu.miu.waa.project.backend.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FavoritesImpl implements FavoritesService {
    private final FavoriteRepo favoritesRepo;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final PropertyService  propertyService;
    private final FavoriteProperty favoritesProperty;


    @Override
    public void save(long propertyId) {
       long userid = userService.getLoggedInUser().getId();
        favoritesRepo.save(FavoriteProperty.builder().propertyId(propertyId).userid(userid).build());
    }

    @Override
    public List<PropertyDto> listOfAllFavorites() {
        long userid = userService.getLoggedInUser().getId();
        User user = new User();
        user.setId(userid);
        return  favoritesRepo.listFaviriots(user).
                stream().
                filter((Property) ->{return !propertyService.isPropertyUNAVAILABLE(Property.getPropertyId());

               }).map(savedProperty -> modelMapper.map(favoritesProperty.getProperty(), PropertyDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public void deleteFavoriteById(long PropertyId) {
        long userid = userService.getLoggedInUser().getId();
        favoritesRepo.deleteFavoritesById(userid,PropertyId);
    }

    @Override
    public void deleteAll() {
        long userid = userService.getLoggedInUser().getId();
        favoritesRepo.deleteAllById(Collections.singleton(userid));
    }


    @Override
    public List<Long> findfavoritsIds() {
        long userid = userService.getLoggedInUser().getId();
        return favoritesRepo.findfavoritsByUserId(userid);
    }
}
