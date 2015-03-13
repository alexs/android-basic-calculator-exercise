package com.github.alexs.basiccalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    EditText numberInput;
    Button btnSum;
    Button btnEqual;
    Button reset;
    double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSum = (Button) findViewById(R.id.btnAdd);
        btnSum.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                try{
                    numberInput = (EditText)findViewById(R.id.mainField);
                    String numberStr = numberInput.getText().toString();
                    result = Double.parseDouble(numberStr) + result;
                    numberInput.setText("");
                }
                catch (Exception e){
                    Toast.makeText(v.getContext(), e.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        btnEqual = (Button) findViewById(R.id.btnResult);
        btnEqual.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                try{
                    numberInput = (EditText)findViewById(R.id.mainField);
                    String numberStr = numberInput.getText().toString();
                    result = Double.parseDouble(numberStr) + result;
                    numberInput.setText( String.valueOf(result) );
                }catch(Exception e){
                    Toast.makeText(v.getContext(),e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });

        reset = (Button) findViewById(R.id.resetButton);
        reset.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                try{
                    result = 0;
                    numberInput.setText("");
                }catch(Exception e){
                    Toast.makeText(v.getContext(),e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
