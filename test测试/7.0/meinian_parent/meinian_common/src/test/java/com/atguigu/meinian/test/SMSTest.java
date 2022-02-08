package com.atguigu.meinian.test;

import com.atguigu.meinian.uilts.SMSUtils;
import com.atguigu.meinian.uilts.ValidateCodeUtils;
import org.junit.Test;

public class SMSTest {

    //@Test
    public void sms() throws Exception {
        Integer code = ValidateCodeUtils.generateValidateCode(6);
        SMSUtils.sendShortMessage("17683805053",String.valueOf(code));
    }
    //@Test
    public void sms2() throws Exception {
        String code = ValidateCodeUtils.generateValidateCode4String(6);
        SMSUtils.sendShortMessage("13581465771",code);
    }
}
