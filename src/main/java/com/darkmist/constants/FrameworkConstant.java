package com.darkmist.constants;

import java.io.File;

public class FrameworkConstant {

    public static final String CONFIG_FILE_PATH = System.getProperty("user.dir")
            + File.separator +"config.properties";
    public static final String EXTENT_REPORT_FILE_PATH = System.getProperty("user.dir")
            +File.separator+"extent_report";
    public static final String EXTENT_CONFIG_FILE_PATH = System.getProperty("user.dir")
            +File.separator+"extent_config.json";
}
