package up1.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTextView = (TextView) findViewById(R.id.result);

        Intent resultIntent = getIntent();
        String result = resultIntent.getStringExtra("result");
        resultTextView.setText(result);

    }
}
