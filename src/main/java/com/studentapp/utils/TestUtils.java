/*
 * Created By: Hiren Patel
 * Project Name: StudentApp-Serenity-Week-19
 */

package com.studentapp.utils;

import java.util.Random;

public class TestUtils {
    public static String getRandomValue(){
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }
}
