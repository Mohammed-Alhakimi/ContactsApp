public class TEST {
    public static void main(String[] args) {

    }
}
interface ManagedDevice {

    void on();

    void off();
     int serialNumber=10;
     boolean on;
}

 abstract class AbstractDevice implements ManagedDevice {

    protected String serialNumber;
    protected boolean on;


    public AbstractDevice(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    protected void setOn(boolean on) {
        this.on = on;
    }

}
