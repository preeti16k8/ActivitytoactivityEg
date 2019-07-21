package com.example.preeti.practice1;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
 TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv=(TextView)findViewById(R.id.textview1);
        Intent intent=getIntent();
        Bundle bnd=intent.getExtras();
        String emp=bnd.getString("emp");
        tv.setText(emp);
    }
}
