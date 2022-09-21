package nem.kulturservice.controllers;

import nem.kulturservice.models.Band;
import nem.kulturservice.models.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nem.kulturservice.services.IBandService;
import nem.kulturservice.services.IEventService;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@RestController
public class EventController {

    private IEventService eventService;
    private IBandService bandService;

    public EventController(IEventService eventService, IBandService bandService){
        this.eventService = eventService;
        this.bandService = bandService;
    }

    @PostMapping("/createEvent")
    public ResponseEntity<String> createEvent(@RequestBody Event event, @RequestParam Long bandID) {
        Optional<Band> band_ = bandService.findById(bandID);
        if (band_.isPresent()) {
            event.setBand(band_.get());
            event.setDateTime(new Date());
            eventService.save(event);
            return new ResponseEntity<>("OK, event created", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Band not found " + bandID, HttpStatus.OK);
        }
    }

    @GetMapping("getEvents")
    public ResponseEntity<Set<Event>> getEvents(){
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }
}
