package lightingft.chart_tests;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.StackedValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Arrays;

public class BarChartsActivity extends AppCompatActivity {

    private BarChart barChartGrouped;
    private BarChart barChartStacked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_charts);

        LinearLayout barChartLayout = findViewById(R.id.barChartLayout);

        initializeBarChartGrouped();
        initializeBarChartStacked();

        barChartLayout.addView(barChartGrouped);
        barChartLayout.addView(barChartStacked);
    }

    private void initializeBarChartGrouped() {
        final int entryCount = 5;
        final float groupSpace = 0.1f;
        final float barSpace = 0.0f;

        // Instantiate BarData and BarDataSet objects
        BarData barDataGrouped = new BarData();
        BarDataSet set1 = new BarDataSet(new ArrayList<BarEntry>(), "Data 1");
        BarDataSet set2 = new BarDataSet(new ArrayList<BarEntry>(), "Data 2");
        BarDataSet set3 = new BarDataSet(new ArrayList<BarEntry>(), "Data 3");

        // Set colors for the BarDataSets
        set1.setColors(Color.RED);
        set2.setColors(Color.BLUE);
        set3.setColors(Color.MAGENTA);

        // Add 4 entries with varying y values
        for (int i = 0; i < entryCount; ++i) {
            set1.addEntry(new BarEntry(i, i+2));
            set2.addEntry(new BarEntry(i, i+1));
            set3.addEntry(new BarEntry(i, i+3));
        }

        // Add the Data Sets
        barDataGrouped.addDataSet(set1);
        barDataGrouped.addDataSet(set2);
        barDataGrouped.addDataSet(set3);

        barDataGrouped.groupBars(0f, groupSpace, barSpace);

        // Create the Bar Chart & set the Data
        barChartGrouped = new BarChart(this);
        barChartGrouped.setData(barDataGrouped);

        // Set minimum height for the Bar Chart
        barChartGrouped.setMinimumHeight(500);

        barChartGrouped.getXAxis().setAxisMinimum(0f);
        barChartGrouped.getXAxis().setAxisMaximum(0 + barDataGrouped.getGroupWidth(groupSpace, barSpace) * entryCount);

        barChartGrouped.invalidate();
    }

    private void initializeBarChartStacked() {
        // Instantiate BarData and BarDataSet objects
        BarData barDataStacked = new BarData();
        BarDataSet set = new BarDataSet(new ArrayList<BarEntry>(), "Data");

        barDataStacked.addDataSet(set);

        // Create the Bar Chart & set the Data
        barChartStacked = new BarChart(this);
        barChartStacked.setData(barDataStacked);

        // Set minimum height for the Bar Chart
        barChartStacked.setMinimumHeight(500);
        barChartStacked.invalidate();
    }
}
