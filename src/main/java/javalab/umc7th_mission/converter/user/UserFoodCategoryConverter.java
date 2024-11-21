package javalab.umc7th_mission.converter.user;

import java.util.List;
import java.util.stream.Collectors;
import javalab.umc7th_mission.domain.FoodCategory;
import javalab.umc7th_mission.domain.User;
import javalab.umc7th_mission.domain.mapping.UserFoodCategory;

public class UserFoodCategoryConverter {
    public static List<UserFoodCategory> toUserFoodCategoryList(User user, List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
            .map(foodCategory ->
                UserFoodCategory.builder()
                    .user(user)
                    .foodCategory(foodCategory)
                    .build()
            ).collect(Collectors.toList());
    }
}
