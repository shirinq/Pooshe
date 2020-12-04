package com.dms.pooshe.controller.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dms.pooshe.controller.adapter.PSPAdapter;
import com.dms.pooshe.databinding.FragmentPspBinding;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PSPFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PSPFragment extends Fragment {

   private FragmentPspBinding mBinding;

   public PSPFragment() {
      // Required empty public constructor
   }

   public static PSPFragment newInstance() {
      return new PSPFragment();
   }

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      // Inflate the layout for this fragment
      mBinding = FragmentPspBinding.inflate(inflater, container, false);
      if (getActivity() instanceof PSPAdapter.ParentActivity)
         mBinding.pspRecycler.setAdapter(new PSPAdapter(Arrays.asList("سایان", "ایران کیش", "پاسارگاد"), (PSPAdapter.ParentActivity) getActivity()));
      return mBinding.getRoot();
   }
}