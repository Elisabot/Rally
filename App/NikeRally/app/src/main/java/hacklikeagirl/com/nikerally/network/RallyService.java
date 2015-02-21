package hacklikeagirl.com.nikerally.network;



import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface RallyService {
    @POST("/startrun")
    void startRun(Callback<Object> cb);

    @GET("/rally")
    void lookForRally(Callback<Rally> cb);


}
