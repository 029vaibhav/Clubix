package com.prolificwebworks.theclubix.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prolificwebworks.theclubix.R;
import com.prolificwebworks.theclubix.entities.ClubData;
import com.prolificwebworks.theclubix.utils.CustomFont;
import com.prolificwebworks.theclubix.utils.MyEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by vaibhav on 13/10/15.
 */
public class AllCLubAdapter extends RecyclerView.Adapter<AllCLubAdapter.ViewHolder> {

    Fragment context;
    Set<String> clubIdsList;
    List<ClubData> clubDataList;

    public AllCLubAdapter(Fragment context, List<ClubData> eventDataList) {

        this.clubDataList = eventDataList;
        this.context = context;
        clubIdsList = new HashSet<>();
    }


    @Override
    public AllCLubAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_event_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AllCLubAdapter.ViewHolder holder, int position) {


        holder.eventNameX.setText(clubDataList.get(position).getCub_name());


    }

    @Override
    public int getItemCount() {

        if (clubDataList != null && clubDataList.size() != 0)
            return clubDataList.size();
        else return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public CustomFont eventNameX;

        public ViewHolder(View itemView) {
            super(itemView);

            eventNameX = (CustomFont) itemView.findViewById(R.id.event_x);
            itemView.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {

            if (clubIdsList.contains(clubDataList.get(getAdapterPosition()).getCub_id())) {
                clubIdsList.remove(clubDataList.get(getAdapterPosition()).getCub_id());
            } else clubIdsList.add(clubDataList.get(getAdapterPosition()).getCub_id());

            MyEnum.INSTANCE.setClub(clubIdsList);

        }
    }
}
