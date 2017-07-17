package com.ai.sweepify;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by RiaAndDave on 7/17/2017.
 */

public class CoolDownFragment extends Fragment {
    View coolDownView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        coolDownView = inflater.inflate(R.layout.cool_down,container,false);
        return coolDownView;
    }
}
