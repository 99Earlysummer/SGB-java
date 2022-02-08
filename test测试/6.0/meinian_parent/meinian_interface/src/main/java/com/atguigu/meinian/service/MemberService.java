package com.atguigu.meinian.service;

import java.util.List;

public interface MemberService {
    /**
     * 加入会员信息
     * @param telephone
     */
    void addMember(String telephone);

    /**
     * 查询所有会员
     * @param list
     * @return
     */
    List<Integer> findMemberCountByMonth(List<String> list);
}
