package com.dms.pooshe.controller.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.dms.pooshe.R;
import com.dms.pooshe.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

   private ActivityLoginBinding mBinding;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
      setContentView(mBinding.getRoot());
      onClick();
   }

   private void onClick(){
      mBinding.user.setOnClickListener(v -> {
         mBinding.llLogin.setVisibility(View.GONE);
         getSupportFragmentManager().beginTransaction()
                 .add(R.id.fragment_container, UserLoginFragment.newInstance())
                 .addToBackStack("user_login")
                 .commit();
      });

      mBinding.agent.setOnClickListener(v -> {
         mBinding.llLogin.setVisibility(View.GONE);
         getSupportFragmentManager().beginTransaction()
                 .add(R.id.fragment_container, AgentLoginFragment.newInstance())
                 .addToBackStack("agent_login")
                 .commit();
      });
   }

   @Override
   public void onBackPressed() {
      mBinding.llLogin.setVisibility(View.VISIBLE);
      super.onBackPressed();
   }
}