package lightingft.chart_tests;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
 * An example Android Activity that demonstrates the 7 charts of
 * MPAndroidChart
 *
 * @author - lightingft
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout chartLayout = findViewById(R.id.chartLayout);

        LineChart lineChart = createLineChart();
        BarChart barChart = createBarChart();
        PieChart pieChart = createPieChart();
        ScatterChart scatterChart = createScatterChart();
        BubbleChart bubbleChart = createBubbleChart();
        RadarChart radarChart = createRadarChart();
        CandleStickChart candleStickChart = createCandleStickChart();

        chartLayout.addView(lineChart);
        chartLayout.addView(barChart);
        chartLayout.addView(pieChart);
        chartLayout.addView(scatterChart);
        chartLayout.addView(bubbleChart);
        chartLayout.addView(radarChart);
        chartLayout.addView(candleStickChart);
    }

    /**.
     * Adds test data set to specified ChartData object
     * @param data - ChartData object
     * @param scalar - Scalar to multiply test entries by
     * @param colors - Chart colors
     */
    public void addDataSetToChartData(ChartData data, int scalar, int... colors) {
        DataSet dataSet = null;

        if (data instanceof LineData)
            dataSet = new LineDataSet(new ArrayList<Entry>(), "Entries");
        else if (data instanceof BarData)
            dataSet = new BarDataSet(new ArrayList<BarEntry>(), "Entries");
        else if (data instanceof PieData)
            dataSet = new PieDataSet(new ArrayList<PieEntry>(), "Entries");
        else if (data instanceof ScatterData)
            dataSet = new ScatterDataSet(new ArrayList<Entry>(), "Entries");
        else if (data instanceof BubbleData)
            dataSet = new BubbleDataSet(new ArrayList<BubbleEntry>(), "Entries");
        else if (data instanceof RadarData)
            dataSet = new RadarDataSet(new ArrayList<RadarEntry>(), "Entries");
        else if (data instanceof CandleData) {
            dataSet = new CandleDataSet(new ArrayList<CandleEntry>(), "Entries");
            initializeCandleDataSet((CandleDataSet)dataSet);
        }

        populateDataSet(dataSet, scalar);
        dataSet.setColors(colors);
        data.addDataSet(dataSet);
    }

    /**.
     * Initializes passed in CandleDataSet instance with test values
     * @param dataSet - CandleDataSet instance
     */
    private void initializeCandleDataSet(CandleDataSet dataSet) {
        // Set Shadow width & color
        dataSet.setShadowWidth(0.5f);
        dataSet.setShadowColor(Color.DKGRAY);

        // Set increasing & decreasing visualization styles
        dataSet.setDecreasingColor(Color.RED);
        dataSet.setDecreasingPaintStyle(Paint.Style.STROKE);
        dataSet.setIncreasingColor(Color.GREEN);
        dataSet.setIncreasingPaintStyle(Paint.Style.FILL);

        // Set neutral value color
        dataSet.setNeutralColor(Color.BLACK);
    }

    /**.
     * Creates a sample LineChart
     * @return - sample LineChart object with test data
     */
    public LineChart createLineChart() {
        // Create new LineChart and set LineData to empty
        LineChart lineChart = new LineChart(this);
        lineChart.setData(new LineData());

        // Add three data sets
        addDataSetToChartData(lineChart.getData(), 1, Color.RED);
        addDataSetToChartData(lineChart.getData(), 2, Color.GREEN);
        addDataSetToChartData(lineChart.getData(), 3, Color.BLUE);

        // Set minimum chart height
        lineChart.setMinimumHeight(500);

        return lineChart;
    }

    /**.
     * Creates a sample BarChart
     * @return - sample BarChart object with test data
     */
    public BarChart createBarChart() {
        // Create new BarChart and set BarData to empty
        BarChart barChart = new BarChart(this);
        barChart.setData(new BarData());

        // Add one new data set
        addDataSetToChartData(barChart.getData(), 1, Color.GREEN);

        // Set minimum chart height
        barChart.setMinimumHeight(500);

        return barChart;
    }

    /**.
     * Creates a sample PieChart
     * @return - sample PieChart object with test data
     */
    public PieChart createPieChart() {
        // Create new PieChart
        PieChart pieChart = new PieChart(this);

        // Create new PieData Object and populate it
        PieData pieData = new PieData();
        addDataSetToChartData(pieData, 1, Color.RED,Color.GREEN,
                Color.BLUE, Color.CYAN, Color.YELLOW, Color.MAGENTA, Color.GRAY, Color.BLACK,
                Color.DKGRAY, Color.LTGRAY);

        pieChart.setDrawEntryLabels(false);

        // Set PieChart data to PieData object
        pieChart.setData(pieData);

        // NOTE that here doing pieChart.setData(new PieData()) does not work,
        // since that simply results in an exception.

        // Set chart minimum height
        pieChart.setMinimumHeight(500);

        return pieChart;
    }

    /**.
     * Creates a sample ScatterChart
     * @return - sample ScatterChart object with test data
     */
    public ScatterChart createScatterChart() {
        // Create new ScatterChart with empty ScatterData object
        ScatterChart scatterChart = new ScatterChart(this);
        scatterChart.setData(new ScatterData());

        // Populate ScatterData
        addDataSetToChartData(scatterChart.getData(), 1, Color.BLACK);

        // Set Chart minimum height
        scatterChart.setMinimumHeight(500);

        return scatterChart;
    }

    /**.
     * Creates a sample BubbleChart
     * @return - sample BubbleChart object with test data
     */
    public BubbleChart createBubbleChart() {
        // Create new BubbleChart with empty BubbleData object
        BubbleChart bubbleChart = new BubbleChart(this);
        bubbleChart.setData(new BubbleData());

        // Populate BubbleData
        addDataSetToChartData(bubbleChart.getData(), 1, Color.MAGENTA);

        // Set Chart minimum height
        bubbleChart.setMinimumHeight(500);

        return bubbleChart;
    }

    /**.
     * Creates a sample RadarChart
     * @return - sample RadarChart object with test data
     */
    public RadarChart createRadarChart() {
        // Create new RadarChart
        RadarChart radarChart = new RadarChart(this);

        // Create new RadarData object and populate it
        RadarData radarData = new RadarData();
        addDataSetToChartData(radarData, 1, Color.BLUE);

        // Set RadarChart data to RadarData object
        radarChart.setData(radarData);

        // Set Chart minimum height
        radarChart.setMinimumHeight(500);

        return radarChart;
    }

    public CandleStickChart createCandleStickChart() {
        // Create new CandleStickChart with empty CandleData object
        CandleStickChart candleStickChart = new CandleStickChart(this);
        candleStickChart.setData(new CandleData());

        // Populate CandleData
        addDataSetToChartData(candleStickChart.getData(), 1, Color.CYAN);

        // Set Charrt minimum height
        candleStickChart.setMinimumHeight(500);

        return candleStickChart;
    }

    /**.
     * Populates the provided Data Set with test values
     * @param dataSet - dataSet to populate
     */
    private void populateDataSet(DataSet dataSet, int scalar) {
        // Create new list of entries
        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 1; i <= 10; ++i) {
            // Define empty Entry object (abstract)
            Entry entry;

            // Check which entry to create by DataSet type
            if (dataSet instanceof BarDataSet)
                entry = new BarEntry(i, scalar*i);
            else if (dataSet instanceof PieDataSet)
                entry = new PieEntry(scalar*i, "#" + i);
            else if (dataSet instanceof RadarDataSet)
                entry = new RadarEntry(i, scalar*i);
            else if (dataSet instanceof BubbleDataSet)
                entry = new BubbleEntry(i*1.0f, i*1.0f, scalar*i*0.5f);
            else if (dataSet instanceof CandleDataSet)
                entry = new CandleEntry(i, i+1, i, i-1, i+4);
            else
                entry = new Entry(i, scalar*i);

            // Add entry to list
            entries.add(entry);
        }

        // Set DataSet to generated entries list
        // (Shows warning here, but it's made sure that entries
        // are of correct type)
        dataSet.setValues(entries);
    }
}
