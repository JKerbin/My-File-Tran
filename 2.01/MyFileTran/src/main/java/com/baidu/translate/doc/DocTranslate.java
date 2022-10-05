package com.baidu.translate.doc;

import com.baidu.translate.data.Config;
import com.baidu.translate.http.HttpClient;
import com.baidu.translate.http.HttpStringCallback;
import com.baidu.translate.http.HttpParams;
import com.baidu.translate.utils.FileUtil;

import java.io.File;

/**
 * DocTranslate
 */
public class DocTranslate {
    private static final String DOCCOUNT_URL = "http://fanyi-api.baidu.com/api/trans/vip/doccount";
    private static final String DOCTRANS_URL = "http://fanyi-api.baidu.com/api/trans/vip/doctrans";

    private static final String FILE_CONTENT_TYPE = "mutipart/form-data";

    private final HttpClient httpClient;
    private Config config;

    public DocTranslate() {
        this.httpClient = new HttpClient();
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    /**
     * 统计校验服务
     *
     * @param callback 请求回调
     */
    public void docCount(HttpStringCallback callback) {
        if (callback == null || config == null) {
            return;
        }
        HttpParams params = new HttpParams();
        params.put("appid", config.getAppId());
        params.put("file", new File(config.getFilePath()), FILE_CONTENT_TYPE);
        params.put("from", config.getFrom());
        params.put("to", config.getTo());
        params.put("timestamp", System.currentTimeMillis() / 1000L); // ms --> s
        params.put("type", FileUtil.getExtension(config.getFilePath()));
        params.put("sign", DocSigner.sign(config, params));
        httpClient.post(DOCCOUNT_URL, params, callback);
    }

    public void docTrans(HttpStringCallback callback) {
        if (callback == null || config == null) {
            return;
        }
        HttpParams params = new HttpParams();
        params.put("appid", config.getAppId());
        params.put("file", new File(config.getFilePath()), FILE_CONTENT_TYPE);
//        params.put("fileId", "XXXXXX");
        params.put("from", config.getFrom());
        params.put("to", config.getTo());
        params.put("timestamp", System.currentTimeMillis() / 1000L); // ms --> s
        params.put("type", FileUtil.getExtension(config.getFilePath()));
        params.put("sign", DocSigner.sign(config, params));
        httpClient.post(DOCTRANS_URL, params, callback);
    }
}
