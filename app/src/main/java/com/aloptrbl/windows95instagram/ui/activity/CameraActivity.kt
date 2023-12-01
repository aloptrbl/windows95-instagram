package com.aloptrbl.windows95instagram.ui.activity

import android.Manifest
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.OptIn
import androidx.camera.core.CameraEffect
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import com.aloptrbl.windows95instagram.R
import com.aloptrbl.windows95instagram.model.TabItem
import com.aloptrbl.windows95instagram.ui.components.WinBox
import com.aloptrbl.windows95instagram.ui.components.WinIconButton
import com.aloptrbl.windows95instagram.ui.theme.WinPrimary
import com.aloptrbl.windows95instagram.ui.theme.Windows95InstagramTheme
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import java.util.concurrent.Executors

class CameraActivity : ComponentActivity() {
    companion object {
        const val REQUEST_CODE_PERMISSIONS = 10
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestPermissions(arrayOf(Manifest.permission.CAMERA), REQUEST_CODE_PERMISSIONS)
        setContent {
            Windows95InstagramTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   CameraView(this)
                }
            }
        }
    }
}


@OptIn(ExperimentalGetImage::class) @Composable
fun CameraView(cameraActivity: CameraActivity) {
    var context = LocalContext.current
    var previewView: PreviewView = remember { PreviewView(context) }
    val cameraController = remember { LifecycleCameraController(context) }
    val executor = remember { Executors.newSingleThreadExecutor() }
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraProviderFuture = remember {
        ProcessCameraProvider.getInstance(context)
    }
    val cameraProvider = cameraProviderFuture.get()
    val preview = remember { Preview.Builder().build() }
    var defaultCameraFacing by remember { mutableStateOf(CameraSelector.DEFAULT_BACK_CAMERA) }

    val cameraEffect = remember { mutableStateOf<CameraEffect?>(null) }
    val imageAnalysis = ImageAnalysis.Builder()
        // .setOutputImageFormat(ImageAnalysis.OUTPUT_IMAGE_FORMAT_RGBA_8888)
        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
        .build()
    imageAnalysis.setAnalyzer(executor, ImageAnalysis.Analyzer { imageProxy ->
        val rotationDegrees = imageProxy.imageInfo.rotationDegrees
        // insert your code here.
        val image = imageProxy.image
        image?.let { i ->
            val bitmap = Bitmap.createBitmap(i.width, i.height, Bitmap.Config.ARGB_8888)
            for (x in 0 until bitmap.width) {
                for (y in 0 until bitmap.height) {
                    val pixel = bitmap.getPixel(x, y)
                    val red = 255 - android.graphics.Color.red(pixel)
                    val green = 255 - android.graphics.Color.green(pixel)
                    val blue = 255 - android.graphics.Color.blue(pixel)
                    bitmap.setPixel(x, y, android.graphics.Color.rgb(red, green, blue))
                }
            }
        }
        // after done, release the ImageProxy object
        imageProxy.close()
    })
    cameraController.bindToLifecycle(lifecycleOwner)
    cameraController.cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA
    previewView.controller = cameraController


    val textRecognizer =
        remember { TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS) }

    var text by rememberSaveable {
        mutableStateOf("")
    }
    var isLoading by remember { mutableStateOf(false) }
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabItems = listOf(
        TabItem("Following", R.drawable.grid),
        TabItem("News", R.drawable.list),
    )
    Column(
        Modifier
            .fillMaxSize()
            .background(WinPrimary),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        WinBox(
            Modifier
                .height(50.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                WinIconButton(
                    onClick = { cameraActivity.finish() },
                    Modifier
                        .width(50.dp)
                        .fillMaxHeight()
                        .padding(horizontal = 0.dp)
                ) {
                    Row(
                        Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.back),
                            contentDescription = "",
                            modifier = Modifier.size(25.dp).rotate(180f)
                        )
                    }
                }
                Row() {

                }
                Row() {
                    WinIconButton(
                        onClick = { },
                        Modifier
                            .alpha(0F)
                            .width(50.dp)
                            .fillMaxHeight()
                            .padding(horizontal = 0.dp)
                    ) {
                        Row(
                            Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.reload),
                                contentDescription = "",
                                modifier = Modifier.size(25.dp)
                            )
                        }
                    }
                }
            }
        }
        WinBox(
            modifier = Modifier
                .padding(3.dp, 5.dp)
                .fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                AndroidView(factory = {
                                      val cameraPreview = PreviewView(it)
                    cameraProviderFuture.addListener({
                        preview.also {
                            it.setSurfaceProvider(cameraPreview.surfaceProvider)
                        }
                        try {
                            cameraProvider.unbindAll()
                            var camera = cameraProvider.bindToLifecycle(lifecycleOwner, defaultCameraFacing, preview)
                        } catch (e: Exception) {
                            Log.e("camera", "camera preview exception :${e.message}")
                        }
                    }, ContextCompat.getMainExecutor(context))
cameraPreview
                                      }, modifier = Modifier.fillMaxSize())

                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                } else {
                    IconButton(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(16.dp),
                        onClick = {
                            isLoading = true
                            cameraController.setImageAnalysisAnalyzer(executor) { imageProxy ->
                                imageProxy.image?.let { image ->
                                    val img = InputImage.fromMediaImage(
                                        image,
                                        imageProxy.imageInfo.rotationDegrees
                                    )

                                    textRecognizer.process(img).addOnCompleteListener { task ->
                                        isLoading = false
                                        text =
                                            if (!task.isSuccessful) task.exception!!.localizedMessage.toString()
                                            else task.result.text

                                        cameraController.clearImageAnalysisAnalyzer()
                                        imageProxy.close()
                                    }
                                }
                            }
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.camera),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(54.dp)
                        )
                    }
                }
            }

            if (text.isNotEmpty()) {
                Dialog(onDismissRequest = { text = "" }) {
                    Card(modifier = Modifier.fillMaxWidth(0.8f)) {
                        Text(
                            text = text,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .padding(top = 16.dp),
                            style = MaterialTheme.typography.bodySmall
                        )
                        Button(
                            onClick = { text = "" },
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(horizontal = 16.dp, vertical = 16.dp)
                        ) {
                            Text(text = "Done")
                        }
                    }
                }
            }
        }
    }
}
