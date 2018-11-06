package ding.example.gaya.ding;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    private void startAPP(String sPackageName){
        Context mContext = InstrumentationRegistry.getContext();
        Intent myIntent = mContext.getPackageManager().getLaunchIntentForPackage(sPackageName);  //通过Intent启动app
        mContext.startActivity(myIntent);
    }
    private void closeAPP(UiDevice uiDevice,String sPackageName){
            try {
                uiDevice.executeShellCommand("am force-stop "+sPackageName);//通过命令行关闭app
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    @Test
    public void daka() {
        // Context of the app under test.
        uiDevice.pressHome();
        startAPP("com.alibaba.android.rimet");
        try {
            UiObject welcome = uiDevice.findObject(new UiSelector().resourceId("com.alibaba.android.rimet:id/tv_welcome"));
            String welcome_text = welcome.getText();
            if ((welcome_text.equals("欢迎使用钉钉"))|(welcome_text.equals("欢迎回来"))){
                UiObject phone = uiDevice.findObject(new UiSelector().resourceId("com.alibaba.android.rimet:id/et_phone_input"));
                UiObject pwd = uiDevice.findObject(new UiSelector().resourceId("com.alibaba.android.rimet:id/et_pwd_login"));
                UiObject login = uiDevice.findObject(new UiSelector().resourceId("com.alibaba.android.rimet:id/btn_next"));
                phone.clearTextField();
                phone.setText("18582382014");
                pwd.clearTextField();
                pwd.setText("80393873");
                login.click();
            }
        }catch (Exception e){
            e.printStackTrace();
        }try {
            UiObject logo_text = uiDevice.findObject(new UiSelector().resourceId("com.alibaba.android.rimet:id/img_logo_text"));
            if(logo_text.getText().equals("钉钉")){
                UiObject work = uiDevice.findObject(new UiSelector().text("工作"));
                work.click();
                UiObject oa = uiDevice.findObject(new UiSelector().text("考勤打卡"));
                oa.click();
                Thread.sleep(8888);
                String is_daka_text = "";
                try{
                    Log.i("somentest1","sgdojoj1");
                    UiObject is_daka = uiDevice.findObject(new UiSelector().description("上班时间09:00"));
                    Log.i("somentest2",is_daka.getContentDescription());
                    is_daka_text = is_daka.getContentDescription();
                }catch (Exception e){

                }
                if(is_daka_text.equals("上班时间09:00")) {
                    Log.i("somentest","sgdojoj");
                }else {
                    uiDevice.click(524, 788);
                }
                Thread.sleep(3000);
                uiDevice.pressBack();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void logout(){
        try{
        UiObject me = uiDevice.findObject(new UiSelector().text("我的"));
        me.click();
        Thread.sleep(2000);
        uiDevice.swipe(540,1600,540,1100,2);
        UiObject setting = uiDevice.findObject(new UiSelector().resourceId("com.alibaba.android.rimet:id/rl_setting"));
        setting.click();
        UiObject logout = uiDevice.findObject(new UiSelector().text("退出登录"));
        logout.click();
        UiObject confirm = uiDevice.findObject(new UiSelector().text("确认"));
        confirm.click();
        }catch (Exception e){
            e.printStackTrace();
        }
        closeAPP(uiDevice,"com.alibaba.android.rimet");
    }
}
