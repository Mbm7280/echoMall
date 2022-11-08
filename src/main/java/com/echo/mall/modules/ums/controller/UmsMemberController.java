package com.echo.mall.modules.ums.controller;


import com.echo.mall.api.ResObj;
import com.echo.mall.modules.ums.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-11-08
 */
@RestController
@Api(value = "UmsMemberController", tags={"会员登录注册管理"})
@RequestMapping("/ums/umsMember")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;


    @ApiOperation("获取验证码")
    @GetMapping(value = "/getAuthCode")
    @ResponseBody
    public ResObj getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @GetMapping(value = "/verifyAuthCode")
    @ResponseBody
    public ResObj updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone,authCode);
    }

}

