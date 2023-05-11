package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private RadioGroup mOptionsRadioGroup;
    private RadioButton mOption1RadioButton;
    private Button mSubmitButton;

    private String[] DU_ARRAY = {"머리카락이 없어졌다.", "귀 뒤쪽이 아프다.", "머리가 지끈거린다.", "앞머리가 흐려지고 있어.",
            "머리카락이 없어졌다."};
    private boolean[] checkedItems = new boolean[DU_ARRAY.length];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        mOptionsRadioGroup = findViewById(R.id.options_radiogroup);
        mOption1RadioButton = findViewById(R.id.option1_radiobutton);
        mSubmitButton = findViewById(R.id.submit_button);

        mSubmitButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                if(mOption1RadioButton.isChecked()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                    builder.setTitle("이두 증상을 선택하세요.");

                    builder.setMultiChoiceItems(DU_ARRAY, checkedItems,
                            new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    // 사용자가 체크박스를 클릭했을 때 처리할 로직
                                    checkedItems[which] = isChecked;
                                }
                            });

                    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 사용자가 확인 버튼을 클릭했을 때 처리할 로직
                            if (checkedItems[0] && !checkedItems[1] && !checkedItems[2]) {
                                Intent intent = new Intent(MainActivity3.this, SubActivity2.class);
                                startActivity(intent);
                                checkedItems[0] = false;
                                checkedItems[1] = false;
                            }
                            else if (checkedItems[0] && checkedItems[1] && !checkedItems[2]) {
                                Intent intent = new Intent(MainActivity3.this, Arm1.class);
                                startActivity(intent);
                                checkedItems[0] = false;
                                checkedItems[1] = false;
                                checkedItems[2] = false;
                            }
                            else if(checkedItems[0] && checkedItems[1] && checkedItems[2]){
                                Intent intent = new Intent(MainActivity3.this, SubActivity1.class);
                                startActivity(intent);
                                checkedItems[0] = false;
                                checkedItems[1] = false;
                                checkedItems[2] = false;
                            }

                        }
                    });

                    builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 사용자가 취소 버튼을 클릭했을 때 처리할 로직
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            }
        });
    }
}