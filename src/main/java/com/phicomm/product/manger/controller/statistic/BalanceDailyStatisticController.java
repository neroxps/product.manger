package com.phicomm.product.manger.controller.statistic;

import com.phicomm.product.manger.annotation.FunctionPoint;
import com.phicomm.product.manger.model.common.CommonResponse;
import com.phicomm.product.manger.model.common.Response;
import com.phicomm.product.manger.model.statistic.Balance24HourDisplayQueryResultModel;
import com.phicomm.product.manger.model.statistic.BalanceAsHourModel;
import com.phicomm.product.manger.service.BalanceDailyStatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import static com.sun.tools.doclint.Entity.or;


/**
 * Created by song02.cao on 2017/11/16.
 */

@Controller
public class BalanceDailyStatisticController {

    private BalanceDailyStatisticService balanceDailyStatisticService;

    @Autowired
    public BalanceDailyStatisticController(BalanceDailyStatisticService balanceDailyStatisticService) {
        this.balanceDailyStatisticService = balanceDailyStatisticService;
        Assert.notNull(this.balanceDailyStatisticService);
    }

    @RequestMapping(value = "balance/statistic/balance/24hour/display", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ApiOperation(value = "体脂称测量统计24小时分布")
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "正常情况", response = Response.class),
    })
    @FunctionPoint("common")
    public Response<Balance24HourDisplayQueryResultModel> get24HourDisplay() {
        Balance24HourDisplayQueryResultModel balance24HourDisplayQueryResultModel = balanceDailyStatisticService.get24HourDisplay();
        return new Response<Balance24HourDisplayQueryResultModel>().setData(balance24HourDisplayQueryResultModel);
    }

}
    
 