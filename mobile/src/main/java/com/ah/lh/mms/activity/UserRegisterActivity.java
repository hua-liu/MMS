package com.ah.lh.mms.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.ah.lh.mms.R;
import com.xuexiang.xui.adapter.FragmentAdapter;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xui.widget.layout.XUIFrameLayout;
import com.xuexiang.xui.widget.tabbar.EasyIndicator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class UserRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        EasyIndicator easyIndicator = findViewById(R.id.register_easy_indicator);
        easyIndicator.setTabTitles(new String[]{"手机号","邮箱"});
        ViewPager viewPager = findViewById(R.id.register_view_pager);
        easyIndicator.setViewPager(viewPager,new FragmentAdapter(getSupportFragmentManager(),
                new Fragment[]{MyFragment.newInstance(this,"register_phone_content"),MyFragment.newInstance(this,"register_email_content")}));
        TitleBar titleBar = findViewById(R.id.register_title_bar);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRegisterActivity.this.finish();
            }
        });
    }
}
