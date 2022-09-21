package nem.kulturservice.services;

import nem.kulturservice.models.Review;
import nem.kulturservice.models.User;
import nem.kulturservice.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ReviewService implements IReviewService{

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Set<Review> findAll() {
        Set<Review> set = new HashSet<>();
        reviewRepository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Review save(Review object) {
        return reviewRepository.save(object);
    }

    @Override
    public void delete(Review object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Review> findById(Long aLong) {
        return reviewRepository.findById(aLong);
    }
}
