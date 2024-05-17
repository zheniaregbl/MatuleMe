package ru.syndicate.matule.shop_part.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import ru.syndicate.matule.R
import ru.syndicate.matule.shop_part.presentation.home.components.SearchTextField
import ru.syndicate.matule.shop_part.presentation.home.components.ShoesCard
import ru.syndicate.matule.ui.theme.CustomBlue
import ru.syndicate.matule.ui.theme.CustomLightGray
import ru.syndicate.matule.ui.theme.MainBackgroundWhite
import ru.syndicate.matule.ui.theme.TextBlack

class HomeScreen : Screen {

    @Composable
    override fun Content() {

        HomeScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit = { }
) {

    var searchText by remember {
        mutableStateOf("")
    }

    val listCategory = listOf(
        "Все",
        "Outdoor",
        "Tennis",
        "Running",
    )

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            top = 6.dp
        ),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        item {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    ),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.svg_home_top_text),
                    contentDescription = null,
                    tint = TextBlack
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = MutableInteractionSource()
                            ) { },
                        imageVector = ImageVector.vectorResource(id = R.drawable.svg_hamburger),
                        contentDescription = null
                    )

                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                color = Color.White
                            )
                            .clickable { onClickBack() }
                            .padding(10.dp)
                    ) {

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.svg_bag),
                            contentDescription = null
                        )
                    }
                }
            }
        }

        item {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    )
            ) {

                SearchTextField(
                    modifier = Modifier
                        .weight(1f),
                    value = searchText,
                    onValueChange = {
                        searchText = it
                    }
                )

                Spacer(
                    modifier = Modifier
                        .width(14.dp)
                )

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(
                            color = CustomBlue
                        )
                        .clickable { }
                        .padding(14.dp)
                ) {

                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.svg_filter),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }

        item {

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Text(
                    modifier = Modifier
                        .padding(
                            start = 20.dp
                        ),
                    text = "Категории",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = TextBlack
                )

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(
                        horizontal = 20.dp
                    ),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    items(listCategory) {

                        Box(
                            modifier = Modifier
                                .width(108.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(
                                    color = Color.White
                                )
                                .padding(
                                    vertical = 11.dp
                                ),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = it,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Normal,
                                fontSize = 12.sp,
                                color = TextBlack
                            )
                        }
                    }
                }
            }
        }

        item {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 20.dp
                    ),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Популярное",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = TextBlack
                    )

                    Text(
                        text = "Все",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = CustomBlue
                    )
                }

                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(19.dp),
                    verticalArrangement = Arrangement.spacedBy(19.dp),
                    maxItemsInEachRow = 2
                ) {

                    for (i in 0..5) {

                        ShoesCard(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(16.dp))
                                .background(
                                    color = Color.White
                                )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreenContent(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = MainBackgroundWhite
            )
    )
}