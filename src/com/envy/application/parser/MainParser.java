package com.envy.application.parser;

import com.envy.application.entity.Basket;

import java.util.ArrayList;
import java.util.List;

public class MainParser {
    private final static String BASKET_PATTERN = "basket,\\d+,\\d+";
    private final static String BALL_PATTERN = "ball,\\d+,\\d+,\\S+";

    private Basket getLastElentOfAList(ArrayList<Basket> input) {
        return input.get(input.size() - 1);
    }

    public ArrayList<Basket> parseAll(List<String> inputData) {
        ArrayList<Basket> resultList = new ArrayList<>();
        BasketParser basketParser = new BasketParser();
        BallParser ballParser = new BallParser();

        for (String line : inputData) {
            if (line.matches(BASKET_PATTERN)) {
                resultList.add(basketParser.parseBasket(line));
            }
            else if (line.matches(BALL_PATTERN)) {
                getLastElentOfAList(resultList).addBall(ballParser.parseBall(line));
            }
        }
        return resultList;
    }
}
