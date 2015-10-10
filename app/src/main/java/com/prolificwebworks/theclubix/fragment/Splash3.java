package com.prolificwebworks.theclubix.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.prolificwebworks.theclubix.R;
import com.prolificwebworks.theclubix.activity.HomeActivity;

/**
 * Created by Akki on 10/7/2015.
 */

public class Splash3 extends Fragment {

    ImageView imageView3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.splash_3, container, false);
        imageView3 = (ImageView) v.findViewById(R.id.image3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
                getActivity().overridePendingTransition(android.R.anim.fade_in, 0);
                getActivity().finish();
            }
        });
        return v;
    }
}
