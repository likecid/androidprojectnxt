
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.Motor;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.NXTConnection;


public class Main {
	public static DataOutputStream dataOutputStream;
	public static DataInputStream dataInputStream;
	public static NXTConnection bluetoothConnection;
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		bluetoothConnection = Bluetooth.waitForConnection();
		bluetoothConnection.setIOMode(NXTConnection.RAW);
		dataOutputStream = bluetoothConnection.openDataOutputStream();
		dataInputStream = bluetoothConnection.openDataInputStream();

		while(true) {
			// Qualifikationsfahrt
			if(receive() == 99) {
				CompassControl compass = new CompassControl();
				compass.calibrateDegree();
				Motor.B.setSpeed(720);
				Motor.C.setSpeed(720);
				Motor.B.forward();
				Motor.C.forward();
				Thread.sleep(1000);
				Motor.B.stop();
				Motor.C.stop();
				while(compass.getDegrees() < 90) {
					Motor.C.forward();
				}
				Motor.C.stop();
				Motor.B.forward();
				Motor.C.forward();
				Thread.sleep(500);
				Motor.B.stop();
				Motor.C.stop();
				compass.calibrateDegree();
				while(compass.getDegrees() < 90) {
					Motor.C.forward();
				}
				Motor.C.stop();
				Motor.B.forward();
				Motor.C.forward();
				Thread.sleep(1000);
				Motor.B.stop();
				Motor.C.stop();
				compass.calibrateDegree();
				while(compass.getDegrees() < 90) {
					Motor.C.forward();
				}
				Motor.C.stop();
				Motor.B.forward();
				Motor.C.forward();
				Thread.sleep(500);
				Motor.B.stop();
				Motor.C.stop();
				compass.calibrateDegree();
				while(compass.getDegrees() < 90) {
					Motor.C.forward();
				}
				Motor.C.stop();
				send(0);
			}
			// Disconnect
			if(receive() == 100) {
				break;
			}
		}
		disconnect();
	}
	
	public static int receive() throws IOException {
		return dataInputStream.read();
	}
	
	public static void send(int x) throws IOException {
		dataOutputStream.write(x);
		dataOutputStream.flush();
	}
	
	public static void disconnect() throws IOException {
		dataOutputStream.close();
		bluetoothConnection.close();
	}

}
