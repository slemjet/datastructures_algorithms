package pl.slemjet.arrays;

import java.util.HashMap;

public class ArraysSums {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     */
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> complementsByIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (complementsByIndex.containsKey(nums[i])) {
                Integer complementIndex = complementsByIndex.get(nums[i]);
                return new int[]{complementIndex, i};
            } else
                complementsByIndex.put(target - nums[i], i);
        }

        return new int[]{};
    }

}
