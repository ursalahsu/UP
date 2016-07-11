package com.up.handsoap;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 油品資料
 * Created by URSALA on 2016/7/12.
 */
public class Oil {
    String name;
    double sap;
    int ins;
    int cleansing;
    int bubbly;
    int condition;
    int creamy;
    int iodine;
    int hardness;
    String memo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSap() {
        return sap;
    }

    public void setSap(double sap) {
        this.sap = sap;
    }

    public int getIns() {
        return ins;
    }

    public void setIns(int ins) {
        this.ins = ins;
    }

    public int getCleansing() {
        return cleansing;
    }

    public void setCleansing(int cleansing) {
        this.cleansing = cleansing;
    }

    public int getBubbly() {
        return bubbly;
    }

    public void setBubbly(int bubbly) {
        this.bubbly = bubbly;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getCreamy() {
        return creamy;
    }

    public void setCreamy(int creamy) {
        this.creamy = creamy;
    }

    public int getIodine() {
        return iodine;
    }

    public void setIodine(int iodine) {
        this.iodine = iodine;
    }

    public int getHardness() {
        return hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    //轉成JSON
    public JSONObject getJsonObject() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", getName())
                    .put("sap", getSap())
                    .put("ins", getIns())
                    .put("cleansing", getCleansing())
                    .put("bubbly", getBubbly())
                    .put("condition", getCondition())
                    .put("creamy", getCreamy())
                    .put("iodine", getIodine())
                    .put("hardness", getHardness())
                    .put("memo", getMemo());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    //復原資料結構
    public Oil newInstanceWithJsonObject(String data){
        JSONObject jsonObject = new JSONObject();
        Oil oil = new Oil();
        try {
            oil.setName(jsonObject.getString("name"));
            oil.setSap(jsonObject.getDouble("sap"));
            oil.setIns(jsonObject.getInt("ins"));
            oil.setCleansing(jsonObject.getInt("cleansing"));
            oil.setBubbly(jsonObject.getInt("bubbly"));
            oil.setCondition(jsonObject.getInt("condition"));
            oil.setCreamy(jsonObject.getInt("creamy"));
            oil.setIodine(jsonObject.getInt("iodine"));
            oil.setHardness(jsonObject.getInt("hardness"));
            oil.setMemo(jsonObject.getString("memo"));
            return oil;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}