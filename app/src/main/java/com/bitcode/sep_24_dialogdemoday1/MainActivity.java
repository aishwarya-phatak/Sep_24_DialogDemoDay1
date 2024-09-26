package com.bitcode.sep_24_dialogdemoday1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeListeners();
    }

    private  void initializeViews(){
        btnAlertDialog = findViewById(R.id.btnAlertDialog);
    }

    private void initializeListeners(){
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Exam Form Submit");
                builder.setMessage("DO YOU REALLY WANT TO SUBMIT?");

                builder.setPositiveButton("Yes",new MyPositiveButtonClickListener());
                builder.setNegativeButton("No",new MyNegativeButtonClickListener());
                builder.setNeutralButton("Not Sure",new MyNeutralButtonClickListener());

                builder.setCancelable(true);
                builder.show();

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
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