public abstract class Bulb implements SmartDevice {
    
    protected int powerUsage; // in watts

    @Override
    public void setUsage(int usage) {
        this.powerUsage = usage;
    }
}