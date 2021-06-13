package com.example.productionprojectfinal.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.productionprojectfinal.Adapters.CommentAdapter;
import com.example.productionprojectfinal.Fragments.Discussion.SingleDiscussionFragment;
import com.example.productionprojectfinal.Models.Comment;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class SingleVideoActivity extends AppCompatActivity {
    String title = null;
    String name = null;
    String description = null;
    String videourl = null;
    String videouri = null;
    String topic = null;
    String uid = null;
    String commenttxt = null;
    String timestamp = null;

    TextView titlex, topicx, descriptionx;
    SimpleExoPlayer exoPlayer;
    PlayerView playerView;
    ProgressBar progressBar;
    CommentAdapter commentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_video);
        Toast.makeText(this, "Press the back button to exit", Toast.LENGTH_SHORT).show();

        TextView texting;
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            name = extras.getString("fullname");
            title = extras.getString("title");
            description = extras.getString("description");
            videourl = extras.getString("videourl");
            topic = extras.getString("topic");
            uid = extras.getString("uid");
            timestamp = extras.getString("timestamp");
        }

        titlex = findViewById(R.id.titletxt);
        topicx = findViewById(R.id.topictxt);
        descriptionx = findViewById(R.id.descriptiontxt);
        progressBar = findViewById(R.id.progress_bar);

        titlex.setText(title);
        topicx.setText(topic);
        descriptionx.setText(description);
        ImageView addcmtbtn;
        addcmtbtn = findViewById(R.id.addcommentbtn);

        RecyclerView commentrecyclers;
        commentrecyclers = findViewById(R.id.videocommentrecycler);
        commentrecyclers.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Comment> options =
                new FirebaseRecyclerOptions.Builder<Comment>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("videocomment").child(timestamp), Comment.class)
                        .build();

        commentAdapter = new CommentAdapter(options);

        commentrecyclers.setAdapter(commentAdapter);

        TextInputEditText comment;
        comment = findViewById(R.id.addacommentbox);

        addcmtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commenttxt = comment.getText().toString();
                FirebaseAuth auth = FirebaseAuth.getInstance();
                String commenterid = auth.getUid();
                FirebaseDatabase firebaseDatabase;
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                DatabaseReference dbref = reference.child("videocomment");


                HashMap<String, String> user = new HashMap<>();
                user.put("comment", commenttxt);
                user.put("commenterid", commenterid);
                user.put("postid", timestamp);

                dbref.child(timestamp)
                        .push()
                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        comment.setText("");
                        Toast.makeText(SingleVideoActivity.this, "Comment Added", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Uri videouri = Uri.parse(videourl);

        playerView = findViewById(R.id.exoplayer);

        LoadControl loadControl = new DefaultLoadControl();

        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();

        TrackSelector trackSelector = new DefaultTrackSelector(
                new AdaptiveTrackSelection.Factory(bandwidthMeter)
        );

        DefaultHttpDataSourceFactory factory = new DefaultHttpDataSourceFactory(
                "exoplayer_video"
        );

        exoPlayer = ExoPlayerFactory.newSimpleInstance(
                this, trackSelector, loadControl
        );

        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();

        MediaSource mediaSource = new ExtractorMediaSource(videouri, factory, extractorsFactory, null, null);

        playerView.setPlayer(exoPlayer);

        playerView.setKeepScreenOn(true);

        exoPlayer.prepare(mediaSource);

        exoPlayer.setPlayWhenReady(true);
        exoPlayer.addListener(new Player.EventListener() {
            @Override
            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {

            }

            @Override
            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

            }

            @Override
            public void onLoadingChanged(boolean isLoading) {

            }

            @Override
            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
                if (playbackState == Player.STATE_BUFFERING){
                    progressBar.setVisibility(View.VISIBLE);
                }
                else if (playbackState == Player.STATE_READY){
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onRepeatModeChanged(int repeatMode) {

            }

            @Override
            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

            }

            @Override
            public void onPlayerError(ExoPlaybackException error) {

            }

            @Override
            public void onPositionDiscontinuity(int reason) {

            }

            @Override
            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

            }

            @Override
            public void onSeekProcessed() {

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        exoPlayer.setPlayWhenReady(false);

        exoPlayer.getPlaybackState();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        exoPlayer.setPlayWhenReady(true);
        exoPlayer.getPlaybackState();
    }
    @Override
    public void onStart() {
        super.onStart();
        commentAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        commentAdapter.stopListening();
    }
}