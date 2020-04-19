package wtp;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import wtp.ConverterStub.CelsiusToFarenheit;
import wtp.ConverterStub.CelsiusToFarenheitResponse;
import wtp.ConverterStub.FarenheitToCelsius;
import wtp.ConverterStub.FarenheitToCelsiusResponse;



public class ConverterClient {

        public static void main(String[] args) {
                try {
                        float celsiusValue = 100;
                        ConverterStub stub = new ConverterStub();
                        CelsiusToFarenheit c2f = new CelsiusToFarenheit();
                        c2f.setCelsius(celsiusValue);
                        CelsiusToFarenheitResponse res = stub.celsiusToFarenheit(c2f);
                        System.out.println("Celsius : "+celsiusValue+" = "+"Farenheit : "+res.get_return());
                        FarenheitToCelsius f2c=new FarenheitToCelsius();
                        f2c.setFarenheit(celsiusValue);
                        FarenheitToCelsiusResponse ftoc=stub.farenheitToCelsius(f2c);
                        System.out.println("Farenheit : "+celsiusValue+" = "+"Celsius : "+ftoc.get_return());
                } catch (AxisFault e) {
                        e.printStackTrace();
                } catch (RemoteException e) {
                        e.printStackTrace();
                }

        }
}