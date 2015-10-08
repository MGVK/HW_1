package ru.mgvk.hw_1;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity  {


    MainActivity Main;

    ListView listv;

    ArrayList list;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        context = this;

        listv =(ListView) findViewById(R.id.list);

            list =  Main.list;


    }

//void createlist(){
//
//    list.add(1, "Один");
//    list.add(2, "Два");
//    list.add(3, "Три");
//    list.add(4, "Четыре");
//    list.add(5, "Пять");
//    list.add(6, "Шесть");
//    list.add(7, "Семь");
//    list.add(8, "Восемь");
//    list.add(9, "Девять");
//    list.add(10, "Десять");
//
//    list.add(11, "Одиннадцать");
//    list.add(12, "Двенадцать");
//    list.add(13, "Тринадцать");
//    //14-19
//    for(int i=4;i<10;i++){
//        list.add(10 + i, list.get(i).substring(0, list.get(i).length() - 2) + "надцать");
//    }
//
//    list.add(20, "Двадцать");
//    list.add(30, "Тридцать");
//    list.add(40, "Сорок");
//    //50-80
//    for(int i=5;i<9;i++){
//        list.add(10 * i, list.get(i) + "десят");
//    }
//    list.add(90, "Девяносто");
//    //21-29,31-39,...
//    for(int i=2; i<10;i++){
//        for(int j=1;j<11;j++){list.add(10 * i + j, list.get(10 * i) + " " + list.get(j));}
//    }
//    list.add(100, "Сто");
//    list.add(200, "Двести");
//    list.add(300, "Триста");
//    list.add(400, "Четыреста");
//    //400,500,600...
//    for(int i=5;i<10;i++){
//        list.add(100*i,list.get(i)+"сот");
//    }
//    //101-199,201-299,...
//    for(int i=100;i<1000;i+=100){
//        for(int j=1;j<100;j++){
//            list.add(i+j,list.get(i)+" "+list.get(j));
//        }
//    }
//
//
//}

    void setlist(){

        ArrayAdapter adapter  = new ArrayAdapter(context,)

    }

}
