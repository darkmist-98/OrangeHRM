package com.darkmist.helper;

import com.darkmist.constants.FrameworkConstant;

import java.io.FileInputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try(FileInputStream fileInputStream = new FileInputStream(FrameworkConstant.CONFIG_FILE_PATH)){
            properties.load(fileInputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static String getPropertyValue(String key){
        return properties.getProperty(key);
    }
}
