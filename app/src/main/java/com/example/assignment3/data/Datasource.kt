package com.example.assignment3.data

import com.example.assignment3.R
import com.example.assignment3.model.DayData



class Datasource {
    fun loadDayData(): List<DayData> {
        return listOf<DayData>(
            DayData("Day 1", R.drawable.sprite1, R.string.titleText1, R.drawable.image1, R.string.contentText1),
            DayData("Day 2", R.drawable.sprite2, R.string.titleText2, R.drawable.image2, R.string.contentText2),
            DayData("Day 3", R.drawable.sprite3, R.string.titleText3, R.drawable.image3, R.string.contentText3),
            DayData("Day 4", R.drawable.sprite4, R.string.titleText4, R.drawable.image4, R.string.contentText4),
            DayData("Day 5", R.drawable.sprite5, R.string.titleText5, R.drawable.image5, R.string.contentText5),
            DayData("Day 6", R.drawable.sprite6, R.string.titleText6, R.drawable.image6, R.string.contentText6),
            DayData("Day 7", R.drawable.sprite7, R.string.titleText7, R.drawable.image7, R.string.contentText7),
            DayData("Day 8", R.drawable.sprite8, R.string.titleText8, R.drawable.image8, R.string.contentText8),
            DayData("Day 9", R.drawable.sprite9, R.string.titleText9, R.drawable.image9, R.string.contentText9),
            DayData("Day 10", R.drawable.sprite10, R.string.titleText10, R.drawable.image10, R.string.contentText10),
            DayData("Day 11", R.drawable.sprite11, R.string.titleText11, R.drawable.image11, R.string.contentText11),
            DayData("Day 12", R.drawable.sprite12, R.string.titleText12, R.drawable.image12, R.string.contentText12),
            DayData("Day 13", R.drawable.sprite13, R.string.titleText13, R.drawable.image13, R.string.contentText13),
            DayData("Day 14", R.drawable.sprite14, R.string.titleText14, R.drawable.image14, R.string.contentText14),
            DayData("Day 15", R.drawable.sprite15, R.string.titleText15, R.drawable.image15, R.string.contentText15),
            DayData("Day 16", R.drawable.sprite16, R.string.titleText16, R.drawable.image16, R.string.contentText16),
            DayData("Day 17", R.drawable.sprite17, R.string.titleText17, R.drawable.image17, R.string.contentText17),
            DayData("Day 18", R.drawable.sprite18, R.string.titleText18, R.drawable.image18, R.string.contentText18),
            DayData("Day 19", R.drawable.sprite19, R.string.titleText19, R.drawable.image19, R.string.contentText19),
            DayData("Day 20", R.drawable.sprite20, R.string.titleText20, R.drawable.image20, R.string.contentText20),
            DayData("Day 21", R.drawable.sprite21, R.string.titleText21, R.drawable.image21, R.string.contentText21),
            DayData("Day 22", R.drawable.sprite22, R.string.titleText22, R.drawable.image22, R.string.contentText22),
            DayData("Day 23", R.drawable.sprite23, R.string.titleText23, R.drawable.image23, R.string.contentText23),
            DayData("Day 24", R.drawable.sprite24, R.string.titleText24, R.drawable.image24, R.string.contentText24),
            DayData("Day 25", R.drawable.sprite25, R.string.titleText25, R.drawable.image25, R.string.contentText25),
            DayData("Day 26", R.drawable.sprite26, R.string.titleText26, R.drawable.image26, R.string.contentText26),
            DayData("Day 27", R.drawable.sprite27, R.string.titleText27, R.drawable.image27, R.string.contentText27),
            DayData("Day 28", R.drawable.sprite28, R.string.titleText28, R.drawable.image28, R.string.contentText28),
            DayData("Day 29", R.drawable.sprite29, R.string.titleText29, R.drawable.image29, R.string.contentText29),
            DayData("Day 30", R.drawable.sprite30, R.string.titleText30, R.drawable.image30, R.string.contentText30)
        )
    }
}