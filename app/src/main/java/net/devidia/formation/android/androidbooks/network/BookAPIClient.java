package net.devidia.formation.android.androidbooks.network;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Boris on 12/05/2016.
 */
public class BookAPIClient {
    private static final String API_BASE_URL = "http://openlibrary.org/";
    private AsyncHttpClient client;

    public BookAPIClient() {
        this.client = new AsyncHttpClient();
    }

    private String buildApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

    // Method for accessing the search API
    public void getBooks(final String query, JsonHttpResponseHandler handler) {
        try {
            String url = buildApiUrl("search.json?q=" + URLEncoder.encode(query, "utf-8"));
            client.get(url , handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
