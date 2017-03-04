package com.limox.jesus.teambeta_sqlite;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.limox.jesus.teambeta_sqlite.Fragments.CreatePost.CreatePost_Fragment;
import com.limox.jesus.teambeta_sqlite.Interfaces.HomeOfFragments;
import com.limox.jesus.teambeta_sqlite.Utils.AllConstants;

public class CreatePost_Activity extends AppCompatActivity implements HomeOfFragments, CreatePost_Fragment.OnCreatePostFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.limox.jesus.teambeta_sqlite.R.layout.activity_create_post);

        if (savedInstanceState == null){
            startFragment(new CreatePost_Fragment(),true, AllConstants.FragmentTag.CreatePostTag);
        }


    }


    @Override
    public void startFragment(Fragment fragment, boolean addStack, String tag) {

        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (addStack)
            ft.addToBackStack(null);
        ft.replace(R.id.activity_create_post, fragment,tag);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        int count =getSupportFragmentManager().getBackStackEntryCount();
        if (count>1){
            super.onBackPressed();
        }else
            finish();

    }
}
