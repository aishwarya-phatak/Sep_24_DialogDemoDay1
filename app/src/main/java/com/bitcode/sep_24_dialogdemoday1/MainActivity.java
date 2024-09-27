package com.bitcode.sep_24_dialogdemoday1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAlertDialog,btnDatePickerDialog,btnTimePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();
    }

    private  void initializeViews(){

        btnAlertDialog = findViewById(R.id.btnAlertDialog);
        btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
        btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);
    }

    private void initializeListeners(){
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Exam Form Submit");
                builder.setMessage("DO YOU REALLY WANT TO SUBMIT?");
                builder.setIcon(R.drawable.ic_launcher_background);

                //way 1 - attaching listeners by creating inner classes
//                builder.setPositiveButton("Yes",new MyPositiveButtonClickListener());
//                builder.setNegativeButton("No",new MyNegativeButtonClickListener());
//                builder.setNeutralButton("Not Sure",new MyNeutralButtonClickListener());

                //way 2 - creating listener interface and attaching object
                DialogInterface.OnClickListener listener = new AlertDialogButtonsClickListener();
                builder.setPositiveButton("Yes", listener);
                builder.setNegativeButton("No", listener);
                builder.setNeutralButton("Not Sure", listener);

                builder.setOnCancelListener(new CancelClickListener());
                builder.setOnDismissListener(new DismissListener());

                builder.setCancelable(true);
                builder.show();

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        btnDatePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    DatePickerDialog datePickerDialog1 = new DatePickerDialog(
                            MainActivity.this,
                            new DatePickerButtonClickListener(),
                            2024,
                            1,
                            17
                    );

                    datePickerDialog1.show();
            }
        });

        btnTimePickerDialog.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(
                                MainActivity.this,
                                new TimePickerButtonClickListener(),
                                11,
                                34,
                                true
                        );
                        timePickerDialog.show();
                    }
                }
        );
    }

    class DatePickerButtonClickListener implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            Toast.makeText(MainActivity.this,"on Date Set " + year + "--" + month + "--" + day,Toast.LENGTH_LONG).show();
        }
    }

    class TimePickerButtonClickListener implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            Toast.makeText(MainActivity.this,"on Time Set" + "--" + hour + ":" + minute, Toast.LENGTH_LONG).show();
        }
    }

    class CancelClickListener implements DialogInterface.OnCancelListener{
        @Override
        public void onCancel(DialogInterface dialogInterface) {
            Toast.makeText(MainActivity.this,"Cancel Click Listener",Toast.LENGTH_LONG).show();
        }
    }

    class DismissListener implements DialogInterface.OnDismissListener{
        @Override
        public void onDismiss(DialogInterface dialogInterface) {
            Toast.makeText(MainActivity.this, "Dismiss Listener", Toast.LENGTH_LONG).show();
        }
    }

    class AlertDialogButtonsClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int buttonValue) {
            if (buttonValue == -1) {
                Toast.makeText(MainActivity.this, "Positive Button Clicked",Toast.LENGTH_LONG).show();
            } else if(buttonValue == -2){
                Toast.makeText(MainActivity.this,"Negative Button Clicked", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this,"Neutral Button Clicked",Toast.LENGTH_LONG).show();
            }
        }
    }

    class MyPositiveButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"Positive Button Clicked " + i,Toast.LENGTH_LONG).show();
        }
    }

    class MyNegativeButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"Negative Button Clicked " + i, Toast.LENGTH_LONG).show();
        }
    }

    class MyNeutralButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"Neutral Button Clicked " + i, Toast.LENGTH_LONG).show();
        }
    }
}