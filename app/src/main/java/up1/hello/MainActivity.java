package up1.hello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import up1.hello.data.CounterParcelable;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static final String TAG = MainActivity.class.getName();
    public static final String COUNTER = "counter";

    TextView resultEditText;
    EditText firstOperandEditText;
    EditText secondOperandEditText;
    Button calculateButton;
    RadioGroup operator;
    TextView counterTextView;
    TextView messageTextView;


    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);
        initialUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");

        CounterParcelable counterParcelable = new CounterParcelable();
        counterParcelable.count = counter;
        outState.putParcelable(COUNTER, counterParcelable);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");

        CounterParcelable counterParcelable = savedInstanceState.getParcelable(COUNTER);
        counter = counterParcelable.count;
        showCounter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }


    private void initialUI() {
        resultEditText = (TextView) findViewById(R.id.result);
        firstOperandEditText = (EditText) findViewById(R.id.firstOperand);
        secondOperandEditText = (EditText) findViewById(R.id.secondOperand);
        calculateButton = (Button) findViewById(R.id.calculate);
        operator = (RadioGroup) findViewById(R.id.operator);
        counterTextView = (TextView) findViewById(R.id.counter);
        messageTextView = (TextView) findViewById(R.id.message);
        calculateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (validateInput()) {
            calculate();
            showCounter();
        }
    }

    private void showCounter() {
        counter++;
        counterTextView.setText(String.format("Counter is %d", counter));
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

        //Send data to result activity
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", result);

        startActivityForResult(intent, 9999);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 9999) {
            if(resultCode == RESULT_OK) {
                String message = data.getStringExtra("message");
                messageTextView.setText(message);
            }
        }
    }

















}
