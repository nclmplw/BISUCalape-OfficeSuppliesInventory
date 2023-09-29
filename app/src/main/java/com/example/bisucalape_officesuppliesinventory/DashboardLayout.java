package com.example.bisucalape_officesuppliesinventory;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class DashboardLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_layout);

        // Assuming you have a LineChart view defined in your XML layout
        LineChart lineChart = findViewById(R.id.lineChart);

        // Simulated data for the line chart (you should fetch this data from your XAMPP database)
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 10f));
        entries.add(new Entry(1, 15f));
        entries.add(new Entry(2, 18f));
        entries.add(new Entry(3, 12f));
        entries.add(new Entry(4, 14f));

        LineDataSet dataSet = new LineDataSet(entries, "Sales Data");
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.RED);

        LineData lineData = new LineData(dataSet);

        // Set the line chart data
        lineChart.setData(lineData);

        // Customize the X-axis (e.g., labels, scaling)
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f); // Minimum axis step (interval) is 1
        xAxis.setValueFormatter(new MyXAxisValueFormatter()); // Custom X-axis label formatter

        // Refresh the chart
        lineChart.invalidate();
    }

    // Custom X-axis label formatter (modify this to fit your data)
    public class MyXAxisValueFormatter implements IAxisValueFormatter {
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            // You can format the X-axis labels here (e.g., convert float value to date or category)
            return String.valueOf((int) value);
        }
    }
}
