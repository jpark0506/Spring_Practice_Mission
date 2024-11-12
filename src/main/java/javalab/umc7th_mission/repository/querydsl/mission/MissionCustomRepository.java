package javalab.umc7th_mission.repository.querydsl.mission;

import com.querydsl.core.Tuple;
import java.util.List;

public interface MissionCustomRepository {

    public List<Tuple> findMissionsByRegionAndDueDate(Integer regionId, int limit, int offset);
    public List<Tuple> findMissionsByUserAndStatus(Integer userId, int limit, int offset);
}
