package com.prolificwebworks.theclubix.server;

import android.util.Log;

import com.prolificwebworks.theclubix.entities.AllEvents;
import com.prolificwebworks.theclubix.entities.Artist;
import com.prolificwebworks.theclubix.entities.Club;
import com.prolificwebworks.theclubix.entities.FacebookRegister;
import com.prolificwebworks.theclubix.entities.Songs;
import com.prolificwebworks.theclubix.utils.EventTime;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by vaibhav on 9/10/15.
 */
public enum Client {

    INSTANCE;
    public Requests requests;


    public interface Requests {

        @GET("/all_event_listing.php")
        void getAllEvents(@Query("page") int pageNo, Callback<AllEvents> allEventsCallback);

        @GET("/today_events.php")
        void getTodaysEvents(@Query("eventlist") String eventTime, Callback<AllEvents> allEventsCallback);

        @GET("/tomorrow_events.php")
        void getTomorrowEvents(@Query("eventlist") String eventTime, Callback<AllEvents> allEventsCallback);

        @GET("/later_events.php")
        void getLaterEvents(@Query("eventlist") String eventTime, Callback<AllEvents> allEventsCallback);

        @GET("/all_artist_listing.php")
        Artist getAllArtist();

        @GET("/single_artist.php")
        Artist getSingleArtist(@Query("artistID") int artistId);

        @GET("/all_songs_listing.php")
        Songs getAllSongs();

        @GET("/single_songs.php")
        Songs getSingleSongs(@Query("songID") int songId);

        @POST("/facebook_register_user")
        void registerUser(@Body FacebookRegister facebookRegister);

        @GET("/header_slider_images.php")
        void getHomePageImage();

        @GET("/get_artist_images.php")
        void getArtistImage();

        @GET("/get_culb_images.php")
        void getClubImage();


        @GET("/cub_service_listing.php")
        Club getAllClubs();

        @GET("/cub_service_listing.php")
        Club getSingleClub(@Query("cubID") int clubId);


    }

    Client() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://www.event.embedinfosoft.com/webservice")
                .setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String message) {
                        Log.i("clubix", message);
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        requests = restAdapter.create(Requests.class);
    }

    public void getAllEvents(int pageNo, Callback<AllEvents> allEventsCallback) {
        requests.getAllEvents(pageNo, allEventsCallback);
    }

    public void getTodaysEvents(Callback<AllEvents> allEventsCallback) {
        requests.getTodaysEvents(EventTime.TODAY.name().toLowerCase(), allEventsCallback);
    }

    public void getTomorrowEvents(Callback<AllEvents> allEventsCallback) {
        requests.getTomorrowEvents(EventTime.TOMORROW.name().toLowerCase(), allEventsCallback);
    }

    public void getLaterEvents(Callback<AllEvents> allEventsCallback) {
        requests.getLaterEvents(EventTime.LATER.name().toLowerCase(), allEventsCallback);
    }

    public Artist getAllArtist() {
        return requests.getAllArtist();
    }

    public Artist getSingleArtist(int artistId) {
        return requests.getSingleArtist(artistId);
    }

    public Songs getAllSongs() {
        return requests.getAllSongs();
    }

    public Songs getSingleSong(int songId) {
        return requests.getSingleSongs(songId);
    }

    public void registerUser(FacebookRegister facebookRegister) {
        requests.registerUser(facebookRegister);
    }

    public void getHomePageImage() {
        requests.getHomePageImage();
    }

    public void getArtistImage() {
        requests.getArtistImage();
    }

    public void getClubImage() {
        requests.getClubImage();
    }

    public Club getAllClubs() {
        return requests.getAllClubs();
    }

    public Club getSingleClud(int clubId) {
        return requests.getSingleClub(clubId);
    }

}
