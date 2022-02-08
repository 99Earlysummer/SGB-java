package com.atguigu.meinian.mapper;

import com.atguigu.meinian.pojo.Member;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface MemberMapper {

    /**
     * 查询会员表，判断当前预约人是否是会员
     * Member是个对象  如果有多个对象就是匹配不到
     * @param telephone
     * @return
     */
    Member findMemberByTelephone(@Param("telephone") String telephone);

    /**
     * 添加所有注册信息
     * @param member
     */
    void addMember(Member member);

    Integer findMemberCountByMonth(@Param("lastDayOfMonth") String lastDayOfMonth);

    /**
     * 获取今日新增会员数
     * @param reportDate
     * @return
     */
    Integer getTodayNewMember(@Param("regTime") String reportDate);

    /**
     * 获取总会员数
     * @return
     */
    Integer getTotalMember();

    /**
     * 获取本周或本月新增会员数
     * @param thisWeekMonday
     * @return
     */
    Integer getThisWeekAndMonthNewMember(@Param("regTime") Date thisWeekMonday);
}
