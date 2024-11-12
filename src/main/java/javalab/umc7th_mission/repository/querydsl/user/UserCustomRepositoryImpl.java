package javalab.umc7th_mission.repository.querydsl.user;


import static ext.javalab.umc7th_mission.domain.QUser.user;
import static ext.javalab.umc7th_mission.domain.QPoint.point1;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository{

    private final JPAQueryFactory queryFactory;

    //Mission 2-4에 대응
    @Override
    public JPAQuery<Tuple> findUserPointById(Integer userId) {
        return queryFactory
            .select(user.id, user.name, user.nickname, user.email, user.phoneNumber, point1.point)
            .from(user)
            .join(user, point1.user)
            .where(user.id.eq(userId).and(user.phoneNumber.isNotNull()))
            .orderBy(point1.id.asc())
            .limit(1);
    }

}
