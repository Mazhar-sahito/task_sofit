package com.mazharali.sofittask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mazharali.sofittask.constants.Const;
import com.mazharali.sofittask.fragments.HomeFragment;
import com.mazharali.sofittask.fragments.PostsFragment;
import com.mazharali.sofittask.fragments.ServiceFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView homeIcon, servicesIcon, postsIcon, hamburgerIcon;
    private TextView homeTxt, servicesTxt, postsTxt, fragmentNameTxtId;
    private LinearLayout homeLayout, servicesLayout, postsLayout;
    private DrawerLayout drawerLayout;
    private Observer<String> observer = new Observer<String>() {
        @Override
        public void onChanged(String s) {
            if (s.equals("change")){
                setFragment(2);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Const.mutableLiveData.observeForever(observer);

        setFragment(1);


    }

    private void setFragment(int i) {
        Fragment selectedFragment = null;
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorControlNormal, typedValue, true);

        switch (i) {
            case 1:
                fragmentNameTxtId.setText("");
                homeIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this,
                        R.color.red)));
                servicesIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this,
                        typedValue.resourceId)));
                postsIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this,
                        typedValue.resourceId)));
                homeTxt.setTextColor(ContextCompat.getColor(this,
                        R.color.red));
                servicesTxt.setTextColor(ContextCompat.getColor(this,
                        typedValue.resourceId));
                postsTxt.setTextColor(ContextCompat.getColor(this,
                        typedValue.resourceId));
                selectedFragment = new HomeFragment();

                break;
            case 2:
                fragmentNameTxtId.setText("Government Services");
                homeIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this,
                        typedValue.resourceId)));
                servicesIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this,
                        R.color.red)));
                postsIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this,
                        typedValue.resourceId)));
                homeTxt.setTextColor(ContextCompat.getColor(this,
                        typedValue.resourceId));
                servicesTxt.setTextColor(ContextCompat.getColor(this,
                        R.color.red));
                postsTxt.setTextColor(ContextCompat.getColor(this,
                        typedValue.resourceId));
                selectedFragment = new ServiceFragment();
                break;
            case 3:
                fragmentNameTxtId.setText("Data");
                homeIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this,
                        typedValue.resourceId)));
                servicesIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this,
                        typedValue.resourceId)));
                postsIcon.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(this,
                        R.color.red)));
                homeTxt.setTextColor(ContextCompat.getColor(this,
                        typedValue.resourceId));
                servicesTxt.setTextColor(ContextCompat.getColor(this,
                        typedValue.resourceId));
                postsTxt.setTextColor(ContextCompat.getColor(this,
                        R.color.red));
                selectedFragment = new PostsFragment();
                break;
            default:
                break;
        }
        if (selectedFragment != null)
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_id, selectedFragment).commit();
    }

    private void initViews() {

        // imageviews initialization
        homeIcon = findViewById(R.id.home_icon_id);
        servicesIcon = findViewById(R.id.service_icon_id);
        postsIcon = findViewById(R.id.posts_icon_id);
        hamburgerIcon = findViewById(R.id.hamburger_icon_id);

        // textviews
        homeTxt = findViewById(R.id.home_text_id);
        servicesTxt = findViewById(R.id.service_text_id);
        postsTxt = findViewById(R.id.posts_text_id);
        fragmentNameTxtId = findViewById(R.id.fragment_name_txt_id);

        // layouts
        homeLayout = findViewById(R.id.home_layout_id);
        servicesLayout = findViewById(R.id.service_layout_id);
        postsLayout = findViewById(R.id.posts_layout_id);
        drawerLayout = findViewById(R.id.drawer_layout_id);

        homeLayout.setOnClickListener(this);
        servicesLayout.setOnClickListener(this);
        postsLayout.setOnClickListener(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        Const.mutableLiveData.removeObserver(observer);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.home_layout_id) {
            setFragment(1);
        } else if (v.getId() == R.id.service_layout_id) {
            setFragment(2);
        } else if (v.getId() == R.id.posts_layout_id) {
            setFragment(3);
        }
    }
}