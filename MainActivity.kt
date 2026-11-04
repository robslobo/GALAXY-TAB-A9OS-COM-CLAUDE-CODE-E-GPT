package com.a9os.launcher

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { A9OSHome() }
    }
}

private data class AppItem(val name: String, val icon: ImageVector, val pkg: String? = null, val tint: Color)

private val apps = listOf(
    AppItem("Telefone", Icons.Default.Call, "com.google.android.dialer", Color(0xFF70D6A4)),
    AppItem("Mensagens", Icons.Default.Chat, "com.google.android.apps.messaging", Color(0xFF83B8FF)),
    AppItem("Câmera", Icons.Default.PhotoCamera, "com.sec.android.app.camera", Color(0xFFFFC477)),
    AppItem("Galeria", Icons.Default.PhotoLibrary, "com.sec.android.gallery3d", Color(0xFFE6A4FF)),
    AppItem("Arquivos", Icons.Default.Folder, "com.google.android.documentsui", Color(0xFFFFD36E)),
    AppItem("Config.", Icons.Default.Settings, "com.android.settings", Color(0xFFB6C5D8)),
    AppItem("Chrome", Icons.Default.Language, "com.android.chrome", Color(0xFF8FC5FF)),
    AppItem("YouTube", Icons.Default.PlayCircle, "com.google.android.youtube", Color(0xFFFF8585)),
    AppItem("Play Store", Icons.Default.ShoppingBag, "com.android.vending", Color(0xFF86DDB7)),
    AppItem("Relógio", Icons.Default.AccessTime, "com.google.android.deskclock", Color(0xFFB5A5FF)),
    AppItem("Calendário", Icons.Default.CalendarMonth, "com.google.android.calendar", Color(0xFFFFA8A8)),
    AppItem("Calculadora", Icons.Default.Calculate, "com.sec.android.app.popupcalculator", Color(0xFF8ED8D4))
)

@Composable
private fun A9OSHome() {
    val context = LocalContext.current
    var query by remember { mutableStateOf("") }
    var showAll by remember { mutableStateOf(false) }
    val time = remember { SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date()) }
    val date = remember { SimpleDateFormat("EEEE, d 'de' MMMM", Locale("pt", "BR")).format(Date()) }

    val bg = Brush.verticalGradient(listOf(Color(0xFF101827), Color(0xFF0B1220), Color(0xFF111C2B)))
    MaterialTheme(colorScheme = darkColorScheme(
        background = Color(0xFF0B1220), surface = Color(0xFF182438),
        primary = Color(0xFF8AB4F8), onSurface = Color(0xFFEAF1FC)
    )) {
        Box(Modifier.fillMaxSize().background(bg)) {
            Column(Modifier.fillMaxSize().statusBarsPadding().navigationBarsPadding().padding(horizontal = 28.dp)) {
                Row(Modifier.fillMaxWidth().padding(top = 10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("A9OS", color = Color.White, fontSize = 19.sp, fontWeight = FontWeight.Bold, letterSpacing = 2.sp)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Wifi, null, tint = Color(0xFFB9C9DE), modifier = Modifier.size(17.dp))
                        Spacer(Modifier.width(8.dp))
                        Icon(Icons.Default.SignalCellularAlt, null, tint = Color(0xFFB9C9DE), modifier = Modifier.size(17.dp))
                        Spacer(Modifier.width(8.dp))
                        Icon(Icons.Default.BatteryFull, null, tint = Color(0xFFB9C9DE), modifier = Modifier.size(19.dp))
                    }
                }

                Spacer(Modifier.height(34.dp))
                Text(time, color = Color.White, fontSize = 64.sp, fontWeight = FontWeight.Light, letterSpacing = (-2).sp)
                Text(date.replaceFirstChar { it.uppercase() }, color = Color(0xFF9EADC2), fontSize = 15.sp)
                Spacer(Modifier.height(24.dp))

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Card(Modifier.weight(1.3f).height(112.dp), shape = RoundedCornerShape(22.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF1B2B42))) {
                        Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.SpaceBetween) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.WbSunny, null, tint = Color(0xFFFFD18A), modifier = Modifier.size(19.dp))
                                Spacer(Modifier.width(7.dp))
                                Text("SEU ESPAÇO", color = Color(0xFF9EADC2), fontSize = 10.sp, letterSpacing = 1.3.sp)
                            }
                            Text("Tudo no seu ritmo.", color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Medium)
                            Text("A9OS • versão conceito", color = Color(0xFF9EADC2), fontSize = 10.sp)
                        }
                    }
                    Card(Modifier.weight(0.8f).height(112.dp), shape = RoundedCornerShape(22.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF263B56))) {
                        Column(Modifier.fillMaxSize().padding(15.dp), verticalArrangement = Arrangement.SpaceBetween) {
                            Icon(Icons.Default.Memory, null, tint = Color(0xFF9FC5FF), modifier = Modifier.size(21.dp))
                            Text("4 GB", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
                            Text("RAM • dispositivo", color = Color(0xFFB4C4D8), fontSize = 10.sp)
                        }
                    }
                }

                Spacer(Modifier.height(26.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text(if (showAll) "Aplicativos" else "Favoritos", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                    Text(if (showAll) "Início" else "Ver todos", color = Color(0xFF9FC5FF), fontSize = 13.sp,
                        modifier = Modifier.clip(RoundedCornerShape(10.dp)).clickable { showAll = !showAll }.padding(8.dp))
                }
                Spacer(Modifier.height(10.dp))

                if (showAll) {
                    OutlinedTextField(
                        value = query, onValueChange = { query = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Buscar aplicativo…", color = Color(0xFF8191A8)) },
                        leadingIcon = { Icon(Icons.Default.Search, null) },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White, unfocusedTextColor = Color.White,
                            focusedBorderColor = Color(0xFF8AB4F8), unfocusedBorderColor = Color(0xFF34445A)
                        )
                    )
                }

                val shown = (if (showAll) apps.filter { it.name.contains(query, true) } else apps.take(8))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier.weight(1f),
                    contentPadding = PaddingValues(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    items(shown) { app ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable {
                            val launch = app.pkg?.let { context.packageManager.getLaunchIntentForPackage(it) }
                            if (launch != null) context.startActivity(launch)
                            else Toast.makeText(context, "Aplicativo não encontrado neste dispositivo", Toast.LENGTH_SHORT).show()
                        }) {
                            Box(Modifier.size(54.dp).clip(RoundedCornerShape(18.dp)).background(Color(0xFF203149)), contentAlignment = Alignment.Center) {
                                Icon(app.icon, contentDescription = app.name, tint = app.tint, modifier = Modifier.size(27.dp))
                            }
                            Spacer(Modifier.height(7.dp))
                            Text(app.name, color = Color(0xFFDCE6F4), fontSize = 11.sp, maxLines = 1)
                        }
                    }
                }

                Row(
                    Modifier.fillMaxWidth().padding(bottom = 12.dp).clip(RoundedCornerShape(24.dp))
                        .background(Color(0xCC1B2A40)).padding(horizontal = 18.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically
                ) {
                    DockItem(Icons.Default.Call, "Telefone", Color(0xFF70D6A4)) { openApp(context, "com.google.android.dialer") }
                    DockItem(Icons.Default.Language, "Navegador", Color(0xFF83B8FF)) { openApp(context, "com.android.chrome") }
                    DockItem(Icons.Default.PhotoCamera, "Câmera", Color(0xFFFFC477)) { openApp(context, "com.sec.android.app.camera") }
                    DockItem(Icons.Default.Settings, "Ajustes", Color(0xFFB6C5D8)) { openApp(context, "com.android.settings") }
                    DockItem(Icons.Default.Apps, "Apps", Color(0xFFB5A5FF)) { showAll = !showAll }
                }
            }
        }
    }
}

private fun openApp(context: android.content.Context, pkg: String) {
    val intent = context.packageManager.getLaunchIntentForPackage(pkg)
    if (intent != null) context.startActivity(intent)
    else Toast.makeText(context, "Aplicativo não encontrado", Toast.LENGTH_SHORT).show()
}

@Composable
private fun DockItem(icon: ImageVector, label: String, tint: Color, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.clickable(onClick = onClick)) {
        Icon(icon, contentDescription = label, tint = tint, modifier = Modifier.size(23.dp))
        Spacer(Modifier.height(4.dp))
        Text(label, color = Color(0xFFB9C8DA), fontSize = 9.sp)
    }
}
