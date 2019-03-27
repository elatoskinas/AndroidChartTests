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
import com.github.mikephil.charting.data.ChartData;
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
     * Initializes specified chart with specified data with test data
     * @param chart - Chart to initialize
     * @param chartData - Chart Data to populate
     */
    public void initializeSampleChart(Chart chart, ChartData chartData) {
        DataSet dataSet = null;

        if (chart instanceof LineChart)
            dataSet = new LineDataSet(new ArrayList<Entry>(), "Entries");
        else if (chart instanceof BarChart)
            dataSet = new BarDataSet(new ArrayList<BarEntry>(), "Entries");
        else if (chart instanceof PieChart)
            dataSet = new PieDataSet(new ArrayList<PieEntry>(), "Entries");

        populateDataSet(dataSet);
        chartData.addDataSet(dataSet);
        chart.setData(chartData);
        chart.setMinimumHeight(500);
    }

    /**.
     * Creates a sample LineChart
     * @return - sample LineChart object with test data
     */
    public LineChart createLineChart() {
        LineChart lineChart = new LineChart(this);
        LineData data = new LineData();
        initializeSampleChart(lineChart, data);

        return lineChart;
    }

    /**.
     * Creates a sample BarChart
     * @return - sample BarChart object with test data
     */
    public BarChart createBarChart() {
        BarChart barChart = new BarChart(this);
        BarData data = new BarData();
        initializeSampleChart(barChart, data);

        return barChart;
    }

    /**.
     * Creates a sample PieChart
     * @return - sample PieChart object with test data
     */
    public PieChart createPieChart() {
        PieChart pieChart = new PieChart(this);
        PieData data = new PieData();
        initializeSampleChart(pieChart, data);

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
