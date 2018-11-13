package com.sc.api.sys.controller;

import com.sc.common.page.PageDto;
import com.sc.sys.model.SysUser;
import com.sc.sys.service.SysUserService;
import com.sc.sys.vo.SysUserSearchVO;
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

import java.util.List;
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
    @Autowired
    private SysUserService sysUserService;

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

    /**
     * 根据条件查询
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JsonResult list(@RequestBody SysUserSearchVO sysUserSearchVO) {
        List<SysUser> list = sysUserService.listBySearch(sysUserSearchVO);
        Integer count = sysUserService.count(sysUserSearchVO);
        PageDto pageDto = new PageDto(sysUserSearchVO.getPageIndex(), count, list);
        return new JsonResult(EnumReturnCode.SUCCESS_INFO_GET, pageDto);
    }

    /**
     * 根据id修改状态
     */
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public JsonResult updateStatus(@RequestBody Map<String, String> paramsMap) {
        if (paramsMap == null || paramsMap.get("usid") == null) {
            return new JsonResult(EnumReturnCode.FAIL_OPERA);
        }
        int flag = sysUserService.updateStatus(Integer.valueOf(paramsMap.get("usid")));
        if (flag > 0) {
            return new JsonResult(EnumReturnCode.SUCCESS_OPERA);
        } else {
            return new JsonResult(EnumReturnCode.FAIL_OPERA);
        }
    }

    /**
     * 根据id重置密码为123456
     */
    @RequestMapping(value = "/updateResetPwd", method = RequestMethod.POST)
    public JsonResult updateResetPwd(@RequestBody Map<String, String> paramsMap) {
        if (paramsMap == null || paramsMap.get("usid") == null) {
            return new JsonResult(EnumReturnCode.FAIL_OPERA);
        }
        int flag = sysUserService.updateResetPwd(Integer.valueOf(paramsMap.get("usid")));
        if (flag > 0) {
            return new JsonResult(EnumReturnCode.SUCCESS_OPERA);
        } else {
            return new JsonResult(EnumReturnCode.FAIL_OPERA);
        }
    }

    /**
     * 检验用户名是否可用
     */
    @RequestMapping(value = "/checkUserCode", method = RequestMethod.POST)
    public JsonResult checkUserName(@RequestBody SysUserSearchVO sysUserSearchVO) {
        SysUser sysUser = sysUserService.getByUserName(sysUserSearchVO.getUserName());
        if (sysUser != null) {
            return new JsonResult(EnumReturnCode.SUCCESS_INFO_GET, false);
        } else {
            return new JsonResult(EnumReturnCode.SUCCESS_INFO_GET, true);
        }
    }
}
