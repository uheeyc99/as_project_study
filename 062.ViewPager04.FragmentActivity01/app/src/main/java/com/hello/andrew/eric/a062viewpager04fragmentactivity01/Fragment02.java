package com.hello.andrew.eric.a062viewpager04fragmentactivity01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by eric on 25/05/2017.
 */

public class Fragment02 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment02,null);
        Toast.makeText(getContext(),"加载Fragment02",Toast.LENGTH_SHORT).show();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(),"删除Fragment02",Toast.LENGTH_SHORT).show();

    }

}
