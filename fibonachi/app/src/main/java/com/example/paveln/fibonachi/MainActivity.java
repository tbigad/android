package com.example.paveln.fibonachi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

    public static native String stringFibonachiFromJNI(String number);

    public void btnClick(View view) {
        TextView tv = (TextView) findViewById(R.id.sample_text);
        EditText et = (EditText)findViewById(R.id.editNumber);
        String strCatName = et.getText().toString();
        String result = stringFibonachiFromJNI(strCatName);
        tv.setText(result);
    }
}
