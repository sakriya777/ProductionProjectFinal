package com.example.productionprojectfinal.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productionprojectfinal.Models.ClassModel;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class ClassAdapter extends FirebaseRecyclerAdapter<ClassModel, ClassAdapter.myViewHolder> {

    public ClassAdapter(@NonNull @NotNull FirebaseRecyclerOptions<ClassModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder, int position, @NonNull @NotNull ClassModel model) {
        String classdescription = model.getClassdescription();
        String classid = model.getClassid();
        String classkey = model.getClasskey();
        String classname = model.getClassname();
        String classpassword = model.getClasspassword();
        String UID = model.getUid();


        FirebaseAuth auth = FirebaseAuth.getInstance();
        String currentuser = auth.getCurrentUser().getUid();

        if (currentuser.equals(UID)){
            holder.cardtitle.setText(classname);
            holder.cardid.setText("Class ID:"+classid);
            holder.cardpassword.setText("Password:"+classpassword);
        }else{
            holder.classcard.setVisibility(View.GONE);
            holder.classcard.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        }

    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_single, parent, false);

        return new ClassAdapter.myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView cardtitle, cardid, cardpassword;

        CardView classcard;
        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            cardtitle = itemView.findViewById(R.id.cardtitle);
            cardid = itemView.findViewById(R.id.cardclassid);
            cardpassword = itemView.findViewById(R.id.cardclasspassword);

            classcard = itemView.findViewById(R.id.classcardone);
        }
    }
}
