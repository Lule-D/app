package com.example.pc.kindakidz;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeechService;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Reading extends AppCompatActivity {

    private TextView resultText;
    TextToSpeech toSpeech;
    int res;
    String a;
    //TextView editText;
    String ttx;
    private Intent f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //resultText = (TextView) findViewById(R.id.textView2);
        //editText = (EditText) findViewById(R.id.txtrd1);
        toSpeech = new TextToSpeech(Reading.this, new TextToSpeech.OnInitListener() {


            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    res = toSpeech.setLanguage(Locale.UK);
                } else {

                }
                Toast.makeText(getApplicationContext(), "This is not suported", Toast.LENGTH_SHORT).show();
            }

            public void TTS(View w) {
                switch (w.getId()) {
                    case R.id.imageButton:
                        if (res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED) {

                            Toast.makeText(getApplicationContext(), "This is not suported", Toast.LENGTH_SHORT).show();
                        } else {
                            ttx = a;
                            toSpeech.speak(ttx, TextToSpeech.QUEUE_FLUSH, null);
                        }

                        break;

                }
            }


            public void onButtonClick(View v) {

                if (v.getId() == R.id.imageButton2) {

                    promptSpeechInput();
                }
            }

            public void promptSpeechInput() {
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "say something NOW");

                try {

                    startActivityForResult(f, 100);
                } catch (ActivityNotFoundException a) {
                    Toast.makeText(Reading.this, "a", Toast.LENGTH_SHORT).show();

                }
            }

            public void onActivityResult(int request_code, int result_code, Intent i) {

                super.onActivityResult(request_code, result_code, i);
                switch (request_code) {
                    case 100:
                        if (result_code == RESULT_OK && i != null) {
                            ArrayList<String> result = i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                            resultText.setText(result.get(0));
                        }
                        break;
                }
            }
        });
    }
}






