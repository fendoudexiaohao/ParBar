package songzhihao.bwei.com.parbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyView circleView;
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleView = (MyView) findViewById(R.id.circleView);
    }

    public void start(View v) {
        // 1000公里
        circleView.setMax(100);
        progress=0;
        new Thread() {
            public void run() {
                while (true) {
                    progress = progress + 1;
                    String text = progress + "%";
                    circleView.setProgressAndText(progress, text);
                    try {
                        sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (progress == 100) {
                        break;
                    }
                }
            };
        }.start();
    }

    public void chong(View v){
        // 1000公里
        circleView.setMax(100);
        progress=0;
        new Thread() {
            public void run() {
                while (true) {
                    progress = progress + 0;
                    String text = progress + "";
                    circleView.setProgressAndText(progress, text);
                    try {
                        sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (progress == 0) {
                        break;
                    }
                }
            };
        }.start();
    }
}
