package com.example.alex.viewpagertest1;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 2018/5/4.
 */

public class Tab1 extends Fragment {
    ArrayList<String> wordListSearch;
    ListView listViewSearch;
    SearchView searchViewDictionary;
    ListAdapterSearch adapterSearch;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1,container, false);
        wordListSearch =new ArrayList<>();
        wordListSearch.add("abstract");
        wordListSearch.add("airbrush");
        wordListSearch.add("animation");
        wordListSearch.add("architecture");
        listViewSearch =view.findViewById(R.id.listViewSearch);
        adapterSearch = new ListAdapterSearch(this.getActivity(),R.layout.list_item_search, wordListSearch);
        listViewSearch.setAdapter(adapterSearch);
       /* searchViewDictionary = view.findViewById(R.id.searchViewDictionary);
        searchViewDictionary.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("newText",newText);
                adapterSearch.getFilter().filter(newText.toString());

                return false;
            }
        });*/

        listViewSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0){
                    Intent DictionaryItemOnClick = new Intent(view.getContext(),SearchItem.class);
                    DictionaryItemOnClick.putExtra("Word",listViewSearch.getItemAtPosition(position).toString());
                    startActivity(DictionaryItemOnClick);
                }
            }
        });
        return view;
    }
}
