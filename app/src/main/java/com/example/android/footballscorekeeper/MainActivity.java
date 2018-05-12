package com.example.android.footballscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA; // holds the total score for team A until reset
    int scoreTeamB; // holds the total score for team B until reset
    int lastTeamA; // holds the last points scored to team A to be able to undo them
    int lastTeamB; // holds the last points scored to team B to be able to undo them

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            scoreTeamA = 0;
            scoreTeamB = 0;
            lastTeamA = 0;
            lastTeamB = 0;
        } else {
            scoreTeamA = savedInstanceState.getInt("scoreOfTeamA", 0);
            scoreTeamB = savedInstanceState.getInt("scoreOfTeamB", 0);
            lastTeamA = savedInstanceState.getInt("lastOfTeamA", 0);
            lastTeamB = savedInstanceState.getInt("lastOfTeamB", 0);
        }

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /* displays the score to the team_a_score view
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /* adds 6 points to score for team A
     */
    public void addSixTeamA(View view) {
        scoreTeamA += 6;
        lastTeamA = 6;
        displayForTeamA(scoreTeamA);
    }

    /* adds 3 points to score for team A
     */
    public void addThreeTeamA(View view) {
        scoreTeamA += 3;
        lastTeamA = 3;
        displayForTeamA(scoreTeamA);
    }

    /* adds 2 points to score for team A
     */
    public void addTwoTeamA(View view) {
        scoreTeamA += 2;
        lastTeamA = 2;
        displayForTeamA(scoreTeamA);
    }

    /* adds 1 points to score for team A
     */
    public void addOneTeamA(View view) {
        scoreTeamA += 1;
        lastTeamA = 1;
        displayForTeamA(scoreTeamA);
    }

    /* removes the last points that were applied to team A
     */
    public void undoTeamA(View view) {
        scoreTeamA -= lastTeamA;
        lastTeamA = 0;
        displayForTeamA(scoreTeamA);
    }

    /* displays the score to the team_b_score view
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /* adds 6 points to score for team B
     */
    public void addSixTeamB(View view) {
        scoreTeamB += 6;
        lastTeamB = 6;
        displayForTeamB(scoreTeamB);
    }

    /* adds 3 points to score for team B
     */
    public void addThreeTeamB(View view) {
        scoreTeamB += 3;
        lastTeamB = 3;
        displayForTeamB(scoreTeamB);
    }

    /* adds 2 points to score for team B
     */
    public void addTwoTeamB(View view) {
        scoreTeamB += 2;
        lastTeamB = 2;
        displayForTeamB(scoreTeamB);
    }

    /* adds 1 points to score for team B
     */
    public void addOneTeamB(View view) {
        scoreTeamB += 1;
        lastTeamB = 1;
        displayForTeamB(scoreTeamB);
    }

    /* removes the last points that were applied to team B
     */
    public void undoTeamB(View view) {
        scoreTeamB -= lastTeamB;
        lastTeamB = 0;
        displayForTeamB(scoreTeamB);
    }

    /* resets the scores and the undo for both teams to 0
     */
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        lastTeamA = 0;
        lastTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }


    /* saves the variables between orientation changes
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreOfTeamA", scoreTeamA);
        outState.putInt("scoreOfTeamB", scoreTeamB);
        outState.putInt("lastOfTeamA", lastTeamA);
        outState.putInt("lastOfTeamB", lastTeamB);
    }
}