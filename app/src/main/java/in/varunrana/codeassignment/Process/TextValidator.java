package in.varunrana.codeassignment.Process;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by vr3v3n on 07/11/16.
 */
public abstract class TextValidator implements TextWatcher {

    private final EditText mEditText;

    public TextValidator(EditText mEditText) {
        this.mEditText = mEditText;
    }

    public abstract void validateText(EditText editText, String stringToValidate);

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
