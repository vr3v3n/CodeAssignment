package in.varunrana.codeassignment.Acitvities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import in.varunrana.codeassignment.DataHandlers.UserInfoHandler;
import in.varunrana.codeassignment.R;
import in.varunrana.codeassignment.Utils.UtilConstant;
import in.varunrana.codeassignment.Utils.Utils;

/**
 * A login screen that offers login via username/password.
 * <p/>
 * Created by vr3v3n on 07/11/16.
 */

public class LoginActivity extends AppCompatActivity {

    // UI references.
    private EditText mUserNameView;
    private EditText mPasswordView;

    //below field are used in case the authentication is done on server
    private View mProgressView;
    private View mLoginFormView;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;

        //Initialising views
        initViews();
    }


    /**
     * Set up the login from.
     */

    private void initViews() {

        mUserNameView = (EditText) findViewById(R.id.userName);

        /**
         * This is to the other way to implement validation using TextWatcher
         * But I'll recommend using the current way as this can be recursive is some cases. like
         * overriding afterTextChange method

        mUserNameView.addTextChangedListener(new TextValidator(mUserNameView) {
            @Override
            public void validateText(EditText editText, String stringToValidate) {
                // if you are using TextWatcher to validate call the validate function here
                // and set the return type to boolean
                // if true then signInButton.setEnable(true)
            }
        });
         */

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mUserSignInButton = (Button) findViewById(R.id.user_sign_in_button);
        mUserSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    /**
     * Attempts to sign in the account specified by the login form.
     * If there are form errors (invalid username, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        //declare UserInfo Model
        UserInfoHandler handler;


        //check validation
        handler = validateFields();

        if (handler == null)
            return;

        Bundle bundle = new Bundle();
        bundle.putSerializable(UtilConstant.BUNDLE_KEY_USER_MODEL, handler);

        Intent homeIntent =  new Intent(mContext, HomeActivity.class);
        homeIntent.putExtras(bundle);
        startActivity(homeIntent);
    }


    /**
     * This function is used to validate the form field
     * @return
     */
    private UserInfoHandler validateFields() {

        // Reset errors.
        mUserNameView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String userName = mUserNameView.getText().toString();
        String password = mPasswordView.getText().toString();


        //this object will help to request focus
        View focusView = null;
        boolean cancel = false;
        UserInfoHandler handler = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            focusView = mPasswordView;
            cancel = true;

        } else if (!Utils.getInstance().isStringLengthValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid userName address.
        if (TextUtils.isEmpty(userName)) {
            mUserNameView.setError(getString(R.string.error_field_required));
            focusView = mUserNameView;
            cancel = true;

        } else if (!Utils.getInstance().isStringLengthValid(userName)) {
            mUserNameView.setError(getString(R.string.error_invalid_username_length));
            focusView = mUserNameView;
            cancel = true;

        } else if (!Utils.getInstance().isUserNameValid(userName)) {
            mUserNameView.setError(getString(R.string.error_invalid_username));
            focusView = mUserNameView;
            cancel = true;
        }


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();

        } else {
            handler = new UserInfoHandler();
            handler.setUserName(userName);
        }

        return handler;
    }

}

