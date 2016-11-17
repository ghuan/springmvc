package com.fanfan.system.ws.client;

/**
 * @description:
 * @autor: huan.gao
 * @Time: 2016/9/27 15:30
 */
public class Test {
    public static void main(String args[]){
        GetPersonnel getPersonnel = new GetPersonnelService().getGetPersonnelPort();
        System.out.println(getPersonnel.getPersonnelPage());
    }
}
