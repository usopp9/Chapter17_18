package kr.or.dgit.it.chapter17_18;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class SingleDialogFragment extends DialogFragment {
    NoticeSingleDialogLIstener mListener;
    int mSelect;

    public interface NoticeSingleDialogLIstener {
         void onSingleDialogClick(DialogFragment dialog, String res);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (NoticeSingleDialogLIstener) context;
        } catch (ClassCastException e) {
            String msg = " must implement NoticeListDialogLIstener";
            throw new ClassCastException(context.toString() + msg);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(bundle.getString("msg"))
                .setSingleChoiceItems(R.array.fruit, mSelect, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mSelect = which;
            }
        })
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] fruits = getResources().getStringArray(R.array.fruit);
                        mListener.onSingleDialogClick(SingleDialogFragment.this, fruits[mSelect]);
                    }
                }).setNegativeButton("취소", null).create();
    }
}
