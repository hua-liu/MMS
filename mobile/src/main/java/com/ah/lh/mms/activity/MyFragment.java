package com.ah.lh.mms.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ah.lh.mms.MainActivity;
import com.ah.lh.mms.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    private View view;
    private static final String TAG = "MyFragment";
    public static MyFragment newInstance(Context context,String value) {
        Bundle args = new Bundle();
        args.putString("key", value);
        args.putString("pageName",context.getPackageName());
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        int id = R.layout.activity_user_register_content;
        String key = getArguments().getString("key");
        if(key!=null&&key.startsWith("register")){
            id = R.layout.activity_user_register_content;
        }else if(key!=null&&key.startsWith("forget")){
            id = R.layout.activity_user_forget_password_content;
        }
        return inflater.inflate(id, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);
        String key = getArguments().getString("key");
        int id = getResources().getIdentifier(key, "id", getArguments().getString("pageName"));
        view.findViewById(id).setVisibility(View.VISIBLE);
        this.view = view;
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }
}
