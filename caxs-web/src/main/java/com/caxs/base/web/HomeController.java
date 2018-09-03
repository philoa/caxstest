package com.caxs.base.web;

import com.caxs.base.domain.HmUser;
import com.caxs.base.domain.ResponseUtil;
import com.caxs.base.service.IUserService;
import com.caxs.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kevin on 2017/6/11.
 */


@Controller
@RequestMapping("/base/home")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    /**
     * @description: 登陆
     * @author wangchen
     * @date 2018/8/2
     */
    @RequestMapping("/login")
    @ResponseBody
    public int loginUser(HttpServletRequest request, @RequestParam String name, @RequestParam String password) {

        //返回接口工具类
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        int a = 0;
        try {
            HmUser user = new HmUser();
            user.setUsername(name);
            user.setPassword(password);
            a = userService.loginUser(user);
            if (a == 1) {
                responseUtil.setMessage("登陆成功");
                System.out.println("登陆成功");
            } else {
                responseUtil.setMessage("登陆失败");
                responseUtil.setSuccess(false);
            }
            if (a == 1) {

            } else {
                System.out.println("登陆失败");
            }
        } catch (Exception e) {
            e.printStackTrace();

            throw new BusinessException("登陆失败！");
        }
        return a;
    }

    /**
     * @description: 注册
     * @author wangchen
     * @date 2018/8/2
     */
    @RequestMapping("/register")
    @ResponseBody
    public Object register(HttpServletRequest request, @RequestParam String name, @RequestParam String password) {

        //返回接口工具类
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        try {
            HmUser user = new HmUser();
            user.setUsername(name);
            user.setPassword(password);
            user.setId("141");
            user.setLoginid("789");
            int a = userService.creatUser(user);
            if (a == 1) {
                responseUtil.setMessage("注册成功！");
            } else {
                responseUtil.setMessage("注册失败！");
                responseUtil.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("aaa::"+e.getMessage());
            responseUtil.setMessage("注册失败");
            responseUtil.setSuccess(false);
            throw new BusinessException("注册失败！");
        }
        return responseUtil;
    }

    /**
     * @description: 更新
     * @author wangchen
     * @date 2018/8/2
     */
    @RequestMapping("/updataUser")
    @ResponseBody
    public Object updataUser(HttpServletRequest request, @RequestParam String name, @RequestParam String password) {

        //返回接口工具类
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        try {
            HmUser user = new HmUser();
            user.setUsername(name);
            user.setPassword(password);
            int a = userService.updataUser(user);
            if (a == 1) {
                responseUtil.setMessage("更新成功！");
            } else {
                responseUtil.setMessage("更新失败！");
                responseUtil.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseUtil.setMessage("更新失败");
            responseUtil.setSuccess(false);
            throw new BusinessException("更新失败！");
        }
        return responseUtil;
    }

    /**
     * @description: 查询
     * @author wangchen
     * @date 2018/8/2
     */
    @RequestMapping("/selectOne")
    @ResponseBody
    public Object selectOne(HttpServletRequest request, @RequestParam String name, @RequestParam String password) {

        //返回接口工具类
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        try {
            HmUser user = userService.select(name);
            if (user != null) {
                responseUtil.setMessage("查询成功！");
            } else {
                responseUtil.setMessage("查询失败！");
                responseUtil.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseUtil.setMessage("查询失败");
            responseUtil.setSuccess(false);
            throw new BusinessException("查询失败！");
        }
        return responseUtil;
    }

    /**
     * @description: 查询所有
     * @author wangchen
     * @date 2018/8/2
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    public Object selectAll(HttpServletRequest request, @RequestParam String name, @RequestParam String password) {

        //返回接口工具类
        ResponseUtil responseUtil = ResponseUtil.createResponseUtil();
        try {
            List<HmUser> list = userService.selectUser();
            if (list.size() > 0) {
                Map<Object, Object> map = new HashMap<>();
                map.put("list" , list);
                responseUtil.setMessage("查询成功！");
                responseUtil.setData(map);
            } else {
                responseUtil.setMessage("查询失败！");
                responseUtil.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseUtil.setMessage("查询失败");
            responseUtil.setSuccess(false);
            throw new BusinessException("查询失败！");
        }
        return responseUtil;
    }

}
