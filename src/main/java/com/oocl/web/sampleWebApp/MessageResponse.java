package com.oocl.web.sampleWebApp;

public class MessageResponse {

    private String msg;

    public MessageResponse(){

    }
    public MessageResponse(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
