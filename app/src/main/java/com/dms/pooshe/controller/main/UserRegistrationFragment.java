package com.dms.pooshe.controller.main;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dms.pooshe.R;
import com.dms.pooshe.databinding.FragmentUserRegistrationBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserRegistrationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserRegistrationFragment extends Fragment {

   private FragmentUserRegistrationBinding mBinding;
   private FragmentActivity mActivity;

   public UserRegistrationFragment() {
      // Required empty public constructor
   }

   public static UserRegistrationFragment newInstance() {
      return new UserRegistrationFragment();
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      mBinding = FragmentUserRegistrationBinding.inflate(inflater, container, false);
      onClick();
      return mBinding.getRoot();
   }

   @Override
   public void onAttach(@NonNull Context context) {
      super.onAttach(context);
      if (context instanceof FragmentActivity)
         mActivity = (FragmentActivity) context;
   }

   private void onClick(){
      mBinding.btnNext.setOnClickListener(v -> {
         if (mActivity!=null)
            mActivity.onDocumentUpload();
      });
   }

   @Override
   public void onDetach() {
      super.onDetach();
      mActivity = null;
   }

   public interface FragmentActivity{
      public void onDocumentUpload();
   }
}