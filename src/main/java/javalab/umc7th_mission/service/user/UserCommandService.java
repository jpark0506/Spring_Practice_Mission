package javalab.umc7th_mission.service.user;

import java.util.List;
import java.util.stream.Collectors;
import javalab.umc7th_mission.converter.user.UserConverter;
import javalab.umc7th_mission.converter.user.UserFoodCategoryConverter;
import javalab.umc7th_mission.domain.FoodCategory;
import javalab.umc7th_mission.domain.User;
import javalab.umc7th_mission.domain.mapping.UserFoodCategory;
import javalab.umc7th_mission.dto.user.UserRequestDTO;
import javalab.umc7th_mission.dto.user.UserResponseDTO;
import javalab.umc7th_mission.global.code.ErrorStatus;
import javalab.umc7th_mission.global.exception.GeneralException;
import javalab.umc7th_mission.repository.FoodCategoryRepository;
import javalab.umc7th_mission.repository.UserFoodCategoryRepository;
import javalab.umc7th_mission.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UserCommandService {

    private final UserRepository userRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    private final UserFoodCategoryRepository userFoodCategoryRepository;

    public UserResponseDTO joinUser(UserRequestDTO requestDTO) {
        User newUser = UserConverter.toUser(requestDTO);
        List<FoodCategory> foodCategoryList = requestDTO.preferCategory().stream()
            .map(category -> {
                // 어차피 Optional인데 굳이 Validation을 앞에서..?
                // Repo 접근하는 것도 똑같은데 사실 Annotation을 써서 Validation을 앞단에서 해야하나 싶음.
                return foodCategoryRepository.findById(category).orElseThrow(() -> new GeneralException(
                    ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
            }).collect(Collectors.toList());

        List<UserFoodCategory> userFoodCategoryList = UserFoodCategoryConverter.toUserFoodCategoryList(newUser,foodCategoryList);
        userRepository.save(newUser);
        userFoodCategoryRepository.saveAll(userFoodCategoryList);


        return UserConverter.toUserResponseDTO(newUser);
    }
}
