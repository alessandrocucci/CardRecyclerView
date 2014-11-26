/*
 * Copyright (C) 2014 Francesco Azzola
 *  Surviving with Android (http://www.survivingwithandroid.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package it.alessandrocucci.cardrecyclerview;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {


    private List<CardInfo> cardList;

    public CardAdapter(List<CardInfo> cardList) {

        this.cardList = cardList;
    }


    @Override
    public int getItemCount() {

        return cardList.size();
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int i) {
        CardInfo ci = cardList.get(i);
        cardViewHolder.vName.setText(ci.name);
        cardViewHolder.vName.setTextColor(Color.BLACK);
        cardViewHolder.vImage.setImageResource(ci.image);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.
            from(viewGroup.getContext()).
            inflate(R.layout.card, viewGroup, false);
        Animation animation = AnimationUtils.loadAnimation(viewGroup.getContext(), (R.anim.slide_up));
        itemView.startAnimation(animation);

        return new CardViewHolder(itemView);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected ImageView vImage;

        public CardViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.textView);
            vImage = (ImageView) v.findViewById(R.id.image);
        }
    }
}
