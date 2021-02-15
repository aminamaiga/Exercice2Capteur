package fr.umontpellier.exercice2capteur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    //Exercice2
    Sensor lightSensor;
    private SensorManager lightSensorManager;
    TextView infos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infos = (TextView)findViewById(R.id.infos);

        //Exercice 2 indisponibilité d'un capteur
        lightSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        lightSensor = lightSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (lightSensor == null) {
            infos.setText(R.string.error);
        } else {
            infos.setText(R.string.succes);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (lightSensor != null) {
            lightSensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        lightSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}