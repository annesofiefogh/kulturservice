package nem.kulturservice.controllers;

import nem.kulturservice.models.Band;
import nem.kulturservice.models.User;
import nem.kulturservice.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nem.kulturservice.services.IBandService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class BandController {

    private IBandService bandService;
    private IUserService userService;

    public BandController(IBandService bandService, IUserService userService){
        this.bandService = bandService;
        this.userService = userService;
    }

    @GetMapping("/getAllBands")
    public ResponseEntity<Set<Band>> getAllBands(){
        return new ResponseEntity<>(bandService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/createBand")
    public ResponseEntity<String> createBand(@RequestBody Band band){
        String message = "";
        if(bandService.save(band) != null){
            message = "Band " + band.getName();
        } else {
            message = "Error creating " + band.getName();
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/findBandByName")
    public ResponseEntity<List<Band>> findBandByName(String name){
        return new ResponseEntity<>(bandService.findBandByName(name), HttpStatus.OK);
    }

    //Virker ikke endnu
    @PutMapping("/editBand")
    public ResponseEntity<Set<Band>> editBand(Long bandID, Band band){
        Optional<Band> band_ = bandService.findById(bandID);
        if(band_.isPresent()){
            bandService.save(band);
            return new ResponseEntity<>(bandService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    //Virker ikke endnu
    @DeleteMapping("/deleteBand")
    public ResponseEntity<Set<Band>> deleteBand(Band band){
        bandService.delete(band);
        return new ResponseEntity<>(bandService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/createLikeForBand")
    public ResponseEntity<String> createLike(@RequestParam Long userID, @RequestParam Long bandID){
        Optional<User> user_ = userService.findById(userID);
        Optional<Band> band_ = bandService.findById(bandID);
        if (user_.isPresent() && band_.isPresent()){
            user_.get().getBandsLiked().add(band_.get()); //saving band in the user object
            User newLike = userService.save(user_.get());
            String userLikedBand = newLike.getName();
            return new ResponseEntity<>("Ok at gemme brugeren: " + userLikedBand + " med et like til bandet med id'et: " + bandID + " i band_like tabellen", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Fejl i oprettelsen af like", HttpStatus.BAD_REQUEST);
        }
    }
}
