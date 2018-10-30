package com.abc.pay_atm;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements UserFragment.OnDbOpListner {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        if(findViewById(R.id.fragment_container2)!=null){


            if(savedInstanceState!=null){
                return ;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            UserFragment userFragment = new UserFragment();
            fragmentTransaction.add(R.id.fragment_container2,userFragment,null);
            fragmentTransaction.commit();

        }


    }

    @Override
    public void dBOpePerformed(int method) {

        switch(method){

            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container2,new AddContactFragment()).addToBackStack(null).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container2,new ReadContactsFragment()).addToBackStack(null).commit();
                break;


        }

    }

    /*
    public void sendMessage(View view) {


        EditText editText = findViewById(R.id.user_message);
        String message = editText.getText().toString();


        Intent intent = new Intent(this,MessageActivity.class);
        intent.putExtra("EXTRA_MESSAGE",message);
        startActivity(intent);
    }
    */




}
