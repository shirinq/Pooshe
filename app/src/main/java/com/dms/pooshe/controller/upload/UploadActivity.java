package com.dms.pooshe.controller.upload;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dms.pooshe.R;

public class UploadActivity extends AppCompatActivity {

   public static final String CHOSEN_BUTTON_EXTRA = "chosenButton";

   public static Intent newIntent(String chosenBtn, Context target){
      Intent intent = new Intent(target, UploadActivity.class);
      intent.putExtra(CHOSEN_BUTTON_EXTRA, chosenBtn);
      return intent;
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_upload);
      if (savedInstanceState == null){
         getSupportFragmentManager().beginTransaction()
                 .add(R.id.fragment_container, UploadDocumentFragment.newInstance(getIntent().getExtras().getString(CHOSEN_BUTTON_EXTRA)))
                 .commit();
      }
   }
}