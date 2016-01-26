package up1.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    EditText resultEditText;
    EditText firstOperandEditText;
    EditText secondOperandEditText;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultEditText = (EditText) findViewById(R.id.result);
        firstOperandEditText = (EditText) findViewById(R.id.firstOperand);
        secondOperandEditText = (EditText) findViewById(R.id.secondOperand);
        Button calculateButton = (Button) findViewById(R.id.calculate);
        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int first = 0;
        try {
            first = Integer.parseInt(firstOperandEditText.getText().toString());
        } catch (NumberFormatException e) {
        }

        int second = 0;
        try {
            second = Integer.parseInt(secondOperandEditText.getText().toString());
        } catch (NumberFormatException e) {
        }

        int result = first + second;

        resultEditText.setText(String.valueOf(result));
    }
}
