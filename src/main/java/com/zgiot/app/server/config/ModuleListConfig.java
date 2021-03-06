package com.zgiot.app.server.config;

import com.zgiot.app.server.dataprocessor.CompleterDataListener;
import com.zgiot.app.server.dataprocessor.DataProcessor;
import com.zgiot.app.server.dataprocessor.impl.CacheUpdater;
import com.zgiot.app.server.module.alert.*;
import com.zgiot.app.server.module.alert.handler.AlertFaultHandler;
import com.zgiot.app.server.module.alert.handler.AlertParamHandler;
import com.zgiot.app.server.module.bellows.BellowsDataListener;
import com.zgiot.app.server.module.bellows.compressor.CompressorManager;
import com.zgiot.app.server.module.bellows.valve.ValveIntelligentJob;
import com.zgiot.app.server.module.bellows.valve.ValveManager;
import com.zgiot.app.server.module.demo.DemoBusiness;
import com.zgiot.app.server.module.demo.DemoDataCompleter;
import com.zgiot.app.server.module.densitycontrol.DensityControlListener;
import com.zgiot.app.server.module.densitycontrol.DensityControlListener2;
import com.zgiot.app.server.module.filterpress.FilterPressDataListener;
import com.zgiot.app.server.module.filterpress.FilterPressManager;
import com.zgiot.app.server.module.filterpress.FilterPressSignalOperateJob;
import com.zgiot.app.server.module.historydata.job.HistoryDayDataJob;
import com.zgiot.app.server.module.historydata.job.HistoryHourDataJob;
import com.zgiot.app.server.module.historydata.job.HistoryMinDataJob;
import com.zgiot.app.server.module.reportforms.input.listener.ReportFormsCompleter;
import com.zgiot.app.server.module.reportforms.output.productionmonitor.listener.ReportFormSystemStartListener;
import com.zgiot.app.server.module.reportforms.output.service.InfluenceTimeServiceImpl;
import com.zgiot.app.server.module.reportforms.output.service.OutputStoreAndTargetService;
import com.zgiot.app.server.module.reportforms.output.service.TransPortServiceImpl;
import com.zgiot.app.server.module.sfstart.*;
import com.zgiot.app.server.module.sfstop.StopExamineListener;
import com.zgiot.app.server.module.sfsubsc.job.UploadHistorySubscCardDatas;
import com.zgiot.app.server.module.sfsubsc.job.UploadProductionSubscCardDatas;
import com.zgiot.app.server.module.sfsubsc.job.UploadSubscCardDatas;
import com.zgiot.app.server.service.SendTraceLogService;
import com.zgiot.app.server.service.impl.HistoryDataPersistDaemon;
import com.zgiot.app.server.service.impl.QuartzManager;
import org.quartz.JobDataMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ModuleListConfig {
    private static final Logger logger = LoggerFactory.getLogger(ModuleListConfig.class);
    public static final String MODULE_SFSTART = "sfstart";
    public static final String MODULE_DEMO = "demo";
    public static final String MODULE_FILTERPRESS = "filterpress";
    public static final String MODULE_ALERT = "alert";
    public static final String MODULE_HIST_PERSIST = "hist-persist";
    public static final String MODULE_BELLOWS = "bellows";
    public static final String MODULE_DENSITY_CONTROL = "density-control";
    public static final String MODULE_COAL_ANALYSIS = "coal-analysis";
    public static final String MODULE_SUBSCRIPTION = "subscription";
    public static final String MODULE_REPORTFORM = "report-form";
    public static final String MODULE_SFSTOP = "sfstop";
    public static final String MODULE_SEND_TRACE = "send-trace";
    public static final String MODULE_DENSITY_CONTROL2 = "density-control2";


    @Value("${sysmodule.demo.enabled}")
    private boolean moduleDemoEnabled;
    @Value("${sysmodule.filterpress.enabled}")
    private boolean moduleFPEnabled;
    @Value("${sysmodule.alert.enabled}")
    private boolean moduleAlertEnabled;
    @Value("${sysmodule.hist-persist.enabled}")
    private boolean moduleHistPersistEnabled;
    @Value("${sysmodule.bellows.enabled}")
    private boolean moduleBellowsEnabled;
    @Value("${sysmodule.density-control.enabled}")
    private boolean moduleDensityCtlEnabled;
    @Value("${sysmodule.coal-analysis.enabled}")
    private boolean moduleCoalAnalyEnabled;
    @Value("${sysmodule.subscription.enabled}")
    private boolean moduleSubsEnabled;
    @Value("${sysmodule.sfstart.enabled}")
    private boolean moduleSfStartEnabled;
    @Value("${sysmodule.report-form.enabled}")
    private boolean moduleReportEnabled;
    @Value("${sysmodule.sfstop.enabled}")
    private boolean moduleSfStopEnabled;
    @Value("${sysmodule.send-trace.enabled}")
    private boolean moduleSendTraceEnabled;
    @Value("${sysmodule.density-control2.enabled}")
    private boolean moduleDensityCtl2Enabled;


    private static final int FAULT_SCAN_RATE = 20;

    private Map configedModuleMap = new ConcurrentHashMap(100);

    @Autowired
    private CacheUpdater cacheUpdater;
    @Autowired
    DemoBusiness demoBusiness;
    @Autowired
    private FilterPressDataListener filterPressListener;
    @Autowired
    private CompleterDataListener completerDataListener;
    @Autowired
    private AlertListener alertListener;
    @Autowired
    private BellowsDataListener bellowsDataListener;
    @Autowired
    private ValveManager valveManager;
    @Autowired
    private CompressorManager compressorManager;
    @Autowired
    private AlertParamHandler alertParamHandler;
    @Autowired
    private AlertFaultHandler alertFaultHandler;
    @Autowired
    private HistoryDataPersistDaemon historyDataPersistDaemon;
    @Autowired
    private DensityControlListener densityControlListener;
    @Autowired
    private ReportFormsCompleter reportFormsCompleter;
    @Autowired
    private AlertManager alertManager;
    @Autowired
    private FilterPressManager filterPressManager;
    @Autowired
    private ReportFormSystemStartListener reportFormSystemStartListener;
    @Autowired
    private OutputStoreAndTargetService outputStoreAndTargetService;
    @Autowired
    private TransPortServiceImpl transPortServiceImpl;
    @Autowired
    private InfluenceTimeServiceImpl influenceTimeServiceImpl;
    @Autowired
    private SfStartManager sfStartManager;
    @Autowired
    private StartBrowseListener startBrowseListener;
    @Autowired
    private StartExamineListener startExamineListener;
    @Autowired
    private StartListener startListener;
    @Autowired
    private SendTraceLogService sendTraceLogService;
    @Autowired
    private DensityControlListener2 densityControlListener2;
    @Autowired
    private StopExamineListener stopExamineListener;

    @PostConstruct
    void init() {
        configedModuleMap.put(MODULE_DEMO, this.moduleDemoEnabled);
        configedModuleMap.put(MODULE_FILTERPRESS, this.moduleFPEnabled);
        configedModuleMap.put(MODULE_ALERT, this.moduleAlertEnabled);
        configedModuleMap.put(MODULE_HIST_PERSIST, this.moduleHistPersistEnabled);
        configedModuleMap.put(MODULE_BELLOWS, this.moduleBellowsEnabled);
        configedModuleMap.put(MODULE_DENSITY_CONTROL, this.moduleDensityCtlEnabled);
        configedModuleMap.put(MODULE_COAL_ANALYSIS, this.moduleCoalAnalyEnabled);
        configedModuleMap.put(MODULE_SUBSCRIPTION, this.moduleSubsEnabled);
        configedModuleMap.put(MODULE_SFSTART, this.moduleSfStartEnabled);
        configedModuleMap.put(MODULE_REPORTFORM, this.moduleReportEnabled);

        configedModuleMap.put(MODULE_SEND_TRACE, this.moduleSendTraceEnabled);
        configedModuleMap.put(MODULE_DENSITY_CONTROL2, this.moduleDensityCtl2Enabled);
    }

    public boolean containModule(String moduleName) {
        Boolean rtn = (Boolean) configedModuleMap.get(moduleName);
        return (rtn == null) ? false : rtn.booleanValue();
    }

    void installModules(DataProcessor processor) {

        try {
            processor.addListener(completerDataListener);
            processor.addListener(cacheUpdater);

            if (containModule(ModuleListConfig.MODULE_COAL_ANALYSIS)) {
                completerDataListener.addCompleter(reportFormsCompleter);
                logIt(MODULE_COAL_ANALYSIS);
            }

            if (containModule(ModuleListConfig.MODULE_HIST_PERSIST)) {
                historyDataPersistDaemon.start();
                QuartzManager.addJob("historyMinData", ModuleListConfig.MODULE_HIST_PERSIST, "historyMinData",
                        ModuleListConfig.MODULE_HIST_PERSIST, HistoryMinDataJob.class, "0 0/1 * * * ?");
                QuartzManager.addJob("historyHourData", ModuleListConfig.MODULE_HIST_PERSIST, "historyHourData",
                        ModuleListConfig.MODULE_HIST_PERSIST, HistoryHourDataJob.class, "0 0 0/1 * * ?");
                QuartzManager.addJob("historyDayData", ModuleListConfig.MODULE_HIST_PERSIST, "historyDayData",
                        ModuleListConfig.MODULE_HIST_PERSIST, HistoryDayDataJob.class, "0 0 0 1/1 * ?");
                logIt(MODULE_HIST_PERSIST);
            }

            if (containModule(ModuleListConfig.MODULE_FILTERPRESS)) {
                filterPressManager.initFilterPress();
                processor.addListener(filterPressListener);
                QuartzManager.addJob("filterPressSignalOperate", ModuleListConfig.MODULE_FILTERPRESS, "filterPressSignalOperate",
                        ModuleListConfig.MODULE_FILTERPRESS, FilterPressSignalOperateJob.class, "0/10 * * * * ?");
                logIt(MODULE_FILTERPRESS);
            }

            if (containModule(ModuleListConfig.MODULE_DENSITY_CONTROL)) {
                processor.addListener(densityControlListener);
                logIt(MODULE_DENSITY_CONTROL);
            }

            if (containModule(ModuleListConfig.MODULE_DENSITY_CONTROL2)) {
                densityControlListener2.initParamCache();
                processor.addListener(densityControlListener2);
                logIt(MODULE_DENSITY_CONTROL2);
            }

            if (containModule(ModuleListConfig.MODULE_ALERT)) {
                alertManager.init();
                processor.addListener(alertListener);
                QuartzManager.addJob("checkParam", ModuleListConfig.MODULE_ALERT, "checkParam",
                        ModuleListConfig.MODULE_ALERT, AlertParamJob.class, "0/10 * * * * ?", new JobDataMap() {
                            {
                                put("handler", alertParamHandler);
                            }
                        });
                QuartzManager.addJob("clearHistory", ModuleListConfig.MODULE_ALERT, "clearHistory",
                        ModuleListConfig.MODULE_ALERT, AlertHistoryJob.class, "0 0 0 * * ?");
                QuartzManager.addJobWithInterval("checkFault", ModuleListConfig.MODULE_ALERT, "checkFault",
                        ModuleListConfig.MODULE_ALERT, AlertFaultJob.class, FAULT_SCAN_RATE, new JobDataMap() {
                            {
                                put("handler", alertFaultHandler);
                            }
                        });

                logIt(MODULE_ALERT);
            }

            if (containModule(ModuleListConfig.MODULE_BELLOWS)) {
                valveManager.init();
                compressorManager.init();
                processor.addListener(bellowsDataListener);
                QuartzManager.addJob("checkBlow", ModuleListConfig.MODULE_BELLOWS, "checkBlow",
                        ModuleListConfig.MODULE_BELLOWS, ValveIntelligentJob.class, "2 * * * * ?");
                logIt(MODULE_BELLOWS);
            }

            if (containModule(ModuleListConfig.MODULE_SUBSCRIPTION)) {
                QuartzManager.addJob("uploadsubscCardDatasOf5s", ModuleListConfig.MODULE_SUBSCRIPTION, "uploadsubscCardDatasOf5s",
                        ModuleListConfig.MODULE_SUBSCRIPTION, UploadSubscCardDatas.class, "0/5 * * * * ?");

                QuartzManager.addJob("uploadsubscCardDatasOf10s", ModuleListConfig.MODULE_SUBSCRIPTION, "uploadsubscCardDatasOf10s",
                        ModuleListConfig.MODULE_SUBSCRIPTION, UploadHistorySubscCardDatas.class, "0/10 * * * * ?");

                QuartzManager.addJob("uploadsubscCardDatasOf6oclock", ModuleListConfig.MODULE_SUBSCRIPTION, "uploadsubscCardDatasOf6oclock",
                        ModuleListConfig.MODULE_SUBSCRIPTION, UploadProductionSubscCardDatas.class, "0 0 6,18 * * ?");

                logIt(MODULE_SUBSCRIPTION);
            }
            if (containModule(ModuleListConfig.MODULE_SFSTART)) {
                sfStartManager.init();
                processor.addListener(startBrowseListener);
                processor.addListener(startExamineListener);
                processor.addListener(startListener);


                QuartzManager.addJob("startDeviceByRequirement", ModuleListConfig.MODULE_SFSTART, "startDeviceByRequirement",
                        ModuleListConfig.MODULE_SFSTART, StartDeviceByRequirementJob.class, "0/20 * * * * ?");

                QuartzManager.addJob("sendCoalCapacity", ModuleListConfig.MODULE_SFSTART, "sendCoalCapacity",
                        ModuleListConfig.MODULE_SFSTART, SendCoalCapacityJob.class, "0/10 * * * * ?");

                QuartzManager.addJob("sendCoalDeport", ModuleListConfig.MODULE_SFSTART, "sendCoalDeport",
                        ModuleListConfig.MODULE_SFSTART, SendCoalDeportJob.class, "0/10 * * * * ?");


            }

            if (containModule(ModuleListConfig.MODULE_SFSTOP)) {
                processor.addListener(stopExamineListener);

            }


            if (containModule(ModuleListConfig.MODULE_REPORTFORM)) {
                reportFormSystemStartListener.init();
                outputStoreAndTargetService.init();
                transPortServiceImpl.init();
                influenceTimeServiceImpl.init();
                processor.addListener(reportFormSystemStartListener);
                logIt(MODULE_REPORTFORM);
            }

            if (this.containModule(MODULE_SEND_TRACE)) {
                sendTraceLogService.init();
                processor.addListener(sendTraceLogService);
                logIt(MODULE_SEND_TRACE);
            }

            if (this.containModule(MODULE_DEMO)) {
                completerDataListener.addCompleter(new DemoDataCompleter());
                processor.addListener(demoBusiness);
                logIt(MODULE_DEMO);
            }

            logger.info("Modules are all loaded successfully. ");

        } catch (Exception e) {
            logger.error("Sys Modules failed to load. Pls check exception and restart again! ", e);
        }

    }

    private void logIt(String moduleName) {
        logger.info("Module `{}` loaded. ", moduleName);
    }

}
