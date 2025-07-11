package com.example.project1.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.font.Font as NormalFont
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.example.project1.R


@Composable
fun provideLobsterFontFamily(): FontFamily {
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )
    val fontName = GoogleFont("Lobster Two")
    return FontFamily(
        Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.Normal)
    )
}

@Composable
fun provideEduFontFamily(): FontFamily {
    return FontFamily(
        NormalFont(R.font.edu, weight = FontWeight.Normal)
    )
}