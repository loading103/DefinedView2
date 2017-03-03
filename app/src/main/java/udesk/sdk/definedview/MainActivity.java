package udesk.sdk.definedview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private  MyAdapter myAdapter;
    private RecyclerView recyclerView;
    private String[] viewNames =
            { "刮刮奖", "回弹移动", "自定义Drawer"
                    , "自定义下拉Drawdown",  "自定义双向跑马灯"
                    , "幸运转盘", "幸运抽奖"
                    , "to be continue"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "666", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        myAdapter = new MyAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.item_main_recycler, parent, false);
            MyHolder myHolder = new MyHolder(linearLayout);
            return myHolder;
        }
        @Override
        public void onBindViewHolder(MyHolder holder, final int position) {
            holder.textView.setText(viewNames[position]);
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                    switch (position) {
                        case 0:
                            intent = new Intent(MainActivity.this, ScratchActivity.class);
                            startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(MainActivity.this, DragActivity.class);
                            startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(MainActivity.this, DrawerActivity.class);
                            startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(MainActivity.this, DragDownActivity.class);
                            startActivity(intent);
                            break;
                        case 4:
                            intent = new Intent(MainActivity.this, MarqueeActivity.class);
                            startActivity(intent);
                            break;
                        case 5:
                            intent = new Intent(MainActivity.this, LuckWheelActivity.class);
                            startActivity(intent);
                            break;
                        case 6:
                            intent = new Intent(MainActivity.this, LuckActivity.class);
                            startActivity(intent);
                            break;
                        default:
                            break;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return viewNames.length;
        }

        class MyHolder extends RecyclerView.ViewHolder {
            TextView textView;
            public MyHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.item_tv);
            }
        }
    }
}
