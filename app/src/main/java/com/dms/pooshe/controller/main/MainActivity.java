package com.dms.pooshe.controller.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dms.pooshe.R;
import com.dms.pooshe.controller.adapter.PSPAdapter;

public class MainActivity extends AppCompatActivity implements PSPAdapter.ParentActivity {

   private static final String DOC_FRAGMENT_TAG = "doc_fragment";
   private boolean doubleBackToExitPressedOnce = false;
   private Toast exitToast;

   public static Intent newIntent(Context target) {
      return new Intent(target, MainActivity.class);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      if (savedInstanceState == null) {
         getSupportFragmentManager().beginTransaction()
                 .add(R.id.fragment_container, PSPFragment.newInstance())
                 .commit();
      }
   }

   @Override
   public void onDocument() {
      getSupportFragmentManager().beginTransaction()
              .add(R.id.fragment_container, DocumentFragment.newInstance())
              .addToBackStack(DOC_FRAGMENT_TAG)
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

   @Override
   protected void onDestroy() {
      if (exitToast !=null)
         exitToast.cancel();
      super.onDestroy();
   }
}