package com.example.tablayout_fragments_viewpager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.tablayout_fragments_viewpager.Chats.ChatFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab_layout_id);
        viewPager = findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Add Fragment Here
        adapter.AddFragment(new CameraFragment(),"");
        adapter.AddFragment(new ChatFragment(),"Chat");
        adapter.AddFragment(new StatusFragment(),"Status");
        adapter.AddFragment(new CallFragment(),"Call");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //Add icons here instead of Title
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);

        //Remove Shadow From the Action Bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menus,menu);
        return true;
    }
}
