package com.example.yun.togethertogether;

        import android.support.v4.content.res.ResourcesCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost; //탭호스트 객체 생성
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle(" TOTO");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost)findViewById(R.id.host);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tab01");

        tabSpec.setIndicator(null, ResourcesCompat.getDrawable(getResources(),R.drawable.power,null));
        tabSpec.setContent(R.id.content01);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tab02");
        tabSpec.setIndicator(null, ResourcesCompat.getDrawable(getResources(),R.drawable.power4,null));
        tabSpec.setContent(R.id.content02);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tab03");
        tabSpec.setIndicator(null, ResourcesCompat.getDrawable(getResources(),R.drawable.power3,null));
        tabSpec.setContent(R.id.content03);
        tabHost.addTab(tabSpec);
    }
}
