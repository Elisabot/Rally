package hacklikeagirl.com.nikerally;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.VideoView;

public class VideoActivity extends Activity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        View view = LayoutInflater.from(this).inflate(R.layout.video_activity, null);
        final VideoView vv = (VideoView) view.findViewById(R.id.vv);
        vv.setBackgroundColor(0);
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.rally_video1;
        Uri video = Uri.parse(uri);
        vv.setVideoURI(video);

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(false);
                vv.start();
            }
        });
        vv.start();
        setContentView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
