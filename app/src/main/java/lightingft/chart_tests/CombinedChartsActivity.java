package lightingft.chart_tests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Random;

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
        combinedData = createSampleCombinedData();
        combinedChart.setData(combinedData);
        combinedChart.setMinimumHeight(500);
    }

    /**
     * Returns a sample Combined Data object with Line, Scatter,
     * Bar, Bubble and Candle data.
     * @return  sample CombinedData object instance
     */
    private CombinedData createSampleCombinedData() {
        CombinedData sampleCombinedData = new CombinedData();

        sampleCombinedData.setData(createRandomLineData("Line Data", 5f));

        return sampleCombinedData;
    }

    /**
     * Returns a randomized Line Data object with one LineDataSet
     *
     * Returns values in [0, multiplier] range
     *
     * @param label  label of the Data Set
     * @param multiplier  multiplier of random values.
     * @return Randomized LineData object instance
     */
    public LineData createRandomLineData(String label, float multiplier) {
        Random random = new Random();

        LineDataSet set = new LineDataSet(new ArrayList<Entry>(), label);

        for (int i = 1; i <= 5; ++i) {
            float y = random.nextFloat() * multiplier;
            Entry entry = new Entry(i, y);

            System.out.println(entry.getX() + " " + entry.getY());

            set.addEntryOrdered(entry);
        }

        LineData lineData = new LineData();
        lineData.addDataSet(set);

        return lineData;
    }
}
