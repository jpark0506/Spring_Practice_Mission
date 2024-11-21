package javalab.umc7th_mission.repository;

import javalab.umc7th_mission.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
