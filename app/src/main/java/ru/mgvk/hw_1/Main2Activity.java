package ru.mgvk.hw_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity  {


//    MainActivity Main;

    ListView listv;

    ArrayList<String> list;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listv = (ListView) findViewById(R.id.list);
        context = this;

        Intent intent = getIntent();
        list = intent.getStringArrayListExtra("list");

            setlist();


    }

    void setlist(){

        ArrayAdapter<String> adapter  = new ArrayAdapter<>(context,R.layout.list_item,R.id.txt,list);
        listv.setAdapter(adapter);

    }

}
