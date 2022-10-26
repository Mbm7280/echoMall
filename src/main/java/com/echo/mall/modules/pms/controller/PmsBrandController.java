package com.echo.mall.modules.pms.controller;


import cn.hutool.core.collection.CollectionUtil;
import com.echo.mall.modules.pms.model.PmsBrand;
import com.echo.mall.modules.pms.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author echo
 * @since 2022-10-25
 */
@RestController
@RequestMapping("/pms/pmsBrand")
@Api(value="pmsBrandController",tags={"品牌管理接口"})
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;


    @ApiOperation("查询品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String queryBrandList() {
        List<PmsBrand> brandList = pmsBrandService.list();
        if(CollectionUtil.isEmpty(brandList)){
            return "failed";
        }else {
            return "success";
        }
    }


}

