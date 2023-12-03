package com.lhc.utils;

import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Response;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Component
public class COS {
    private final TreeMap<String, Object> config = new TreeMap<String, Object>();
    private final String secretId = "AKIDeAh94qcFf6VkkiV9bs9IEyV4VnsnUxBD";
    private final String secretKey = "1rXGn47vVtGn8GCtxz4vgNqEQanrncDd";
    private final String bucket = "yinmu-1322413319";
    private final String region = "ap-nanjing";

    public Map<String, String> getConfig() {
        Map<String, String> config = new HashMap<>();
        config.put("bucket", bucket);
        config.put("region", region);
        config.put("prefix", "avatar");
        return config;
    }

    public Response getAvatarKey() {
        try {
            config.put("secretId", secretId);
            config.put("secretKey", secretKey);
            config.put("durationSeconds", 1800);
            config.put("bucket", bucket);
            config.put("region", region);
            config.put("allowPrefixes", new String[]{
                    "avatar/*",
            });
            String[] allowActions = new String[]{
                    // 简单上传
                    "name/cos:PutObject",
            };
            config.put("allowActions", allowActions);

            return CosStsClient.getCredential(config);
        } catch (Exception e) {
            throw new ServiceException(Result.ERROR, "no valid secret !");
        }

    }
}
