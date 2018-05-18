package kr.or.dgit.it.chapter17_18;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MultiListFragment extends ListFragment {
    private String[] planets;
    private int mLastIndex;
    private boolean mMultiPane;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        planets = getResources().getStringArray(R.array.planet);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.planet,android.R.layout.simple_list_item_activated_1);
        setListAdapter(adapter);

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        if(savedInstanceState != null){
            mLastIndex = savedInstanceState.getInt("lastIndex");
        }

        View descPanel = getActivity().findViewById(R.id.planet_desc);
        if(descPanel != null && descPanel.getVisibility() == View.VISIBLE){
            mMultiPane = true;
            onListItemClick(getListView(),null,mLastIndex,0);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lastIndex",mLastIndex);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mLastIndex = position;
        getListView().setItemChecked(position,true);

        if(mMultiPane){
            FragmentManager fm = getFragmentManager();
            MultiDescFragment mdf = (MultiDescFragment) fm.findFragmentById(R.id.planet_desc);
            if(mdf==null || mdf.mNowIndex != position){
                mdf = MultiDescFragment.newInstance(position);
                fm.beginTransaction().replace(R.id.planet_desc,mdf).commit();
            }
        }else {
            //desc startActivity
            Intent intent = new Intent(getActivity(), MultiDescActivity.class);
            intent.putExtra("selectedIndex", position);
            startActivity(intent);
        }
    }
}
