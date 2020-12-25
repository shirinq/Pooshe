package com.dms.pooshe.controller.upload;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.dms.pooshe.R;
import com.dms.pooshe.databinding.FragmentLoadDocumentBinding;
import com.dms.pooshe.utils.TakePicture;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;

import static android.app.Activity.RESULT_CANCELED;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UploadDocumentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UploadDocumentFragment extends Fragment {

   private static final String ARG_CHOSENDOC = "param1";
   private static final int REQ_TAKE_PICTURE = 0;

   private String mChosenDoc;
   private FragmentLoadDocumentBinding mBinding;

   public UploadDocumentFragment() {
      // Required empty public constructor
   }

   public static UploadDocumentFragment newInstance(String chosenDoc) {
      UploadDocumentFragment fragment = new UploadDocumentFragment();
      Bundle args = new Bundle();
      args.putString(ARG_CHOSENDOC, chosenDoc);
      fragment.setArguments(args);
      return fragment;
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      if (getArguments() != null) {
         mChosenDoc = getArguments().getString(ARG_CHOSENDOC);
      }
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      mBinding = FragmentLoadDocumentBinding.inflate(inflater, container, false);
      mBinding.btnChooseDoc.setText(mChosenDoc);
      onClick();
      return mBinding.getRoot();
   }

   private void onClick() {
      mBinding.btnChooseDoc.setOnClickListener(v -> startActivityForResult(TakePicture.getPickImageIntent(getActivity()), REQ_TAKE_PICTURE));

      mBinding.btnConfirm.setOnClickListener(v -> {
         Snackbar.make(mBinding.getRoot(), "عملیات با موفقیت انجام شد", BaseTransientBottomBar.LENGTH_LONG).setAction("تایید", view -> {
            getActivity().finish();
         }).show();
      });
   }

   @Override
   public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      if (resultCode == RESULT_CANCELED)
         return;

      else if (requestCode == REQ_TAKE_PICTURE) {
         File imageFile = TakePicture.getTempFile(getActivity());
         Uri selectedImage;
         boolean isCamera = (data == null ||
                 data.getData() == null ||
                 data.getData().toString().contains(imageFile.toString()));
         if (isCamera) {
            selectedImage = Uri.fromFile(imageFile);
         } else {
            selectedImage = data.getData();
         }
         Glide.with(this)
                 .load(selectedImage)
                 .placeholder(R.mipmap.ic_launcher_foreground)
                 .diskCacheStrategy(DiskCacheStrategy.NONE)
                 .skipMemoryCache(true)
                 .apply(new RequestOptions().override(400, 270))
                 .into(mBinding.imgPreview);

      }
   }
}