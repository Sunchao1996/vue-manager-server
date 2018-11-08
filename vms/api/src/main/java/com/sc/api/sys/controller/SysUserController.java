package com.sc.api.sys.controller;

import com.sc.util.code.EnumReturnCode;
import com.sc.util.json.JsonResult;
import com.sc.util.redis.RedisKey;
import com.sc.util.redis.RedisUtil;
import com.sc.util.session.WebSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * what:  用户信息
 *
 * @author 孙超 created on 2018/11/8
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public JsonResult info(@RequestBody Map<String, String> paramsMap) {
        if (paramsMap == null || paramsMap.get("token") == null) {
            return new JsonResult(EnumReturnCode.FAIL_INFO_GET);
        }
        WebSession webSession = redisUtil.get(RedisKey.WEBSESSION + paramsMap.get("token"), WebSession.class);
        if (webSession == null) {
            return new JsonResult(EnumReturnCode.FAIL_INFO_GET);
        }
        return new JsonResult(EnumReturnCode.SUCCESS_INFO_GET, webSession);
    }
}
