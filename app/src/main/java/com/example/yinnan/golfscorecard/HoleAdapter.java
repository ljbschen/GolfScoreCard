package com.example.yinnan.golfscorecard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HoleAdapter extends RecyclerView.Adapter<HoleAdapter.HoleViewHolder> {
    private Context mContext;
    private Hole[] mHoles;

    public HoleAdapter(Context context, Hole[] holes) {
        mContext = context;
        mHoles = holes;
    }

    @Override
    public HoleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_list, parent, false);
        return new HoleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HoleViewHolder holder, int position) {
        holder.bind(mHoles[position]);
    }

    @Override
    public int getItemCount() {
        return mHoles.length;
    }

    public class HoleViewHolder extends RecyclerView.ViewHolder {

        private TextView mHoleLabel,mScoreLabel;
        private Button mPlusButton, mMinusButton;
        private Hole mHole;

        public HoleViewHolder(View itemView) {
            super(itemView);

            mHoleLabel = (TextView) itemView.findViewById(R.id.holeLabel);
            mScoreLabel = (TextView) itemView.findViewById(R.id.scoreLabel);
            mPlusButton = (Button) itemView.findViewById(R.id.plusButton);
            mMinusButton = (Button) itemView.findViewById(R.id.minusButton);

            mPlusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //change the hole score
                    mHole.setScore(mHole.getScore()+1);
                    mScoreLabel.setText(mHole.getScore()+"");
                }
            });

            mMinusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mHole.setScore(mHole.getScore()-1);
                    if (mHole.getScore()<0) {
                        mHole.setScore(0);
                    }
                    mScoreLabel.setText(mHole.getScore()+"");
                }
            });
        }

        public void bind(Hole hole) {
            mHoleLabel.setText("Hole " + hole.getNumber() + ":");
            mScoreLabel.setText(hole.getScore()+"");
            mHole = hole;
        }
    }
}
