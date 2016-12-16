package threesixty.a15puzzle;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainMenuFragment extends Fragment {
    private Button playButton;
    private Button setupButton;



    public MainMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        //set the buttons
        playButton = (Button)view.findViewById(R.id.playButton);
        setupButton = (Button)view.findViewById(R.id.setupButton);


        // set on click listeners
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Game.class);
                startActivity(i);

            }
        });

        setupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Setup.class));
            }
        });



        // Inflate the layout for this fragment
        return view;
    }



}
