public class BrandBBulb extends Bulb {
    private String color;
    private int brightness; // in lumens

    public BrandBBulb(String color, int brightness) {
        this.color = color;
        this.brightness = brightness;
    }

    @Override
    public void showInfo() {
        System.out.println("Brand B Bulb - Color: " + color + ", Brightness: " + brightness + " lumens, Power Usage: " + powerUsage + " watts");
    }
}