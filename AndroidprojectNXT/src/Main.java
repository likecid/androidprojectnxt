
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.geom.Point;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.CompassHTSensor;
import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.NXTConnection;
import lejos.robotics.localization.PoseProvider;
import lejos.robotics.navigation.CompassPilot;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;

public class Main {
	public static DataOutputStream dataOutputStream;
	public static DataInputStream dataInputStream;
	public static NXTConnection bluetoothConnection;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException, InterruptedException {

//		CompassControl compass = new CompassControl();
//		compass.calibrateDegree();
		CompassHTSensor compass = new CompassHTSensor(SensorPort.S1);
		
//		Pose positiona = new Pose(0,0,0);
//		Pose positionb = new Pose(100,0,90);
//		Pose positionc = new Pose(100,50,180);
//		Pose positiond = new Pose(0,50,270);
//
//		PoseProvider pospro;
//		pospro.setPose(positionb);
		
//		Point pointone = new Point(100,0);
//		Point pointtwo = new Point(100,50);
//		Point pointthree = new Point(0,50);
//		Point pointfour = new Point(0,0);

		
		
		@SuppressWarnings("deprecation")
		CompassPilot pilot = new CompassPilot(compass, (float)5.6, 14,Motor.B, Motor.C);
		DifferentialPilot pilotzwei = new DifferentialPilot((float)5.6,(float)14,Motor.B,Motor.C);
		
		Navigator nav = new Navigator(pilotzwei);
//		nav.addWaypoint(0,0,0);
//		nav.addWaypoint(0,50,270);
//		nav.addWaypoint(100,50,180);
//		nav.addWaypoint(100,0,90);
//		nav.addWaypoint(0,0,0);

		
		bluetoothConnection = Bluetooth.waitForConnection();
		LCD.drawString("Verbunden", 1, 1);
		bluetoothConnection.setIOMode(NXTConnection.RAW);
		dataOutputStream = bluetoothConnection.openDataOutputStream();
		dataInputStream = bluetoothConnection.openDataInputStream();

		
//		float rotate = compass.getDegrees2();

		while (true) {
			// Qualifikationsfahrt

			LCD.clear();
			LCD.drawInt((int) compass.getDegrees(), 1, 1);
//			Thread.sleep(1000);
//			compass.calibrate();
			
//			if (receive() == 99) {
//				compass.calibrateDegree();
//				LCD.clear();
//				LCD.drawString("Quali", 1, 1);
////				send(99);
//
//				Motor.B.setSpeed(360);
//				Motor.C.setSpeed(360);
//				Motor.B.forward();
//				Motor.C.forward();
//				Thread.sleep(5555);
//
//				Motor.B.stop(true);
//				Motor.C.stop(true);
//				Thread.sleep(1000);
//				
//				Motor.B.setSpeed(100);
//				Motor.C.setSpeed(100);
//				LCD.drawString("1", 1, 5);
//				Motor.C.forward();
//				LCD.drawString("2", 1, 5);
//				Motor.B.backward();
//				LCD.drawString("3", 1, 5);
//				
//				Thread.sleep(100);
//				
//				// compass.getDegrees() >= 90 && compass.getDegrees() >= 340
//				
//				while (compass.getDegrees() < 90 || compass.getDegrees() > 300) {
//					LCD.drawString(Float.toString(compass.getDegrees()), 1, 1);
//					
//					LCD.drawString("Drehung 1", 1, 5);
//					
//					
////					Motor.C.forward();
////					Thread.sleep(100);
//				}
//				Motor.C.stop(true);
//				Motor.B.stop(true);
//				Motor.B.setSpeed(360);
//				Motor.C.setSpeed(360);
//				Motor.B.forward();
//				Motor.C.forward();
//				
//				
//				Thread.sleep(2777);
//				Motor.B.stop(true);
//				Motor.C.stop(true);
//				Thread.sleep(1000);
//				
//				Motor.B.setSpeed(100);
//				Motor.C.setSpeed(100);
//				Motor.C.forward();
//				Motor.B.backward();
//				Thread.sleep(100);
//				
//				
//				// compass.getDegrees() <= 180 && compass.getDegrees() <= 340
//				
//				
//				
//				while (compass.getDegrees() <= 180 || compass.getDegrees() >= 300) {
//					
//					LCD.drawString(Float.toString(compass.getDegrees()), 1, 1);
//					
////					Motor.C.forward();
//				}
//				Motor.C.stop(true);
//				Motor.B.stop(true);
//				Motor.B.setSpeed(360);
//				Motor.C.setSpeed(360);
//				Motor.B.forward();
//				Motor.C.forward();
//				Thread.sleep(5555);
//				Motor.B.stop(true);
//				Motor.C.stop(true);
//				Thread.sleep(1000);
//				
//				Motor.B.setSpeed(100);
//				Motor.C.setSpeed(100);
//				Motor.C.forward();
//				Motor.B.backward();
//				Thread.sleep(100);
//				
//				
//				// compass.getDegrees() <= 270 && compass.getDegrees() <= 340
//				
//				
//				
//				while (compass.getDegrees() < 270|| compass.getDegrees() > 300) {
//					LCD.drawString(Float.toString(compass.getDegrees()), 1, 1);
//					
////					Motor.C.forward();
//				}
//				Motor.B.stop(true);
//				Motor.C.stop(true);
//				Motor.B.setSpeed(360);
//				Motor.C.setSpeed(360);
//				Motor.B.forward();
//				Motor.C.forward();
//				Thread.sleep(2777);
//				Motor.B.stop(true);
//				Motor.C.stop(true);
//				Thread.sleep(1000);
//				
//				Motor.B.setSpeed(100);
//				Motor.C.setSpeed(100);
//				Motor.C.forward();
//				Motor.B.backward();
			nav.goTo(0, 0, 0);
			nav.stop();
			nav.goTo(100, 0, 90);
			nav.stop();
			nav.goTo(100, 50, 180);
			nav.stop();
			nav.goTo(0, 50, 270);
			nav.stop();
			nav.goTo(0, 0, 0);
			nav.stop();
//		    	nav.followPath();
//				
//				
//				// compass.getDegrees() <= 359 || compass.getDegrees() <10
//				Thread.sleep(100);
//				
//				
//				while (compass.getDegrees() < 359 || compass.getDegrees() < 50) {
//					LCD.drawString(Float.toString(compass.getDegrees()), 1, 1);
//					
////					Motor.C.forward();
//				}
//				Motor.C.stop(true);
//				Motor.B.stop(true);
//				
//				LCD.drawString("Quali Bestanden", 1, 1);
////			send(98);
		//	}
			// Disconnect
			
			
			
			
//			vorwaerts();
//			Thread.sleep(5555);
//			stop();
//			neunzig(compass);
//			
//			vorwaerts();
//			Thread.sleep(2777);
//			stop();
//			neunzig(compass);
//			
//			vorwaerts();
//			Thread.sleep(5555);
//			stop();
//			neunzig(compass);
//			
//			vorwaerts();
//			Thread.sleep(2777);
//			stop();
//			neunzig(compass);
			
			Motor.B.setSpeed(360);
			Motor.C.setSpeed(360);
//			pilot.calibrate();
			vorwaerts();
			Thread.sleep(5555);
			stop();
			pilot.rotate(90);
			vorwaerts();
			Thread.sleep(2777);
			stop();
			pilot.rotate(90);
			vorwaerts();
			Thread.sleep(5555);
			stop();
			pilot.rotate(90);
			vorwaerts();
			Thread.sleep(2777);
			stop();
			pilot.rotate(90);
			
			
			
			
			
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
	
	public static void vorwaerts() {
		Motor.B.setSpeed(360);
		Motor.C.setSpeed(360);
		Motor.B.forward();
		Motor.C.forward();
		
	}

	public static void neunzig(CompassControl Compass) {
		
		
		/*
		Motor.B.setSpeed(30);
		Motor.C.setSpeed(30);
		
		CompassControl compass =Compass;
		compass.calibrateDegree();
		float startwert  = compass.getDegrees() ;

		while(((compass.getDegrees()+90) %360) < ((startwert+180) % 360) ) {
			LCD.drawString(Float.toString(compass.getDegrees()), 1, 1);
			Motor.C.forward();
			Motor.B.backward();	
			
			
			
		}
		stop();
		
		
		
		*/
		
	Motor.B.rotateTo(90);
	stop();
	
		
	
	}
	
	
	
	
	
}
