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
import com.prolificwebworks.theclubix.adapter.AllArtistAdapter;
import com.prolificwebworks.theclubix.entities.Artist;
import com.prolificwebworks.theclubix.server.Client;
import com.prolificwebworks.theclubix.utils.MyEnum;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class AllArtistFragment extends Fragment implements View.OnClickListener {


    RecyclerView recyclerView;
    GridLayoutManager linearLayoutManager;
    TextView submitTextView;


    public static AllArtistFragment newInstance() {
        AllArtistFragment fragment = new AllArtistFragment();

        return fragment;
    }

    public AllArtistFragment() {
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

        Client.INSTANCE.getAllArtist(new Callback<Artist>() {
            @Override
            public void success(Artist allEvents, Response response) {

                AllArtistAdapter allEventsAdapter = new AllArtistAdapter(AllArtistFragment.this, allEvents.getPostData());
                recyclerView.setAdapter(allEventsAdapter);

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


    @Override
    public void onClick(View v) {

        if (MyEnum.INSTANCE.getArtist() != null && MyEnum.INSTANCE.getArtist().size() > 0) {

            String ids = android.text.TextUtils.join(",", MyEnum.INSTANCE.getArtist());

            Client.INSTANCE.submitArtistIds(ids, new Callback<Response>() {
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
