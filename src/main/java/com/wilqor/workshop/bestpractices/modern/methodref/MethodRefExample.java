package com.wilqor.workshop.bestpractices.modern.methodref;

import java.util.function.ToIntBiFunction;

/**
 * @author wilqor
 */
final class MethodRefExample {
    private MethodRefExample() {
    }

    public static void main(String[] args) {
        printResult(MethodRefExample::longestCommonSubstring, "Hello world", "Welcome world");
    }

    private static void printResult(ToIntBiFunction<String, String> function, String first, String second) {
        System.out.println(function.applyAsInt(first, second));
    }

    private static int longestCommonSubstring(String first, String second) {
        int maxLen = 0;
        int firstLength = first.length();
        int secondLength = second.length();
        int[][] grid = new int[firstLength + 1][secondLength + 1];
        for (int i = 1; i <= firstLength; i++) {
            for (int j = 1; j <= secondLength; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    grid[i][j] = grid[i - 1][j - 1] + 1;
                    if (grid[i][j] > maxLen) {
                        maxLen = grid[i][j];
                    }
                }
            }
        }
        return maxLen;
    }
}
