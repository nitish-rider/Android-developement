package com.nitish.listapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

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
        setContentView(R.layout.activity_numbers);

        final ArrayList<Word> words= new ArrayList<Word>();

        words.add(new Word("Zero","zeh-ro",R.drawable.number_one,R.raw.number_one));
        words.add(new Word("one","un",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("Two","deux",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("Three","trois",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("Four","quatre",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("Five","cinq",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("Six","sees",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("Seven","sept",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("Eight","huit",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("Nine","neuf",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter adapter=new WordAdapter(this,words,R.color.colorNumbersCatagory);
        ListView listView=(ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                releaseMediaPlayer();

                Word word=words.get(i);

                mMediaPlayer=MediaPlayer.create(Numbers.this,word.getAudioResorceId());
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