package com.ah.lh.mms.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ah.lh.mms.R;
import com.xuexiang.xui.adapter.FragmentAdapter;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xui.widget.tabbar.EasyIndicator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class UserForgetPasswordActivity extends AppCompatActivity {
    MyFragment forget_phone_content = null;
    MyFragment forget_email_content = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_forget_password);
        EasyIndicator easyIndicator = findViewById(R.id.forget_easy_indicator);
        easyIndicator.setTabTitles(new String[]{"手机号","邮箱"});
        ViewPager viewPager = findViewById(R.id.forget_view_pager);
        forget_phone_content = MyFragment.newInstance(this, "forget_phone_content");
        forget_email_content = MyFragment.newInstance(this, "forget_email_content");
        easyIndicator.setViewPager(viewPager,new FragmentAdapter(getSupportFragmentManager(),
                new Fragment[]{forget_phone_content, forget_email_content}));
        TitleBar titleBar = findViewById(R.id.forget_title_bar);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserForgetPasswordActivity.this.finish();
            }
        });
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        bindClickEvent();
    }

    private void bindClickEvent(){
        /*忘记密码 手机找回下一步*/
        findViewById(R.id.forget_password_phone_next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserForgetPasswordActivity.this, UserResetPasswordActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                UserForgetPasswordActivity.this.finish();
            }
        });
        /*忘记密码 邮箱找回下一步*/
        findViewById(R.id.forget_password_email_next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserForgetPasswordActivity.this, UserResetPasswordActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                UserForgetPasswordActivity.this.finish();
            }
        });
    }
}
