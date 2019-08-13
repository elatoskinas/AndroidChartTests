package lightingft.chart_tests;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**.
 * The main activity that provides navigation to all the other
 * example activities.
 *
 * @author - lightingft
 */
public class MainActivity extends AppCompatActivity {

    private Button allChartsButton;
    private Button barChartsButton;
    private Button combinedChartsButton;
    private Button pieChartsButton;
    private Button lineChartsButton;
    private Button dynamicChartsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allChartsButton = findViewById(R.id.allChartsButton);
        barChartsButton = findViewById(R.id.barChartsButton);
        combinedChartsButton = findViewById(R.id.combinedChartsButton);
        pieChartsButton = findViewById(R.id.pieChartsButton);
        lineChartsButton = findViewById(R.id.lineChartsButton);
        dynamicChartsButton = findViewById(R.id.dynamicChartsButton);

        allChartsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to All Charts Activity
                goToActivity(AllChartsActivity.class);
            }
        });

        barChartsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to Bar Charts Activity
                goToActivity(BarChartsActivity.class);
            }
        });

        combinedChartsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to Combined Charts Activity
                goToActivity(CombinedChartsActivity.class);
            }
        });

        pieChartsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to Pie Charts Activity
                goToActivity(PieChartsActivity.class);
            }
        });

        lineChartsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to Line Charts Activity
                goToActivity(LineChartsActivity.class);
            }
        });

        dynamicChartsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to Dynamic Charts Activity
                goToActivity(DynamicChartsActivity.class);
            }
        });
    }

    private void goToActivity(Class activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }
}
