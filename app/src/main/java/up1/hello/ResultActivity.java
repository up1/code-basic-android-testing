package up1.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    EditText messageEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTextView = (TextView) findViewById(R.id.result);
        messageEditText = (EditText) findViewById(R.id.message);
        Button backButton = (Button) findViewById(R.id.back);

        Intent resultIntent = getIntent();
        String result = resultIntent.getStringExtra("result");
        resultTextView.setText(result);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("back_message", messageEditText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("back_message", messageEditText.getText().toString());
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
