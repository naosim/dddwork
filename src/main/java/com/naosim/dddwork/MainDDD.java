package com.naosim.dddwork;

import com.naosim.dddwork.lib.ApiHandler;

public class MainDDD {

    public static void main(String[] args) {
        ApiHandler apiHandler = new ApiHandler();

//        args = new String[]{
//                "input", "20170103","0900", "1700"
//        };

        args = new String[]{
                "total", "201701"
        };

        System.out.println(args);
        try {
            if(args.length < 1) {
                throw new RuntimeException("引数が足りません");
            }
            String methodType = args[0];
            apiHandler.handle(methodType, args);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
