package mollie.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Intent mGameOptionsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mGameOptionsIntent = new Intent(MenuActivity.this, SmallBoardActivity.class);
        setPlayButton();
    }

    private void setPlayButton() {
        Button playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(view -> startActivity(mGameOptionsIntent));
    }

    public void onRadioButtonClicked(View view) {
        mGameOptionsIntent = RadioButtonOptions.getIntentForGameOptions(view, mGameOptionsIntent);
    }

    public void onBoardSizeSelected(View view) {
        mGameOptionsIntent = RadioButtonOptions.formatIntentForBoardOptions(view, mGameOptionsIntent, this);
    }
}
