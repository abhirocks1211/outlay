package com.outlay.view.activity;

import android.os.Bundle;

import com.outlay.R;
import com.outlay.view.activity.base.ParentActivity;
import com.outlay.view.fragment.LoginFragment;

public class LoginActivity extends ParentActivity {
    private LoginFragment loginFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        this.initializeActivity(savedInstanceState);
    }

    private void initializeActivity(Bundle savedInstanceState) {
        loginFragment = new LoginFragment();
        loginFragment.setArguments(getIntent().getExtras());
        addFragment(R.id.fragment, loginFragment);
    }
}
