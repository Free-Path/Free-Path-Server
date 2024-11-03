package com.freepath.disability;

import java.util.Arrays;

public enum Disability {

    // 점자 블록
    BRAILLE_BLOCK, BRAILLE_PROMOTION,

    AUDIO_GUIDE, HELP_DOG, WHEELCHAIR, ELEVATOR,
    // 유모차
    STROLLER, GUIDE_HUMAN,
    // 수화안내
    SIGN_GUIDE;

    public static boolean existType(String disability) {
        for (Disability disabilityEnum : Disability.values()) {
            if (disability.equals(disabilityEnum.toString())) {
                return true;
            }
        }
        return false;
    }

}
