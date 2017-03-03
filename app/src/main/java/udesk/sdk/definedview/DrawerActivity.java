package udesk.sdk.definedview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import udesk.sdk.definedview.view.MyDrawerLayout;


public class DrawerActivity extends AppCompatActivity implements View.OnClickListener {
    MyDrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        drawerLayout = (MyDrawerLayout) findViewById(R.id.my_drawer_layout);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.getmLeftMenuOnScrren() > 0.5) {
                    drawerLayout.closeDrawer();
                } else {
                    drawerLayout.openDrawer();
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
    }
}
