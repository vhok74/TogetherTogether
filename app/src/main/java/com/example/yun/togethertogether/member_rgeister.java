package com.example.yun.togethertogether;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class member_rgeister extends Login_db {

    EditText NAME,EMAIL,PASS,PASSSIGN,KPUEMAIL,CONFIRMNUM;

    String Rname, Remail,Rpass, Rpasssign,Rkpumail,Rconfimnum;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_rgeister);
        NAME = (EditText) findViewById(R.id.MYname);
        EMAIL = (EditText)findViewById(R.id.MYemail);
        PASS = (EditText) findViewById(R.id.MYpassword);
        PASSSIGN = (EditText) findViewById(R.id.MYpasswordConfirm);
        KPUEMAIL = (EditText) findViewById(R.id.schoolEmail);
        CONFIRMNUM = (EditText) findViewById(R.id.confirmNum);

        Button regButton = (Button)findViewById(R.id.regster_button);
        regButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Rname = NAME.getText().toString();
                Remail = EMAIL.getText().toString();
                Rpass = PASS.getText().toString();
                Rpasssign = PASSSIGN.getText().toString();
                Rkpumail = KPUEMAIL.getText().toString();
                //  Rconfimnum = CONFIRMNUM.getText().toString(); //이거는 외부로 뺴야할꺼같은데..? 먼저 확인을 해야하니까.

                Cursor cursor = database.rawQuery("SELECT Name, Email, Password FROM " + tableName, null);

                int count = cursor.getCount();
                for (int i = 0; i < count; i++) {
                    cursor.moveToNext();

                    Lname = cursor.getString(0);
                    Lemail = cursor.getString(1);
                    Lpassword = cursor.getString(2);
                }

                if (Rname.length() < 2) {
                    Toast.makeText(getApplicationContext(), "이름을 정확하게 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (Remail.length() < 6) {
                    Toast.makeText(getApplicationContext(), "메일주소를 정확하게 입력하여 주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (Rpass.length() < 6) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 6자리 이상 입력하세요.", Toast.LENGTH_SHORT).show();
                }

                else if (Rpasssign.length() < 6) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        if (database != null) {
                            database.execSQL("INSERT INTO " + tableName + "(Name, Email, Password, PassCheck, KpuEmail) VALUES" +
                                    "(" + "'" + Rname + "'" + "," +"'" + Remail + "'" +","+ "'" + Rpass + "'" + "," + "'" + Rpasssign + "'" + "," + Rkpumail +"'"+ ")");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Intent login = new Intent(getApplication(), Login.class);
                    login.putExtra("splash", "splash");
                    startActivity(login);
                    finish();
                    Toast.makeText(getApplication(), Rname + "님 회원가입을 축하합니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}