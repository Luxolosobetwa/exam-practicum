package com.example.pr1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        // Retrieve data from intent
        val intent = intent
        val days = intent.getStringArrayExtra("days") ?: emptyArray()
        val minTemps = intent.getIntArrayExtra("minTemps") ?: IntArray(0)
        val maxTemps = intent.getIntArrayExtra("maxTemps") ?: IntArray(0)
        val weatherConditions = intent.getStringArrayExtra("weatherConditions") ?: emptyArray()

        val tableLayout: TableLayout = findViewById(R.id.tableLayout)

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

            val dayTextView = TextView(this).apply {
                text = days[i]
                textSize = 18f
                setPadding(16, 16, 16, 16)
            }

            val minTempTextView = TextView(this).apply {
                text = minTemps[i].toString()
                textSize = 18f
                setPadding(16, 16, 16, 16)
            }

            val maxTempTextView = TextView(this).apply {
                text = maxTemps[i].toString()
                textSize = 18f
                setPadding(16, 16, 16, 16)
            }

            val weatherTextView = TextView(this).apply {
                text = weatherConditions[i]
                textSize = 18f
                setPadding(16, 16, 16, 16)
            }

            tableRow.addView(dayTextView)
            tableRow.addView(minTempTextView)
            tableRow.addView(maxTempTextView)
            tableRow.addView(weatherTextView)
            tableLayout.addView(tableRow)
        }
    }
}
