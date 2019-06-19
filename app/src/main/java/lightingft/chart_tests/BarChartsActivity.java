package lightingft.chart_tests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class BarChartsActivity extends AppCompatActivity {

    private BarChart barChartGrouped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_charts);

        LinearLayout barChartLayout = findViewById(R.id.barChartLayout);

        initializeBarChartGrouped();
        barChartLayout.addView(barChartGrouped);
    }

    public void initializeBarChartGrouped() {
        BarData barDataGrouped = new BarData();

        barChartGrouped = new BarChart(this);
        barChartGrouped.setData(barDataGrouped);

        barChartGrouped.setMinimumHeight(500);
    }
}
