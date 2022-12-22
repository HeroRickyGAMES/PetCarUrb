package com.herorickystudiosoficial.petcarurb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//Programado por HeroRicky_Games e Doménica

public class ActivityWeb extends AppCompatActivity {


    WebView webV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webV=(WebView)findViewById(R.id.webView);

        //URL do site
        String url= "petcarurbaomeupetc.wixsite.com/petcarurb";

        //WebViewClient() para que se abra dentro de la aplicacion
        webV.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // Página iniciada
                System.out.println(url);

                if(url.equals("whatsapp://send/?phone=5511980203863&text&type=phone_number&app_absent=0")){

                    Uri uri = Uri.parse("https://wa.me/5511980203863");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // Página finalizada

            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                webV.loadUrl("https://petcarurbaomeupetc.wixsite.com/petcarurb");
            }
        });


        //Iniciamos la busqueda
        webV.loadUrl("https://"+url);
        webV.getSettings().setJavaScriptEnabled(true);
        webV.getSettings().setAllowContentAccess(true);


        //Esconde a action Bar
        getSupportActionBar().hide();

}
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webV.canGoBack()) {
                        webV.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }


}