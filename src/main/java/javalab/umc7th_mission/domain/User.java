package javalab.umc7th_mission.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import javalab.umc7th_mission.domain.common.BaseEntity;
import javalab.umc7th_mission.domain.enums.Gender;
import javalab.umc7th_mission.domain.mapping.UserFoodCategory;
import javalab.umc7th_mission.domain.mapping.UserMission;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    @Enumerated
    private Gender gender;

    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 50)
    private String nickname;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 13)
    private String phoneNumber;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserFoodCategory> foodCategories;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserMission> userMissions;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Report> reports;

}