package com.example.yinnan.golfscorecard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HoleAdapter extends RecyclerView.Adapter<HoleAdapter.HoleViewHolder> {


    @Override
    public HoleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(HoleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HoleViewHolder extends RecyclerView.ViewHolder {

        private TextView mHoleLabel,mScoreLabel;
        private Button mPlusButton, mMinusButton;

        public HoleViewHolder(View itemView) {
            super(itemView);

            mHoleLabel = (TextView) itemView.findViewById(R.id.holeLabel);
            mScoreLabel = (TextView) itemView.findViewById(R.id.scoreLabel);
            mPlusButton = (Button) itemView.findViewById(R.id.plusButton);
            mMinusButton = (Button) itemView.findViewById(R.id.minusButton);

            mPlusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        public void bind() {

        }
    }
}
