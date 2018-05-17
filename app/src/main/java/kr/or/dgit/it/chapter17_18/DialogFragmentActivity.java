package kr.or.dgit.it.chapter17_18;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

public class DialogFragmentActivity extends AppCompatActivity implements QuestionDialogFragment.NoticeDialogListener,
        ListDialogFragment.NoticeListDialogLIstener,
        SingleDialogFragment.NoticeSingleDialogLIstener,
        MultipleDialogFragment.NoticeMultipleDialogLIstener,
        CustomDialogFragment.NoticeCustomDialogLIstener{
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);
        setTitle(getIntent().getStringExtra("title"));
        tv = findViewById(R.id.tvResult);
    }

    @Override
    public void onDialogClick(DialogFragment dialog, int res) {
        tv.setText("연산 결과=" + res);
        Toast.makeText(this, "연산을 완료하였습니다.", Toast.LENGTH_SHORT).show();
    }

    public void mOpenDlgClick(View view) {
        QuestionDialogFragment newFragment = new QuestionDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", "질문");
        bundle.putString("msg", "어떤 연산을 하시겠습니까?");
        bundle.putString("Q1", "덧셈");
        bundle.putString("Q2", "곱셈");
        bundle.putInt("a", 3);
        bundle.putInt("b", 4);
        newFragment.setArguments(bundle);
        newFragment.show(getSupportFragmentManager(), "Dialog");
    }


    @Override
    public void onDialogClick(DialogFragment dialog, String res) {
        tv.setText("선택 음식=" + res);
        Toast.makeText(this, "선택 음식을 선택하였습니다.", Toast.LENGTH_SHORT).show();
    }

    public void mOpenListClick(View view) {
        ListDialogFragment  newFragment = new ListDialogFragment ();
        Bundle bundle = new Bundle();
        bundle.putString("msg", "음식을 선택하시오");

        newFragment.setArguments(bundle);
        newFragment.show(getSupportFragmentManager(), "Dialog");
    }

    public void mOpenSingleChoiceClick(View view) {
        SingleDialogFragment  newFragment = new SingleDialogFragment ();
        Bundle bundle = new Bundle();
        bundle.putString("msg", "음식을 선택하시오");

        newFragment.setArguments(bundle);
        newFragment.show(getSupportFragmentManager(), "Dialog");
    }

    @Override
    public void onSingleDialogClick(DialogFragment dialog, String res) {
        tv.setText("선택 음식=" + res);
        Toast.makeText(this, "선택 음식을 선택하였습니다.", Toast.LENGTH_SHORT).show();
    }

    public void mOpenMultiChoiceClick(View view) {
        MultipleDialogFragment  newFragment = new MultipleDialogFragment ();
        Bundle bundle = new Bundle();
        bundle.putString("msg", "음식을 선택하시오");

        newFragment.setArguments(bundle);
        newFragment.show(getSupportFragmentManager(), "Dialog");
    }

    @Override
    public void onMultipleDialogClick(DialogFragment dialog, String res) {
        tv.setText("선택 음식=" + res);
        Toast.makeText(this, "선택 음식을 선택하였습니다.", Toast.LENGTH_SHORT).show();
    }

    public void mOpenCustomChoiceClick(View view) {
        CustomDialogFragment  newFragment = new CustomDialogFragment ();
        Bundle bundle = new Bundle();
        bundle.putString("msg", "주문정보를 입력하시오");

        newFragment.setArguments(bundle);
        newFragment.show(getSupportFragmentManager(), "Dialog");
    }

    @Override
    public void onCustomDialogClick(DialogFragment dialog, String res) {
        tv.setText("주문 결과=" + res);
        Toast.makeText(this, res +" 선택하였습니다.", Toast.LENGTH_SHORT).show();
    }
}
