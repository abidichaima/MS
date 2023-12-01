package tn.esprit.ProjetSpring.Services;

import tn.esprit.ProjetSpring.entities.Restaurant;

import java.util.List;

public interface IRestaurantService {
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(long id);
    List<Restaurant> getAllRestaurants();
    Restaurant updateRestaurant(Restaurant restaurant);
    void deleteRestaurant (long id);
}
