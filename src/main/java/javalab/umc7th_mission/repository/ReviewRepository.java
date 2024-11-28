package javalab.umc7th_mission.repository;

import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Page<Review> findAllByUser(User user, Pageable pageable);
}
