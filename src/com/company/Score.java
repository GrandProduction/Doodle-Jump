package com.company;

public class Score {
    private static int score = 0;

    public Score(int step){
        score += step;
    }
    public static int getScore() {
        return score;
    }
    public static void setScore(int score) {
        Score.score = score;
    }
}
