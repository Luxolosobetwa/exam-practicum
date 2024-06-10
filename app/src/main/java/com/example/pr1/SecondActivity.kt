package com.example.pr1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private val days =
        arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private var minTemps = arrayOf(12, 15, 14, 16, 13, 10, 10)
    private var maxTemps = arrayOf(25, 29, 27, 20, 29, 18, 18)
    private var weatherConditions =
        arrayOf("Sunny", "Sunny", "Sunny", "Cool", "Raining", "Cool", "Cold")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tableLayout: TableLayout = findViewById(R.id.tableLayout)
        val buttonClearData: Button = findViewById(R.id.buttonClearData)
        val buttonReinputData: Button = findViewById(R.id.buttonReinputData)
        val buttonNextToThirdPage: Button = findViewById(R.id.buttonNextToThirdPage)

        populateTable(tableLayout)

        buttonClearData.setOnClickListener {
            clearData()
            populateTable(tableLayout)
        }

        buttonReinputData.setOnClickListener {
            saveData(tableLayout)
        }

        buttonNextToThirdPage.setOnClickListener {
            saveData(tableLayout)
            navigateToThirdActivity()
        }
    }

    private fun populateTable(tableLayout: TableLayout) {
        tableLayout.removeAllViews()

        // Add table header
        val headerRow = TableRow(this)

        val dayHeader = TextView(this).apply {
            text = "Day"
            textSize = 18f
            setPadding(16, 16, 16, 16)
        }
        val minTempHeader = TextView(this).apply {
            text = "Min Temp"
            textSize = 18f
            setPadding(16, 16, 16, 16)
        }
        val maxTempHeader = TextView(this).apply {
            text = "Max Temp"
            textSize = 18f
            setPadding(16, 16, 16, 16)
        }
        val weatherHeader = TextView(this).apply {
            text = "Weather"
            textSize = 18f
            setPadding(16, 16, 16, 16)
        }

        headerRow.addView(dayHeader)
        headerRow.addView(minTempHeader)
        headerRow.addView(maxTempHeader)
        headerRow.addView(weatherHeader)
        tableLayout.addView(headerRow)

        // Add table rows
        for (i in days.indices) {
            val tableRow = TableRow(this)

            val dayTextView = EditText(this).apply {
                setText(days[i])
                textSize = 18f
                isEnabled = false
                setPadding(16, 16, 16, 16)
            }

            val minTempEditText = EditText(this).apply {
                setText(minTemps[i].toString())
                textSize = 18f
                setPadding(16, 16, 16, 16)
            }

            val maxTempEditText = EditText(this).apply {
                setText(maxTemps[i].toString())
                textSize = 18f
                setPadding(16, 16, 16, 16)
            }

            val weatherEditText = EditText(this).apply {
                setText(weatherConditions[i])
                textSize = 18f
                setPadding(16, 16, 16, 16)
            }

            tableRow.addView(dayTextView)
            tableRow.addView(minTempEditText)
            tableRow.addView(maxTempEditText)
            tableRow.addView(weatherEditText)
            tableLayout.addView(tableRow)
        }

        // Add space
        val spaceRow = TableRow(this)
        val spaceTextView = TextView(this).apply {
            text = "" // Empty text for space
            textSize = 18f
            setPadding(16, 80, 16, 16) // Adjust top padding to create space
        }
        spaceRow.addView(spaceTextView)
        tableLayout.addView(spaceRow)

        // Display average temperature below the array information
        val averageTempTextView = TextView(this).apply {
            text = "Average Temperature: ${"%.2f".format(calculateAverageTemperature())}"
            textSize = 18f
            setPadding(16, 16, 16, 16)
        }
        tableLayout.addView(averageTempTextView)
    }

    private fun clearData() {
        minTemps = Array(minTemps.size) { 0 }
        maxTemps = Array(maxTemps.size) { 0 }
        weatherConditions = Array(weatherConditions.size) { "" }
    }

    private fun saveData(tableLayout: TableLayout) {
        for (i in 1 until tableLayout.childCount) { // start from 1 to skip the header row
            val tableRow = tableLayout.getChildAt(i) as TableRow
            minTemps[i - 1] =
                (tableRow.getChildAt(1) as EditText).text.toString().toIntOrNull() ?: 0
            maxTemps[i - 1] =
                (tableRow.getChildAt(2) as EditText).text.toString().toIntOrNull() ?: 0
            weatherConditions[i - 1] = (tableRow.getChildAt(3) as EditText).text.toString()
        }
    }

    private fun calculateAverageTemperature(): Float {
        val totalMinTemp = minTemps.sum()
        val totalMaxTemp = maxTemps.sum()
        val averageMinTemp = totalMinTemp / minTemps.size.toFloat()
        val averageMaxTemp = totalMaxTemp / maxTemps.size.toFloat()
        return (averageMinTemp + averageMaxTemp) / 2
    }

    private fun navigateToThirdActivity() {
        val intent = Intent(this, ThirdActivity::class.java)
        startActivity(intent)
    }
}
