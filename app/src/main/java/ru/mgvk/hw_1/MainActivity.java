package ru.mgvk.hw_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl1;

    ArrayList<String> list =  new ArrayList<>();

    ListView listv;

    final static Object b=new Object();  //ожидание загрузки второго активити

    Context context;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl1  =(RelativeLayout) findViewById(R.id.rl1);
        rl1.setBackgroundResource(R.mipmap.image1);

        listv =(ListView) findViewById(R.id.list);
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
        super.onDestroy();
    }

    void changeact(){
        Thread newActivityThread = new Thread(new Runnable() {
            @Override
            public void run() {

                Thread addlist = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        synchronized (b) {
                            try {
                                addlist();
                                Log.d("Thread", "Wait");
                                b.wait();
                            } catch (Exception e) {
                                Log.e("AddListThr", "" + e);
                            }
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                                intent.putStringArrayListExtra("list",list);
                                startActivity(intent);
                                finish();
                            }

                        });
                    }
                });
                addlist.start();

                try{
                    Thread.sleep(2000);
                    synchronized (b) {
                        Log.d("Thread", "Notify");
                        if(MainActivity.super.isDestroyed()){}else{
                        b.notifyAll();}
                    }
                }catch (Exception e){
                    Log.e("NewActThrSleep",""+e);
                }


            }
        });
        newActivityThread.start();
    }

    void addlist(){
        for(int i=0;i<1000;i++){
            list.add(i,"");
        }
        list.set(0, "Один");
        list.set(1, "Два");
        list.set(2, "Три");
        list.set(3, "Четыре");
        list.set(4, "Пять");
        list.set(5, "Шесть");
        list.set(6, "Семь");
        list.set(7, "Восемь");
        list.set(8, "Девять");
        list.set(9, "Десять");

        list.set(10, "Одиннадцать");
        list.set(11, "Двенадцать");
        list.set(12, "Тринадцать");
        //14-19
        for(int i=3;i<9;i++){
            list.set(10 + i, list.get(i).substring(0, list.get(i).length() - 1) + "надцать");
        }

        list.set(19, "Двадцать");
        list.set(29, "Тридцать");
        list.set(39, "Сорок");
        //50-80
        for(int i=5;i<9;i++){
            list.set((10 * i)-1, list.get(i-1) + "десят");
        }
        list.set(89, "Девяносто");
        //21-29,31-39,...
        for(int i=2; i<10;i++){
            for(int j=1;j<10;j++){list.set(10 * i-1 + j, list.get(10 * i-1) + " " + list.get(j-1));}
        }
        list.set(99, "Сто");
        list.set(199, "Двести");
        list.set(299, "Триста");
        list.set(399, "Четыреста");
        //400,500,600...
        for(int i=5;i<10;i++){
            list.set(100 * i-1, list.get(i-1) + "сот");
        }
        //101-199,201-299,...
        for(int i=100;i<1000;i+=100){
            for(int j=1;j<100;j++){
                list.set(i-1 + j, list.get(i-1) + " " + list.get(j-1));
            }
        }
        list.set(999,"Тысяча");

    }


}
