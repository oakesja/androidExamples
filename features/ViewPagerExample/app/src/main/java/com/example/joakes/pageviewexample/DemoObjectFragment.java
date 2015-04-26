package com.example.joakes.pageviewexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
* Created by joakes on 4/26/15.
*/
public class DemoObjectFragment extends Fragment {
    public static final String ARG_OBJECT = "object1";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                android.R.layout.simple_list_item_1, container, false);
        Bundle args = getArguments();
        String text = "" + args.getInt(ARG_OBJECT);
        ((TextView) rootView.findViewById(android.R.id.text1)).setText(text);
        return rootView;
    }
}
