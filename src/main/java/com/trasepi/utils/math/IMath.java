package com.trasepi.utils.math;

import java.util.Random;

/**
 * my math util class
 */
public class IMath {

    static {
        random = new Random();
    }

    private static Random random;

    /**
     * to produce a random sequence which hsa no duplicated elements
     * @param amount the num of generated elements
     * @param range elements should between 1 and range
     * @return sequence array
     */
    public static int[] getNonRRS(int amount, int range) {

        if (amount > range) {
            throw new IllegalArgumentException(String.format("the first arg amount (%d )should less than the second arg range (%d )", amount, range));
        }

        int[] ints = new int[amount];
        ints[0] = random.nextInt(range);
        boolean flag = false;

        for (int i = 1; i < amount; ++i) {
            ints[i] = random.nextInt(range);
            while (true) {
                for (int j = 0; j < i; ++j) {
                    if (ints[j] == ints[i]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) break;
                flag = false;
                ints[i] = random.nextInt(range);
            }
        }
        return ints;
    }
}