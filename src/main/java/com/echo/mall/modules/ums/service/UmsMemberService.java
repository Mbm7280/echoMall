package com.echo.mall.modules.ums.service;

import com.echo.mall.api.ResObj;
import com.echo.mall.modules.ums.model.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author echo
 * @since 2022-11-08
 */
public interface UmsMemberService extends IService<UmsMember> {

    /**
     * 生成验证码
     */
    ResObj generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    ResObj verifyAuthCode(String telephone, String authCode);

}
