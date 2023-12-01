package tn.esprit.ProjetSpring.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import tn.esprit.ProjetSpring.Exception.UserAlreadyExistsException;
import tn.esprit.ProjetSpring.Repositories.PasswordResetTokenRepository;
import tn.esprit.ProjetSpring.Repositories.RoleRepository;
import tn.esprit.ProjetSpring.Repositories.UserRepository;
import tn.esprit.ProjetSpring.Repositories.VerificationTokenRepository;
import tn.esprit.ProjetSpring.dto.RegistrationRequest;
import tn.esprit.ProjetSpring.entities.PasswordResetToken;
import tn.esprit.ProjetSpring.entities.Role;
import tn.esprit.ProjetSpring.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import tn.esprit.ProjetSpring.entities.VerificationToken;


import java.util.*;


@Service
@RequiredArgsConstructor
public class UserService implements IUserService{


    @Autowired
    private PasswordEncoder passwordEncoder ;
    @Autowired

    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    private final VerificationTokenRepository tokenRepository;
    private final PasswordResetTokenService passwordResetTokenService;
    PasswordResetTokenRepository passwordResetTokenRepository ;




    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(false);
        Role role = roleRepository.findById(1L).orElseThrow(() -> new RuntimeException("Role not found")); // Remplacez 1L par l'ID du rôle approprié
        user.setRoles(role);
        return userRepository.save(user);
    }

    @Override
    public User getUser(long idUser) {
        return userRepository.findById(idUser).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(long idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public User updateUser(User user) {
        User us = userRepository.findById(user.getIdUser()).orElse(null);
        if (us != null)
            userRepository.save(user);

        return us;

    }

    @Override
    public Optional<User> findByCin(long cin) {
        return userRepository.findByCin(cin);
    }

    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User registerUser(RegistrationRequest request) {
        Optional<User> user = this.findByEmail(request.email());
        if (user.isPresent()){
            throw new UserAlreadyExistsException(
                    "User with email "+request.email() + " already exists");
        }

        // Check if cin already exists
        Optional<User> existingCinUser = userRepository.findByCin(request.cin());
        if (existingCinUser.isPresent()) {
            throw new UserAlreadyExistsException("User with CIN " + request.cin() + " already exists");
        }

        // Check if phone number already exists
        Optional<User> existingPhoneUser = userRepository.findByPhone(request.phone());
        if (existingPhoneUser.isPresent()) {
            throw new UserAlreadyExistsException("User with phone number " + request.phone() + " already exists");
        }

        // Check if any required information is missing
        if (StringUtils.isAnyBlank(
                request.firstName(),
                request.lastName(),
                StringUtils.defaultString(String.valueOf(request.email())),
                StringUtils.defaultString(String.valueOf(request.phone())),
                StringUtils.defaultString(String.valueOf(request.cin())),
                StringUtils.defaultString(request.password()))) {
            throw new IllegalArgumentException("Please provide all required information");
        }
        var newUser = new User();
        newUser.setFirstName(request.firstName());
        newUser.setLastName(request.lastName());
        newUser.setEmail(request.email());
        newUser.setPhone(request.phone());
        newUser.setCin(request.cin());
        Role defaultRole = roleRepository.findByName("etudiant"); // replace with your actual query
        newUser.setRoles(defaultRole);

        newUser.setPassword(passwordEncoder.encode(request.password()));
        return userRepository.save(newUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUserVerificationToken(User theUser, String token) {
        var verificationToken = new VerificationToken(token, theUser);
        tokenRepository.save(verificationToken);
    }
    @Override
    public String validateToken(String theToken) {
        VerificationToken token = tokenRepository.findByToken(theToken);
        if(token == null){
            return "Invalid verification token";
        }
        User user = token.getUser();
        Calendar calendar = Calendar.getInstance();
        if ((token.getExpirationTime().getTime()-calendar.getTime().getTime())<= 0){
            return "Verification link already expired," +
                    " Please, click the link below to receive a new verification link";
        }
        user.setEnabled(true);
        userRepository.save(user);
        return "valid";
    }

    @Override
    public VerificationToken generateNewVerificationToken(String oldToken) {
        VerificationToken verificationToken = tokenRepository.findByToken(oldToken);
        var verificationTokenTime = new VerificationToken();
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationToken.setExpirationTime(verificationTokenTime.getTokenExpirationTime());
        return tokenRepository.save(verificationToken);
    }

    public void changePassword(User theUser, String newPassword) {
        theUser.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(theUser);
    }

    @Override
    public String validatePasswordResetToken(String token) {
        return passwordResetTokenService.validatePasswordResetToken(token);
    }

    @Override
    public User findUserByPasswordToken(String token) {
        return passwordResetTokenService.findUserByPasswordToken(token).get();
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String passwordResetToken) {
        passwordResetTokenService.createPasswordResetTokenForUser(user, passwordResetToken);
    }
    @Override
    public boolean oldPasswordIsValid(User user, String oldPassword){
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    public boolean checkEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean checkCinExists(long cin) {
        return userRepository.existsByCin(cin);
    }


}

