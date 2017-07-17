package com.ai.sweepify;

import android.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by RiaAndDave on 7/18/2017.
 */

public class BoostFragment extends Fragment {
    View boostView;
    Button btnBoost;
    TextView memProgress;
    TextView result;
    int progress = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        boostView = inflater.inflate(R.layout.boost_layout,container,false);
        btnBoost = (Button) boostView.findViewById(R.id.btnBoost);
        memProgress = (TextView) boostView.findViewById(R.id.memProgress);
        result = (TextView) boostView.findViewById(R.id.result);
        btnBoost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress = 0;
                final Runnable setProgress = new Runnable() {
                    public void run() {
                        memProgress.setText(Integer.toString(progress));
                    }
                };
                final Timer myTimer = new Timer();
                myTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (progress >= 99) {
                            myTimer.cancel();
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    result.setText("Excellent");
                                }
                            });
                        }
                        progress++;
                        getActivity().runOnUiThread(setProgress);
                    }
                }, 0, 100);

            }
        });
        return boostView;
    }


}
