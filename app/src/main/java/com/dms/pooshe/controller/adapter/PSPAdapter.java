package com.dms.pooshe.controller.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dms.pooshe.databinding.PspViewholderBinding;

import java.util.ArrayList;
import java.util.List;

public class PSPAdapter extends RecyclerView.Adapter<PSPAdapter.PSPViewHolder> {

   private List<String> mPSPs = new ArrayList<>();
   private ParentActivity mActivity;

   public PSPAdapter(List<String> list, ParentActivity activity){
      mPSPs = list;
      mActivity = activity;
   }

   @NonNull
   @Override
   public PSPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      return new PSPViewHolder(PspViewholderBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
   }

   @Override
   public void onBindViewHolder(@NonNull PSPViewHolder holder, int position) {
      holder.onBind(mPSPs.get(position));
      setFadeAnimation(holder.itemView);
   }

   private void setFadeAnimation(View view) {
      AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
      anim.setDuration(2000);
      view.startAnimation(anim);
   }

   @Override
   public int getItemCount() {
      return mPSPs.size();
   }

   /**
    * View holder
    */

   class PSPViewHolder extends RecyclerView.ViewHolder{

      private PspViewholderBinding mBinding;

      public PSPViewHolder(@NonNull PspViewholderBinding binding) {
         super(binding.getRoot());
         mBinding = binding;
         mBinding.getRoot().setOnClickListener(v -> {
            mActivity.onDocument();
         });
      }

      public void onBind(String name){
         mBinding.getRoot().setText(name);
      }
   }

   public interface ParentActivity{
      public void onDocument();
   }
}
