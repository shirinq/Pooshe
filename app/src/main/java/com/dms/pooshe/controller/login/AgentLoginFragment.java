package com.dms.pooshe.controller.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dms.pooshe.controller.main.AgentActivity;
import com.dms.pooshe.controller.main.MainActivity;
import com.dms.pooshe.databinding.FragmentAgentLoginBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgentLoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgentLoginFragment extends Fragment {

   private FragmentAgentLoginBinding mBinding;

   public AgentLoginFragment() {
      // Required empty public constructor
   }

   public static AgentLoginFragment newInstance() {
      return new AgentLoginFragment();
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      mBinding = FragmentAgentLoginBinding.inflate(inflater, container, false);
      onClick();
      return mBinding.getRoot();
   }

   private void onClick() {
      mBinding.login.setOnClickListener(v -> {

         if (mBinding.contractNumber.getEditText().getText().toString().equals("") || mBinding.mobile.getEditText().getText().toString().equals("")) {
            Toast.makeText(getActivity(), "فیلد های بالا نمیتوانند خالی باشند", Toast.LENGTH_LONG).show();
            mBinding.contractNumber.setErrorEnabled(mBinding.contractNumber.getEditText().getText().toString().equals(""));
            mBinding.mobile.setErrorEnabled(mBinding.mobile.getEditText().getText().toString().equals(""));
         } else {
            startActivity(AgentActivity.newIntent(getActivity()));
            getActivity().finish();
         }
      });
   }
}