package com.envy.application.entity;

public class Ball implements Comparable<Ball>{
    private static final double WEIGHT_DEFAULT = 1;
    private static final double SIZE_DEFAULT = 1;

    private final double weight;
    private final double size;
    private Color ballColor;

    public double getWeight() {
        return weight;
    }

    public Color getBallColor() {
        return ballColor;
    }

    public double getSize() {
        return size;
    }

    public Ball(double weight, double size) {
        if ((weight > 0) && (size > 0)) {
            this.weight = weight;
            this.size = size;
        }
        else {
            this.weight = WEIGHT_DEFAULT;
            this.size = SIZE_DEFAULT;
        }
    }

    public Ball(double weight, double size, Color ballColor) {
        this(weight, size);
        this.ballColor = ballColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;

        Ball ball = (Ball) o;

        if (Double.compare(ball.getWeight(), getWeight()) != 0) return false;
        if (Double.compare(ball.getSize(), getSize()) != 0) return false;
        return getBallColor() == ball.getBallColor();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getWeight());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getBallColor().hashCode();
        temp = Double.doubleToLongBits(getSize());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(Ball comparableBall) {
        if (equals(comparableBall)) {
            return 0;
        }
        else if (weight < comparableBall.getWeight() && size < comparableBall.getSize()) {
            return -1;
        }
        else {
            return 1;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");
        sb.append("weight=").append(weight);
        sb.append(", size=").append(size);
        sb.append(", ballColor=").append(ballColor.toString());
        sb.append('}');
        return sb.toString();
    }
}
