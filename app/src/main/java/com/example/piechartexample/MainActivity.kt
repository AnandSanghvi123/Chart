package com.example.piechartexample

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class MainActivity : AppCompatActivity() {
    private lateinit var pieChart: PieChart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pieChart = findViewById(R.id.pieChart)

        // Create sample data for the pie chart
        val entries = listOf(
            PieEntry(10f),
            PieEntry(10f),
            PieEntry(25f),
            PieEntry(25f),
            PieEntry(30f),
            PieEntry(10f),
            PieEntry(10f),
            PieEntry(25f),
            PieEntry(25f),
            PieEntry(30f)
        )

        // Set up the PieDataSet
        val dataSet = PieDataSet(entries, "")
        dataSet.colors = mutableListOf(
            Color.rgb(148, 0, 211),
            Color.RED,
            Color.parseColor("#FCAC12"),
            Color.YELLOW,
            Color.BLUE,
            Color.rgb(148, 0, 211),
            Color.RED,
            Color.parseColor("#FCAC12"),
            Color.YELLOW,
            Color.BLUE

        )

        // Disable the value text from being displayed inside the chart slices
        dataSet.setDrawValues(false)

        // Configure the pie chart
        pieChart.data = PieData(dataSet)

        //Round the corners of the pie slices
        pieChart.setDrawRoundedSlices(true)

        // Convert to ring chart
        pieChart.isDrawHoleEnabled = true
        pieChart.holeRadius = 70f
        pieChart.setHoleColor(Color.BLACK)
        pieChart.centerText = "9400.0"
        pieChart.setCenterTextSize(24f)
        pieChart.setCenterTextTypeface(Typeface.DEFAULT_BOLD)


        // Adjust the slice spacing
        dataSet.sliceSpace = 0f

        // Disable the description label
        pieChart.description.isEnabled = false

        // Disable the legend
        pieChart.legend.isEnabled = false

        // Refresh the chart
        pieChart.invalidate()

    }

}