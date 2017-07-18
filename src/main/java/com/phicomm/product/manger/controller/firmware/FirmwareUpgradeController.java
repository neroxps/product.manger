package com.phicomm.product.manger.controller.firmware;

import com.alibaba.fastjson.JSONObject;
import com.phicomm.product.manger.annotation.FunctionPoint;
import com.phicomm.product.manger.exception.*;
import com.phicomm.product.manger.model.common.CommonResponse;
import com.phicomm.product.manger.model.firmware.FirmwareInfo;
import com.phicomm.product.manger.service.FirmwareUpgradeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * 固件文件上传
 * <p>
 * Created by yufei.liu on 2017/7/10.
 */
@Controller
public class FirmwareUpgradeController {

    private FirmwareUpgradeService firmwareUpgradeService;

    @Autowired
    public FirmwareUpgradeController(FirmwareUpgradeService firmwareUpgradeService) {
        this.firmwareUpgradeService = firmwareUpgradeService;
        Assert.notNull(this.firmwareUpgradeService);
    }

    /**
     * 固件升级下面手环项目文件上传接口
     *
     * @return 上传成功返回0，失败返回1
     */
    @RequestMapping(value = "firmware/upgrade/wristband/file/upload", method = RequestMethod.POST,
            consumes = "multipart/form-data", produces = "application/json")
    @ApiOperation("固件升级下面手环项目文件上传接口")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "正常情况", response = CommonResponse.class),
            @ApiResponse(code = 2, message = "数据格式错误", response = CommonResponse.class),
            @ApiResponse(code = 7, message = "文件上传失败", response = CommonResponse.class),
            @ApiResponse(code = 8, message = "固件版本已经存在", response = CommonResponse.class)

    })
    @FunctionPoint(value = "common")
    public CommonResponse firmwareUpgradeWristbandFileUpload(@RequestParam("firmwareType") String firmwareType,
                                                             @RequestParam("hardwareVersion") String hardwareVersion,
                                                             @RequestParam("firmwareVersion") String firmwareVersion,
                                                             @RequestParam("gnssVersion") String gnssVersion,
                                                             @RequestParam("environment") String environment,
                                                             @RequestPart("file") MultipartFile file,
                                                             @RequestParam("description") String description)
            throws DataFormatException, UploadFileException, VersionHasExistException {
        firmwareUpgradeService.firmwareUpgradeWristbandFileUpload(firmwareType,
                hardwareVersion, firmwareVersion, environment, gnssVersion, file, description);
        return CommonResponse.ok();
    }

    /**
     * 固件升级获取列表接口
     *
     * @return 固件列表
     */
    @RequestMapping(value = "firmware/upgrade/list", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json")
    @ApiOperation("固件升级获取列表接口")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "正常情况", response = CommonResponse.class),
            @ApiResponse(code = 2, message = "数据格式错误", response = CommonResponse.class)
    })
    @FunctionPoint(value = "common")
    public JSONObject firmwareUpgradeWristbandList(@RequestParam("environment") String environment)
            throws DataFormatException {
        return firmwareUpgradeService.firmwareUpgradeWristbandList(environment);
    }

    /**
     * 获取固件详情
     *
     * @return 获取固件详情
     */
    @RequestMapping(value = "firmware/upgrade/detail", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json")
    @ApiOperation("获取固件详情")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "正常情况", response = CommonResponse.class),
            @ApiResponse(code = 2, message = "数据格式错误", response = CommonResponse.class)
    })
    @FunctionPoint(value = "common")
    public FirmwareInfo getFirmwareDetail(@RequestParam("firmwareType") String firmwareType,
                                          @RequestParam("hardwareCode") String hardwareCode,
                                          @RequestParam("environment") String environment,
                                          @RequestParam("versionCode") String versionCode)
            throws DataFormatException {
        return firmwareUpgradeService.getFirmwareDetail(
                firmwareType, hardwareCode, environment, versionCode);
    }

    /**
     * 修改当前固件版本
     *
     * @return 修改当前固件版本
     */
    @RequestMapping(value = "firmware/upgrade/modify/current/version", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json")
    @ApiOperation("修改当前固件版本")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "正常情况", response = CommonResponse.class),
            @ApiResponse(code = 2, message = "数据格式错误", response = CommonResponse.class),
            @ApiResponse(code = 9, message = "版本不存在", response = CommonResponse.class)
    })
    @FunctionPoint(value = "common")
    public CommonResponse modifyCurrentFirmwareVersion(@RequestParam("firmwareType") String firmwareType,
                                                       @RequestParam("hardwareCode") String hardwareCode,
                                                       @RequestParam("environment") String environment,
                                                       @RequestParam("versionCode") String versionCode)
            throws DataFormatException, VersionNotExistException {
        firmwareUpgradeService.modifyCurrentFirmwareVersion(
                firmwareType, hardwareCode, environment, versionCode);
        return CommonResponse.ok();
    }

    /**
     * 获取配置信息
     *
     * @return 获取配置信息
     */
    @RequestMapping(value = "firmware/upgrade/config/get", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json")
    @ApiOperation("获取配置信息")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "正常情况", response = CommonResponse.class)
    })
    @FunctionPoint(value = "common")
    public CommonResponse getFirmwareConfig() {
        String configuation = firmwareUpgradeService.getFirmwareConfig();
        return CommonResponse.ok().setDescription(configuation);
    }

    /**
     * 设置配置信息
     *
     * @return 设置配置信息
     */
    @RequestMapping(value = "firmware/upgrade/config/set", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json")
    @ApiOperation("设置配置信息")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "正常情况", response = CommonResponse.class)
    })
    @FunctionPoint(value = "common")
    public CommonResponse setFirmwareConfig(@RequestParam("configuation") String configuation) {
        firmwareUpgradeService.setFirmwareConfig(configuation);
        return CommonResponse.ok();
    }

    /**
     * 固件降级
     *
     * @return 固件降级
     */
    @RequestMapping(value = "firmware/downgrade", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json")
    @ApiOperation("固件降级")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "正常情况", response = CommonResponse.class),
            @ApiResponse(code = 9, message = "版本不存在", response = CommonResponse.class),
            @ApiResponse(code = 11, message = "该固件当前不可用", response = CommonResponse.class)
    })
    @FunctionPoint(value = "common")
    public CommonResponse firmwareDowngrade(@RequestParam("id") Integer id)
            throws FirmwareDisableException, VersionNotExistException, NoSuchAlgorithmException, KeyManagementException, IOException {
        firmwareUpgradeService.firmwareDowngrade(id);
        return CommonResponse.ok();
    }

    /**
     * 删除固件
     *
     * @return 删除固件
     */
    @RequestMapping(value = "firmware/delete", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json")
    @ApiOperation("删除固件")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "正常情况", response = CommonResponse.class),
            @ApiResponse(code = 9, message = "版本不存在", response = CommonResponse.class),
            @ApiResponse(code = 12, message = "版本当前可用", response = CommonResponse.class)
    })
    @FunctionPoint(value = "common")
    public CommonResponse firmwareDelete(@RequestParam("id") Integer id)
            throws VersionNotExistException, FirmwareEnableException {
        firmwareUpgradeService.firmwareDelete(id);
        return CommonResponse.ok();
    }

    /**
     * 重新触发升级
     *
     * @return 重新触发升级
     */
    @RequestMapping(value = "firmware/repeat/trigger", method = {RequestMethod.POST, RequestMethod.GET},
            produces = "application/json")
    @ApiOperation("重新触发升级")
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "正常情况", response = CommonResponse.class),
            @ApiResponse(code = 9, message = "版本不存在", response = CommonResponse.class),
            @ApiResponse(code = 11, message = "该固件当前不可用", response = CommonResponse.class)
    })
    @FunctionPoint(value = "common")
    public CommonResponse firmwareRepeatTrigger(@RequestParam("id") Integer id)
            throws FirmwareDisableException, VersionNotExistException {
        firmwareUpgradeService.firmwareRepeatTrigger(id);
        return CommonResponse.ok();
    }
}
