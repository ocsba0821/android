package com.example.test;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
public class head extends AppCompatActivity {

    Button eyesButton;
    private Spinner eyesSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head);

        eyesButton = findViewById(R.id.EYESBUTTON);
        eyesSpinner = findViewById(R.id.spinner_eyes);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.eyes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eyesSpinner.setAdapter(adapter);

        eyesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyTag", "Button clicked");
                eyesSpinner.setVisibility(View.VISIBLE);

            }
        });
    }
}





