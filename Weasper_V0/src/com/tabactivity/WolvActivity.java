package com.tabactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import net.simonvt.menudrawer.samples.R;


import com.fragment.wolvFragment;

public class WolvActivity extends FragmentActivity {

    static final String TAG = "WolvActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.tabswithfragmentsactivity);
        setContentView(R.layout.activity_windowsample);
        // add initial fragment, do not add to back stack, no transition animation
        addFragment(new wolvFragment(), false, FragmentTransaction.TRANSIT_NONE);
    }

    void addFragment(Fragment fragment, boolean addToBackStack, int transition) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(android.R.id.tabcontent, fragment);
        ft.setTransition(transition);
        if (addToBackStack)
            ft.addToBackStack(null);
        ft.commit();
    }

}
