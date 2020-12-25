package com.dms.pooshe.controller.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.dms.pooshe.controller.adapter.PSPAdapter;
import com.dms.pooshe.databinding.FragmentPspBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PSPFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PSPFragment extends Fragment {

   public static final String PSP_LIST_ARG = "param1";
   private FragmentPspBinding mBinding;
   private List<String> mPspList = new ArrayList<>();

   public PSPFragment() {
      // Required empty public constructor
   }

   public static PSPFragment newInstance(ArrayList<String> pspList) {
      Bundle bundle = new Bundle();
      bundle.putStringArrayList(PSP_LIST_ARG, pspList);
      PSPFragment fragment = new PSPFragment();
      fragment.setArguments(bundle);
      return fragment;
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      if (getArguments() != null)
         mPspList = getArguments().getStringArrayList(PSP_LIST_ARG);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      mBinding = FragmentPspBinding.inflate(inflater, container, false);
      if (getActivity() instanceof PSPAdapter.ParentActivity)
         mBinding.pspRecycler.setAdapter(new PSPAdapter(mPspList, (PSPAdapter.ParentActivity) getActivity()));
      return mBinding.getRoot();
   }
}