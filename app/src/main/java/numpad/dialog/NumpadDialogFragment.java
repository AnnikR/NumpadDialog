package numpad.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

/**
 * Created by Annika on 16.3.2018.
 * Numpad for Snippy's Journey
 */

public class NumpadDialogFragment extends DialogFragment {

    ChoiceListener AnswerListener;

    public interface ChoiceListener {
        void onDialogPositiveClick(DialogFragment dialog);

        void onDialogNegativeClick(DialogFragment dialog);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ChoiceListener) {
            AnswerListener = (ChoiceListener) context;
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        final EditText answerText = new EditText(getActivity());
        answerText.setInputType(InputType.TYPE_CLASS_PHONE);

        dialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //OK button clicked
//                        String answerString = answerText.getText().toString();
                        AnswerListener.onDialogPositiveClick(NumpadDialogFragment.this);
                    }
                });
        dialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Cancel button clicked
                        AnswerListener.onDialogNegativeClick(NumpadDialogFragment.this);
                    }
                });
        dialogBuilder.setView(answerText);
        return dialogBuilder.create();
    }
}
