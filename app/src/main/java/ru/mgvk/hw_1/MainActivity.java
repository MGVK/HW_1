package ru.mgvk.hw_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl1;

    ArrayList<String> list =  new ArrayList<>();

    Context context;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl1  =(RelativeLayout) findViewById(R.id.rl1);
        rl1.setBackgroundResource(R.mipmap.image1);


//        Toast.makeText(this,"Change activity",Toast.LENGTH_SHORT).show();
//        intent = new Intent(MainActivity.this, MainActivity.class);
//        startActivity(intent);

        context = this;

        changeact();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onDestroy(){

        try {
            super.onDestroy();
        }catch (Exception e){
            Log.e("exc ",""+e);
        }
    }

    void changeact(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t = Thread.currentThread();
                try{

                    t.sleep(2000);
                }catch (Exception e){

                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "Change activity", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                        try{
                        MainActivity.this.onStop();
                        }catch(Exception e){
                            Log.e("except",""+e);
                        }

                    }
                });

            }
        });

        t.start();


    }


    void setlist(){

        list.add(1, "Один");
        list.add(2, "Два");
        list.add(3, "Три");
        list.add(4, "Четыре");
        list.add(5, "Пять");
        list.add(6, "Шесть");
        list.add(7, "Семь");
        list.add(8, "Восемь");
        list.add(9, "Девять");
        list.add(10, "Десять");

        list.add(11, "Одиннадцать");
        list.add(12, "Двенадцать");
        list.add(13, "Тринадцать");
        //14-19
        for(int i=4;i<10;i++){
            list.add(10 + i, list.get(i).substring(0, list.get(i).length() - 2) + "надцать");
        }

        list.add(20, "Двадцать");
        list.add(30, "Тридцать");
        list.add(40, "Сорок");
        //50-80
        for(int i=5;i<9;i++){
            list.add(10 * i, list.get(i) + "десят");
        }
        list.add(90, "Девяносто");
        //21-29,31-39,...
        for(int i=2; i<10;i++){
            for(int j=1;j<11;j++){list.add(10 * i + j, list.get(10 * i) + " " + list.get(j));}
        }
        list.add(100, "Сто");
        list.add(200, "Двести");
        list.add(300, "Триста");
        list.add(400, "Четыреста");
        //400,500,600...
        for(int i=5;i<10;i++){
            list.add(100*i,list.get(i)+"сот");
        }
        //101-199,201-299,...
        for(int i=100;i<1000;i+=100){
            for(int j=1;j<100;j++){
                list.add(i+j,list.get(i)+" "+list.get(j));
            }
        }


    }

}
