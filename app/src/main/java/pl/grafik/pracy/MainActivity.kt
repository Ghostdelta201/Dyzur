package pl.grafik.pracy

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class MainActivity : Activity() {
    private lateinit var web: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        web = WebView(this)
        setContentView(web)
        web.settings.javaScriptEnabled = true
        web.settings.domStorageEnabled = true
        web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                val url = request.url.toString()
                if (url.startsWith("intent:")) {
                    try {
                        val i = Intent.parseUri(url, Intent.URI_INTENT_SCHEME)
                        i.component = null
                        i.selector = null
                        startActivity(i)
                    } catch (e: Exception) {
                        Toast.makeText(this@MainActivity, "Nie można otworzyć aplikacji zegara", Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
                return false
            }
        }
        web.loadUrl("file:///android_asset/index.html")
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (web.canGoBack()) web.goBack() else super.onBackPressed()
    }
}
