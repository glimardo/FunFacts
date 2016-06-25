package com.example.gian.funfacts;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        final TextView factLabel= (TextView) findViewById(R.id.factTextView);
        final Button showFactButton= (Button) findViewById(R.id.showFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String fact = mFactBook.getFact();

                factLabel.setText(fact);

                int color = mColorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
            }

        };

        showFactButton.setOnClickListener(listener);

        String message = "Yay! Our ACtivity was createrd";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        Log.d(TAG,"We're logging from the onCreate() method!");
    }
}
