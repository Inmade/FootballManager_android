package com.mortier.martin.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class Camera extends Fragment{

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Button takePictureButton;
    private ImageView imageView;
    private Uri file;
    private ProgressBar mProgressBar;
    private Button mButton;
    public Camera() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_camera, container, false);
        takePictureButton = (Button) view.findViewById(R.id.button_image);
        imageView = (ImageView) view.findViewById(R.id.imageview);


        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        mProgressBar = (ProgressBar) view.findViewById(R.id.pBAsync);
        mButton = (Button) view.findViewById(R.id.btnLaunch);


        // On met un Listener sur le bouton
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                BigCalcul calcul=new BigCalcul();
                calcul.execute();
            }
        });
        return view;
    }
    String mCurrentPhotoPath;

    public File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

/*    static final int REQUEST_TAKE_PHOTO = 1;

    public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        // Create the File where the photo should go
        File photoFile = null;
        try {
            photoFile = createImageFile();
            galleryAddPic();
        } catch (IOException ex) {
            // Error occurred while creating the File
        }
        // Continue only if the File was successfully created
        if (photoFile != null) {
            Uri photoURI = FileProvider.getUriForFile(getContext(),
                    "com.example.android.fileprovider",
                    photoFile);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        }
    }*/


    public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);

            try {
                createImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private class BigCalcul extends AsyncTask<Void, Integer, Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getActivity().getApplicationContext(), "Début du traitement asynchrone", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            super.onProgressUpdate(values);
            mProgressBar.setProgress(values[0]);
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            int progress;
            for (progress=0;progress<=100;progress++)
            {
                    publishProgress(progress);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Toast.makeText(getActivity().getApplicationContext(), "Le traitement asynchrone est terminé", Toast.LENGTH_LONG).show();
            mProgressBar.setProgress(0);
        }

    }
}
