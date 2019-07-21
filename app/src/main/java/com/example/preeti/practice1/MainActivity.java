package com.example.preeti.practice1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2,et3;
    Button b1;
    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

  //  String[] arr={"fb.com","twitter.com"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.edit1);
        et2=(EditText)findViewById(R.id.edit2);
        et3=(EditText)findViewById(R.id.edit3);
        b1=(Button)findViewById(R.id.button1);
        lv=(ListView)findViewById(R.id.listview1);
        al=new ArrayList<String>();
        aa=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);
       // aa=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        lv.setAdapter(aa);
       // al.add("fb.com");
        aa.notifyDataSetChanged();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ename=et1.getText().toString();
                String esal=et2.getText().toString();
                String edesign=et3.getText().toString();
                al.add(ename+"\n"+esal+"\n"+edesign);
                et3.setText("");
                et2.setText("");
                et1.setText("");
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String emp=al.get(i);
                        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                        intent.putExtra("emp",emp);
                        startActivity(intent);
                    }
                });
            }
        });

    }
}
