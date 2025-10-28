package com.ute.multimedia

import android.net.Uri
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --- YouTube en WebView ---
        webView = findViewById(R.id.webViewYouTube)

        val ws: WebSettings = webView.settings
        ws.javaScriptEnabled = true
        ws.domStorageEnabled = true
        ws.mediaPlaybackRequiresUserGesture = false

        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()

        // Limpiar caché y historial del WebView
        webView.clearCache(true)
        webView.clearHistory()

        // Usar la URL de YouTube en formato embed
        val youtubeEmbedUrl = "https://www.youtube.com/embed/emJtURJmVmk?list=RDemJtURJmVmk"
        val html = """
            <html>
                <body style="margin:0;padding:0;">
                    <iframe width="100%" height="100%" src="$youtubeEmbedUrl" frameborder="0" allowfullscreen></iframe>
                </body>
            </html>
        """.trimIndent()

        // Cargar la URL en el WebView
        webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null)

        // --- MP4 local en VideoView (res/raw/demo.mp4) ---
        videoView = findViewById(R.id.videoViewMp4)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        val videoUri: Uri = Uri.parse("android.resource://${packageName}/raw/demo")
        videoView.setVideoURI(videoUri)

        videoView.setOnPreparedListener { mp ->
            mp.isLooping = false
            videoView.start()
        }

        videoView.setOnErrorListener { mp, what, extra ->
            // Manejo de errores aquí si es necesario
            false
        }
    }

    override fun onBackPressed() {
        if (this::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
