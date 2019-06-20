package lightingft.chart_tests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class CombinedChartsActivity extends AppCompatActivity {

    private CombinedChart combinedChart;
    private CombinedData combinedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combined_charts);

        LinearLayout combinedChartsLayout = findViewById(R.id.combinedChartsLayout);

        initializeCombinedChart();

        combinedChartsLayout.addView(combinedChart);
    }

    /**
     * Initializes a Combined Chart object with Line, Scatter, Bar, Bubble
     * and Candle data.
     */
    private void initializeCombinedChart() {
        combinedChart = new CombinedChart(this);
        combinedData = new CombinedData();
        combinedChart.setData(combinedData);

        combinedChart.setMinimumHeight(500);
    }
}
