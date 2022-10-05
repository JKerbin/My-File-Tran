package com.baidu.translate.doc;

import com.baidu.translate.data.Config;
import com.baidu.translate.http.HttpParams;
import com.baidu.translate.utils.FileUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * DocTranslate signer
 */
class DocSigner {

    static String sign(Config config, HttpParams params) {
        if (config == null || params == null) {
            return "";
        }
        // 第1步，根据生成的token，计算sign值
        Map<String, String> stringParams = params.getStringParams();
        Map<String, HttpParams.FileWrapper> fileParams = params.getFileParams();
        // 先拿到所有的key，对key列表做排序
        List<String> keys = new ArrayList<>(stringParams.keySet());
        Collections.sort(keys);
        // 根据排序后的key列表来拼接sign
        StringBuilder builder = new StringBuilder();
        for (String key : keys) {
            String value = stringParams.get(key);
            builder.append(key).append("=").append(value).append("&");
        }
        // 然后拼接上file的md5
        // TODO: 2020/12/1 避免使用硬编码，考虑从fileParams中拿第一个文件来拼接。
        if (fileParams.containsKey("file")) {
            HttpParams.FileWrapper file = fileParams.get("file");
            String fileMD5 = FileUtil.md5(file.file).toLowerCase();
            builder.append(fileMD5);
        }
        // 最后拼接上secretKey
        builder.append(config.getSecretKey());
        return FileUtil.md5(builder.toString()).toLowerCase();
    }
}
