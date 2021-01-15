import gnu.io.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Some {
   static CommPort commPort;
    static InputStream in;
    static  OutputStream out;
    static  Thread thread;
    static SerialPort serialPort;

    public static void main(String[] args) throws NoSuchPortException, UnsupportedCommOperationException, IOException, PortInUseException {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("/dev/ttyUSB0");
        if (portIdentifier.isCurrentlyOwned()) {
            System.out.println("Error: Port is currently in use");
        } else {
            commPort = portIdentifier.open("papa", 2000);

            if (commPort instanceof SerialPort) {
                serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                in = serialPort.getInputStream();
                thread.start();
            } else {
                System.out.println("Error: Only serial ports are handled by this example.");
            }

        }

        in.close();
        out.close();
        serialPort.close();
        commPort.close();
    }
}
