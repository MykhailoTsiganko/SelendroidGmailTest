package com.epam.lab.selendroid.utils;


import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;


public class DriverSingeltone {
    private static Logger LOG = Logger.getLogger(DriverSingeltone.class);

    private static SelendroidLauncher selendroidServer = null;
    private static WebDriver driver = null;

    public static WebDriver getDriver() throws Exception {
        LOG.info("gerDriver");

        if (driver == null) {
            if (selendroidServer != null) {
                selendroidServer.stopSelendroid();
            }
            SelendroidConfiguration config = new SelendroidConfiguration();

            selendroidServer = new SelendroidLauncher(config);
            selendroidServer.launchSelendroid();

            DesiredCapabilities caps = SelendroidCapabilities.android();

            driver = new SelendroidDriver(caps);
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        }

        return driver;
    }

    public static void closeDriver(){
        if (driver != null) {
            driver.quit();
        }
        if (selendroidServer != null) {
            selendroidServer.stopSelendroid();
        }
    }

}
