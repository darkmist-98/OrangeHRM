package com.darkmist.constants;

import java.io.File;

public class FrameworkConstant {

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String CONFIG_FILE_PATH = PROJECT_PATH
            + File.separator +"config.properties";
    public static final String EXTENT_REPORT_FILE_PATH = PROJECT_PATH
            +File.separator+"reports";
    public static final String EXTENT_CONFIG_FILE_PATH = PROJECT_PATH
            +File.separator+"src"+File.separator+"test"+File.separator+"resources"+
            File.separator+"extent-config.json";
}
