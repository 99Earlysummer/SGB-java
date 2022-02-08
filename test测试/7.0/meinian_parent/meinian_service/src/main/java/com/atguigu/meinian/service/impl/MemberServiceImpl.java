package com.atguigu.meinian.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.meinian.mapper.MemberMapper;
import com.atguigu.meinian.pojo.Member;
import com.atguigu.meinian.service.MemberService;
import com.atguigu.meinian.uilts.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(interfaceClass = MemberService.class)
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void addMember(String telephone) {
        Member member = memberMapper.findMemberByTelephone(telephone);
        if (member == null) {
            //表示该手机号未注册会员，将其注册为会员
            member = new Member();
            member.setPhoneNumber(telephone);
            member.setRegTime(new Date());
            memberMapper.addMember(member);
        }
    }
    /**
     * 根据注册日期查询 根据月份统计会员数量<遍历12个月  每个月的会员数量统计起来></遍历12个月>
     * @param list
     * @return
     */
    @Override
    public List<Integer> findMemberCountByMonth(List<String> list) {
//        List list=memberMapper.findMemberCountByMonth();
        List<Integer> arrayList = new ArrayList<>();
        //检验传来的值不能为空
        if (list != null && list.size() > 0) {
            for (String s : list) {
                //获取最后一天
                String lastDayOfMonth = DateUtils.getLastDayOfMonth(s);
                //  迭代过去12个月，每个月注册会员的数量，根据注册日期查询  然后将每个月的会员数量添加到arrayList中
                Integer integer=memberMapper.findMemberCountByMonth(lastDayOfMonth);
                arrayList.add(integer);
            }
        }
        return arrayList;


    }
}
