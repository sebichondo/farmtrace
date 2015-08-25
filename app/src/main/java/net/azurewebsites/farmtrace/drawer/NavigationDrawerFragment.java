package net.azurewebsites.farmtrace.drawer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.malinskiy.materialicons.Iconify;

import net.azurewebsites.farmtrace.BaseFragment;
import net.azurewebsites.farmtrace.Constants;
import net.azurewebsites.farmtrace.R;
import net.azurewebsites.farmtrace.event.Events;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sebichondo on 8/4/15.
 */
public class NavigationDrawerFragment  extends BaseFragment implements View.OnClickListener {

    private File mCurrentPhoto;
    private Context context;
    private Uri mCropImagedUri;
    private LayoutInflater inflater;
    @Bind(R.id.profile_pic)
    public ImageView profilePic;
    @Bind(R.id.username)
    TextView username;
    @Bind(R.id.designation)
    TextView designation;
    @Bind(R.id.log_out_image)
    TextView logout;
    @Bind(R.id.farmer_image)
    TextView farmerimage;
    @Bind(R.id.crop_image)
    TextView cropimage;
    @Bind(R.id.input_image)
    TextView inputimage;
    @Bind(R.id.txtFarmInputs)
    TextView farmInputs;
    @Bind(R.id.txtfarmers)
    TextView farmers;
    @Bind(R.id.txtcrops)
    TextView crops;
    @Bind(R.id.txtdashboard)
    TextView dashboard;
    @Bind(R.id.dashboard_image)
    TextView dashboardimage;

    @Override
    public void onClick(final View v) {

        bus.post(new Events.CloseDrawerEvent());
        Log.d("DataRepository", "NIKO HAPA: " );
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (v.getId()) {
                    case R.id.txtfarmers:
                        bus.post(new Events.FarmersSelectedEvent());
                        Log.d("DataRepository", "TUMEFIKEA HAPA: ");
                        break;
                    case R.id.txtcrops:
                        bus.post(new Events.CropsSelectedEvent());
                        break;
                    case R.id.txtFarmInputs:
                        bus.post(new Events.FarmInputsSelectedEvent());
                        break;
                    case R.id.txtdashboard:
                        bus.post(new Events.DashboardSelectedEvent());
                        break;

                }
            }
        }, 300);
    }

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater = inflater;
        this.context = getActivity();



        final View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.bind(this, view);

        username.setText("David Kamau");
        designation.setText("Techincal Assistant");

        farmers.setOnClickListener(this);
        farmInputs.setOnClickListener(this);
        crops.setOnClickListener(this);
        dashboard.setOnClickListener(this);

        Iconify.addIcons(logout,farmerimage,cropimage,inputimage,dashboardimage);


        return view;
    }

    @OnClick(R.id.profile_pic)
    public void onClickProfilePic() {
        Intent chooseFromGalleryIntent;
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            chooseFromGalleryIntent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            chooseFromGalleryIntent.putExtra(MediaStore.EXTRA_OUTPUT, getProfilePicUri());
        } else {
            chooseFromGalleryIntent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }

        Intent chooserIntent = Intent.createChooser(chooseFromGalleryIntent, getResources().getText(R.string.set_profile_photo));

        try {
            mCurrentPhoto = createImageFile();
            if (mCurrentPhoto != null) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mCurrentPhoto));
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{takePictureIntent});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        startActivityForResult(chooserIntent, Constants.IntentRequestCode.GET_PIC);
    }

    private File storeCloudPictureLocally(Uri uri) {
        final File file = getProfilePicFile();

        try {
            InputStream inputStream = context.getContentResolver().openInputStream(uri);
            final OutputStream output = new FileOutputStream(file);

            try {
                final byte[] buffer = new byte[1024];
                int read;

                while ((read = inputStream.read(buffer)) != -1)
                    output.write(buffer, 0, read);

                output.flush();
            } finally {
                output.close();
                inputStream.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return file;
    }

    private String getRealPathFromURI(Uri contentUri) {
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor == null) {
            return contentUri.getPath();
        }
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    /*
    private void updateCurrentUserProfilePhoto(String path) {
        if (currentUser != null) {

            if (path != null && !path.equals(currentUser.getProfilePicUri())) {
                currentUser.setProfilePicUri(path);
                DataRepository.insertOrUpdateUser(context, currentUser);
            }

            Uri pictureUri = null;
            if (currentUser.getProfilePicUri() != null) {
                File pictureFile = new File(currentUser.getProfilePicUri());
                if (pictureFile != null) {
                    pictureUri = Uri.fromFile(pictureFile);

                    Picasso.with(context)
                            .invalidate(pictureUri);

                }
            }

            Picasso.with(context)
                    .load(pictureUri)
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.placeholder_2)
                    .error(R.drawable.placeholder_2)
                    .into(profilePic);
        }
    }
*/

    private void performCrop(Uri picUri) {

        Intent cropIntent = new Intent("com.android.camera.action.CROP");
        //indicate image type and Uri
        cropIntent.setDataAndType(picUri, "image/*");
        //set crop properties
        cropIntent.putExtra("crop", "true");
        //indicate aspect of desired crop
        cropIntent.putExtra("aspectX", 1);
        cropIntent.putExtra("aspectY", 1);
        //indicate output X and Y
        cropIntent.putExtra("outputX", getResources().getDimensionPixelSize(R.dimen.profile_pic_size));
        cropIntent.putExtra("outputY", getResources().getDimensionPixelSize(R.dimen.profile_pic_size));

        //DO NOT retrieve data on return
        // On some devices we would get ->android.os.TransactionTooLargeException
        cropIntent.putExtra("return-data", false);
        File f = createCropFile("CROP_");
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mCropImagedUri = Uri.fromFile(f);
        cropIntent.putExtra(MediaStore.EXTRA_OUTPUT, mCropImagedUri);

        //start the activity - we handle returning in onActivityResult
        if (cropIntent.resolveActivity(context.getPackageManager()) != null) {
            startActivityForResult(cropIntent, Constants.IntentRequestCode.PIC_CROP);
        }
    }

    private File createCropFile(String prefix) {
        if (prefix == null || "".equalsIgnoreCase(prefix)) {
            prefix = "IMG_";
        }
        File newDirectory = new File(Environment.getExternalStorageDirectory() + "/mypics/");
        if (!newDirectory.exists()) {
            if (newDirectory.mkdir()) {
            }
        }
        File file = new File(newDirectory, (prefix + System.currentTimeMillis() + ".jpg"));
        if (file.exists()) {
            //this wont be executed
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp;

        String folderName = context.getString(R.string.app_name).toLowerCase();

        File path = new File(ContextCompat.getExternalFilesDirs(getActivity(), null)[0]
                .getAbsolutePath() + "/" + folderName);

        //make sure folder exists
        path.mkdirs();

        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                path      /* directory */
        );

        return image;
    }

    private Uri getProfilePicUri() {
        return Uri.fromFile(getProfilePicFile());
    }

    private String getProfilePicPath() {
        return context.getFilesDir() + "david" + "_profile_picture.jpg";
    }

    private File getProfilePicFile() {
        File f = new File(getProfilePicPath());
        try {
            f.createNewFile();
        } catch (IOException e) {

        }
        return f;
    }


}
