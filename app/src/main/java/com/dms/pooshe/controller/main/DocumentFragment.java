package com.dms.pooshe.controller.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dms.pooshe.R;
import com.dms.pooshe.databinding.FragmentDocumentBinding;
import com.dms.pooshe.utils.TakePicture;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DocumentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DocumentFragment extends Fragment {

   private FragmentDocumentBinding mBinding;
   private int shortAnimationDuration = 2000;
   public DocumentFragment() {
      // Required empty public constructor
   }

   public static DocumentFragment newInstance() {
      DocumentFragment fragment = new DocumentFragment();
      Bundle args = new Bundle();
      fragment.setArguments(args);
      return fragment;
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      if (getArguments() != null) {
      }
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      // Inflate the layout for this fragment

      mBinding = FragmentDocumentBinding.inflate(inflater, container, false);
      onClick();
      crossFade();
      return mBinding.getRoot();
   }

   private void crossFade() {
      mBinding.contentView.setAlpha(0.0f);
      mBinding.contentView.setVisibility(View.VISIBLE);
      mBinding.contentView.animate()
              .alpha(1.0f)
              .setDuration(shortAnimationDuration)
              .setListener(null);
   }

   private void onClick(){
      mBinding.exitBtn.setOnClickListener(v -> {
         getActivity().finish();
      });
      mBinding.identityBtn.setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction()
      .add(R.id.fragment_container,LoadDocumentFragment.newInstance(mBinding.identityBtn.getText().toString()))
              .addToBackStack("docloading")
              .commit()
      );
      mBinding.identity2Btn.setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction()
              .add(R.id.fragment_container,LoadDocumentFragment.newInstance(mBinding.identity2Btn.getText().toString()))
              .addToBackStack("docloading")
              .commit()
      );
      mBinding.identityPaperBtn.setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction()
              .add(R.id.fragment_container,LoadDocumentFragment.newInstance(mBinding.identityPaperBtn.getText().toString()))
              .addToBackStack("docloading")
              .commit()
      );
      mBinding.billBtn.setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction()
              .add(R.id.fragment_container,LoadDocumentFragment.newInstance(mBinding.billBtn.getText().toString()))
              .addToBackStack("docloading")
              .commit()
      );
      mBinding.contract.setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction()
              .add(R.id.fragment_container,LoadDocumentFragment.newInstance(mBinding.contract.getText().toString()))
              .addToBackStack("docloading")
              .commit()
      );
      mBinding.certificateBtn.setOnClickListener(v -> getActivity().getSupportFragmentManager().beginTransaction()
              .add(R.id.fragment_container,LoadDocumentFragment.newInstance(mBinding.certificateBtn.getText().toString()))
              .addToBackStack("docloading")
              .commit()
      );
   }
}