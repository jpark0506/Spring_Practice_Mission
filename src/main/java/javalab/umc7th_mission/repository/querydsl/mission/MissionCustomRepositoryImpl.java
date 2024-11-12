package javalab.umc7th_mission.repository.querydsl.mission;

import static ext.javalab.umc7th_mission.domain.QMission.mission;
import static ext.javalab.umc7th_mission.domain.QStore.store;
import static ext.javalab.umc7th_mission.domain.mapping.QUserMission.userMission;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Date;
import java.util.List;
import javalab.umc7th_mission.domain.enums.MissionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MissionCustomRepositoryImpl implements
    MissionCustomRepository {

    private final JPAQueryFactory queryFactory;

    //Mission 2-3에 대응
    @Override
    public List<Tuple> findMissionsByRegionAndDueDate(Integer regionId, int limit, int offset) {
        return queryFactory
            .select(
                store.name,
                store.storeType,
                mission.content,
                mission.points,
                mission.deadline)
            .from(mission)
            .join(mission.store, store)
            .leftJoin(userMission).on(mission.id.eq(userMission.mission.id))
            .where(userMission.user.id.isNull()
                .and(store.region.id.eq(regionId))
                .and(mission.deadline.after(new Date())))
            .orderBy(userMission.startTime.asc(), mission.id.asc(), userMission.user.id.asc())
            .limit(limit)
            .offset(offset)
            .fetch();
    }

    //Mission 2-1에 대응
    @Override
    public List<Tuple> findMissionsByUserAndStatus(Integer userId, int limit, int offset) {
        return queryFactory
            .select(
                store.name.as("store_name"),
                mission.content,
                mission.points,
                userMission.startTime)
            .from(mission)
            .join(mission.store, store)
            .join(userMission).on(mission.id.eq(userMission.mission.id))
            .where(
                userMission.user.id.eq(userId)
                    .and(userMission.missionStatus.in(MissionStatus.PENDING,MissionStatus.COMPLETED))
            )
            .orderBy(userMission.startTime.desc(), mission.id.asc(), userMission.user.id.asc())
            .limit(limit)
            .offset(offset)
            .fetch();
    }


}
