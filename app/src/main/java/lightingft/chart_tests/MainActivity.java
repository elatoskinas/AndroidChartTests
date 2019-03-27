package lightingft.chart_tests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout chartLayout = findViewById(R.id.chartLayout);

        chartLayout.addView(createLineChart());
        chartLayout.addView(createBarChart());
        chartLayout.addView(createPieChart());
    }

    /**.
     * Creates a sample LineChart
     * @return - sample LineChart object with test data
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
     * Creates a sample BarChart
     * @return - sample BarChart object with test data
     */
    public BarChart createBarChart() {
        // Create BarData from one DataSet
        DataSet<BarEntry> dataSet = new BarDataSet(new ArrayList<BarEntry>(), "Entries");
        populateDataSet(dataSet);
        BarData barData = new BarData((BarDataSet) dataSet);

        BarChart barChart = new BarChart(this);
        barChart.setData(barData);

        barChart.setMinimumHeight(500);

        return barChart;
    }

    public PieChart createPieChart() {
        // Creates PieData from one DataSet
        DataSet<PieEntry> dataSet = new PieDataSet(new ArrayList<PieEntry>(), "Entries");
        populateDataSet(dataSet);
        PieData pieData = new PieData((PieDataSet)dataSet);

        PieChart pieChart = new PieChart(this);
        pieChart.setData(pieData);

        pieChart.setMinimumHeight(500);

        return pieChart;
    }

    /**.
     * Populates the provided Data Set with test values
     * @param dataSet - dataSet to populate
     */
    public void populateDataSet(DataSet dataSet) {
        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 1; i <= 10; ++i) {
            Entry entry;

            if (dataSet instanceof BarDataSet)
                entry = new BarEntry(i, i);
            else if (dataSet instanceof PieDataSet)
                entry = new PieEntry(i, i);
            else
                entry = new Entry(i, i);

            entries.add(entry);
        }

        dataSet.setValues(entries);
    }
}
