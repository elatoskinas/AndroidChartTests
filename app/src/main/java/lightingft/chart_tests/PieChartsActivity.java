package lightingft.chart_tests;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PieChartsActivity extends AppCompatActivity {

    PieChart mainPieChart;
    List<PieChart> charts;
    RelativeLayout chartLayout;

    Button addPieChartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_charts);

        charts = new ArrayList<PieChart>();

        chartLayout = findViewById(R.id.pieChartLayout);

        initializeMainPieChart();
        chartLayout.addView(mainPieChart);

        addPieChartButton = findViewById(R.id.addInnerPieChartButton);

        addPieChartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addInnerPieChart();
            }
        });
    }

    private void initializeMainPieChart() {
        mainPieChart = createPieChart();

        // Set width and height of the Pie Chart to 1000
        mainPieChart.setLayoutParams(new PieChart.LayoutParams(1000, 1000));

        charts.add(mainPieChart);
    }

    private void addInnerPieChart() {
        // Get the last chart in the charts list
        PieChart lastChart = charts.get(charts.size() - 1);

        // Re-scale hole radius of the last Chart to fit new Chart
        lastChart.setHoleRadius(75f);
        lastChart.setTransparentCircleRadius(75f);
        lastChart.invalidate();

        // Compute new width and height of the new Inner Chart
        int width = (int)(lastChart.getWidth() * 0.75f);
        int height = (int)(lastChart.getHeight() * 0.75f);

        // Create new inner Chart, add it to the Chart Layout
        PieChart innerChart = createPieChart();
        chartLayout.addView(innerChart);

        // Center & set the width and height parameters of the Inner Chart
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)innerChart
                .getLayoutParams();
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        params.width = width;
        params.height = height;
        innerChart.setLayoutParams(params);

        // Add Inner Chart to charts list
        charts.add(innerChart);
    }

    private PieChart createPieChart() {
        PieChart chart = new PieChart(this);

        // Create and populate PieDataSet
        PieDataSet pieDataSet = new PieDataSet(new ArrayList<PieEntry>(), "Data");
        pieDataSet.addEntry(new PieEntry(100f));
        pieDataSet.addEntry(new PieEntry(50f));
        pieDataSet.addEntry(new PieEntry(25f));

        // Set random colors for the 3 entries of the PieDataSet
        pieDataSet.setColors(getRandomColor(), getRandomColor(), getRandomColor());

        // Set Data Set to PieData; Set PieData to Chart
        PieData pieData = new PieData();
        pieData.setDataSet(pieDataSet);
        chart.setData(pieData);

        // Disable legend and description
        chart.getLegend().setEnabled(false);
        chart.getDescription().setEnabled(false);

        return chart;
    }

    private int getRandomColor() {
        Random random = new Random();

        int red = random.nextInt();
        int blue = random.nextInt();
        int green = random.nextInt();

        return Color.rgb(red, green, blue);
    }
}
