package com.dms.pooshe.controller.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dms.pooshe.controller.main.MainActivity;
import com.dms.pooshe.databinding.FragmentLoginBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

   private FragmentLoginBinding mBinding;

   public LoginFragment() {
      // Required empty public constructor
   }

   public static LoginFragment newInstance() {
      return new LoginFragment();
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      mBinding = FragmentLoginBinding.inflate(inflater, container, false);
      View view = mBinding.getRoot();
      onClick();
      return view;
   }

   private void onClick(){
      mBinding.login.setOnClickListener(v -> {

         if (mBinding.contractNumber.getEditText().getText().toString().equals("") || mBinding.mobile.getEditText().getText().toString().equals("")) {
            Toast.makeText(getActivity(), "فیلد های بالا نمیتوانند خالی باشند", Toast.LENGTH_LONG).show();
            mBinding.contractNumber.setErrorEnabled(mBinding.contractNumber.getEditText().getText().toString().equals(""));
            mBinding.mobile.setErrorEnabled(mBinding.mobile.getEditText().getText().toString().equals(""));
         }
         else {
            startActivity(MainActivity.newIntent(getActivity()));
            getActivity().finish();
         }
      });
   }
}