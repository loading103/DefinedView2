package udesk.sdk.definedview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import udesk.sdk.definedview.databinding.ContentLuckWheelBinding;
import udesk.sdk.definedview.viewModels.LuckyWheelViewModel;


public class LuckWheelActivity extends AppCompatActivity {

    private RelativeLayout contentlayout;
    private LuckyWheelViewModel luckyWheelViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck_wheel);

        contentlayout = (RelativeLayout) findViewById(R.id.content_luck_wheel);
        ContentLuckWheelBinding contentLuckWheelBinding = DataBindingUtil.bind(contentlayout);
        luckyWheelViewModel = new LuckyWheelViewModel();
        luckyWheelViewModel.setContentLuckWheelBinding(contentLuckWheelBinding);
        contentLuckWheelBinding.setViewModel(luckyWheelViewModel);
    }
}
