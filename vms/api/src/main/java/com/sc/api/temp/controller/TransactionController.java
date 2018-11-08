package com.sc.api.temp.controller;

import com.sc.api.sys.dto.SysUserDto;
import com.sc.api.temp.model.Transaction;
import com.sc.util.code.EnumReturnCode;
import com.sc.util.json.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * what:   首页表格信息
 *
 * @author 孙超 created on 2018/11/9
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    public static List<Transaction> transactions = new ArrayList<>();

    {
        transactions.add(new Transaction("cc8c54DE-FBeE-D5FF-8d6d-D9fB5B87e7cd", "" + (new Date()).getTime(), "Thomas Moore", "10503.7", "success"));
        transactions.add(new Transaction("f16ed9Fd-C575-B1fd-e25E-2dAad06BC13c", "" + (new Date()).getTime(), "Jessica Rodriguez", "3518.2", "pending"));
        transactions.add(new Transaction("fDD953eb-5C9D-faB5-DEC9-EB2d8a6B6Aa1", "" + (new Date()).getTime(), "Daniel Taylor", "13540", "success"));
        transactions.add(new Transaction("1B3dBB96-6D63-114b-BFc6-4Af583BFE7ef", "" + (new Date()).getTime(), "Thomas Gonzalez", "9999.3", "pending"));
        transactions.add(new Transaction("eeBEBF2C-Ce8A-dfd2-C5f6-F6AE67904315", "" + (new Date()).getTime(), "Carol Walker", "5217", "success"));
        transactions.add(new Transaction("a2cfd48D-1Df4-D552-2C18-8143eA4BC0F2", "" + (new Date()).getTime(), "Melissa Hall", "6119.4", "pending"));
        transactions.add(new Transaction("bbeEFcFe-c8e9-b3D5-E22b-b2B60d171a71", "" + (new Date()).getTime(), "Sandra Thomas", "10698.5", "success"));
        transactions.add(new Transaction("aD74572A-8ff5-E145-1cFF-9996C3D27b27", "" + (new Date()).getTime(), "Edward Johnson", "7033", "pending"));
        transactions.add(new Transaction("d97d6b98-5627-7D18-Ee6d-2EBE750F8f2d", "" + (new Date()).getTime(), "Jessica Clark", "3788", "success"));
        transactions.add(new Transaction("0C2428af-1157-fCf2-DA36-E7BBbDDB8CfF", "" + (new Date()).getTime(), "Karen Rodriguez", "3914.4", "pending"));
        transactions.add(new Transaction("DF264Ac0-A9AC-e3fa-4bC2-33857EFB8E1d", "" + (new Date()).getTime(), "George Rodriguez", "8671.8", "success"));
        transactions.add(new Transaction("7E1e2ff4-6E4f-4FDd-32a6-ddDBcdabb4b6", "" + (new Date()).getTime(), "Jessica Johnson", "1206", "pending"));
        transactions.add(new Transaction("cBeF4aEF-bfAe-bE70-f127-C1A0c88cbBCF", "" + (new Date()).getTime(), "Patricia Taylor", "9223.4", "pending"));
        transactions.add(new Transaction("1E5D6C1D-DE5C-A58A-47CA-9F2E6008f4A1", "" + (new Date()).getTime(), "Dorothy Garcia", "14704.3", "pending"));
        transactions.add(new Transaction("fA67393e-6fE5-1525-28bE-5e7F79DeaeDA", "" + (new Date()).getTime(), "William Rodriguez", "12714.8", "success"));
        transactions.add(new Transaction("3dA3C8EF-127e-5Be4-3bBf-869Cc02CbEe5", "" + (new Date()).getTime(), "Jose Gonzalez", "11100", "pending"));
        transactions.add(new Transaction("D725e7C7-cD72-e7E0-FA3B-BfEC1D49C3EA", "" + (new Date()).getTime(), "Maria White", "14674.4", "success"));
        transactions.add(new Transaction("d5B2EF0F-EEcE-1F1D-4CD5-9CDbfadEBEBb", "" + (new Date()).getTime(), "Patricia Wilson", "8290.5", "pending"));
        transactions.add(new Transaction("d31FC048-BA0D-9CAf-df6A-beD7342F7cDe", "" + (new Date()).getTime(), "George Lee", "10302.7", "pending"));
        transactions.add(new Transaction("F41058e2-FC50-D9b9-3b38-Ff6FAcFd29cE", "" + (new Date()).getTime(), "Sarah Jones", "8543.3", "success"));
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public JsonResult transaction() {
        Map<String, Object> map = new HashMap<>();
        map.put("total", transactions.size());
        map.put("items", transactions);
        return new JsonResult(EnumReturnCode.SUCCESS_INFO_GET, map);
    }
}
