package up1.hello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    EditText resultEditText;
    EditText firstOperandEditText;
    EditText secondOperandEditText;
    Button calculateButton;
    RadioGroup operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialUI();
    }

    private void initialUI() {
        resultEditText = (EditText) findViewById(R.id.result);
        firstOperandEditText = (EditText) findViewById(R.id.firstOperand);
        secondOperandEditText = (EditText) findViewById(R.id.secondOperand);
        calculateButton = (Button) findViewById(R.id.calculate);
        operator = (RadioGroup) findViewById(R.id.operator);
        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (validateInput()) {
            calculate();
        }
    }

    private boolean validateInput() {
        boolean isValid = true;
        if (firstOperandEditText.getText().toString().isEmpty()) {
            firstOperandEditText.setError("Please fill in data");
            isValid = false;
        }
        if (secondOperandEditText.getText().toString().isEmpty()) {
            secondOperandEditText.setError("Please fill in data");
            isValid = false;
        }
        return isValid;
    }

    private void calculate() {
        int first = Integer.parseInt(firstOperandEditText.getText().toString());
        int second = Integer.parseInt(secondOperandEditText.getText().toString());

        String result = "NaN";
        switch (operator.getCheckedRadioButtonId()) {
            case R.id.plus:
                result = String.valueOf(first + second);
                break;
            case R.id.minus:
                result = String.valueOf(first - second);
                break;
            case R.id.multiply:
                result = String.valueOf(first * second);
                break;
            case R.id.divide:
                if(second != 0) {
                    result = String.valueOf(first / second);
                }
                break;
        }

        resultEditText.setText(result);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }
}
