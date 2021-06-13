package com.example.productionprojectfinal;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

import android.widget.Toast;
import android.widget.VideoView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class AddOutSchoolCourse extends AppCompatActivity {

    private static final int VIDEO_PICK_GALLERY_CODE = 100;
    private static final int VIDEO_PICK_CAMERA_CODE = 101;
    private static final int CAMERA_REQUEST_CODE = 102;
    TextInputEditText title, description;
    VideoView videoView;
    Button addVideo, addOutCourse;
    ProgressDialog progressDialog;

    String titles, descriptions, fullname, fname, lname, uid;
    private String[] cameraPermissions;

    private Uri videoUrl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_out_school_course);

        FirebaseUser auth = FirebaseAuth.getInstance().getCurrentUser();
        uid = auth.getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.orderByChild("UID").equalTo(uid)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        for (DataSnapshot datas : snapshot.getChildren()) {
                            fname = datas.child("fname").getValue().toString();
                            lname = datas.child("lname").getValue().toString();
                        }
                    }


                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) {

                    }
                });

        fullname = fname + " " + lname;

        title = findViewById(R.id.edittitle);
        description = findViewById(R.id.editdescription);
        videoView = findViewById(R.id.videopreview);
        addOutCourse = findViewById(R.id.btnaddoutcourse);
        addVideo = findViewById(R.id.btnaddvideo);
        //progressBar = findViewById(R.id.uploadprogess);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Video is being Uploaded");
        progressDialog.setCanceledOnTouchOutside(false);

        //camera permission
        cameraPermissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        addVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoPickDialog();
            }
        });


        addOutCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titles = title.getText().toString();
                descriptions = description.getText().toString();
                if (TextUtils.isEmpty(titles)) {
                    Toast.makeText(AddOutSchoolCourse.this, "Title Must Be Added", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(descriptions)) {
                    Toast.makeText(AddOutSchoolCourse.this, "Description Must Be Added", Toast.LENGTH_SHORT).show();
                } else if (videoUrl == null) {
                    Toast.makeText(AddOutSchoolCourse.this, "Pick a Video First", Toast.LENGTH_SHORT).show();
                } else {
                    UploadVideoFirebase();
                }

            }
        });



    }

    private void UploadVideoFirebase() {
        progressDialog.show();

        Long timestamp = System.currentTimeMillis();

        String filepathandname = "Videos/" + "video " + timestamp;

        StorageReference storageReference = FirebaseStorage.getInstance().getReference(filepathandname);

        storageReference.putFile(videoUrl)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uriTask.isSuccessful()) ;
                        Uri downloaduri = uriTask.getResult();
                        if (uriTask.isSuccessful()) {

                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("title", "" + titles);
                            hashMap.put("description", "" + descriptions);
                            hashMap.put("timestamp", "" + timestamp);
                            hashMap.put("videourl", "" + downloaduri);
                            hashMap.put("uid", "" + uid);
                            hashMap.put("name", "" + fullname);

                            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("videos");
                            databaseReference.child("" + timestamp)
                                    .setValue(hashMap)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            progressDialog.dismiss();
                                            Toast.makeText(AddOutSchoolCourse.this, "Video Uploaded", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull @NotNull Exception e) {
                                            progressDialog.dismiss();
                                            Toast.makeText(AddOutSchoolCourse.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull @NotNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(AddOutSchoolCourse.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


    }

    private void VideoPickDialog() {

        String[] options = {"Camera", "Gallery"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick Video From")
                .setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            //Camera is Picked

                            if (!checkCameraPermission()) {
                                requestCameraPermission();

                            } else {
                                VideoPickCamera();
                            }

                        } else if (which == 1) {
                            //Gallery is Picked
                            VideoPickGallery();
                        }
                    }
                })
                .show();
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, cameraPermissions, CAMERA_REQUEST_CODE);
    }

    private boolean checkCameraPermission() {
        boolean result1 = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
        boolean result2 = ContextCompat.checkSelfPermission(this, Manifest.permission.WAKE_LOCK) == PackageManager.PERMISSION_GRANTED;
        return result1 && result2;
    }

    private void VideoPickGallery() {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Videos"), VIDEO_PICK_GALLERY_CODE);
    }

    private void VideoPickCamera() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent, VIDEO_PICK_CAMERA_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if (cameraAccepted && storageAccepted) {
                        VideoPickCamera();
                    } else {
                        Toast.makeText(this, "Camera and Storage Remissions required", Toast.LENGTH_SHORT).show();
                    }
                }

            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == VIDEO_PICK_GALLERY_CODE) {
                videoUrl = data.getData();
                //shoe video in video view
                SetVideoToVideoView();
            } else if (requestCode == VIDEO_PICK_CAMERA_CODE) {
                videoUrl = data.getData();
                //shoe video in video view
                SetVideoToVideoView();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void SetVideoToVideoView() {
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);

        videoView.setVideoURI(videoUrl);

        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.pause();
            }
        });
    }

}