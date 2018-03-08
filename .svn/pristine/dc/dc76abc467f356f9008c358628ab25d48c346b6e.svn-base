package utils;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sl on 2017/5/26.
 */
public class ScreenShot {
    public static Logger logger =  LogManager.getLogger(ScreenShot.class.getName());



    /**
     * 自动截图，保存图片到本地以及html结果文件中
     *
     * @param scenario
     */
    public static void takeScreenShot(Scenario scenario) {

        File f = new File("./captures");
        if (!f.exists()) {
            f.mkdirs();
        }
        if (scenario.isFailed()) {
            f = BrowserDriver.dr.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(f, new File("./captures/" + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".png"));
                byte[] image = image2Bytes(f);
                scenario.embed(image,"image/png");
            } catch (IOException e) {
                logger.info(e);
                e.printStackTrace();
            }
        }

    }

    public static byte[] image2Bytes(File file){
        byte[] data = null;
        FileInputStream input = null;
        try{
            input = new FileInputStream(file);
            ByteArrayOutputStream output  = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1){
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();

        }catch (FileNotFoundException ex1){
            ex1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
