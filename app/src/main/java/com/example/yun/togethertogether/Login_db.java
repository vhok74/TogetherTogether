package com.example.yun.togethertogether;

/**
 * Created by Yun on 2018-05-06.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Yun on 2018-05-06.
 */

public class Login_db extends AppCompatActivity {
    SQLiteDatabase database;
    CustomerDB_Helper db_helper;
    String tableName = "MEMBER";
    String dbName = "register_member";

    String Lemail; //아이디 == email
    String Lname; //이름
    String Lpassword; //비번
    String Lmajor; //학과

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        try {
            if (database == null) {
                db_helper = new CustomerDB_Helper(getApplicationContext(),dbName,null,1);
                database = db_helper.getWritableDatabase();
                Toast.makeText(getApplication(),dbName+"생성 완료",Toast.LENGTH_SHORT).show();
            }
            else if(database !=null) {
                Toast.makeText(getApplication(),"db가 이미 생성 되어있습니다.",Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        try {
            if(database !=null){
                database.execSQL("CREATE TABLE if not exists"+tableName+"("+"_id integer PRIMARY KEY autoincrement,"+
                        "Name Text"+"Email Text"+"Password Text"+")");
                Toast.makeText(getApplication(),tableName+"이 생성되었습니다.",Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    class CustomerDB_Helper extends SQLiteOpenHelper {
        CustomerDB_Helper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }
        @Override
        public void onOpen(SQLiteDatabase database) {
            super.onOpen(database);
        }

        @Override
        public void onCreate(SQLiteDatabase database){}

        @Override
        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){}
    }
}
