package lightingft.chart_tests;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;

import java.util.ArrayList;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        allChartsButton = findViewById(R.id.allChartsButton);
        barChartsButton = findViewById(R.id.barChartsButton);
        combinedChartsButton = findViewById(R.id.combinedChartsButton);

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
    }

    private void goToActivity(Class activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }
}
