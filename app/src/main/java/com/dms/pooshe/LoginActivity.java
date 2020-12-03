package com.dms.pooshe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_login);

      if (savedInstanceState == null) {
         getSupportFragmentManager().beginTransaction()
                 .add(R.id.fragment_container, LoginFragment.newInstance())
                 .commit();
      }
   }
}