package nem.kulturservice.controllers;

import nem.kulturservice.models.User;
import nem.kulturservice.models.Venue;
import nem.kulturservice.services.IUserService;
import nem.kulturservice.services.IVenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class VenueController {

    private IVenueService venueService;
    private IUserService userService;

    public VenueController(IVenueService venueService, IUserService userService){
        this.venueService = venueService;
        this.userService = userService;
    }

    @GetMapping("/getAllVenues")
    public ResponseEntity<Set<Venue>> getVenues(){
        return new ResponseEntity<>(venueService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/createLikeForVenue")
    public ResponseEntity<String> createLike(@RequestParam Long userID, @RequestParam Long venueID){
        Optional<User> user_ = userService.findById(userID);
        Optional<Venue> venue_ = venueService.findById(venueID);
        if (user_.isPresent() && venue_.isPresent()){
            user_.get().getVenuesLiked().add(venue_.get()); //saving venue in the user object
            userService.save(user_.get());
            return new ResponseEntity<>("Ok at gemme user: " + userID + " med like_venue " + venueID, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Fejl i oprettelsen af like", HttpStatus.BAD_REQUEST);
        }
    }
}
