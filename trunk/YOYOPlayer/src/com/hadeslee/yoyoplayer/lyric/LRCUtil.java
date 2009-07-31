package com.hadeslee.yoyoplayer.lyric;

import com.hadeslee.yoyoplayer.lyric.SearchResult.Task;
import com.hadeslee.yoyoplayer.playlist.PlayListItem;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LRCUtil {

    public static final String getSingleResultURL = "http://lrcfinder.appspot.com/YOYO?cmd=getSingleResult&artist={0}&title={1}";
    public static final String getLyricContentURL = "http://lrcfinder.appspot.com/YOYO?cmd=getLyricContent&id={0}&lrcId={1}&lrcCode={2}&artist={3}&title={4}";
    public static final String getResultListURL = "http://lrcfinder.appspot.com/YOYO?cmd=getResultList&artist={0}&title={1}";

    private static String $(String s) throws UnsupportedEncodingException {
        return URLEncoder.encode(s, "UTF-8");
    }

    private static List<SearchResult> getSearchResult(String artistParam, String titleParam) throws Exception {
        String urlContent = MessageFormat.format(getResultListURL, $(artistParam), $(titleParam));
        ObjectInputStream ois = getObjectInputStream(urlContent);
        int back = ois.readInt();
        List<SearchResult> list = new ArrayList<SearchResult>();
        if (back == 1) {
            int size = ois.readInt();
            for (int i = 0; i < size; i++) {
                final String artist = ois.readUTF();
                final String lrcCode = ois.readUTF();
                final String lrcId = ois.readUTF();
                final String title = ois.readUTF();
                final String id = ois.readUTF();
                final Task task = new Task() {

                    public String getLyricContent() {
                        return getLyricContent_S(id, lrcId, lrcCode, artist, title);
                    }
                };
                list.add(new SearchResult(id, lrcId, lrcCode, artist, title, task));
            }
        }
        return list;
    }

    private static String getSingleResult(String artistParam, String titleParam) throws Exception {
        String urlContent = MessageFormat.format(getSingleResultURL, $(artistParam), $(titleParam));
        ObjectInputStream ois = getObjectInputStream(urlContent);
        int back = ois.readInt();
        if (back == 1) {
            return ois.readUTF();
        } else {
            return null;
        }
    }

    private static String getLyricContent_S(String id, String lrcId, String lrcCode, String artist, String title) {
        try {
            String urlContent = MessageFormat.format(getLyricContentURL, $(id), $(lrcId), $(lrcCode), $(artist), $(title));
            ObjectInputStream ois = getObjectInputStream(urlContent);
            int back = ois.readInt();
            if (back == 1) {
                return ois.readUTF();
            } else {
                return "";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    private static ObjectInputStream getObjectInputStream(String urlContent) throws Exception {
        URL url = new URL(urlContent);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        ObjectInputStream ois = new ObjectInputStream(conn.getInputStream());
        return ois;
    }

    /**
     * 根据传入的歌名和歌手名，得到一个搜索的列表
     * 注意，传进来的不能为null,否则将会出现不可意料的
     * 异常
     * 这个方法调用另一个方法，并且进行多种组合进行查找，直到
     * 有结果或者组合都有完了为止
     * @param item 要搜索的项
     * @return 一个搜索的列表
     */
    public static List<SearchResult> search(PlayListItem item) {
        if (!item.isInited()) {
            item.reRead();
        }
        List<SearchResult> list = new ArrayList<SearchResult>();
        try {
            //先把歌手名和歌名一起附上
            List<SearchResult> temp = search(item.getArtist(), item.getTitle());
            if (temp.isEmpty()) {
                temp = search("", item.getTitle());
                if (temp.isEmpty()) {
                    temp = search("", item.getName());
                }
            }
            list.addAll(temp);
        } catch (Exception ex) {
            Logger.getLogger(LRCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    /**
     * 实际上进行搜索的方法
     * @param singer
     * @param title
     * @return
     */
    public static List<SearchResult> search(String singer, String title) throws Exception {
        if (singer == null) {
            singer = "";
        }
        if (title == null) {
            title = "";
        }
        return getSearchResult(singer, title);
    }

    private static String readURL(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String temp = null;
            StringBuilder sb = new StringBuilder();
            while ((temp = br.readLine()) != null) {
                sb.append(temp).append("\n");
            }
            br.close();
            return sb.toString();
        } catch (Exception exe) {
            exe.printStackTrace();
            return null;
        }
    }
}
