package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    dbHelper helper;
    ListView lv;
    ArrayList<Cate> arrayList;
    CateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.recyc);
        arrayList = new ArrayList<>();
        adapter = new CateAdapter(this,R.layout.hienthicate,arrayList);
        lv.setAdapter(adapter);


        //Taodatabase

        helper = new dbHelper(this,"category1.sqlite",null,3);

        //taobang

        helper.Querydata("CREATE TABLE IF NOT EXISTS category(id Integer primary key autoincrement, ten varchar(200)) ");

        //themdulieu

        helper.Querydata("INSERT INTO category VALUES (null,'Nguyen Thanh Cuong')");
        helper.Querydata("INSERT INTO category VALUES (null,'Nguyen Thanh Cuong 1')");

        //hienthidulieu
        Cursor datacate = helper.GetData("SELECT * FROM category");
        while (datacate.moveToNext()){
            String ten =datacate.getString(1);
            int id = datacate.getInt(0);
           //Toast.makeText(this,ten,Toast.LENGTH_SHORT).show();
            arrayList.add(new Cate(id,ten));
        }
        adapter.notifyDataSetChanged();
    }
}