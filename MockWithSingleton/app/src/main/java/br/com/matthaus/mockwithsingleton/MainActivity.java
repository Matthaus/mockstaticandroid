package br.com.matthaus.mockwithsingleton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.matthaus.mockwithsingleton.provider.CalendarUtils;

public class MainActivity extends AppCompatActivity {

    private static final String FORMAT_DATE = "dd/MM/yyyy";

    CalendarUtils calendarUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarUtils = CalendarUtils.getInstance();

        //Calendar currentTime = Calendar.getInstance();"dd/MM/yyyy"
        Calendar currentTime = calendarUtils.getCurrentDate();

        String dateFormatted = new SimpleDateFormat(FORMAT_DATE).format(currentTime.getTime());

        TextView tvDataHora = (TextView) findViewById(R.id.textview_DataHora);
        tvDataHora.setText(dateFormatted);

    }
}
