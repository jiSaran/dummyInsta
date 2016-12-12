package com.saran.test.dummyinsta;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by core I5 on 11/30/2016.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int no_of_tab;
    public PagerAdapter(FragmentManager fm, int tab_no) {
        super(fm);
        this.no_of_tab = tab_no;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Fragment fr1 = new ProfileContentFragment();
                return fr1;
            case 1:
                Fragment fr2 = new ProfileTagFragment();
                return fr2;
            case 2:
                Fragment fr3 = new ProfileMapFragment();
                return fr3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.no_of_tab;
    }
}
