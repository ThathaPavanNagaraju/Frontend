package com.apps.akhilsreekar.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public static RecyclerView recyclerView;
    CustomGridAdapter adapter;
    public static MainActivity mMainActivity;
    public static int TYPE;
    public boolean first_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TYPE = CustomListAdapter.LIST;
        mMainActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new CustomGridAdapter(this, Data.getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        switch (id){
            /*case R.id.linearViewHorizontal:
                LinearLayoutManager mlinearLayoutManagerHorizontal = new LinearLayoutManager(this);
                mlinearLayoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(mlinearLayoutManagerHorizontal);
                break;

            case R.id.linearViewVertical:
                LinearLayoutManager mlinearLayoutManagerVertical = new LinearLayoutManager(this);
                mlinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(mlinearLayoutManagerVertical);
                break;*/

                case R.id.listView:
                    CustomListAdapter customListAdapter = new CustomListAdapter(mMainActivity,Data.getData());
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    recyclerView.setAdapter(customListAdapter);
                break;

                case R.id.gridView:
                    CustomGridAdapter customeGridAdapter = new CustomGridAdapter(mMainActivity,Data.getData());
                    recyclerView.setLayoutManager(new GridLayoutManager(this,3));
                    recyclerView.setAdapter(customeGridAdapter);
                break;

            /*case R.id.staggeredViewHorizontal:
                StaggeredGridLayoutManager mStaggeredHorizontalLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(mStaggeredHorizontalLayoutManager);
                break;

            case R.id.staggeredViewVertical:
                StaggeredGridLayoutManager mStaggeredVerticalLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);
                break;*/
        }
        return super.onOptionsItemSelected(item);
    }

    public void callBackShowDetails(int position) {
        Intent intent = new Intent(MainActivity.this,ItemDetailsActivivty.class);
        intent.putExtra("position",position);
        startActivity(intent);
    }
}
