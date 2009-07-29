package com.hadeslee.yoyoplayer.lyric;

import com.hadeslee.yoyoplayer.playlist.PlayListItem;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class LRCUtil {

    public static final String SearchPath = "http://ttlrcct2.qianqian.com/dll/lyricsvr.dll?sh?Artist={0}&Title={1}&Flags=0";
    public static final String DownloadPath = "http://ttlrcct2.qianqian.com/dll/lyricsvr.dll?dl?Id={0}&Code={1}";

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
        if(!item.isInited()){
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
        singer = singer.toLowerCase().replace(" ", "").replace("'", "");
        title = title.toLowerCase().replace(" ", "").replace("'", "");
        String url = (MessageFormat.format(SearchPath, ToQianQianHexString(singer, "UTF-16LE"), ToQianQianHexString(title, "UTF-16LE")));
        String back = readURL(url);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //support the namespace
        factory.setNamespaceAware(true);
        //Get the instance
        Document doc = factory.newDocumentBuilder().parse(new InputSource(new StringReader(back)));
        System.out.println(back);
        NodeList nodes = doc.getElementsByTagName("lrc");
        List<SearchResult> list = new ArrayList<SearchResult>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            final String artistTemp = node.getAttributes().getNamedItem("artist").getTextContent();
            final String titleTemp = node.getAttributes().getNamedItem("title").getTextContent();
            final int lrcId = Integer.parseInt(node.getAttributes().getNamedItem("id").getTextContent());
            SearchResult.Task task = new SearchResult.Task() {

                public String getLyricContent() {
                    try {
                        String url = MessageFormat.format(DownloadPath, "" + lrcId, CreateQianQianCode(artistTemp, titleTemp, lrcId));
                        return readURL(url);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(LRCUtil.class.getName()).log(Level.SEVERE, null, ex);
                        return null;
                    }
                }
            };
            list.add(new SearchResult(artistTemp, titleTemp, task));
        }
        return list;
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

    private static String ToQianQianHexString(String s, String chatset) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = s.getBytes(chatset);
        for (byte b : bytes) {
            int j = b & 0xff;
            if (j < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(j, 16).toUpperCase());
        }
        return sb.toString();
    }

    private static String CreateQianQianCode(String singer, String title, int lrcId) throws UnsupportedEncodingException {
        String qqHexStr = ToQianQianHexString(singer + title, "UTF-8");
        int length = qqHexStr.length() / 2;
        int[] song = new int[length];
        for (int i = 0; i < length; i++) {
            song[i] = Integer.parseInt(qqHexStr.substring(i * 2, i * 2 + 2), 16);
        }
        int t1 = 0, t2 = 0, t3 = 0;
        t1 = (lrcId & 0x0000FF00) >> 8;
        if ((lrcId & 0x00FF0000) == 0) {
            t3 = 0x000000FF & ~t1;
        } else {
            t3 = 0x000000FF & ((lrcId & 0x00FF0000) >> 16);
        }

        t3 = t3 | ((0x000000FF & lrcId) << 8);
        t3 = t3 << 8;
        t3 = t3 | (0x000000FF & t1);
        t3 = t3 << 8;
        if ((lrcId & 0xFF000000) == 0) {
            t3 = t3 | (0x000000FF & (~lrcId));
        } else {
            t3 = t3 | (0x000000FF & (lrcId >> 24));
        }

        int j = length - 1;
        while (j >= 0) {
            int c = song[j];
            if (c >= 0x80) {
                c = c - 0x100;
            }

            t1 = (int) ((c + t2) & 0x00000000FFFFFFFFL);
            t2 = (int) ((t2 << (j % 2 + 4)) & 0x00000000FFFFFFFFL);
            t2 = (int) ((t1 + t2) & 0x00000000FFFFFFFFL);
            j -= 1;
        }
        j = 0;
        t1 = 0;
        while (j <= length - 1) {
            int c = song[j];
            if (c >= 128) {
                c = c - 256;
            }
            int t4 = (int) ((c + t1) & 0x00000000FFFFFFFFL);
            t1 = (int) ((t1 << (j % 2 + 3)) & 0x00000000FFFFFFFFL);
            t1 = (int) ((t1 + t4) & 0x00000000FFFFFFFFL);
            j += 1;
        }

        int t5 = (int) Conv(t2 ^ t3);
        t5 = (int) Conv(t5 + (t1 | lrcId));
        t5 = (int) Conv(t5 * (t1 | t3));
        t5 = (int) Conv(t5 * (t2 ^ lrcId));

        long t6 = (long) t5;
        if (t6 > 2147483648L) {
            t5 = (int) (t6 - 4294967296L);
        }
        return Integer.toString(t5);
    }

    public static long Conv(int i) {
        long r = i % 4294967296L;
        if (i >= 0 && r > 2147483648L) {
            r = r - 4294967296L;
        }

        if (i < 0 && r < 2147483648L) {
            r = r + 4294967296L;
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        // "http://ttlrcct2.qianqian.com/dll/lyricsvr.dll?sh?Artist=&Title=29597F4F8476C57F8081&Flags=0"
        List<SearchResult> list = search("", "天使的翅膀");
        System.out.println(list.get(0).getContent());
//        System.out.println(CreateQianQianCode("西单女孩", "天使的翅膀", 263407));
    }
}
