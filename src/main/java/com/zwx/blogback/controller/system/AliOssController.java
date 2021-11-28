package com.zwx.blogback.controller.system;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class AliOssController {

    private String accessId = "*";
    private String secretId = "*";
    private String endpoint = "*";
    private String bucketName = "pig-blog";

    private String dir = "blog-file/img/";
    private String host = "https://" + bucketName + "." + endpoint;

    private OSS ossClient;

    @GetMapping
    public Object getToken() throws UnsupportedEncodingException, JSONException {
        ossClient = new OSSClientBuilder().build(endpoint,accessId,secretId);
        long expireTime = 30;
        long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        // PostObject请求最大可支持的文件大小为5 GB，即CONTENT_LENGTH_RANGE为5*1024*1024*1024。
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
        String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes("utf-8");
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = ossClient.calculatePostSignature(postPolicy);



        Map<String, String> respMap = new LinkedHashMap<String, String>();
        respMap.put("accessId", accessId);
        respMap.put("policy", encodedPolicy);
        respMap.put("signature", postSignature);
        respMap.put("dir", dir);
        respMap.put("host",host);
        respMap.put("expire", String.valueOf(expireEndTime / 1000));

        /**
        //String callbackUrl = "http://localhost:8527/";
        JSONObject jasonCallback = new JSONObject();
        //jasonCallback.put("callbackUrl", callbackUrl);
        jasonCallback.put("callbackBody",
                "filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}");
        jasonCallback.put("callbackBodyType", "application/x-www-form-urlencoded");
        String base64CallbackBody = BinaryUtil.toBase64String(jasonCallback.toString().getBytes());
        respMap.put("callback", base64CallbackBody);*/

        return respMap;
    }

}
