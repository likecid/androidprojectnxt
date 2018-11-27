import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.addon.CompassHTSensor;

public class CompassControl {

    public CompassControl() {
    }
    private CompassHTSensor compass = new CompassHTSensor(SensorPort.S1); // Port S1 - S4, noch definieren?

    /*
        Davor mit einem calibrateDegree Nullen!
     */
    public float getDegrees(){ //Cartesian
        return compass.getDegreesCartesian();
    }

    public float getDegrees2(){ //orientiert sich an Norden, zum benutzen umständlicher
        return compass.getDegrees();
    }

    public void calibrateDegree(){
        compass.resetCartesianZero();
        
    }
    

    public void calibrate() throws InterruptedException{
        compass.startCalibration();
		Motor.B.setSpeed(20);
		Motor.C.setSpeed(20);
        Motor.B.forward();
        Motor.C.backward();
        Thread.sleep(20000);
        Motor.B.stop();
        Motor.C.stop();
        compass.stopCalibration();
    }

}
