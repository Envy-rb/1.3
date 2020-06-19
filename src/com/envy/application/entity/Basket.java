package com.envy.application.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Basket {

    private static final double VOLUME_DEFAULT = 100;
    private static final double PAYLOAD_DEFAULT = 100;

    private final double volume;
    private final double maxPayload;
    private final ArrayList<Ball> ballsPayload;

    public Basket(double volume, double maxPayload) {
        if ((volume > 0) && (maxPayload > 0)) {
            this.volume = volume;
            this.maxPayload = maxPayload;
        }
        else {
            this.volume = VOLUME_DEFAULT;
            this.maxPayload = PAYLOAD_DEFAULT;
        }
        ballsPayload = new ArrayList<Ball>();
    }

    public double getVolume() {
        return volume;
    }

    public double getMaxPayload() {
        return maxPayload;
    }
    public double calcEmptyVolume() {
        double currentUsingVolume = 0;
        for (Ball ball : ballsPayload) {
            currentUsingVolume += ball.getSize();
        }
        return volume - currentUsingVolume;
    }

    public double calcEmptyPayload() {
        double currentWeight = 0;
        for (Ball ball : ballsPayload) {
            currentWeight += ball.getWeight();
        }
        return maxPayload - currentWeight;
    }

    private Ball getPotentialPuttingBall() {
        return new Ball(calcEmptyPayload(), calcEmptyVolume());
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(ballsPayload);
    }

    public boolean addBall(Ball putting) {
        boolean result = false;
        if (putting.compareTo(getPotentialPuttingBall()) < 1) {
            ballsPayload.add(putting);
            result = true;
        }
        return result;
    }

    public boolean removeBall(int index) {
        boolean result = false;
        if (index > -1 && index < ballsPayload.size()) {
            ballsPayload.remove(index);
            result = true;
        }
        return result;
    }

    public int ballsCount() {
        return ballsPayload.size();
    }

    public double calcBallsWeight() {
        double weight = 0;
        for (Ball ball : ballsPayload) {
            weight += ball.getWeight();
        }
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Basket)) return false;

        Basket basket = (Basket) o;

        if (Double.compare(basket.getVolume(), getVolume()) != 0) return false;
        if (Double.compare(basket.getMaxPayload(), getMaxPayload()) != 0) return false;
        return ballsPayload.equals(basket.ballsPayload);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getVolume());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMaxPayload());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ballsPayload.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("volume=").append(volume);
        sb.append(", maxPayload=").append(maxPayload);
        sb.append(", ballsCount=").append(ballsPayload.size());
        sb.append('}');
        return sb.toString();
    }
}
