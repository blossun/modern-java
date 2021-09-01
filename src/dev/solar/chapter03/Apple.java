package dev.solar.chapter03;

public class Apple {
    private Color color;
    private Integer weight;
    private String area;

    public Apple() {
    }

    public Apple(final Integer weight) {
        this.weight = weight;
    }

    public Apple(final Integer weight, final Color color) {
        this.weight = weight;
        this.color = color;
    }

    //    public Apple(final String color, final Integer weight) {
//        this.color = color;
//        this.weight = weight;
//    }

    public Apple(final Color color, final Integer weight, final String area) {
        this.color = color;
        this.weight = weight;
        this.area = area;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(final Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", area='" + area + '\'' +
                '}';
    }
}
