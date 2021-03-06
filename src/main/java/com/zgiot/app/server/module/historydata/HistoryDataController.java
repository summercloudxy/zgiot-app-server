package com.zgiot.app.server.module.historydata;

import com.alibaba.fastjson.JSON;
import com.zgiot.app.server.module.historydata.enums.AccuracyEnum;
import com.zgiot.app.server.module.historydata.enums.SummaryTypeEnum;
import com.zgiot.app.server.service.HistoryDataService;
import com.zgiot.common.exceptions.SysException;
import com.zgiot.common.pojo.DataModel;
import com.zgiot.common.restcontroller.ServerResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author wangwei
 */
@RestController
@RequestMapping(value = "/historydata")
public class HistoryDataController {

    @Autowired
    private HistoryDataService historyDataService;

    @PostMapping("")
    public ResponseEntity<String> insertBatch(@RequestBody String requestData) {
        //check requestData
        if (StringUtils.isBlank(requestData)) {
            ServerResponse res = new ServerResponse("Blank request.", SysException.EC_UNKNOWN, 0);
            String resJSON = JSON.toJSONString(res);
            return new ResponseEntity<>(resJSON, HttpStatus.BAD_REQUEST);
        }

        List<DataModel> modelList = JSON.parseArray(requestData, DataModel.class);
        //check modelList
        if (CollectionUtils.isEmpty(modelList)) {
            ServerResponse res = new ServerResponse("Empty list.The incoming req body is: `" + requestData + "`", SysException.EC_UNKNOWN, 0);
            String resJSON = JSON.toJSONString(res);
            return new ResponseEntity<>(resJSON, HttpStatus.BAD_REQUEST);
        }

        int count = historyDataService.insertBatch(modelList);
        return new ResponseEntity<>(
                ServerResponse.buildOkJson(count)
                , HttpStatus.OK);
    }


    @PostMapping("/metric/{metricCode}")
    public ResponseEntity<String> metricData(@PathVariable String metricCode, @RequestBody String requestData) {
        HistoryDataDto historyDataDto = JSON.parseObject(requestData, HistoryDataDto.class);
        //check parse result
        if (historyDataDto.getEndTime() == null || historyDataDto.getStartTime() == null || historyDataDto.getThingCodes() == null || historyDataDto.getThingCodes().isEmpty()) {
            ServerResponse res = new ServerResponse("Invalid request data.The incoming req body is: `" + requestData + "`", SysException.EC_UNKNOWN, 0);
            String resJSON = JSON.toJSONString(res);
            return new ResponseEntity<>(resJSON, HttpStatus.BAD_REQUEST);
        }

        Map<String, List<DataModel>> result;
        String nullReturn = historyDataDto.getNullReturn();
        if(StringUtils.isBlank(nullReturn)){
            nullReturn = "0";
        }
        if (historyDataDto.getSegment() != null) {
            if (historyDataDto.getTimeCorrection() == null){
                historyDataDto.setTimeCorrection(true);
            }
            // by segment
            if (historyDataDto.getAccuracy() == null) {
                result = historyDataService.findMultiThingsHistoryDataOfMetricBySegment(historyDataDto.getThingCodes(), metricCode,
                        historyDataDto.getStartTime(), historyDataDto.getEndTime(), historyDataDto.getSegment(), historyDataDto.getTimeCorrection());
            }else {
                AccuracyEnum accuracyEnum = AccuracyEnum.valueOf(historyDataDto.getAccuracy());
                if(StringUtils.isBlank(historyDataDto.getStatsMode())){
                    result = historyDataService.findMultiThingsHistoryDataOfMetricBySegment(historyDataDto.getThingCodes(), metricCode,
                            historyDataDto.getStartTime(), historyDataDto.getEndTime(), historyDataDto.getSegment(), historyDataDto.getTimeCorrection(),accuracyEnum,Integer.valueOf(nullReturn));
                }else{
                    SummaryTypeEnum summaryTypeEnum = SummaryTypeEnum.valueOf(historyDataDto.getStatsMode());
                    result = historyDataService.findMultiThingsHistoryDataOfMetricBySegment(historyDataDto.getThingCodes(), metricCode,
                            historyDataDto.getStartTime(), historyDataDto.getEndTime(), historyDataDto.getSegment(), historyDataDto.getTimeCorrection(),accuracyEnum,summaryTypeEnum,nullReturn);
                }
            }
        } else {
            // all data in time range
            if (historyDataDto.getAccuracy() == null) {
                result = historyDataService.findMultiThingsHistoryDataOfMetric(historyDataDto.getThingCodes(), metricCode, historyDataDto.getStartTime(), historyDataDto.getEndTime());
            }else {
                AccuracyEnum accuracyEnum = AccuracyEnum.valueOf(historyDataDto.getAccuracy());
                if(StringUtils.isBlank(historyDataDto.getStatsMode())){
                    result = historyDataService.findMultiThingsHistoryDataOfMetric(historyDataDto.getThingCodes(), metricCode, historyDataDto.getStartTime(), historyDataDto.getEndTime(),accuracyEnum,SummaryTypeEnum.AVG);
                }else{
                    SummaryTypeEnum summaryTypeEnum = SummaryTypeEnum.valueOf(historyDataDto.getStatsMode());
                    result =  historyDataService.findMultiThingsHistoryDataOfMetric(historyDataDto.getThingCodes(), metricCode, historyDataDto.getStartTime(), historyDataDto.getEndTime(),accuracyEnum,summaryTypeEnum);
                }


            }
        }
        return new ResponseEntity<>(ServerResponse.buildOkJson(result), HttpStatus.OK);
    }

}
