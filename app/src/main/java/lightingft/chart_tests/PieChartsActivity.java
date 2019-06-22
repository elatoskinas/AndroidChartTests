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

        mainPieChart.setMinimumHeight(1000);
        mainPieChart.setMinimumWidth(1000);

        charts.add(mainPieChart);
    }

    private void addInnerPieChart() {
        PieChart lastChart = charts.get(charts.size() - 1);

        lastChart.setHoleRadius(75f);
        lastChart.setTransparentCircleRadius(75f);
        lastChart.invalidate();

        System.out.println(lastChart.getMinimumWidth());
        int width = (int)(lastChart.getMinimumWidth() * 0.75f);

        PieChart innerChart = createPieChart();
        innerChart.setMinimumHeight(width);
        innerChart.setMinimumWidth(width);

        chartLayout.addView(innerChart);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)innerChart
                .getLayoutParams();
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        innerChart.setLayoutParams(params);

        charts.add(innerChart);
    }

    private PieChart createPieChart() {
        PieChart chart = new PieChart(this);

        PieData pieData = new PieData();

        PieDataSet pieDataSet = new PieDataSet(new ArrayList<PieEntry>(), "Data");

        pieDataSet.addEntry(new PieEntry(100f));
        pieDataSet.addEntry(new PieEntry(50f));
        pieDataSet.addEntry(new PieEntry(25f));

        pieDataSet.setColors(getRandomColor(), getRandomColor(), getRandomColor());

        pieData.setDataSet(pieDataSet);

        chart.setData(pieData);

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
