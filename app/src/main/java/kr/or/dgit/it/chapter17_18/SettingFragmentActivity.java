package kr.or.dgit.it.chapter17_18;

import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SettingFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_fragment);
        setTitle(getIntent().getStringExtra("title"));

        FragmentPref perfFragment = new FragmentPref();
        getFragmentManager().beginTransaction().add(R.id.frame, perfFragment).commit();
    }

    public static class FragmentPref extends PreferenceFragment {

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            addPreferencesFromResource(R.xml.settings_preference);
        }
    }
}