package it.alessandrocucci.cardrecyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import junit.framework.Assert;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    String title = "Card RecyclerView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            toolbar.setTitle(title);
            setSupportActionBar(toolbar);
        }

        RecyclerView recyclerList = (RecyclerView) findViewById(R.id.cardList);
        recyclerList.setHasFixedSize(true);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerList.setLayoutManager(layout);

        CardAdapter cardadapt = new CardAdapter(createList(10));
        recyclerList.setAdapter(cardadapt);

    }

    private List<CardInfo> createList(int size) {

        List<CardInfo> result = new ArrayList<CardInfo>();
        for (int i=1; i <= size; i++) {
            CardInfo card = new CardInfo();
            card.name = CardInfo.NAME_PREFIX + i;
            String Imageid = "image" + i;
            card.image = getDrawable(this, Imageid);
            result.add(card);

        }

        return result;
    }

    public static int getDrawable(Context context, String name)
    {
        Assert.assertNotNull(context);
        Assert.assertNotNull(name);

        return context.getResources().getIdentifier(name,
                "drawable", context.getPackageName());
    }

}
