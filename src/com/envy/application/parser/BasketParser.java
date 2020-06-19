package com.envy.application.parser;

import com.envy.application.entity.Basket;

public class BasketParser {
    private final String SEPARATOR = ",";
    private final int BASKET_VOLUME_INDEX = 1;
    private final int BASKET_MAXPAYLOAD_INDEX = 2;

    public Basket parseBasket(String basketData) {
        String[] args = basketData.split(SEPARATOR);
        double basketVolume = Double.parseDouble(args[BASKET_VOLUME_INDEX]);
        double basketMaxPayload = Double.parseDouble(args[BASKET_MAXPAYLOAD_INDEX]);
        return new Basket(basketVolume, basketMaxPayload);
    }
}
