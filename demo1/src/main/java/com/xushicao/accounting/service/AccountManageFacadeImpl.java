/**
 * xxx.com Inc.
 *
 */
package com.xushicao.accounting.service;

import com.xushicao.accounting.facade.AccountManageFacade;
import com.xushicao.accounting.facade.req.OpenAccountReq;
import com.xushicao.accounting.facade.result.AccountManageResult;

/**
 * 账户管理接口实现类<br/>
 *
 *用于实现账户管理接口
 *
 * @author   Shichao.Xu
 * @version  001
 */

public class AccountManageFacadeImpl implements AccountManageFacade {
    /**
     * 开户方法的重写<br/>
     *
     * 完成开户
     *
     * @param openAccountReq 开户请求
     * @return
     */

    @Override
    public AccountManageResult openAccount(OpenAccountReq openAccountReq) {

        AccountManageResult accountManageResult=new AccountManageResult();//建立一个返回对象
        // 1、参数校验,判断账户类型为内部户时，账户名是否为空
        if (openAccountReq.getAccountType()=="03")
        {
            if(openAccountReq.getAccountName()==null){
               accountManageResult.setErrorCode("01");//设置错误码
               accountManageResult.setSuccess(false);
               return accountManageResult;
            }
        }
        // 2、生成账号
        String accountType=openAccountReq.getAccountType();//获取账号类型
        String accountCurrency= openAccountReq.getCurrency();//获取账号币种
        String accountNo="2000"+accountType+"123456"+accountCurrency;
        // 3、数据库插入

        // 4、返回开户结果
        accountManageResult.setAccountNo(accountNo);
        accountManageResult.setSuccess(true);
        return accountManageResult;
    }
}
