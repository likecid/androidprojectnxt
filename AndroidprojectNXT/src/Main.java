
import java.io.DataOutputStream;
import java.io.IOException;

import lejos.nxt.comm.Bluetooth;
import lejos.nxt.comm.NXTConnection;


public class Main {
	public static DataOutputStream dataOutputStream;
	public static NXTConnection bluetoothConnection;
	
	
	public static void main(String[] args) throws IOException {
		bluetoothConnection = Bluetooth.waitForConnection();
		bluetoothConnection.setIOMode(NXTConnection.RAW);
		dataOutputStream = bluetoothConnection.openDataOutputStream();

		send(100);
	}
	
	
	
	public static void send(int x) throws IOException {
		dataOutputStream.write(x);
		dataOutputStream.flush();
	}
	
	public void disconnect() throws IOException {
		dataOutputStream.close();
		bluetoothConnection.close();
	}

}
