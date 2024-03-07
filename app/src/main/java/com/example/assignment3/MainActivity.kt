package com.example.assignment3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment3.data.Datasource
import com.example.assignment3.model.DayData
import com.example.assignment3.ui.theme.Assignment3Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DayDataApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TheTopBarHeader(modifier:Modifier=Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.image_size))
                        .padding(dimensionResource(id = R.dimen.padding_small)),
                    painter = painterResource(R.drawable.recipebook),
                    contentDescription = null
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        },
        colors = topAppBarColors(MaterialTheme.colorScheme.primaryContainer),
        modifier = modifier
    )
}

@Composable
private fun TheCardButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier:Modifier=Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if(expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = "See More",
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}


@Composable
private fun TheHeadline(@DrawableRes spriteResourceId: Int, @StringRes titleId: Int, expanded: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier=Modifier.padding(horizontal =  dimensionResource(id = R.dimen.padding_medium))
    ) {
        if(!expanded) {
            Image(
                painter = painterResource(spriteResourceId),
                contentDescription = stringResource(titleId),
                modifier = Modifier.height(50.dp).width(50.dp),
                contentScale = ContentScale.FillBounds
            )
        }
        Text(
            text = stringResource(titleId),
            modifier = Modifier.padding(
                horizontal = dimensionResource(id = R.dimen.padding_medium),
                vertical = dimensionResource(id = R.dimen.padding_small)
            ),
            style = MaterialTheme.typography.headlineLarge
        )
    }
}


@Composable
private fun TheContent(@DrawableRes imageResourceId: Int, @StringRes titleId: Int, @StringRes contentId: Int) {
    Image(
        painter = painterResource(imageResourceId),
        contentDescription = stringResource(titleId),
        modifier = Modifier
            .fillMaxWidth()
            .height(194.dp)
            .padding(horizontal = dimensionResource(id = R.dimen.padding_small)),
        contentScale = ContentScale.Crop
    )
    Text(
        text = stringResource(contentId),
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
        style = MaterialTheme.typography.bodyMedium
    )
}


@Composable
fun DayDataCard(dayData: DayData, modifier:Modifier=Modifier) {

    var expanded by remember { mutableStateOf(false)}

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp
    ),) {
        Column {
            Row(modifier=Modifier.fillMaxWidth()) {
                Text(
                    text = dayData.dayText,
                    modifier = Modifier.padding(
                        top = dimensionResource(id = R.dimen.padding_medium),
                        start = dimensionResource(id = R.dimen.padding_medium)
                    )
                )
                Spacer(modifier = Modifier.weight(1.0f))
                TheCardButton(expanded = expanded, onClick = { expanded = !expanded })
            }
            TheHeadline(dayData.spriteResourceId, dayData.titleId, expanded)
            if(expanded) {
                TheContent(dayData.imageResourceId, dayData.titleId, dayData.contentId)
            }

        }
    }
}


@Composable
fun DayDataList(dayDataList: List<DayData>, contentPadding: PaddingValues, modifier:Modifier=Modifier) {
    LazyColumn(
        contentPadding = contentPadding,
        modifier=modifier
    ) {
        items(dayDataList) { dayData ->
            DayDataCard(
                dayData=dayData,
                modifier=Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DayDataApp() {
    Assignment3Theme {
        Scaffold(topBar = {TheTopBarHeader()}) {
            DayDataList(dayDataList = Datasource().loadDayData(), contentPadding=it)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    Assignment3Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DayDataApp()
        }
    }
}