public class BrandABulb extends Bulb {
    private String color;
    private int brightness; // in lumens

    public BrandABulb(String color, int brightness) {
        this.color = color;
        this.brightness = brightness;
    }

    @Override
    public void showInfo() {
        System.out.println("Brand A Bulb - Color: " + color + ", Brightness: " + brightness + " lumens, Power Usage: " + powerUsage + " watts");
    }
}