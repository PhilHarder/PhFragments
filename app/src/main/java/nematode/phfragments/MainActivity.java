package nematode.phfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BlankFragment.MyFragInterface {

    BlankFragment bf1;
    BlankFragment bf2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!= null) return;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        bf1 = new BlankFragment();
        bf2 = new BlankFragment();

        ft.add(R.id.myFL1, bf1);
        ft.add(R.id.myFL2, bf2);
        ft.commit();
    }

   @Override
    public void sendData(String s, String s2) {
       switch (s2){
           case "myFL1}":
               bf2.useData(s);
               break;
           case "myFL2}":
               bf1.useData(s);
               break;
       }
   }
}
