package nem.kulturservice.controllers;

import nem.kulturservice.models.Band;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import nem.kulturservice.services.IBandService;

@RestController
public class BandController {

    private IBandService bandService;

    public BandController(IBandService bandService){
        this.bandService = bandService;
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

}
