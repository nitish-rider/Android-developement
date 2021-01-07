package com.nitish.listapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

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
        setContentView(R.layout.activity_phrases);

        final ArrayList<Word> words= new ArrayList<Word>();

        words.add(new Word("Zero","zeh-ro",R.raw.phrase_are_you_coming));
        words.add(new Word("one","un",R.raw.phrase_come_here));
        words.add(new Word("Two","deux",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("Three","trois",R.raw.phrase_im_coming));
        words.add(new Word("Four","quatre",R.raw.phrase_im_feeling_good));
        words.add(new Word("Five","cinq",R.raw.phrase_lets_go));
        words.add(new Word("Six","sees",R.raw.phrase_my_name_is));
        words.add(new Word("Seven","sept",R.raw.phrase_what_is_your_name));
        words.add(new Word("Eight","huit",R.raw.phrase_yes_im_coming));
        words.add(new Word("Nine","neuf",R.raw.phrase_where_are_you_going));

        WordAdapter adapter=new WordAdapter(this,words,R.color.colorVedio);
        ListView listView=(ListView) findViewById(R.id.listvedios);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                releaseMediaPlayer();

                Word word=words.get(i);

                mMediaPlayer=MediaPlayer.create(Phrases.this,word.getAudioResorceId());
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