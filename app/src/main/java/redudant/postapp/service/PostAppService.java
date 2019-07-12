package redudant.postapp.service;

import redudant.postapp.modul.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostAppService {

    //from url : https://jsonplaceholder.typicode.com/guide.html
    //https://jsonplaceholder.typicode.com/posts
    //parameter {posts}
    @POST("posts")
    Call<User> getResult(@Body User user);
}
