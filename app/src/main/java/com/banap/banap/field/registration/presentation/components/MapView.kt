package com.banap.banap.field.registration.presentation.components

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.banap.banap.R
import com.banap.banap.ui.theme.BRANCO
import com.banap.banap.ui.theme.VERDE_CLARO
import com.banap.banap.ui.theme.VERDE_ESCURO
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PinConfig
import com.google.android.gms.maps.model.PinConfig.Glyph
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polygon
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@SuppressLint("UnrememberedMutableState")
@Composable
fun MapView(
    isExpanded: Boolean,
    mapModifier: Modifier,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    val fusedLocationClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }

    var marcadores = remember {
        mutableStateListOf<LatLng>()
    }

    var defaultValue by remember {
        mutableStateOf(LatLng(-23.537761, -46.631072))
    }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(defaultValue, 10f)
    }

    LaunchedEffect(
        Unit
    ) {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                location?.let {
                    defaultValue = LatLng(it.latitude, it.longitude)

                    val currentLatLng = LatLng(it.latitude, it.longitude)
                    cameraPositionState.position = CameraPosition.fromLatLngZoom(currentLatLng, 10f)
                }
            }
        } else {
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                1001
            )
        }
    }

    Box(
        modifier = mapModifier
            .clip(
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            googleMapOptionsFactory = {
                GoogleMapOptions().mapId("DEMO_MAP_ID")
            },
            properties = MapProperties(isMyLocationEnabled = true),
            uiSettings = MapUiSettings(myLocationButtonEnabled = true),
            onMapClick = { latLng ->
                marcadores.add(latLng)
            }
        ) {
            marcadores.forEach { posicao ->
                val pingConfig = PinConfig.builder()
                    .setBackgroundColor(VERDE_ESCURO.toArgb())
                    .setBorderColor(VERDE_ESCURO.toArgb())
                    .setGlyph(Glyph(BRANCO.toArgb()))
                    .build()

                AdvancedMarker(
                    state = MarkerState(position = posicao),
                    title = "Ponto A",
                    pinConfig = pingConfig
                )
            }

            if (marcadores.size >= 2) {
                Polyline(
                    points = marcadores.toList(),
                    color = VERDE_ESCURO,
                    width = 5f
                )
            }

            if (marcadores.size >= 3) {
                Polygon(
                    points = marcadores.toList(),
                    fillColor = VERDE_CLARO.copy(alpha = 0.5f),
                    strokeColor = VERDE_CLARO,
                    strokeWidth = 1f
                )
            }
        }

        Card (
            onClick = onClick,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(
                    top = 46.dp,
                    end = 7.dp
                ),
            colors = CardDefaults.cardColors(
                containerColor = BRANCO.copy(alpha = 0.8f)
            ),
            shape = RoundedCornerShape(min(0.dp, 0.dp)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 1.dp
            )
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = if (isExpanded) R.drawable.baseline_close_fullscreen_24 else R.drawable.baseline_open_in_full_24),
                contentDescription = "Fechar",
                modifier = Modifier
                    .padding(7.dp)
                    .scale(0.9f)
                    .background(BRANCO.copy(alpha = 0.5f))
            )
        }
    }
}