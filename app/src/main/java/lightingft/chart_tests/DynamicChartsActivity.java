package lightingft.chart_tests;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DynamicChartsActivity extends AppCompatActivity {

    private LineChart chart;
    private LineDataSet dataset;
    private LineDataSet dataset2;
    private LineDataSet dataset3;

    private Button addEntryButton;
    private Button realTimeButton;
    private Button addRemoveButton;

    private ExecutorService asyncExecutor = Executors.newSingleThreadExecutor();
    private ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    private ExecutorService refreshExecutor = Executors.newSingleThreadExecutor();
    private Handler uiHandler = new Handler();

    private int t = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_charts);

        LinearLayout chartLayout = findViewById(R.id.dynamicChartLayout);

        chart = createLineChart();
        chart.setHardwareAccelerationEnabled(false);
        chartLayout.addView(chart);

        addEntryButton = findViewById(R.id.addEntryButton);
        realTimeButton = findViewById(R.id.realTimeButton);
        addRemoveButton = findViewById(R.id.addRemoveButton);

        addEntryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        addRandomEntry(dataset);
                        refreshLineChart();
                    }
                });
            }
        });

        realTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scheduledExecutor.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {
                        if (dataset.getEntryCount() >= 200) {
                            dataset.getValues().remove(0);
                        }

                        for (int i = 0; i < 100; ++i) addRandomEntry(dataset);

                        refreshLineChart();
                    }
                },0, 100, TimeUnit.MILLISECONDS);
            }
        });

        addRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        for (int z = 0; z < 100; ++z) {
                            for (int i = 0; i < chart.getLineData().getDataSetCount(); ++i) {
                                LineDataSet set = (LineDataSet) chart.getLineData().getDataSetByIndex(i);

                                //int count = (int)(Math.random() * 1000);
                                int count = 500;

                                for (int j = 0; j < count; ++j) {
                                    addRandomEntry(set);
                                }

                                for (int j = 0; j < set.getEntryCount(); ++j) {
                                    set.getValues().remove(0);
                                }

                                refreshLineChart(set);
                            }
                        }
                    }
                });
            }
        });
    }

    private LineChart createLineChart() {
        LineChart LineChart = new LineChart(this);

        LineData data = new LineData();
        dataset = new LineDataSet(new ArrayList<Entry>(), "");
        dataset2 = new LineDataSet(new ArrayList<Entry>(), "");
        dataset3 = new LineDataSet(new ArrayList<Entry>(), "");

        data.addDataSet(dataset);
        data.addDataSet(dataset2);
        data.addDataSet(dataset3);

        LineChart.setData(data);

        LineChart.setMinimumHeight(500);

        return LineChart;
    }

    private void refreshLineChart() {
        dataset.notifyDataSetChanged();
        dataset2.notifyDataSetChanged();

        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                chart.getLineData().notifyDataChanged();
                chart.notifyDataSetChanged();
                chart.invalidate();
            }
        });
    }

    private DelayQueue<Delayed> delayQueue = new DelayQueue<Delayed>();

    private void refreshLineChart(final DataSet dataSet) {
//        dataSet.setVisible(false);
        //dataSet.setValues(dataSet.getValues());
        dataSet.notifyDataSetChanged();

        if (!delayQueue.isEmpty()) {
            return;
        }

        System.out.println("X");

        final long startTime = System.currentTimeMillis() + 100;

        Delayed delay = new Delayed() {
            @Override
            public long getDelay(@NonNull TimeUnit unit) {
                return unit.convert(startTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
            }

            @Override
            public int compareTo(@NonNull Delayed o) {
                return 0;
            }
        };

        delayQueue.put(delay);

        try {
            delayQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        uiHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
                chart.getLineData().notifyDataChanged();
                chart.notifyDataSetChanged();
                chart.postInvalidate();
//            }
//        }, 100);
    }

    private void addRandomEntry(LineDataSet set) {
        Entry entry = new Entry(t, (float)Math.random()*10f);
        t++;
        set.getValues().add(entry);
    }
}
