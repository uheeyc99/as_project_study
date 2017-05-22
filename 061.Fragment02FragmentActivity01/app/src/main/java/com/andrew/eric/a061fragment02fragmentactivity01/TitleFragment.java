package com.andrew.eric.a061fragment02fragmentactivity01;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by eric on 2017/5/22.
 */

public class TitleFragment extends Fragment {
    ImageButton imageButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.title_fragment, container, false);
        imageButton = (ImageButton) view.findViewById(R.id.id_title_left_btn);
        imageButton.setOnClickListener(listener);
        view.setBackgroundColor(Color.BLACK);  //eric
        return view;
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),"乱点什么？",Toast.LENGTH_SHORT).show();
        }
    };
}
