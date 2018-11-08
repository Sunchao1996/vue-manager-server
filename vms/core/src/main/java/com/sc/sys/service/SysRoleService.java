package com.sc.sys.service;

import com.sc.sys.dao.SysRoleDao;
import com.sc.sys.dao.SysRoleResourceDao;
import com.sc.sys.model.SysRole;
import com.sc.sys.model.SysRolesResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * what:
 *
 * @author 孙超 created on 2018/11/8
 */
@Service
public class SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleResourceDao sysRoleResourceDao;

    /**
     * 新增角色
     */
    public int save(SysRole sysRole) {
        int flag = sysRoleDao.save(sysRole);
        flag += sysRoleResourceDao.batchAdd(createRolesResourcesList(sysRole.getId(), sysRole.getResourcesIds()));
        return flag;
    }

    /**
     * 修改角色
     */
    public int updateById(SysRole sysRole) {
        int flag = sysRoleDao.updateById(sysRole);
        flag += sysRoleResourceDao.deleteByRoleId(sysRole.getId());
        flag += sysRoleResourceDao.batchAdd(createRolesResourcesList(sysRole.getId(), sysRole.getResourcesIds()));
        return flag;
    }

    /**
     * 构成RolesResources对象
     */
    public List<SysRolesResources> createRolesResourcesList(Integer roleId, String resources) {
        String[] resourceArray = resources.split("@");
        List<SysRolesResources> list = new ArrayList<>();
        for (String temp : resourceArray) {
            SysRolesResources sysRolesResources = new SysRolesResources();
            sysRolesResources.setRoleId(roleId);
            sysRolesResources.setResourceId(Integer.valueOf(temp));
            list.add(sysRolesResources);
        }
        return list;
    }

    /**
     * 删除角色
     */
    public int deleteById(Integer id) {
        int flag = sysRoleDao.deleteById(id);
        flag += sysRoleResourceDao.deleteByRoleId(id);
        return flag;
    }

    /**
     * 查询所有
     */
    public List<SysRole> listAll() {
        return sysRoleDao.listAll();
    }

    /**
     * 根据id查询
     */
    public SysRole getById(Integer id) {
        return sysRoleDao.getById(id);
    }

    /**
     * 根据角色代码获取
     */
    public SysRole getByRoleCode(String roleCode) {
        return sysRoleDao.getByRoleCode(roleCode);
    }
}
