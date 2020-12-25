package com.dms.pooshe.controller.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.dms.pooshe.R;
import com.dms.pooshe.controller.adapter.PSPAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class AgentActivity extends AppCompatActivity implements PSPAdapter.ParentActivity, UserRegistrationFragment.FragmentActivity {

   private boolean doubleBackToExitPressedOnce = false;
   private Toast exitToast;

   public static Intent newIntent(Context target) {
      return new Intent(target, AgentActivity.class);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_agent);

      if (savedInstanceState == null) {
         getSupportFragmentManager().beginTransaction()
                 .add(R.id.fragment_container, PSPFragment.newInstance(new ArrayList<>(Arrays.asList("سداد","پارسیان","اقتصاد نوین", "ایران کیش", "پاسارگاد"))))
                 .commit();
      }
   }

   @Override
   public void onDocument() {
      getSupportFragmentManager().beginTransaction()
              .add(R.id.fragment_container, UserRegistrationFragment.newInstance())
              .addToBackStack("UserRegistrationFragment")
              .commit();
   }

   @Override
   public void onDocumentUpload() {
      getSupportFragmentManager().beginTransaction()
              .add(R.id.fragment_container, DocumentFragment.newInstance())
              .addToBackStack("DocumentFragment")
              .commit();
   }

   @Override
   public void onBackPressed() {

      if (doubleBackToExitPressedOnce || getSupportFragmentManager().getBackStackEntryCount() >= 1) {
         super.onBackPressed();
         return;
      }

      this.doubleBackToExitPressedOnce = true;
      exitToast = Toast.makeText(this, getResources().getString(R.string.exit_app), Toast.LENGTH_SHORT);
      exitToast.show();

      new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
   }
}