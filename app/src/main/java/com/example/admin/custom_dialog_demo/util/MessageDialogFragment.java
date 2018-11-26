package com.example.admin.custom_dialog_demo.util;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.admin.custom_dialog_demo.R;

public class MessageDialogFragment extends DialogFragment {

    private  String message;

    private OnSendDataListener listener;

    public void setOnSendDataListener(OnSendDataListener listener){
        this.listener = listener;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        //builder.setMessage(message==null ? "" : message);
        builder.setTitle("New Product discount!");

        View view =LayoutInflater.from(getActivity()).
                inflate(R.layout.login_dialog_layout,null);
        builder.setView(view);

        EditText userName=view.findViewById(R.id.username);
        EditText password=view.findViewById(R.id.password);

        builder.setPositiveButton("OK",(dialog,id)->{
            String name=userName.getText().toString();
            String pass=password.getText().toString();
            //Log.e("data","name+"+name +"password"+pass);
            if(listener!=null)
                listener.onGetData(name,pass);
        });

        return builder.create();

    }

   public interface OnSendDataListener{
        void onGetData(String name,String password);
   }
}
