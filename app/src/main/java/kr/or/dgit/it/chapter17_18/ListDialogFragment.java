package kr.or.dgit.it.chapter17_18;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class ListDialogFragment extends DialogFragment {
    NoticeListDialogLIstener mListener;

    public interface NoticeListDialogLIstener {
         void onDialogClick(DialogFragment dialog, String res);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (NoticeListDialogLIstener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement NoticeListDialogLIstener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(bundle.getString("msg"))
                .setItems(R.array.fruit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String[] fruits = getResources().getStringArray(R.array.fruit);
                mListener.onDialogClick(ListDialogFragment.this, fruits[which]);
            }
        }).setNegativeButton("취소", null).create();
    }
}
