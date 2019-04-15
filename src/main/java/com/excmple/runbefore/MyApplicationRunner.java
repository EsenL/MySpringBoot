package com.excmple.runbefore;



import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 在项目启动时执行此方法
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {

    /**
     * 项目启动时，自动上传GiT项目
     * @param var1
     */
    @Override
    public void run(ApplicationArguments var1){
        //System.out.println("MyApplicationRunner class will be execute when the project was started!");
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String classpath=courseFile.toString().replace("\\","/");
        String delete = classpath+"/MySpringBoot/src/main/resources/GITupload/DeleteSchtasks.bat";
        String create = classpath+"/MySpringBoot/src/main/resources/GITupload/CreateSchtasks.bat";

        System.out.println("执行GIT同步任务");

        Runtime rt = Runtime.getRuntime();
        Process ps = null;
        try {
            ps = rt.exec("cmd.exe /C start /b " + delete);
            ps.waitFor();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = ps.exitValue();
        if (i == 0) {
            System.out.println("执行删除GIT同步任务完成.") ;
        } else {
            System.out.println("执行删除GIT同步任务失败.") ;
        }

        //执行创建
        try {
            ps = rt.exec("cmd.exe /C start /b " + create);
            ps.waitFor();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i = ps.exitValue();
        if (i == 0) {
            System.out.println("执行创建GIT同步任务完成.") ;
        } else {
            System.out.println("执行创建GIT同步任务失败.") ;
        }
    }

    public static void main(String args[]){
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String classpath=courseFile.toString().replace("\\","/");
        String create = classpath+"/MySpringBoot/src/main/resources/GITupload/GITupload.bat";

        System.out.println("执行GIT同步任务");

        Runtime rt = Runtime.getRuntime();
        Process ps = null;
        int i = 0;

        //执行创建
        try {
            ps = rt.exec("cmd.exe /C start /b " + create);
            ps.waitFor();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i = ps.exitValue();
        if (i == 0) {
            System.out.println("执行创建GIT同步任务完成.") ;
        } else {
            System.out.println("执行创建GIT同步任务失败.") ;
        }
    }
}
