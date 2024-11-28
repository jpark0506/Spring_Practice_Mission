package javalab.umc7th_mission.repository;

import java.util.List;
import javalab.umc7th_mission.domain.Mission;
import javalab.umc7th_mission.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Integer> {

    Page<Mission> findAllByStore(Store store, Pageable pageable);
}
