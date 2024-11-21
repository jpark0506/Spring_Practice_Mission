package javalab.umc7th_mission.repository;

import javalab.umc7th_mission.domain.mapping.UserFoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFoodCategoryRepository extends JpaRepository<UserFoodCategory, Integer> {

}
