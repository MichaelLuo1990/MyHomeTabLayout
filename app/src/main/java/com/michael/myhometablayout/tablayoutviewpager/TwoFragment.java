package com.michael.myhometablayout.tablayoutviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michael.myhometablayout.R;

/**
 * Desc fragment分页
 * Created by Michael on 2018/3/16.
 */
public class TwoFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tab_two, container, false);
        return view;
    }
}
