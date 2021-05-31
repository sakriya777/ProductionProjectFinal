package com.example.productionprojectfinal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productionprojectfinal.Models.Messages;
import com.example.productionprojectfinal.Models.Users;
import com.example.productionprojectfinal.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Messages> messagesArrayList;
    int ITEM_SEND = 1;
    int ITEM_RECIEVE = 2;

    public MessageAdapter(Context context, ArrayList<Messages> messagesArrayList) {
        this.context = context;
        this.messagesArrayList = messagesArrayList;
    }

    public MessageAdapter(FirebaseRecyclerOptions<Users> options) {
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_SEND) {
            View view = LayoutInflater.from(context).inflate(R.layout.sender_layout_item, parent, false);
            return new SenderViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.reciever_layout_item, parent, false);
            return new RecieverViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {

        Messages messages = messagesArrayList.get(position);

        if(holder.getClass() == SenderViewHolder.class){
            SenderViewHolder senderViewHolder = (SenderViewHolder)holder;
            senderViewHolder.textmessage.setText(messages.getMessage());
        }else{
            RecieverViewHolder recieverViewHolder = (RecieverViewHolder)holder;
            recieverViewHolder.textmessage.setText(messages.getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return messagesArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Messages messages = messagesArrayList.get(position);
        if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals(messages.getSenderID())){
            return ITEM_SEND;
        }
        else{
            return ITEM_RECIEVE;
        }
    }

    class SenderViewHolder extends RecyclerView.ViewHolder {
        TextView textmessage;

        public SenderViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textmessage = itemView.findViewById(R.id.messagetxt);
        }
    }

    class RecieverViewHolder extends RecyclerView.ViewHolder {
        TextView textmessage;

        public RecieverViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textmessage = itemView.findViewById(R.id.messagetxt);
        }
    }
}
