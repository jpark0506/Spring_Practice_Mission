package javalab.umc7th_mission.global.exception.handler;

import javalab.umc7th_mission.global.BaseErrorCode;
import javalab.umc7th_mission.global.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
