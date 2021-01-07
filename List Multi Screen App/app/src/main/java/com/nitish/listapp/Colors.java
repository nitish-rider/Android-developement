package com.nitish.listapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        final ArrayList<Word> words= new ArrayList<Word>();

        words.add(new Word("RED","ROUGE",R.drawable.color_red,R.raw.color_red));
        words.add(new Word("Blue","Bleue",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("Yellow","Jaune",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("Green","Verte",R.drawable.color_green,R.raw.color_green));
        words.add(new Word("Violet","Violette",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("indigo","ˈindəˌɡō",R.drawable.color_white,R.raw.color_white));
        words.add(new Word("orange","ˈôrənj",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        words.add(new Word("Black","Noire",R.drawable.color_black,R.raw.color_black));
        WordAdapter adapter=new WordAdapter(this,words,R.color.colorAudio);
        ListView listView=(ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                releaseMediaPlayer();

                Word word=words.get(i);

                mMediaPlayer=MediaPlayer.create(Colors.this,word.getAudioResorceId());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}