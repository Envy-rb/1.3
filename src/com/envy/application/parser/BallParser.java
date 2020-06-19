package com.envy.application.parser;

import com.envy.application.entity.Ball;
import com.envy.application.entity.Color;

public class BallParser {
    private final String SEPARATOR = ",";
    private final int BALL_WEIGHT_INDEX = 1;
    private final int BALL_SIZE_INDEX = 2;
    private final int BALL_COLOR_INDEX = 3;

    public Ball parseBall(String ballData) {
        String[] args = ballData.split(SEPARATOR);
        double ballWeight = Double.parseDouble(args[BALL_WEIGHT_INDEX]);
        double ballSize = Double.parseDouble(args[BALL_SIZE_INDEX]);
        Color ballColor = Color.valueOf(args[BALL_COLOR_INDEX]);
        return new Ball(ballWeight, ballSize, ballColor);
    }
}
