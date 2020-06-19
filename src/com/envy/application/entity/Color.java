package com.envy.application.entity;

public enum Color {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue");

    private final String colorName;

    Color(String colorName) {
        this.colorName = colorName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Color{");
        sb.append("colorName='").append(colorName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
