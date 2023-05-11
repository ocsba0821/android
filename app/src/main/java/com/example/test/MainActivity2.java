package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity2 extends AppCompatActivity {

    Button eyesButton;
    private Spinner eyesSpinner;
    private Spinner SubEyesSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button emergencyEx = findViewById(R.id.emergency);

        eyesButton = findViewById(R.id.EYESBUTTON);
        eyesSpinner = findViewById(R.id.spinner_eyes);
        SubEyesSpinner = findViewById(R.id.spinner_eyes_child);

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



        emergencyEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/119"));

                startActivity(intent);
            }
        });

        eyesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // 선택된 아이템이 "눈이 붉어요" 인 경우
                if (eyesSpinner.getSelectedItem().toString().equals("눈이 붉어요")) {

                    // 하위 스피너의 항목을 정의합니다.
                    ArrayAdapter<CharSequence> adapterSubEyes = ArrayAdapter.createFromResource(
                            MainActivity2.this, R.array.sub_eyes_array_red, android.R.layout.simple_spinner_item);
                    adapterSubEyes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    // 하위 스피너에 항목을 추가하고 보이도록 설정합니다.
                    SubEyesSpinner.setAdapter(adapterSubEyes);
                    SubEyesSpinner.setVisibility(View.VISIBLE);
                    eyesSpinner.setVisibility(View.GONE);

                    SubEyesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            // 선택된 아이템이 "부음" 인 경우
                            if (SubEyesSpinner.getSelectedItem().toString().equals("충혈")) {

                                // 새로운 Activity를 시작하여 activity_congestion.xml 파일을 보여줍니다.
                                Intent intent = new Intent(MainActivity2.this, SubActivity1.class);
                                startActivity(intent);
                            }
                            else if (SubEyesSpinner.getSelectedItem().toString().equals("각막염")) {
                                Intent intent = new Intent(MainActivity2.this, SubActivity2.class);
                                startActivity(intent);
                            }
                            else if (SubEyesSpinner.getSelectedItem().toString().equals("이전")) {
                                SubEyesSpinner.setVisibility(View.GONE);
                                eyesSpinner.setVisibility(View.VISIBLE);
                            }
                        }


                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                } else {
                    // 선택된 아이템이 "눈이 붉어요"가 아닌 경우, 하위 스피너를 숨깁니다.
                    SubEyesSpinner.setVisibility(View.GONE);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}