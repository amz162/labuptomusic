package com.example.admine.labuptomusic;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.admine.labuptomusic.R;
import com.example.admine.labuptomusic.ContactsModal;
import java.util.ArrayList;
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.RecyclerViewHolders> {
    private Context context;
    private ArrayList<ContactsModal> modelList;
    private OnItemClickListener mItemClickListener;
    public ContactsAdapter(Context context, ArrayList<ContactsModal> modelList) {
        this.context = context;
        this.modelList = modelList;
    }
    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_contacts_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        ContactsModal contactsDTO = modelList.get(position);
        holder.ivUser.setImageResource(contactsDTO.imagePath);
        holder.tvName.setText(contactsDTO.contactName);
    }
    @Override
    public int getItemCount() {
        return modelList.size();
    }
    public void addItems(ArrayList<ContactsModal> activitiesList) {
        modelList.addAll(activitiesList);
        this.notifyDataSetChanged();
    }
    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        public ImageView ivUser;
        public TextView tvName;
        public RecyclerViewHolders(View itemView) {
            super(itemView);
            ivUser = (ImageView) itemView.findViewById(R.id.iv_item_contact_img);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_contact_name);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getAdapterPosition(), modelList);
            }
        }
    }
    public interface OnItemClickListener {
        public void onItemClick(View v, int position, ArrayList<ContactsModal> modelList);
    }
    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}