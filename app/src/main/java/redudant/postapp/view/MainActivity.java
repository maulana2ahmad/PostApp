package redudant.postapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import redudant.postapp.R;
import redudant.postapp.modul.User;
import redudant.postapp.service.Client;
import redudant.postapp.service.PostAppService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText emailEdittext, passwordEditText;
    private Button submitButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEdittext = (EditText) findViewById(R.id.et_email);
        passwordEditText = (EditText) findViewById(R.id.et_password);

        submitButton = (Button) findViewById(R.id.btn_submit);
        resultTextView = (TextView) findViewById(R.id.tv_result);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                postData();
            }
        });
    }

    private void postData() {

        User user = new User();
        user.setUserEmail(emailEdittext.getText().toString());
        user.setPassWord(passwordEditText.getText().toString());

        Log.i("response", "+++++++++++++++++ befor id: " + user.getId());

        PostAppService postAppService = Client.getServices();

        Call<User> call = postAppService.getResult(user);

        emailEdittext.setText("");
        passwordEditText.setText("");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                User returnedUser = response.body();

                resultTextView.setText("Id Is: " + returnedUser.getId());

                Log.i("response", "++++++++++++++++++= after id: " + returnedUser.getId());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
