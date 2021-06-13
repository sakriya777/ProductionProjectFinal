package com.example.productionprojectfinal.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productionprojectfinal.Activities.SingleVideoActivity;
import com.example.productionprojectfinal.Fragments.Discussion.SingleDiscussionFragment;
import com.example.productionprojectfinal.Models.VideoModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class VideoAdapter extends FirebaseRecyclerAdapter<VideoModel, VideoAdapter.myViewHolder> {



    public VideoAdapter(@NonNull @NotNull FirebaseRecyclerOptions<VideoModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull VideoModel model) {

        String videoURL = model.getVideourl();
        String title = model.getTitle();
        String UID = model.getUid();
        String topics = model.getTopic();
        String description = model.getDescription();
        String timestamp = model.getTimestamp();
        String txt = String.valueOf(title.charAt(0)).toUpperCase() + title.substring(1, title.length());
        holder.title.setText(txt);
        holder.topic.setText(topics);
        Uri videouri = Uri.parse(videoURL);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.orderByChild("UID").equalTo(UID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for(DataSnapshot datas: snapshot.getChildren()){
                    String fname;
                    String lname;
                    String fullname;
                    fname = datas.child("fname").getValue().toString();
                    lname = datas.child("lname").getValue().toString();
                    fullname = fname+" "+lname;
                    holder.name.setText("By : " + fullname);
                    holder.card.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(v.getContext(), SingleVideoActivity.class);
                            intent.putExtra("videourl", videoURL);
                            intent.putExtra("videouri", videouri);
                            intent.putExtra("fullname", fullname);
                            intent.putExtra("topic", topics);
                            intent.putExtra("description", description);
                            intent.putExtra("title", txt);
                            intent.putExtra("uid", UID);
                            intent.putExtra("timestamp", timestamp);
                            v.getContext().startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }

        });
    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_video, parent, false);

        return new VideoAdapter.myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        TextView title, name, topic;
        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.videoone);
            title = itemView.findViewById(R.id.videotitle);
            topic = itemView.findViewById(R.id.videotopic);
            name = itemView.findViewById(R.id.videoowner);
        }
    }

}
