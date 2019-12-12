package pickspot.cl;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class brujula extends AppCompatActivity  implements SensorEventListener {
    TextView y,x,z;
    Sensor sensor;
    SensorManager sm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brujula);

        y = (TextView) findViewById(R.id.y);
        x = (TextView) findViewById(R.id.x);
        z = (TextView) findViewById(R.id.z);

        sm =(SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sm.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        y.setText(String.valueOf(sensorEvent.values[0]));
        x.setText(String.valueOf(sensorEvent.values[1]));
        z.setText(String.valueOf(sensorEvent.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}



