package kr.or.dgit.it.chapter17_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WebViewFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_fragment);
        FragmentWeb webfg = new FragmentWeb();
        getFragmentManager().beginTransaction().add(R.id.frame,webfg).commit();
    }
}
