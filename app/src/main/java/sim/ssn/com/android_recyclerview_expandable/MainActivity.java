package sim.ssn.com.android_recyclerview_expandable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import sim.ssn.com.android_recyclerview_expandable.recyclerview.expand.ExpandableRecyclerAdapter;
import sim.ssn.com.android_recyclerview_expandable.recyclerview.expand.TestAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.main_recycler);

        adapter = new TestAdapter(this);
        adapter.setMode(ExpandableRecyclerAdapter.MODE_ACCORDION);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
    }
}
