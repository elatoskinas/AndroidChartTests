package lightingft.chart_tests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout chartLayout = findViewById(R.id.chartLayout);

        chartLayout.addView(createLineChart());
    }

    /**.
     * Creates a sample LineChart
     * @return - sample LineChart object with some data
     */
    public LineChart createLineChart() {
        // Create LineData from one DataSet
        DataSet<Entry> dataSet = new LineDataSet(null, "Entries");
        populateDataSet(dataSet);
        LineData lineData = new LineData((LineDataSet) dataSet);

        // Create the chart itself, set data to created data
        LineChart lineChart = new LineChart(this);
        lineChart.setData(lineData);

        // Set minimum height
        lineChart.setMinimumHeight(500);

        return lineChart;
    }

    /**.
     * Populates the provided Data Set with test values
     * @param dataSet - dataSet to populate
     */
    public void populateDataSet(DataSet<Entry> dataSet) {
        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 1; i <= 10; ++i) {
            Entry entry = new Entry(i, i);
            entries.add(entry);
        }

        dataSet.setValues(entries);
    }
}
