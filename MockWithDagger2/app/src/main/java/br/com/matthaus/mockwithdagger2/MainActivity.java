package br.com.matthaus.mockwithdagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.matthaus.mockwithdagger2.dagger.CalendarUtils;
import br.com.matthaus.mockwithdagger2.dagger.MockWithDagger2Application;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String FORMAT_DATE = "dd/MM/yyyy";

    @Inject
    CalendarUtils calendarUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MockWithDagger2Application) getApplication()).component().inject(this);

        Calendar currentTime = calendarUtils.getCurrentDate();

        String dateFormatted = new SimpleDateFormat(FORMAT_DATE).format(currentTime.getTime());

        TextView tvDataHora = (TextView) findViewById(R.id.textview_DataHora);
        tvDataHora.setText(dateFormatted);

    }
}
