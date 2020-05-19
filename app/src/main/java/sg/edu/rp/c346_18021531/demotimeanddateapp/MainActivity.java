package sg.edu.rp.c346_18021531.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
DatePicker dp;
TimePicker tp;
Button btnDisplayDate;
Button btnDisplayTime;
Button btnReset;
TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        tp.setIs24HourView(true);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.buttonReset);

       btnDisplayTime.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               tp.setIs24HourView(true);
               Integer currenthour = tp.getCurrentHour();
               Integer currentminute  = tp.getCurrentMinute();
               tvDisplay.setText("time is : " + currenthour + ":" + currentminute );
           }
       });
       btnDisplayDate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Integer day = dp.getDayOfMonth();
               Integer month = dp.getMonth() + 1;
               Integer year = dp.getYear();
               tvDisplay.setText("Date is "+ day + "/"+ month + "/" + year);
           }
       });
       btnReset.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               tp.setCurrentHour(0);
               tp.setCurrentMinute(0);
               dp.updateDate(2020,0,1);
           }
       });
    }
}
