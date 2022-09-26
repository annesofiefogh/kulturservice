package nem.kulturservice.controllers;

import nem.kulturservice.models.Event;
import nem.kulturservice.models.Review;
import nem.kulturservice.models.User;
import nem.kulturservice.services.IEventService;
import nem.kulturservice.services.IReviewService;
import nem.kulturservice.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class ReviewController {

    private IReviewService reviewService;
    private IEventService eventService;
    private IUserService userService;

    public ReviewController(IReviewService reviewService, IEventService eventService, IUserService userService){
        this.reviewService = reviewService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping("/getAllReviews")
    public ResponseEntity<Set<Review>> getReviews(){
        return new ResponseEntity<>(reviewService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/createReview")
    public ResponseEntity<String> addReview(@RequestBody Review review, @RequestParam Long eid, @RequestParam Long uid){
        Optional<Event> event_ = eventService.findById(eid);
        Optional<User> user_ = userService.findById(uid);
        if(event_.isPresent() && user_.isPresent()){
            review.setEvent(event_.get());
            review.setUser(user_.get());
            reviewService.save(review);
            return new ResponseEntity<>("Review created", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to create review", HttpStatus.OK);
        }
    }
    @GetMapping("/getReview")
    public ResponseEntity<Set<Review>> getReviewForEvent (@RequestBody Event event){
        Optional<Event> event_ = eventService.findById(event.getId());
        if(event_.isPresent()){
            return new ResponseEntity<>(event.getReviews(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }


}
