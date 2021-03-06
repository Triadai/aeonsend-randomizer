package com.games.boardgames.aeonsend.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.games.boardgames.aeonsend.R;
import com.games.boardgames.aeonsend.cards.MarketSetupCard;
import com.games.boardgames.aeonsend.database.MarketSetupCardList;

/**
 * Created by honza on 14.9.17.
 */

public class MarketListViewAdapter extends BaseAdapter {

    private final Context mContext;
    private final MarketSetupCard[] marketSetupCards;

    public MarketListViewAdapter(Context mContext, MarketSetupCard[] marketSetupCards) {
        this.mContext = mContext;
        this.marketSetupCards = marketSetupCards;
    }

    @Override
    public int getCount() {
        return MarketSetupCardList.getMarketSetupCards().length;
    }

    @Override
    public Object getItem(int i) {
        return marketSetupCards[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MarketSetupCard marketSetupCard = marketSetupCards[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.setup_fragment_listview_item, null);
        }

        final ImageView imageView = convertView.findViewById(R.id.imageMarketSetup);
        final TextView textMarketSetupName = convertView.findViewById(R.id.textMarketSetupName);
        final TextView textGemDistribution = convertView.findViewById(R.id.textGemCardDistribution);
        final TextView textRelicDistribution = convertView.findViewById(R.id.textRelicCardDistribution);
        final TextView textSpellDistribution = convertView.findViewById(R.id.textSpellCardDistribution);


        imageView.setImageResource(marketSetupCard.getImage());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        textMarketSetupName.setText(marketSetupCard.getName());
        textMarketSetupName.setAllCaps(true);
        textMarketSetupName.setTypeface(null, Typeface.BOLD);
        textGemDistribution.setText("Gems: " + MarketSetupCard.toStringPriceRange(MarketSetupCard.mapPriceRangeFromArray(marketSetupCard.getGemsPriceList())));
        textRelicDistribution.setText("Relics: " + MarketSetupCard.toStringPriceRange(MarketSetupCard.mapPriceRangeFromArray(marketSetupCard.getRelicsPriceList())));
        textSpellDistribution.setText("Spells: " + MarketSetupCard.toStringPriceRange(MarketSetupCard.mapPriceRangeFromArray(marketSetupCard.getSpellsPriceList())));

        return convertView;
    }
}
