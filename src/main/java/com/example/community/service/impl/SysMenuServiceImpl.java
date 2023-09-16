package com.example.community.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.community.dao.SysMenuDao;
import com.example.community.entity.SysMenu;
import com.example.community.service.SysMenuService;
//import com.example.community.utils.MenuTree;
import com.example.community.utils.MenuTree;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

/**
 * 菜单权限表(SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2023-09-14 09:53:02
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

    @Resource
    private SysMenuDao sysMenuDao;
    @Override
    public List<SysMenu> MenuTree(int id) {
        List<SysMenu> sysMenuList = sysMenuDao.selectMenuTreeByUserId(id);
        MenuTree menuTree = new MenuTree(sysMenuList);
        List<SysMenu> sysMenuList1 = menuTree.builTree();
        return sysMenuList1;

    }

    @Override
    public List<SysMenu> getMenuList(String menuName, String status) {
        List<SysMenu> menuList = sysMenuDao.getMenuList(menuName, status);
        menuList.sort(new Comparator<SysMenu>() {
            @Override
            public int compare(SysMenu o1, SysMenu o2) {
                return o1.getOrderNum() - o2.getOrderNum();
            }
        });
        return menuList;
    }


//    @Override
//    public List<SysMenu> getMenuList(String menuName, String status) {
//        List<SysMenu> sysMenuList = sysMenuDao.getMenuList(menuName,status);
//        MenuTree menuTree = new MenuTree(sysMenuList);
//        List<SysMenu> sysMenuList1 = menuTree.builTree();
//        return sysMenuList1;
//    }
}

