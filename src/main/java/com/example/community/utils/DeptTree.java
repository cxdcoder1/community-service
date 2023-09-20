package com.example.community.utils;

import com.example.community.entity.SysDept;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sun
 */
public class DeptTree {
    private List<SysDept> deptList = new ArrayList<SysDept>();
    public DeptTree(List<SysDept> deptList) {
        this.deptList=deptList;
    }
    //建立树形结构
    public List<SysDept> builTree(){
        List<SysDept> treeMenus =new  ArrayList<SysDept>();
        for(SysDept menuNode : getRootNode()) {
            menuNode=buildChilTree(menuNode);
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }
    //递归，建立子树形结构
    private SysDept buildChilTree(SysDept pNode){
        List<SysDept> chilMenus =new ArrayList<SysDept>();
        for(SysDept menuNode : deptList) {
            if(menuNode.getParentId().equals(pNode.getDeptId())) {
                chilMenus.add(buildChilTree(menuNode));
            }
        }

        pNode.setChildren(chilMenus);
        return pNode;
    }

    //获取根节点
    private List<SysDept> getRootNode() {
        List<SysDept> rootMenuLists =new  ArrayList<SysDept>();
        for(SysDept menuNode : deptList) {
            if(menuNode.getParentId() == 0) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }
}
