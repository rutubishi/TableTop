package com.rutubishi.common.ui.util

import java.io.File
import java.io.IOException
import kotlin.jvm.Throws

@Throws(IOException::class)
fun loadPainter(res: String): String = File("drawables/$res").path