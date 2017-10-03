package com.ntsoft.ihhq.model;

import com.ntsoft.ihhq.constant.Constant;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 7/21/2017.
 */

public class PaymentModel {
    public int payment_id, transaction_id;
    public String file_ref, purpose, amount, currency, remarks, status, created_at;

    public PaymentModel(JSONObject jsonObject) {
        try {
            payment_id = jsonObject.getInt("payment_id");
            transaction_id = jsonObject.getInt("transaction_id");
            file_ref = jsonObject.getString("file_ref");
            purpose = jsonObject.getString("purpose");
            amount = jsonObject.getString("amount");
            currency = jsonObject.getString("currency");
            if (jsonObject.has("remarks")) {
                remarks = jsonObject.getString("remarks");
            } else {
                remarks = "";
            }

            created_at = jsonObject.getString("created_at");
            if (jsonObject.has("status_detail")) {
                status = jsonObject.getString("status_detail");
            } else {
                status = Constant.arrPaymentStatus[0];//for test
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}