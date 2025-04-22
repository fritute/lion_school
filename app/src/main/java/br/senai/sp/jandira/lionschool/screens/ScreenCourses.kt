package br.senai.sp.jandira.lionschool.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
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
import androidx.navigation.NavHostController
import br.senai.sp.jandira.lionschool.R
import br.senai.sp.jandira.lionschool.model.Course
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme

val imageModifierHead = Modifier
    .size(40.dp)
    .padding(end = 8.dp)

@Composable
fun CoursesScreen(navController: NavHostController) {
    val courses = listOf(
        Course(
            id = 1,
            sigla = "DS",
            icone = R.drawable.programming1,
            nome = stringResource(R.string.course_ds_name),
            descricao = stringResource(R.string.course_ds_description),
            cargaHoraria = stringResource(R.string.course_ds_duration)
        ),
        Course(
            id = 2,
            sigla = "RDS",
            icone = R.drawable.internet1,
            nome = stringResource(R.string.course_rds_name),
            descricao = stringResource(R.string.course_rds_description),
            cargaHoraria = stringResource(R.string.course_rds_duration)
        ),
        Course(
            id = 3,
            sigla = "ELE",
            icone = R.drawable.lion_chip1,
            nome = stringResource(R.string.course_ele_name),
            descricao = stringResource(R.string.course_ele_description),
            cargaHoraria = stringResource(R.string.course_ele_duration)
        )
    )

    LionSchoolTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = stringResource(R.string.logo_descripition),
                            contentScale = ContentScale.Fit,
                            modifier = imageModifierHead
                        )
                        Text(
                            text = stringResource(R.string.title),
                            fontSize = 18.sp,
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Card(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        colors = CardDefaults.cardColors(Color(0xFFFFC23D))
                    ) {
                        // Ícone do perfil (opcional)
                    }
                }

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                    placeholder = {
                        Text(text = stringResource(R.string.search_placeholder))
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(R.string.search_placeholder),
                            tint = Color.Gray
                        )
                    },

                )


                Spacer(modifier = Modifier.height(16.dp))

                Divider(
                    color = Color(0xFFFFC23D),
                    thickness = 2.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Text(
                    text = stringResource(R.string.courses_section_title),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3347B0),
                    modifier = Modifier.padding(start = 8.dp, bottom = 16.dp)
                )

                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(courses) { course ->
                        CourseCard(
                            course = course,
                            navController = navController,
                            courseIcon = course.icone
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CourseCard(course: Course, navController: NavHostController, courseIcon: Int?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF3347B0)),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = course.sigla,
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFC23D),
                    modifier = Modifier.weight(1f)
                )
                if (courseIcon != null) {
                    Image(
                        painter = painterResource(id = courseIcon),
                        contentDescription = course.nome,
                        modifier = Modifier.size(60.dp)
                    )
                }
            }
            Text(
                text = course.nome,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = course.descricao,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 4.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = course.cargaHoraria,
                fontSize = 16.sp,
                color = Color(0xFFFFC23D),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CoursesScreenPreview() {
    LionSchoolTheme {
        CoursesScreen(navController = androidx.navigation.compose.rememberNavController())
    }
}
