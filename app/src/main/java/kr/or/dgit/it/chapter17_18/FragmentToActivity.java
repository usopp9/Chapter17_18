package kr.or.dgit.it.chapter17_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FragmentToActivity extends AppCompatActivity {
    EditText et;
    private int start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to);
        setTitle(getIntent().getStringExtra("title"));

        et = findViewById(R.id.editStartNum);
    }

    public void btnPushClick(View view) {
        start += Integer.parseInt(et.getText().toString());
        CountFragment cf = CountFragment.newInstance(start);
        getSupportFragmentManager().beginTransaction().add(R.id.frame,cf,"counterFrag").addToBackStack(null).commit();

    }
}
