package com.forezp.web;

import com.forezp.BaseModule;
import com.forezp.dao.IAccountDAO;
import com.forezp.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * TODO
 * @author msh
 * @time 2017/11/23 20:55
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    IAccountDAO accountService;


    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String helloWord() {
        return "hello  Spring boot";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseModule<List<Account>> getAccounts() {
        System.out.println(" 手机请求网页了。");
        List<Account> datas = accountService.findAccountList();
        BaseModule<List<Account>> base = new BaseModule<List<Account>>();

        if (datas != null) {
            base.setResult(accountService.findAccountList());
            base.setMessage("成功， 获取");
            base.setIsSuccess(true);
        }
        System.out.println(base.toString());
        return base;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BaseModule<Account> getAccountById(@PathVariable("id") int id) {
        Account account = accountService.findAccountById(id);

        BaseModule<Account> base = new BaseModule<>();


        System.out.println(" 手机请求网页了。");

        if (account == null) {
            base.setIsSuccess(false);
            base.setMessage("没有用户");
        } else {
            base.setMessage("搜索到用户");
            base.setIsSuccess(true);
            base.setResult(account);
        }

        System.out.println(base.toString());
        return base;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        System.out.println(" 手机请求网页了。");
        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        account.setId(id);
        int t = accountService.update(account);

        if (t == 1) {
            return account.toString();
        } else {
            return "fail";
        }
    }


    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(@RequestBody Account msg){

        return msg.toString();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public BaseModule<Account> postAccount(
            @RequestBody Account account
    ) {
        System.out.println(" 手机请求网页了。");
        int t = accountService.add(account);

        BaseModule<Account> base = new BaseModule<>();
        if (t == 1) {

            base.setMessage("success");
            base.setIsSuccess(true);
            base.setResult(account);

        } else {
            base.setMessage("error");
            base.setResult(null);
        }
        return base;
    }


    @RequestMapping(value = "",method = RequestMethod.GET)
    public String login(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password){
        if (username.equals(password))
        {
            return "succ";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public void upload(HttpServletRequest req, MultipartHttpServletRequest multiReq) {

    }
}
