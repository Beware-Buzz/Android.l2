package com.example.user.application2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer trying = 10;
    TextView tvInfo;
    TextView trys;
    EditText etInput;
    Button bControl;
    int number = (int)(Math.random()*100);
    boolean gameFinished = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView)findViewById(R.id.textView3);
        etInput = (EditText)findViewById(R.id.editText);
        bControl = (Button)findViewById(R.id.button);
        trys = (TextView)findViewById(R.id.textView);
        trys.setText(trying.toString());
    }

    public void onClick(View v){
        if (!gameFinished){
            String inStr = etInput.getText().toString();
            try {
                int inp = Integer.parseInt(inStr);
                if (inp < 0 || inp > 100 )
                    tvInfo.setText(getResources().getString(R.string.error));
                else {
                    trying--;
                    if ( trying < 0)
                    {
                        trying = 10;
                        bControl.setText(getResources().getString(R.string.play_more));
                        gameFinished = true;
                        trys.setText(trying.toString());
                    }
                    else {
                        trys.setText(trying.toString());
                        if (inp > number)
                            tvInfo.setText(getResources().getString(R.string.ahead));
                        if (inp < number)
                            tvInfo.setText(getResources().getString(R.string.behind));
                        if (inp == number) {
                            tvInfo.setText(getResources().getString(R.string.hit));
                            bControl.setText(getResources().getString(R.string.play_more));
                            gameFinished = true;
                        }
                    }
                }
            }
            catch (Throwable t)
            {
                tvInfo.setText(getResources().getString(R.string.error));
            }
        }
        else
        {
            trying = 10;
            number = (int)(Math.random()*100);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
        etInput.setText("");

    }

}
