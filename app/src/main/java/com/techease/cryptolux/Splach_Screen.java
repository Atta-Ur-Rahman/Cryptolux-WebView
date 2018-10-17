package com.techease.cryptolux;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Splach_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach__screen);  Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                if (Utilities.CheckNetwork.isInternetAvailable(Splach_Screen.this)) {
                    startActivity(new Intent(Splach_Screen.this, MainActivity.class));
                    finish();
                } else {
                    SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Splach_Screen.this, SweetAlertDialog.ERROR_TYPE);
                    sweetAlertDialog.setConfirmText("Refresh")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    startActivity(new Intent(Splach_Screen.this, Splach_Screen.class));
                                    finish();
                                }
                            })
                            .setTitleText("Oops...")
                            .setContentText("No internet connection!")
                            .setOnKeyListener(new DialogInterface.OnKeyListener() {
                                @Override
                                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                                    finish();
                                    return false;
                                }
                            });

                    sweetAlertDialog.setCancelable(false);
                    sweetAlertDialog.show();

                }
            }
        };
        handler.postDelayed(runnable, 1000);


    }
}

