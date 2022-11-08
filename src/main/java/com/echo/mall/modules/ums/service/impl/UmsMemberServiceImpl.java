package com.echo.mall.modules.ums.service.impl;

import com.echo.mall.api.RedisApi;
import com.echo.mall.api.ResObj;
import com.echo.mall.modules.ums.model.UmsMember;
import com.echo.mall.modules.ums.mapper.UmsMemberMapper;
import com.echo.mall.modules.ums.service.UmsMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author echo
 * @since 2022-11-08
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Autowired
    private RedisApi redisApi;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public ResObj generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisApi.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisApi.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return ResObj.success(sb.toString(), "获取验证码成功");
    }


    //对输入的验证码进行校验
    @Override
    public ResObj verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return ResObj.failed("请输入验证码");
        }
        String realAuthCode = redisApi.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return ResObj.success( "验证码校验成功");
        } else {
            return ResObj.failed("验证码不正确");
        }
    }
}
