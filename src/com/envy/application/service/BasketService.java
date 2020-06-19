package com.envy.application.service;

import com.envy.application.entity.Basket;
import com.envy.application.fileReader.Reader;
import com.envy.application.parser.MainParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasketService {
    private ArrayList<Basket> baskets;
    private MainParser mainParser;
    private Reader fileReader;

    public BasketService() throws IOException {
        fileReader = new Reader();
        mainParser = new MainParser();
        List<String> parsingData = fileReader.readFile(false);
        baskets = mainParser.parseAll(parsingData);
    }

    public int calcTotalBaskets() {
        return baskets.size();
    }

    public int calcTotalBalls() {
        int ballsCount = 0;
        for (Basket basket : baskets) {
            ballsCount += basket.ballsCount();
        }
        return ballsCount;
    }

    public double calcMaxVolumeOfBasket() {
        double maxVolume = -Double.MAX_VALUE;
        for (Basket basket : baskets) {
            if (basket.getVolume() > maxVolume) {
                maxVolume = basket.getVolume();
            }
        }
        return maxVolume;
    }

    public double calcTotalWeightOfBalls() {
        double weight = 0;
        for (Basket basket : baskets) {
            weight += basket.calcBallsWeight();
        }
        return weight;
    }

}
