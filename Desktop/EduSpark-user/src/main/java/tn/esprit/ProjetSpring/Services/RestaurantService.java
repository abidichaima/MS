package tn.esprit.ProjetSpring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Repositories.RestaurantRepository;

import tn.esprit.ProjetSpring.entities.Restaurant;

import java.util.List;

@Service
@AllArgsConstructor

public class RestaurantService implements IRestaurantService{
    RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant getRestaurantById(long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        Restaurant re=restaurantRepository.findById(restaurant.getIdRestaurant()).orElse(null);
        if (re!=null)
            restaurantRepository.save(restaurant);
        return  re;
    }

    @Override
    public void deleteRestaurant(long id) {
        restaurantRepository.deleteById(id);

    }
}
