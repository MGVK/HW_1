package ru.mgvk.hw_1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        BlackWhiteAdapter adapter  = new BlackWhiteAdapter((Activity) context,R.layout.list_item,R.id.txt,list);
        listv.setAdapter(adapter);

    }

    class BlackWhiteAdapter extends ArrayAdapter<String>{
            private final Activity context;
            private final ArrayList<String> list;

        public BlackWhiteAdapter(Activity context, int resource, int textViewResourceId, ArrayList<String> list) {
            super(context, resource, textViewResourceId, list);
            this.context = context;
            this.list = list;
        }

        class ViewHolder{
            public ImageView imageView;
            public TextView textView;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            ViewHolder holder;

            View rowView =convertView;
            if(rowView==null){
                LayoutInflater inflater = context.getLayoutInflater();
                rowView = inflater.inflate(R.layout.list_item,null,true);
                holder = new ViewHolder();
                holder.textView = (TextView) rowView.findViewById(R.id.txt);
                rowView.setTag(holder);

            }else{
                holder = (ViewHolder) rowView.getTag();
            }

            holder.textView.setText(list.get(position));
            if(position%2==1){
                holder.textView.setBackgroundResource(R.color.grey);
            }else{
                holder.textView.setBackgroundResource(R.color.white);
            }
            return rowView;
        }

    }

}
