package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ProjetSpring.Services.IRestaurantService;
import tn.esprit.ProjetSpring.entities.Restaurant;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestaurantController {
    IRestaurantService restaurantService;


    @PostMapping("/Restaurantadd")
    Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("/Restaurantupdate")
    Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurant);
    }

    @GetMapping("/Restaurant/{id}")
    Restaurant getRestaurantById(@PathVariable long id) {
        return restaurantService.getRestaurantById(id);
    }


    @GetMapping("/Restaurants")
    List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }
    @DeleteMapping("/Restaurant/{id}")
    void deleteRestaurant(@PathVariable long id) {
        restaurantService.deleteRestaurant(id);
    }
}
