package br.cefetmg.mockwithsingleton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar currentTime = Calendar.getInstance();

        TextView tvDataHora = (TextView) findViewById(R.id.textview_DataHora);
        tvDataHora.setText(currentTime.getTime().toString());

    }
}
