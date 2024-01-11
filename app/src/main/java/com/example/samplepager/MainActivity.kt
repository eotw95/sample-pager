package com.example.samplepager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                Divider(thickness = 0.5.dp)
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Row {
                    tabs.forEach {
                        Box(
                            modifier = Modifier.width(100.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = it
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.padding(vertical = 5.dp))
                Surface {
                    Divider(
                        thickness = 0.5.dp,
                        modifier = Modifier.offset(y = 2.dp)
                    )
                    HorizontalPagerIndicator(
                        pagerState = pager,
                        pageCount = count,
                        indicatorWidth = 100.dp,
                        indicatorHeight = 3.dp,
                        spacing = 0.dp,
                        inactiveColor = Color.Transparent,
//                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
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