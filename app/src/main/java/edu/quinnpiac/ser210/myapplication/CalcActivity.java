package edu.quinnpiac.ser210.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {
    //move here to be able to access in performop()
     EditText input1;
     EditText input2;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        res = (TextView) findViewById(R.id.result);
        Button add = (Button)findViewById(R.id.addition);

                Spinner opSpinner = (Spinner) findViewById(R.id.spinner);
                opSpinner.setSelection(0,false);
                opSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        String operation = (String) adapterView.getItemAtPosition(i);
                        if (operation.equals("*")){
                            performOp('*');
                        }
                        if (operation.equals("/")) {
                            performOp('/');
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        performOp('+');
                    }
                });

    }
    // handling event subtract as defined in activity_calc.xml
    public void subtract(View v){
        performOp('-');
    }
    private void performOp(char op){
        Log.v("Debug","method performOp called");
        if ((input1.getText() != null) && (input2.getText() != null) ) {

            // read from input1 and input2
            double num1 = Double.valueOf(input1.getText().toString());
            double num2 = Double.valueOf(input2.getText().toString());

            Log.v("Debug", "num 1 " + num1 + "num 2" + num2);
            double result = 0;

            // peform operation the two values

            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;

            }
            //update the value of text in the result textView
            res.setText(Double.toString(result));
        }
    }
}
