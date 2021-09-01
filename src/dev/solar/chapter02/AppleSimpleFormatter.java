package dev.solar.chapter02;

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(final Apple apple) {
        StringBuilder sb = new StringBuilder();
        sb.append("A ").append(apple.getColor()).append(" ").append(apple.getWeight()).append("g apple");
        return sb.toString();
    }
}
