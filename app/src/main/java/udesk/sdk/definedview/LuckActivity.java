package udesk.sdk.definedview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

import udesk.sdk.definedview.view.LuckyPanView;


public class LuckActivity extends Activity
{
	private LuckyPanView mLuckyPanView;
	private ImageView mStartBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);

		mLuckyPanView = (LuckyPanView) findViewById(R.id.id_luckypan);
		mStartBtn = (ImageView) findViewById(R.id.id_start_btn);

		mStartBtn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (!mLuckyPanView.isStart())
				{
					mStartBtn.setImageResource(R.drawable.stop);
					mLuckyPanView.luckyStart((int)(Math.random()*6)+1);
//					Toast.makeText(LuckActivity.this,(int)(Math.random()*6)+1+ "", Toast.LENGTH_SHORT).show();
				} else
				{
					if (!mLuckyPanView.isShouldEnd())
					{
						mStartBtn.setImageResource(R.drawable.start);
						mLuckyPanView.luckyEnd();
					}
				}
			}
		});
	}

}
