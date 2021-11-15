package com.maitreya.animationssample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            FragFirst fragment1 = new FragFirst();
            replaceFragment(fragment1, 0);
        }

    }

    /*
        Takes care of fragment changes, takes fragment and an integer
        1 - X Axis
        2 - Y Axis
        Anything else - Skip
     */
    public void replaceFragment(Fragment frag, Integer Axis){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if(Axis == 1)
            fragmentTransaction.setCustomAnimations(R.anim.enterx, R.anim.exitx);
        if(Axis == 2)
            fragmentTransaction.setCustomAnimations(R.anim.entery, R.anim.exity);
        fragmentTransaction.replace(R.id.fL, frag);
        fragmentTransaction.commit();
    }

}