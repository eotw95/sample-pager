package com.example.samplepager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplepager.ui.theme.SamplePagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SamplePagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    pager()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun pager() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        HorizontalPager(
            pageCount = 3
        ) {
            Text(
                text = "$it"
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        HorizontalPager(
            pageCount = 3
        ) {
            Text(
                text = "$it"
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        HorizontalPager(
            pageCount = 3
        ) {
            Text(
                text = "$it"
            )
        }
    }
}