package com.example.yun.togethertogether;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Login_db {
    EditText idText;
    EditText passwordText;
    String id;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        if(getIntent().getExtras() ==null){
            //  startActivity(new Intent(this, MainActivity.class));
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idText = (EditText)findViewById(R.id.id);
        passwordText = (EditText)findViewById(R.id.password);
    }

    public void login(View v) {
        if (database != null) {
            Cursor cursor = database.rawQuery("SELECT name, num, password FROM" + tableName, null);
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                cursor.moveToNext();
                Lname = cursor.getString(0);
                Lemail = cursor.getString(1);
                Lpassword = cursor.getString(2);
            }
            id = idText.getText().toString();
            password = passwordText.getText().toString();

            if (id.equals(Lemail) && password.equals(Lpassword)) {
                Intent main = new Intent(getApplication(), MainActivity.class);
                main.putExtra("splash", "splash");
                startActivity(main);
                Toast.makeText(getApplicationContext(), Lname + "님 환영합니다!", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(getApplicationContext(), "아이디/비밀번호가 틀렸거나 없습니다.", Toast.LENGTH_SHORT).show();

            cursor.close();
        }

    }

    public void member(View view){
        Intent reg_member = new Intent(getApplication(),member_rgeister.class);
        reg_member.putExtra("splash","splash");
        startActivity(reg_member);
    }
}