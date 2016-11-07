package in.varunrana.codeassignment.Acitvities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import in.varunrana.codeassignment.DataHandlers.UserInfoHandler;
import in.varunrana.codeassignment.R;
import in.varunrana.codeassignment.Utils.UtilConstant;

public class HomeActivity extends AppCompatActivity {

    TextView welcomeMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        initViews();

        //this to get a Serializable model from intent
        // Can use other ways to get the data
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        intialiseViewWithValues(bundle);

    }

    // this is to set the UI part
    private void initViews(){

        welcomeMsg = (TextView) findViewById(R.id.welcomeMsg);

    }


    private void intialiseViewWithValues(Bundle bundle){

        if(bundle == null)
            return;


         UserInfoHandler model = (UserInfoHandler)
                bundle.getSerializable(UtilConstant.BUNDLE_KEY_USER_MODEL);

        welcomeMsg.setText(getString(R.string.msg_welcome)+ model.getUserName());
    }
}
