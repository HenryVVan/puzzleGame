package com.henry.ui;

import java.util.Random;

public class CodeUtil {

    public static String getCode() {
        StringBuilder code = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int k = r.nextInt(3);
            char c;
            if (k == 0) {
                c = (char) (r.nextInt(10) + 48);
            } else if (k == 1) {
                c = (char) (r.nextInt(26) + 65);
            }
            else {
                c = (char) (r.nextInt(26) + 97);
            }
            code.append(c);
        }
        return code.toString();
    }
}
