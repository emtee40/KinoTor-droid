package com.kinotor.tiar.kinotor.parser.video.animevost;

import android.os.AsyncTask;
import android.util.Log;

import com.kinotor.tiar.kinotor.utils.OnTaskUrlCallback;

import java.util.ArrayList;

/**
 * Created by Tiar on 02.2018.
 */

public class AnimevostUrl extends AsyncTask<Void, Void, Void> {
    private String url;
    private String[] quality_arr, url_arr;
    private OnTaskUrlCallback callback;

    public AnimevostUrl (String url, OnTaskUrlCallback callback) {
        this.url = url;
        this.callback = callback;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        callback.OnCompleted(quality_arr, url_arr);
    }

    @Override
    protected Void doInBackground(Void... voids) {
//        getSeries(GetData(url));
        getSeries(url);
        return null;
    }
    private void getSeries(String url) {
        final ArrayList<String> q = new ArrayList<>();
        final ArrayList<String> u = new ArrayList<>();
        Log.e("test", "hulyyy " + url );
        if (url.contains("[")) {
            for (String qqq : url.split("\\[")) {
                if (qqq.contains("]")) {
                    q.add(qqq.split("\\]")[0].trim() + " (mp4)");
                    u.add(qqq.split("\\]")[1].replace(",", "").trim());
                    add(q, u);
                }
            }
        }
        if (!q.isEmpty())
            add(q, u);
        else {
            q.add("видео не доступно");
            u.add("error");
            add(q, u);
        }
    }
    private void add(ArrayList<String> q,  ArrayList<String> u) {
        quality_arr = q.toArray(new String[q.size()]);
        url_arr = u.toArray(new String[u.size()]);
    }
//    private void getSeries(Document doc) {
//        final ArrayList<String> q = new ArrayList<>();
//        final ArrayList<String> u = new ArrayList<>();
//        if (doc == null) {
//            Log.d(TAG, "AnimeVost: некорректная ссылка");
//            q.add("видео недоступно");
//            u.add("error");
//        } else if (doc.body().html().contains("var flashvars")) {
//            String video_list = doc.body().html().split("flashvars = \\{")[1].split("\\};")[0];
//            if (video_list.contains("file\":\"")){
//                String allurl = video_list.split("file\":\"")[1].split("\"")[0];
//                String url = "error";
//                String url1 = "error";
//                if (allurl.contains(".mp4"))
//                    if (allurl.contains("drek"))
//                        url = "http://drek" + allurl.split("drek")[1].split("\\.mp4")[0] + ".mp4";
//                    else url = "http" + allurl.split("http")[1].split("\\.mp4")[0] + ".mp4";
//
//                if (allurl.contains(" or")) {
//                    String[] urls = allurl.split(" or ");
//                    if (urls[0].equals(url)) url1 = urls[1];
//                    else url1 = urls[0];
//                    if (url1.contains("drek"))
//                        url1 = "http://drek" + allurl.split("drek")[1].split("\\.mp4")[0] + ".mp4";
//                }
//                q.add("480 (mp4)");
//                u.add(url);
//                if (!url1.contains("error")) {
//                    q.add("зеркало 480 (mp4)");
//                    u.add(url1);
//                }
//            }
//            if (video_list.contains("filehd\":\"")){
//                String allurl = video_list.split("filehd\":\"")[1].split("\"")[0];
//                String url;
//                String url1 = "error";
//                if (allurl.contains("drek"))
//                    url = "http://drek" + allurl.split("drek")[1].split("\\.mp4")[0] + ".mp4";
//                else url = "http" + allurl.split("http")[1].split("\\.mp4")[0] + ".mp4";
//
//                if (allurl.contains(" or")) {
//                    String[] urls = allurl.split(" or ");
//                    if (urls[0].equals(url)) url1 = urls[1];
//                    else url1 = urls[0];
//                    if (url1.contains("drek"))
//                        url1 = "http://drek" + allurl.split("drek")[1].split("\\.mp4")[0] + ".mp4";
//                }
//                q.add("720 (mp4)");
//                u.add(url);
//                if (!url1.contains("error")) {
//                    q.add("зеркало 720 (mp4)");
//                    u.add(url1);
//                }
//            }
//        } else if (doc.body().html().contains("knpki")){
//            Log.d(TAG, "ParseAVMp4: 0 видео недоступно");
//            Elements allLink = doc.select("a");
//            for (Element link : allLink) {
//                if (link.attr("href").contains(".mp4")){
//                    if (link.text().contains("720")){
//                        q.add("720 (mp4)");
//                        u.add(link.attr("href"));
//                    } else {
//                        q.add("480 (mp4)");
//                        u.add(link.attr("href"));
//                    }
//                }
//            }
//        } else {
//            Log.d(TAG, "ParseAVMp4: 1 видео недоступно");
//            q.add("видео недоступно");
//            u.add("error");
//        }
//        quality_arr = q.toArray(new String[q.size()]);
//        url_arr = u.toArray(new String[u.size()]);
//    }
//
//    private Document GetData(String url){
//        url = "http://play.aniland.org/" + url + "?player=7";
//        try {
//            if (Statics.ProxyUse.contains("animevost") && Statics.ProxyCur.contains(":") && !Statics.ProxyCur.contains("адрес:порт")){
//                System.setProperty("http.proxyHost", Statics.ProxyCur.split(":")[0].trim());
//                System.setProperty("http.proxyPort", Statics.ProxyCur.split(":")[1].trim());
//            }
//            Document htmlDoc = Jsoup.connect(url)
//                    .referrer("http://animevost.org/")
//                    .userAgent("Mozilla/5.0 (Windows; U; Windows NT 5.1; de; rv:1.9) Gecko/2008052906 Firefox/3.0")
//                    .timeout(5000).ignoreContentType(true).get();
//            Log.d(TAG, "Getdata: connected to " + url);
//            return htmlDoc;
//        } catch (Exception e) {
//            Log.d(TAG, "Getdata: connected false to " + url);
//            e.printStackTrace();
//            return null;
//        }
//    }

}
