package com.prolificwebworks.theclubix.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.prolificwebworks.theclubix.R;
import com.prolificwebworks.theclubix.intraface.OnClickInterface;

/**
 * Created by Akki on 20/7/2025.
 */
public class Splash2 extends Fragment {

    OnClickInterface clickInterface2;
    ImageView imageView2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.splash_2,container,false);
        imageView2 = (ImageView) v.findViewById(R.id.image2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                clickInterface2.buttonClicked(v);
                Splash3 splash3 = new Splash3();
                getFragmentManager().beginTransaction().replace(R.id.frameSplash, splash3).commit();
            }
        });
        return v;
    }

//    public void setInterface(OnClickInterface clickInterface3){
//        this.clickInterface2 = clickInterface3;
//    }
}
