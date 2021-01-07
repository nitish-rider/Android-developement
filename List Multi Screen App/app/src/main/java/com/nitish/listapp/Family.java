package com.nitish.listapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Family extends AppCompatActivity {

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
        setContentView(R.layout.activity_family);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Father","Père",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("Mother", "Mère",R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("Brother", "Frère",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("Sister", "Sœur",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("Uncle", "Oncle",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("Aunt", "Tante",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("Grandfather", "Grandfather",R.drawable.family_grandfather,R.raw.family_grandfather));
        words.add(new Word("Grandmother", "Grand-mère",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Word("Wife", "épouse",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word("Child", "Enfant",R.drawable.family_son,R.raw.family_son));

        WordAdapter adapter = new WordAdapter(this, words,R.color.colorNames);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                releaseMediaPlayer();

                Word word=words.get(i);

                mMediaPlayer=MediaPlayer.create(Family.this,word.getAudioResorceId());
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