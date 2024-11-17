package javalab.umc7th_mission.global.exception.handler;

import javalab.umc7th_mission.global.BaseErrorCode;
import javalab.umc7th_mission.global.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}