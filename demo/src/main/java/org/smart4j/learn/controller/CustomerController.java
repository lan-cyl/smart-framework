package org.smart4j.learn.controller;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;
import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.learn.model.Customer;
import org.smart4j.learn.service.CustomerService;

import java.util.List;

/**
 * 处理客户管理相关的请求
 *
 * Created by lan_cyl on 2016/11/1.
 */
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Action("get:/customer")
    public View index(Param param) {
        BeanHelper.getBeanMap();
        List<Customer> customers = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customers", customers);
    }

    @Action("get:/customer_show")
    public View show(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer", customer);
    }

    @Action("get:/customer_create")
    public View create() {
        return new View("customer_create.jsp");
    }

    @Action("post:/customer_cureate")
    public Data createSubmit(Param param) {
        boolean result = customerService.createCustomer(param.getMap());
        return new Data(result);
    }

    @Action("get:/customer_edit")
    public View edit(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }

    @Action("post:/customer_edit")
    public Data editSubmit(Param param) {
        long id = param.getLong("id");
        boolean result = customerService.updataCustomer(id, param.getMap());
        return new Data(result);
    }

    @Action("get:/customer_delete")
    public Data delete(Param param) {
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }
}
