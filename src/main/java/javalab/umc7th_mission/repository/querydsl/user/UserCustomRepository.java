package javalab.umc7th_mission.repository.querydsl.user;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;

public interface UserCustomRepository {

    JPAQuery<Tuple> findUserPointById(Integer userId);

}
