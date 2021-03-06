package com.dms.pooshe.controller.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.dms.pooshe.controller.upload.UploadActivity;
import com.dms.pooshe.databinding.FragmentDocumentBinding;

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

   private void onClick() {
      mBinding.exitBtn.setOnClickListener(v -> {
         getActivity().finish();
      });

      mBinding.identityBtn.setOnClickListener(v -> startActivity(UploadActivity.newIntent(mBinding.identityBtn.getText().toString(), getActivity())));
      mBinding.identity2Btn.setOnClickListener(v -> startActivity(UploadActivity.newIntent(mBinding.identity2Btn.getText().toString(), getActivity())));
      mBinding.identityPaperBtn.setOnClickListener(v -> startActivity(UploadActivity.newIntent(mBinding.identityPaperBtn.getText().toString(), getActivity())));
      mBinding.billBtn.setOnClickListener(v -> startActivity(UploadActivity.newIntent(mBinding.billBtn.getText().toString(), getActivity())));
      mBinding.leaseBtn.setOnClickListener(v -> startActivity(UploadActivity.newIntent(mBinding.leaseBtn.getText().toString(), getActivity())));
      mBinding.certificateBtn.setOnClickListener(v -> startActivity(UploadActivity.newIntent(mBinding.certificateBtn.getText().toString(), getActivity())));
   }
}