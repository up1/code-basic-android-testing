package up1.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    public static final String RESULT = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Get data from intent
        Intent resultIntent = getIntent();
        TextView textView = (TextView) findViewById(R.id.result);
        textView.setText(resultIntent.getStringExtra(RESULT));

        final EditText messageEditext = (EditText) findViewById(R.id.message);

        Button backButton = (Button) findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("message", messageEditext.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
