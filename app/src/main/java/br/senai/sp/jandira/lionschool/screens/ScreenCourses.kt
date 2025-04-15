package br.senai.sp.jandira.lionschool.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.R

val imageModifierHead = Modifier
    .size(50.dp)
    .padding(end = 8.dp)

@Composable
fun TelaScreenCourses(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xFFFFFFFF),
                        Color(0xFFFFFFFF)
                    )
                )
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp), // Reduzi o espaço entre os itens
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp ,)
                    .padding(vertical = 30.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(R.string.logo_descripition),
                    contentScale = ContentScale.Fit,
                    modifier = imageModifierHead
                )
                Text(
                    text = stringResource(R.string.title),
                    fontSize = 15.sp,
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold
                )
                Card(
                    modifier = Modifier
                        .size(40.dp) // Tamanho da foto de perfil
                        .clip(CircleShape),
                    colors = CardDefaults.cardColors(Color(0xFFFFC23D)),


                ) {

                }
            }

        }
        }
    }

























@Preview(showSystemUi = true)
@Composable
private fun TelaScreenCoursesPreview() {
    TelaScreenCourses()
}