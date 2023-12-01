package tn.esprit.ProjetSpring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ProjetSpring.Services.IUserService;
import tn.esprit.ProjetSpring.entities.User;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")

@CrossOrigin("*")

public class UserController {
    IUserService userService ;

//des fonctions de control saisie
public boolean hasEightDigits(Long number) {
    return (number >= 10000000L && number <= 99999999L);//La première condition vérifie si "number" est supérieur ou égal à 10^7 (ce qui correspond à un nombre à 8 chiffres ou plus).
    //La deuxième condition vérifie si "number" est inférieur ou égal à 10^8 - 1 (ce qui correspond à un nombre à 8 chiffres ou moins).
}
    @PostMapping("/adduser")
    public ResponseEntity<String> ajouter(@RequestBody User user) {
        System.out.println("Received user data: " + user.toString());

        boolean testMotdepasse = user.getPassword().matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+~`|}{\\[\\]\\\\:;'<>,.?/\\-])[A-Za-z0-9!@#$%^&*()_+~`|}{\\[\\]\\\\:;'<>,.?/\\-]{8,}$");
        boolean test = hasEightDigits(user.getPhone());
        boolean testCin = hasEightDigits(user.getCin());

        if (!test) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le numéro de téléphone doit contenir 8 chiffres");
        } else if (!testCin) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le numéro de CIN doit contenir 8 chiffres");
        } else if (!user.getEmail().matches("^.+@.+\\..+$")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Un problème au niveau de la saisie du mail");
        } else {
            userService.addUser(user);
            return ResponseEntity.status(HttpStatus.OK).body("Ajout réussi");
        }
    }
    @GetMapping
    public List<User> getUsers(){return userService.getAllUsers();}
    @GetMapping("/user/{id}")
    User retrieveUserById (@PathVariable Long id){return userService.getUser(id);}
    @GetMapping("/users")
    List<User> retreiveUsers(){return userService.getAllUsers();}
    @DeleteMapping("/deleteuser/{id}")

    void deleteUser (@PathVariable Long id){
        userService.deleteUser(id);
    }
    @PutMapping("/updateuser")
    public ResponseEntity<String> updateUser( @RequestBody User user) {
        boolean test = hasEightDigits(user.getPhone());
        boolean testCin = hasEightDigits(user.getCin());
        if (!test) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("le numèro de téléphone doit contenir 8 chiffres");
        } else if (!testCin) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("le numèro de CIN doit contenir 8 chiffres");
        }
        else
        {
            userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.OK).body("update done");
        }
    }
    @GetMapping("/user/cin/{cin}")
    public ResponseEntity<User> getUserByCin(@PathVariable long cin) {
        Optional<User> optionalUser = userService.findByCin(cin);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok(optionalUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }

}
    @GetMapping("/checkEmailExists")
    public ResponseEntity<?> checkEmailExists(@RequestParam String email) {
        boolean emailExists = userService.checkEmailExists(email);
        return ResponseEntity.ok(emailExists);
    }

    @GetMapping("/checkCinExists")
    public ResponseEntity<?> checkCinExists(@RequestParam long cin) {
        boolean cinExists = userService.checkCinExists(cin);
        return ResponseEntity.ok(cinExists);
    }

}
