package com.sc.sys.service;

import com.sc.sys.dao.SysUserDao;
import com.sc.sys.dao.SysUserRoleDao;
import com.sc.sys.model.SysRolesResources;
import com.sc.sys.model.SysUser;
import com.sc.sys.model.SysUsersRoles;
import com.sc.sys.vo.SysUserSearchVO;
import com.sc.util.code.RandomCodeUtil;
import com.sc.util.encrypt.Md5SaltUtil;
import com.sc.util.page.PageUtil;
import com.sc.util.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * what:   系统用户
 *
 * @author 孙超 created on 2018/11/8
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    /**
     * 新增用户
     */
    public int save(SysUser sysUser) {
        sysUser.setRandomCode(RandomCodeUtil.createRandomCode(6));
        Md5SaltUtil md5SaltUtil = new Md5SaltUtil(sysUser.getRandomCode());
        sysUser.setUserPassword(md5SaltUtil.encode("123456"));
        int flag = sysUserDao.save(sysUser);
        flag += sysUserRoleDao.batchAdd(createUsersRolesList(sysUser.getId(), sysUser.getRoles()));
        return flag;
    }

    /**
     * 修改用户信息
     */
    public int updateById(SysUser sysUser) {
        int flag = sysUserDao.updateById(sysUser);
        flag += sysUserRoleDao.deleteByUserId(sysUser.getId());
        flag += sysUserRoleDao.batchAdd(createUsersRolesList(sysUser.getId(), sysUser.getRoles()));
        return flag;
    }

    /**
     * 构成SysUsersRoles对象
     */
    public List<SysUsersRoles> createUsersRolesList(Integer userId, String roles) {
        String[] roleArray = roles.split("@");
        List<SysUsersRoles> list = new ArrayList<>();
        for (String temp : roleArray) {
            SysUsersRoles sysUsersRoles = new SysUsersRoles();
            sysUsersRoles.setUserId(userId);
            sysUsersRoles.setRoleId(Integer.valueOf(temp));
            list.add(sysUsersRoles);
        }
        return list;
    }

    /**
     * 修改用户状态
     */
    public int updateStatus(Integer userStatus, Integer userId) {
        if (userStatus == null || userId == null) {
            return -1;
        }
        if (userStatus == 0) {
            userStatus = 1;
        } else {
            userStatus = 0;
        }
        return sysUserDao.updateStatus(userStatus, userId);
    }

    /**
     * 删除用户
     */
    public int deleteById(Integer id) {
        int flag = sysUserDao.deleteById(id);
        flag += sysUserRoleDao.deleteByUserId(id);
        return flag;
    }


    /**
     * 根据id查询
     */
    public SysUser getById(Integer id) {
        return sysUserDao.getById(id);
    }

    /**
     * 查询所有用户
     */
    public List<SysUser> listAll() {
        return sysUserDao.listAll();
    }

    /**
     * 根据用户名查询
     */
    public SysUser getByUserName(String userName) {
        return sysUserDao.getByUserName(userName);
    }


    /**
     * 根据条件统计个数
     */
    public int count(SysUserSearchVO sysUserSearchVO) {
        return sysUserDao.count(sysUserSearchVO);
    }

    /**
     * 根据条件查询
     */
    public List<SysUser> listBySearch(SysUserSearchVO sysUserSearchVO) {
        return sysUserDao.listBySearch(sysUserSearchVO);
    }

    /**
     * 验证密码是否正确
     */
    public boolean checkPass(SysUser sysUser, String inputPassword) {
        Md5SaltUtil md5SaltUtil = new Md5SaltUtil(sysUser.getRandomCode());
        return md5SaltUtil.isPasswordValid(sysUser.getUserPassword(), inputPassword);
    }

    public static void main(String[] args) {
        Md5SaltUtil md5SaltUtil = new Md5SaltUtil("@@@@@");
        System.out.println(md5SaltUtil.encode("123456"));
    }
}
