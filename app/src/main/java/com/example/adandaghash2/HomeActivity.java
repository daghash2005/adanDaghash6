package com.example.adandaghash2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

   public void NailBits(View view){
       Intent i ;
       i= new Intent(this,NailBits.class);
       startActivity(i);

    }
    public void NailBits(View view) {
        Intent i;
        i= new Intent(this,NailBits.class);
        startActivity(i);
    }
}