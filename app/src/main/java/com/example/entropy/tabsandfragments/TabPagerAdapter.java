package com.example.entropy.tabsandfragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

public class TabPagerAdapter extends FragmentPagerAdapter {
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentOne tab1 = new FragmentOne();



                return tab1;
            case 1:
                FragmentTwo tab2 = new FragmentTwo();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
