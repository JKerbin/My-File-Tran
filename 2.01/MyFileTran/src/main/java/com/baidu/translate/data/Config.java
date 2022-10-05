package com.baidu.translate.data;

public class Config {
    private final String appId;
    private final String secretKey;
    private String from;
    private String to;
    private String filePath;

    /**
     * 构建Config对象实例。具体请在 { http://api.fanyi.baidu.com/api/trans/product/desktop }上申请查看
     *
     * @param appId     APP ID
     * @param secretKey 密钥
     */
    public Config(String appId, String secretKey) {
        this.appId = appId;
        this.secretKey = secretKey;
    }

    /**
     * 设置翻译语种方向
     *
     * @param from 源语言方向
     * @param to   目标语言方向
     * @see Language
     */
    public void lang(String from, String to) {
        this.from = from;
        this.to = to;
    }

    /**
     * 设置翻译文件路径。
     *
     * @param filePath 文件路径
     */
    public void file(String filePath) {
        this.filePath = filePath;
    }

    public String getAppId() {
        return appId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
