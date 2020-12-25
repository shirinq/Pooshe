package com.dms.pooshe.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.MediaStore;

import androidx.core.content.FileProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class TakePicture {
   private static final String TEMP_IMAGE_NAME = "tempImage.jpg";
   private static final String AUTHORITY_FILE_PROVIDER = "com.dms.pooshe.fileprovider";

   public static Intent getPickImageIntent(Context context) {
      Intent chooserIntent = null;
      List<Intent> intentList = new ArrayList<>();

      Intent pickIntent = new Intent(Intent.ACTION_PICK,
              android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
      Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
      takePhotoIntent.putExtra("return-data", true);

      takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT,  FileProvider.getUriForFile(context, AUTHORITY_FILE_PROVIDER,
              getTempFile(context)));
      intentList = addIntentsToList(context, intentList, pickIntent);
      intentList = addIntentsToList(context, intentList, takePhotoIntent);

      if (intentList.size() > 0) {
         chooserIntent = Intent.createChooser(intentList.remove(intentList.size() - 1), "انتخاب کنید");
         chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentList.toArray(new Parcelable[]{}));
      }else{
         chooserIntent = takePhotoIntent;
      }

      return chooserIntent;
   }

   private static List<Intent> addIntentsToList(Context context, List<Intent> list, Intent intent) {
      List<ResolveInfo> resInfo = context.getPackageManager().queryIntentActivities(intent, PackageManager.GET_RESOLVED_FILTER);
      for (ResolveInfo resolveInfo : resInfo) {
         context.grantUriPermission(resolveInfo.activityInfo.packageName,
                 FileProvider.getUriForFile(context, AUTHORITY_FILE_PROVIDER, getTempFile(context)), Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
         String packageName = resolveInfo.activityInfo.packageName;
         Intent targetedIntent = new Intent(intent);
         targetedIntent.setPackage(packageName);
         list.add(targetedIntent);
      }
      return list;
   }

   public static File getTempFile(Context context) {
      return new File(context.getFilesDir(),TEMP_IMAGE_NAME);
   }
}
