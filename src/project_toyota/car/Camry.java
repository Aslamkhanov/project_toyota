package project_toyota.car;

import project_toyota.car.car_detail.*;
import project_toyota.project_enum.Country;
import project_toyota.project_enum.Transmission;

import java.math.BigDecimal;

public class Camry extends LightCar {
    private UsbSocket usbSocket;

    public Camry(Country country, String color, double maxSpeed, Transmission transmission,
                 Wheel[] wheel, GasTank gasTank, Engine engine, Electrician electrician,
                 Headlights headlight, BigDecimal price, boolean cruiseControl, UsbSocket usbSocket) {
        super(country, color, maxSpeed, transmission, wheel, gasTank, engine, electrician, headlight, price, cruiseControl);
        this.usbSocket = usbSocket;
    }
   // public void usb() {
      //  System.out.println("функция подключить музыку ");
   // }
    public void usb() {
        if (usbSocket.isUsb()) {
            usbSocket.setUsb(false);
            System.out.println("USB - музыка подключена ");
        } else {
            usbSocket.setUsb(true);
            System.out.println("USB - музыка отключена ");
        }
    }

    public UsbSocket getUsbSocket() {
        return usbSocket;
    }

    public void setUsbSocket(UsbSocket usbSocket) {
        this.usbSocket = usbSocket;
    }
}
