package com.example.myapplication;
import android.graphics.Color;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WebSocketClient {
    private static final String TAG = "WebSocketClient";
    private WebSocket webSocket;
    private final WebSocketCallback callback;
    public boolean isConnected = false;

    public interface WebSocketCallback {
        void onConnected();
        void onColorReceived(int color);
        void onConnectionFailure(String error);
    }

    public boolean isConnected() {
        return isConnected;
    }

    public WebSocketClient(String serverUrl, WebSocketCallback callback) {
        this.callback = callback;
        initialize(serverUrl);
    }

    private void initialize(String serverUrl) {
        OkHttpClient client = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .build();

        Request request = new Request.Builder()
                .url(serverUrl)
                .build();

        // 使用正确的 listener 变量名（小写）
        webSocket = client.newWebSocket(request, listener);
    }

    // 修正 1：将 listener 定义为成员变量（小写），并修复方法作用域
    private final WebSocketListener listener = new WebSocketListener() {
        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            isConnected = true;
            Log.d(TAG, "Connection opened");
            callback.onConnected();
        }

        @Override
        public void onMessage(WebSocket webSocket, String text) {
            Log.d("WebSocket", "Received message: " + text);
            try {
                int[] rgb = parseColorData(text);
                Log.d("WebSocket", "jiexihou RGB: r=" + rgb[0] + ", g=" + rgb[1] + ", b=" + rgb[2]);
                int color = Color.rgb(rgb[0], rgb[1], rgb[2]);
                Log.d("WebSocket", "rgb: #" + Integer.toHexString(color));
                callback.onColorReceived(color);
            } catch (Exception e) {
                // 修正 2：定义 error 变量
                String error = "jiexierror: " + e.getMessage();
                Log.e("WebSocket", error);
                callback.onConnectionFailure(error);
            }
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            isConnected = false;
            String error = "Connection failed: " + t.getMessage();
            Log.e(TAG, error);
            callback.onConnectionFailure(error);
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            isConnected = false;
            Log.d(TAG, "Connection closed: " + reason);
        }
    };

    // 修正 3：将 parseColorData 移到 listener 外部（属于 WebSocketClient 类）
    private int[] parseColorData(String json) throws Exception {
        try {
            JSONObject root = new JSONObject(json);
            JSONObject data = root.getJSONObject("data");
            return new int[]{
                    data.getInt("r"),
                    data.getInt("g"),
                    data.getInt("b")
            };
        } catch (JSONException e) {
            throw new Exception("JSON geshicuowu: " + e.getMessage());
        }
    }

    // 修正 4：close 方法应属于 WebSocketClient 类
    public void close() {
        if (webSocket != null) {
            webSocket.close(1000, "正常关闭");
        }
    }
}
