package udesk.sdk.definedview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import java.util.ArrayList;

import udesk.sdk.definedview.view.MarqueeTextView;


public class MarqueeActivity extends AppCompatActivity {

    private MarqueeTextView marqueeTextView1, marqueeTextView2;
    private ArrayList<String> contentStringList = new ArrayList<>();
    private String[] viewNames =
            {"自定义双向跑马灯"
                    , "jgiorejiojiojfvioaerjrioa"
                    , "第三方个地方司法"
                    , "紧凑i阿娇次日哦啊级点击aid"
                    , "家供热计量空间克隆揭开了艰苦艰苦环境开会进口氯化钾开会艰苦环境开会了就快乐健康就好了空间花见花开了就环境开会了空间和空间"
                    , "自定义Drawer"
                    , "的发射点发发射点发大是"
                    , "GradientTe阿德斯发"
                    , "还是让他黑色的风格"
                    , "to be as的发射点发大师傅大厦发生的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marquee);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        for (int i = 0; i < viewNames.length; i++) {
            contentStringList.add(viewNames[i]);
        }
        initView();
    }

    private void initView() {
        marqueeTextView1 = (MarqueeTextView) findViewById(R.id.marquee_1);
        marqueeTextView1.setContentList(contentStringList);
//        marqueeTextView1.setSingleText(viewNames[4]);
//        marqueeTextView2 = (MarqueeTextView) findViewById(R.id.marquee_2);
//        marqueeTextView2.setContentList(contentStringList);
    }

}
