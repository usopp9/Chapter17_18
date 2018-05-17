package kr.or.dgit.it.chapter17_18;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CountFragment extends Fragment {

    public static CountFragment newInstance(int start){
        CountFragment cf = new CountFragment();
        Bundle args = new Bundle();
        args.putInt("start",start);
        cf.setArguments(args);
        return cf;
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        final TextView cntTextView = getView().findViewById(R.id.txtCounter);
        int data = Integer.parseInt(cntTextView.getText().toString());
        outState.putInt("count",data);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_count,container,false);
        final TextView cntTextView = root.findViewById(R.id.txtCounter);
        if(savedInstanceState !=null){
            cntTextView.setText(String.valueOf(savedInstanceState.getInt("count")));
        }
        Bundle args = getArguments();
        if(args !=null){
            int start = args.getInt("start");
            cntTextView.setText(String.valueOf(start));
        }
        Button btnincrease = root.findViewById(R.id.btnincrease);
        btnincrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.parseInt(cntTextView.getText().toString());
                cntTextView.setText(String.valueOf(count+1));
            }
        });
        return root;
    }
}
