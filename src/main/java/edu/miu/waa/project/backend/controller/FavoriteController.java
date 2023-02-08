package edu.miu.waa.project.backend.controller;

import edu.miu.waa.project.backend.domain.dto.PropertyDto;
import edu.miu.waa.project.backend.service.FavoritesService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequestMapping("api/v1/favorites")
@CrossOrigin(origins ="http://localhost:3000" )
public class FavoriteController {
    private final FavoritesService favoritesService;

    @PostMapping("/Favorite/{Id}")
    public void save(long propertyId){
        favoritesService.save(propertyId);
    }
    @GetMapping("/Favorite/")
    public List<PropertyDto> listOfAllFavorites(){
        return  favoritesService.listOfAllFavorites();
    }
    @DeleteMapping("/Favorite/{id}")
    public void deleteFavoriteById(@PathVariable long Id, @PathVariable String id){
        favoritesService.deleteFavoriteById(Id);
    }
    @DeleteMapping()
    public void deleteAll(){
        favoritesService.deleteAll();
    }
    @GetMapping
    public List<Long> findfavoritsIds(){

        return favoritesService.findfavoritsIds() ;
    }

}
