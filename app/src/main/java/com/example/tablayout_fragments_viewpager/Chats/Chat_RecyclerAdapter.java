package com.example.tablayout_fragments_viewpager.Chats;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tablayout_fragments_viewpager.PersonalChatWindow;
import com.example.tablayout_fragments_viewpager.R;


public class Chat_RecyclerAdapter extends RecyclerView.Adapter<Chat_RecyclerAdapter.MyViewHolder>
{
    Context context;

    public Chat_RecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position)
    {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return Chat_List.chatImage.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView chatImage;
        public TextView chatName;
        public TextView chat;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            chatImage = itemView.findViewById(R.id.chatImage);
            chatName = itemView.findViewById(R.id.chatName);
            chat = itemView.findViewById(R.id.chat);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
        public void bindView(final int position)
        {
            chatImage.setImageResource(Chat_List.chatImage[position]);
            chatName.setText(Chat_List.chatName[position]);
            chat.setText(Chat_List.chat[position]);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PersonalChatWindow.class);
                    intent.putExtra("chatImage",Chat_List.chatImage[position]);
                    intent.putExtra("chatName",Chat_List.chatName[position]);
                    context.startActivity(intent);
                }
            });
        }

    }
}
