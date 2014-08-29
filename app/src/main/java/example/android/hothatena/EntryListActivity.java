package example.android.hothatena;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import org.apache.http.Header;
import java.util.List;
import rejasupotaro.asyncrssclient.AsyncRssClient;
import rejasupotaro.asyncrssclient.AsyncRssResponseHandler;
import rejasupotaro.asyncrssclient.RssFeed;
import rejasupotaro.asyncrssclient.RssItem;

public class EntryListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_list);

        AsyncRssClient client = new AsyncRssClient();
        client.read("http://b.hatena.ne.jp/hotentry?mode=rss", new AsyncRssResponseHandler() {
            @Override
            public void onSuccess(RssFeed rssFeed) {
                ArrayAdapter adapter = new ArrayAdapter(EntryListActivity.this, android.R.layout.simple_list_item_1);

                ListView listView = (ListView) findViewById(R.id.lv_entries);
                listView.setAdapter(adapter);

                List<RssItem> itemList = rssFeed.getRssItemList();

                for (RssItem rssItem: itemList) {
                    String title = rssItem.getTitle();
                    adapter.add(title);
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(EntryListActivity.this, "Failed to read RSS.", Toast.LENGTH_SHORT).show();
            }
        });

        ListView listView = (ListView) findViewById(R.id.lv_entries);
        listView.setEmptyView(findViewById(R.id.empty));
    }
}
