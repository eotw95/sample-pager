package com.example.samplepager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.samplepager.ui.theme.SamplePagerTheme
import com.google.accompanist.pager.HorizontalPagerIndicator

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
        val pager = rememberPagerState()
        val count = 3
        val tabs = listOf("Hatena", "Zenn", "Qiita")

        Spacer(modifier = Modifier.padding(vertical = 50.dp))
        Surface(
            modifier = Modifier.align(Alignment.Start)
        ) {
            Column {
                Row {
                    tabs.forEach {
                        Text(
                            text = it,
//                            modifier = Modifier.padding(end = 65.dp)
                            modifier = if (it == "Hatena") {
                                Modifier.padding(start = 10.dp).padding(end = 65.dp)
                            } else {
                                Modifier.padding(end = 65.dp)
                            }
                        )
                    }
                }
                HorizontalPagerIndicator(
                    pagerState = pager,
                    pageCount = count,
                    indicatorWidth = 30.dp,
                    indicatorHeight = 1.dp,
                    spacing = 70.dp,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(vertical = 30.dp))
        HorizontalPager(
            state = pager,
            pageCount = count
        ) {
            Text(
                text = "$it"
            )
        }
    }
}