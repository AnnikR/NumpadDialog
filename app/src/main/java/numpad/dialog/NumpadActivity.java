package numpad.dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NumpadActivity extends AppCompatActivity implements NumpadDialogFragment.ChoiceListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void startDialog_clicked(View v)
    {
        NumpadDialogFragment dialog = new NumpadDialogFragment();
        dialog.show(getFragmentManager(), "AnswerDia");
    }

    public void onDialogPositiveClick(android.app.DialogFragment dialog){
        Toast.makeText(getBaseContext(), "OK clicked", Toast.LENGTH_SHORT).show();
    }
    public void onDialogNegativeClick(android.app.DialogFragment dialog){
        Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
    }
}
