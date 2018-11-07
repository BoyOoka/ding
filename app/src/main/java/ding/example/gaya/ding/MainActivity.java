package ding.example.gaya.ding;

import android.app.Instrumentation;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        try{
        Thread.sleep(2000);
        }catch (Exception e){

        }

        CommandExecution.execCommand("nohup am instrument -w -r -e debug false -e class ding.example.gaya.ding.ExampleInstrumentedTest#daka ding.example.gaya.ding.test/android.support.test.runner.AndroidJUnitRunner",true);
    }
    /**
     * 点击按钮对应的方法
     * @param v
     */
    public void runMyUiautomator(View v)throws IOException{
//        new UiautomatorThread().start();
        Log.e("test","test");
        CommandExecution.execCommand("nohup am instrument -w -r -e debug false -e class ding.example.gaya.ding.ExampleInstrumentedTest#daka ding.example.gaya.ding.test/android.support.test.runner.AndroidJUnitRunner",true);
//        execCommand("nohup am instrument -w -r -e debug false -e class ding.example.gaya.ding.ExampleInstrumentedTest#daka ding.example.gaya.ding.test/android.support.test.runner.AndroidJUnitRunner",true);

    }
}
