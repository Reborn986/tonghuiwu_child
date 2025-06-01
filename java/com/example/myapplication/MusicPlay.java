package com.example.myapplication;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;

public class MusicPlay {
    private Context context;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private Map<String, Integer> colorToMusicMap = new HashMap<>();
    private OnPlaybackStateChangeListener stateChangeListener;

    public interface OnPlaybackStateChangeListener {
        void onPlaybackStateChanged(boolean isPlaying);
    }

    public MusicPlay(Context context) {
        this.context = context;
        initColorMusicMap();
    }

    public void setOnPlaybackStateChangeListener(OnPlaybackStateChangeListener listener) {
        this.stateChangeListener = listener;
    }

    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    private void initColorMusicMap() {
        colorToMusicMap.put("red", R.raw.red);
        colorToMusicMap.put("orange", R.raw.orange);
        colorToMusicMap.put("yellow", R.raw.yellow);
        colorToMusicMap.put("green", R.raw.green);
        colorToMusicMap.put("cyan", R.raw.qing);
        colorToMusicMap.put("blue", R.raw.blue);
        colorToMusicMap.put("purple", R.raw.purple);
        colorToMusicMap.put("pink", R.raw.pink);
        colorToMusicMap.put("brown", R.raw.brown);
        colorToMusicMap.put("rainbow", R.raw.colorful);
        colorToMusicMap.put("black", R.raw.black);
        colorToMusicMap.put("white", R.raw.white);
        
        // 添加中文支持
        colorToMusicMap.put("红色", R.raw.red);
        colorToMusicMap.put("橙色", R.raw.orange);
        colorToMusicMap.put("黄色", R.raw.yellow);
        colorToMusicMap.put("绿色", R.raw.green);
        colorToMusicMap.put("青色", R.raw.qing);
        colorToMusicMap.put("蓝色", R.raw.blue);
        colorToMusicMap.put("紫色", R.raw.purple);
        colorToMusicMap.put("粉色", R.raw.pink);
        colorToMusicMap.put("棕色", R.raw.brown);
        colorToMusicMap.put("黑色", R.raw.black);
        colorToMusicMap.put("白色", R.raw.white);
        colorToMusicMap.put("彩色", R.raw.colorful);
    }

    public void playColorMusic(String color) {
        if (color == null || color.isEmpty()) {
            return;
        }

        String normalizedColor = color.toLowerCase().trim();
        if (!colorToMusicMap.containsKey(normalizedColor)) {
            return;
        }

        stopMusic();
        mediaPlayer = MediaPlayer.create(context, colorToMusicMap.get(normalizedColor));
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(mp -> {
                isPlaying = false;
                if (stateChangeListener != null) {
                    stateChangeListener.onPlaybackStateChanged(false);
                }
            });
            startMusic();
        }
    }

    public void startMusic() {
        if (mediaPlayer == null) {
            return;
        }

        if (!isPlaying) {
            try {
                AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                if (am.requestAudioFocus(null, AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN) == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    // 设置音频流类型为音乐
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    
                    // 设置音量
                    mediaPlayer.setVolume(1.0f, 1.0f);
                    
                    // 设置循环模式
                    mediaPlayer.setLooping(false);
                    
                    // 设置音频会话ID
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                                .setUsage(AudioAttributes.USAGE_MEDIA)
                                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                .build());
                    }

                    mediaPlayer.start();
                    isPlaying = true;
                    if (stateChangeListener != null) {
                        stateChangeListener.onPlaybackStateChanged(true);
                    }
                }
            } catch (IllegalStateException e) {
                Log.e("MusicPlay", "播放器初始化失败", e);
            }
        }
    }

    public void pauseMusic() {
        if (mediaPlayer != null && isPlaying) {
            mediaPlayer.pause();
            isPlaying = false;
            if (stateChangeListener != null) {
                stateChangeListener.onPlaybackStateChanged(false);
            }
        }
    }

    public void stopMusic() {
        if (mediaPlayer != null) {
            if (isPlaying) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
            isPlaying = false;
            if (stateChangeListener != null) {
                stateChangeListener.onPlaybackStateChanged(false);
            }
        }
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void release() {
        stopMusic();
    }
}
