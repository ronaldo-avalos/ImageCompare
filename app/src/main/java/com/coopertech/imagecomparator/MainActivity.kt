package com.coopertech.imagecomparator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.beforeafter.AfterLabel
import com.smarttoolfactory.beforeafter.BeforeAfterLayout
import com.smarttoolfactory.beforeafter.BeforeLabel
import com.smarttoolfactory.beforeafter.ContentOrder
import com.smarttoolfactory.beforeafter.OverlayStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}


@Composable
fun MainScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Column(
            Modifier.fillMaxWidth()
                .height(54.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 24.sp,
                color = Color.White)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF1C1C1D)),
            contentAlignment = Alignment.Center
        ) {
            BeforeAfterLayout(
                modifier = Modifier,
                beforeContent = {
                    Image(
                        painter = painterResource(id = R.drawable.img_before_exaomple),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )
                },
                afterContent = {
                    Image(
                        painter = painterResource(id = R.drawable.img_after_example),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )

                },
                overlayStyle = OverlayStyle(
                    dividerWidth = 3.dp,
                    dividerColor = Color.White,
                ),
                contentOrder = ContentOrder.BeforeAfter,
                beforeLabel = {
                    BeforeLabel(
                        text = "Before",
                        textColor = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                },
                afterLabel = {
                    AfterLabel(
                        text = "After",
                        textColor = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                },

                )
        }
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
                .height(54.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            contentPadding = PaddingValues(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White, RoundedCornerShape(18)),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Descargar",
                        color = Color(0xFF1C1C1D),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}