package example.android.hothatena;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;


public class EntryListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_list);

        ListView listView = (ListView) findViewById(R.id.lv_entries);
        listView.setEmptyView(findViewById(R.id.empty));
    }
}
