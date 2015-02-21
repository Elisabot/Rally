package hacklikeagirl.com.nikerally;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import hacklikeagirl.com.nikerally.network.RallyClient;

public class MainActivity extends Activity {

    private CardScrollView mCardScroller;

    private View mView;
    private RallyClient rallyClient;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        mView = buildView();

        mCardScroller = new CardScrollView(this);
        mCardScroller.setAdapter(new CardScrollAdapter() {
            @Override
            public int getCount() {
                return 1;
            }

            @Override
            public Object getItem(int position) {
                return mView;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return mView;
            }

            @Override
            public int getPosition(Object item) {
                if (mView.equals(item)) {
                    return 0;
                }
                return AdapterView.INVALID_POSITION;
            }
        });
        // Handle the TAP event.
        mCardScroller.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, VideoActivity.class));
            }
        });
        setContentView(mCardScroller);

        // Get the network client
        rallyClient = RallyClient.getInstance();

        // start a run
        // doesn't work on captive portal wifi networks :(
        /* rallyClient.startRun(new Callback<Object>() {
            @Override
            public void success(Object o, Response response) {
                Log.d("Rally", "success");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Rally", "failure");
            }
        }); */

        // TODO: look for a rally by polling the API periodically
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCardScroller.activate();
    }

    @Override
    protected void onPause() {
        mCardScroller.deactivate();
        super.onPause();
    }

    private View buildView() {
        return LayoutInflater.from(this).inflate(R.layout.main_view, null);
    }

}
