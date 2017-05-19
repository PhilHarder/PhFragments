package nematode.phfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class BlankFragment extends Fragment {

    Button b;
    EditText eT;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vi = inflater.inflate(R.layout.fragment_blank, container, false);

        b = (Button) vi.findViewById(R.id.button);
        eT = (EditText) vi.findViewById(R.id.editText);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFragInterface mfiActivity = (MyFragInterface) getActivity();
                //
                // Through trial and error I was able to identify a unique identifier
                // at the end of "String.valueOf(container)"
                // The identifier is the ID of the FrameLayout that the fragment class
                // was instantiated into.
                //
                Log.d("Container ", String.valueOf(container));
                mfiActivity.sendData(eT.getText().toString(), String.valueOf(container).split("/")[1]);
            }
        });
        return vi;
    }

    public void useData(String data){
        eT.setText(data);
    }

    public interface MyFragInterface {
        void sendData(String s, String s2);
    }
}
