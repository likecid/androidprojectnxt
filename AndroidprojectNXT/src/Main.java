
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.NXTConnection;

public class Main {
	public static DataOutputStream dataOutputStream;
	public static DataInputStream dataInputStream;
	public static NXTConnection bluetoothConnection;

	public static void main(String[] args) throws IOException, InterruptedException {

		bluetoothConnection = Bluetooth.waitForConnection();
		LCD.drawString("Verbunden", 1, 1);
		bluetoothConnection.setIOMode(NXTConnection.RAW);
		dataOutputStream = bluetoothConnection.openDataOutputStream();
		dataInputStream = bluetoothConnection.openDataInputStream();

		CompassControl compass = new CompassControl();
		compass.calibrateDegree();
//		float rotate = compass.getDegrees2();

		while (true) {
			// Qualifikationsfahrt

			LCD.clear();
			LCD.drawInt((int) compass.getDegrees(), 1, 1);
//			Thread.sleep(1000);
//			compass.calibrate();
			
			if (receive() == 99) {
				LCD.clear();
				LCD.drawString("Quali", 1, 1);
//				send(99);

				Motor.B.setSpeed(360);
				Motor.C.setSpeed(360);
				Motor.B.forward();
				Motor.C.forward();
				Thread.sleep(5555);

				Motor.B.stop(true);
				Motor.C.stop(true);
				Thread.sleep(1000);
				compass.calibrateDegree();
				Motor.B.setSpeed(100);
				Motor.C.setSpeed(100);
				Motor.C.forward();
				Motor.B.backward();
				while (compass.getDegrees() < 90 || compass.getDegrees() > 180) {
					LCD.clear();
					LCD.drawString(Float.toString(compass.getDegrees()), 1, 1);
//					Motor.C.forward();
//					Thread.sleep(100);
				}
				Motor.C.stop(true);
				Motor.B.stop(true);
				Motor.B.setSpeed(360);
				Motor.C.setSpeed(360);
				Motor.B.forward();
				Motor.C.forward();
				Thread.sleep(2777);
				Motor.B.stop(true);
				Motor.C.stop(true);
				Thread.sleep(1000);
				compass.calibrateDegree();
				Motor.B.setSpeed(100);
				Motor.C.setSpeed(100);
				Motor.C.forward();
				Motor.B.backward();
				while (compass.getDegrees() < 90 || compass.getDegrees() > 180) {
					LCD.clear();
					LCD.drawString(Float.toString(compass.getDegrees()), 1, 1);
//					Motor.C.forward();
				}
				Motor.C.stop(true);
				Motor.B.stop(true);
				Motor.B.setSpeed(360);
				Motor.C.setSpeed(360);
				Motor.B.forward();
				Motor.C.forward();
				Thread.sleep(5555);
				Motor.B.stop(true);
				Motor.C.stop(true);
				Thread.sleep(1000);
				compass.calibrateDegree();
				Motor.B.setSpeed(100);
				Motor.C.setSpeed(100);
				Motor.C.forward();
				Motor.B.backward();
				while (compass.getDegrees() < 90 || compass.getDegrees() > 180) {
//					Motor.C.forward();
				}
				Motor.C.stop();
				Motor.B.setSpeed(360);
				Motor.C.setSpeed(360);
				Motor.B.forward();
				Motor.C.forward();
				Thread.sleep(2777);
				Motor.B.stop(true);
				Motor.C.stop(true);
				Thread.sleep(1000);
				compass.calibrateDegree();
				Motor.B.setSpeed(100);
				Motor.C.setSpeed(100);
				Motor.C.forward();
				Motor.B.backward();
				while (compass.getDegrees() < 90 || compass.getDegrees() > 180) {
					LCD.clear();
					LCD.drawString(Float.toString(compass.getDegrees()), 1, 1);
//					Motor.C.forward();
				}
				Motor.C.stop(true);
				Motor.B.stop(true);
				LCD.clear();
				LCD.drawString("Quali Bestanden", 1, 1);
//			send(98);
			}
			// Disconnect
			if (/* receive() == 50 */true) {
				break;
			}

		}

		// disconnect();
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

	public static void stop() {
		Motor.B.stop(true);
		Motor.C.stop(true);
	}

}
