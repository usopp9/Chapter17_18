package kr.or.dgit.it.chapter17_18;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;

public class MultipleDialogFragment extends DialogFragment {
    NoticeMultipleDialogLIstener mListener;
    ArrayList<Integer> mSelectLists = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (NoticeMultipleDialogLIstener) context;
        } catch (ClassCastException e) {
            String msg = " must implement NoticeMultipleDialogLIstener";
            throw new ClassCastException(context.toString() + msg);
        }
    }

    public interface NoticeMultipleDialogLIstener {
        public void onMultipleDialogClick(DialogFragment dialog, String res);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(bundle.getString("msg"))
                .setMultiChoiceItems(R.array.fruit, null, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    mSelectLists.add(which);
                } else if (mSelectLists.contains(which)) {
                    mSelectLists.remove(which);
                }
            }
        }).setPositiveButton("확인", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String[] fruits = getResources().getStringArray(R.array.fruit);
                StringBuilder sb = new StringBuilder();
                for (int idx : mSelectLists) {
                    sb.append(fruits[idx] + ", ");
                }
                sb.delete(sb.length() - 2, sb.length() - 1);
                mListener.onMultipleDialogClick(MultipleDialogFragment.this, sb.toString());
            }
        }).setNegativeButton("취소", null).create();
    }

}
