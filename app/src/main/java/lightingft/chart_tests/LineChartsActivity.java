package lightingft.chart_tests;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class LineChartsActivity extends AppCompatActivity {

    private LineChart areaChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_charts);

        LinearLayout barChartLayout = findViewById(R.id.lineChartlayout);

        initializeAreaChart();

        barChartLayout.addView(areaChart);
    }

    private void initializeAreaChart() {
        areaChart = new LineChart(this);

        LineData data = new LineData();

        areaChart.setData(data);

        LineDataSet set1 = new LineDataSet(new ArrayList<Entry>(), "Data1");
        LineDataSet set2 = new LineDataSet(new ArrayList<Entry>(), "Data2");
        set1.setDrawFilled(true);
        set1.setColor(Color.BLUE);
        set1.setFillColor(Color.BLUE);
        set2.setDrawFilled(true);
        set2.setColor(Color.RED);
        set2.setFillColor(Color.RED);

        set1.addEntryOrdered(new Entry(1f, 1f));
        set1.addEntryOrdered(new Entry(2f, 2f));
        set1.addEntryOrdered(new Entry(0f, 5f));
        data.addDataSet(set1);

        set2.addEntryOrdered(new Entry(1f, 5f));
        set2.addEntryOrdered(new Entry(3f, 7f));
        data.addDataSet(set2);

        // Set minimum height for the Bar Chart
        areaChart.setMinimumHeight(500);
        areaChart.notifyDataSetChanged();
    }
}
