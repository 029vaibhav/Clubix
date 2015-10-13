package com.prolificwebworks.theclubix.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prolificwebworks.theclubix.R;
import com.prolificwebworks.theclubix.adapter.AllCLubAdapter;
import com.prolificwebworks.theclubix.entities.Club;
import com.prolificwebworks.theclubix.server.Client;
import com.prolificwebworks.theclubix.utils.MyEnum;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AllClubFragment extends Fragment implements View.OnClickListener {


    RecyclerView recyclerView;
    GridLayoutManager linearLayoutManager;
    TextView submitTextView;


    public static AllClubFragment newInstance() {
        AllClubFragment fragment = new AllClubFragment();

        return fragment;
    }

    public AllClubFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_all_event, container, false);
        submitTextView = (TextView) viewGroup.findViewById(R.id.submit);
        recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view);

        linearLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(linearLayoutManager);

        callServiceTogetData();
        submitTextView.setOnClickListener(this);


        return viewGroup;


    }

    private void callServiceTogetData() {

        Client.INSTANCE.getAllClubs(new Callback<Club>() {
            @Override
            public void success(Club allEvents, Response response) {

                AllCLubAdapter allEventsAdapter = new AllCLubAdapter(AllClubFragment.this, allEvents.getPostData());
                recyclerView.setAdapter(allEventsAdapter);

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    @Override
    public void onClick(View v) {


        if (MyEnum.INSTANCE.getClub() != null && MyEnum.INSTANCE.getClub().size() > 0) {

            String ids = android.text.TextUtils.join(",", MyEnum.INSTANCE.getClub());

            Client.INSTANCE.submitClubIds(ids, new Callback<Response>() {
                @Override
                public void success(Response response, Response response2) {

                }

                @Override
                public void failure(RetrofitError error) {

                }
            });

        } else {
            // no items selected message to be displayed
        }

    }
}
