package threesixty.a15puzzle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Startup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        // load main menu fragment
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        MainMenuFragment MMF = new MainMenuFragment();
        ft.replace(R.id.fragment_container, MMF, null);
        ft.addToBackStack("MMF");
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        // do nothing!
    }
}
