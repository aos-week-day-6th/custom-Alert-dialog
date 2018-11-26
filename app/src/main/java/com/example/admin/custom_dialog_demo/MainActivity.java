package com.example.admin.custom_dialog_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.custom_dialog_demo.util.MessageDialogFragment;

public class MainActivity extends AppCompatActivity
        implements MessageDialogFragment.OnSendDataListener {

    Button btnShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowDialog=findViewById(R.id.butShowDialog);
        btnShowDialog.setOnClickListener(v-> {
            MessageDialogFragment dialog=new MessageDialogFragment();
            dialog.setMessage("Discount 50% off!");
            dialog.setOnSendDataListener(this);
            dialog.show(getSupportFragmentManager(),"discount fragment");
        });


    }

    @Override
    public void onGetData(String name, String password) {
        Log.e("data","name+"+name +"password"+password);
    }
}
