
package com.lhc.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhc.pojo.User;
import com.lhc.query.UserQuery;
import com.lhc.service.UserService;
import com.lhc.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<User> login(@RequestParam String username, @RequestParam String password) {
        if (StrUtil.isNotBlank(username) && StrUtil.isNotBlank(password)) {
            var dto = userService.login(username, password);
            if (dto != null) {
                return Result.Success(dto);
            }
        }
        return new Result<>(Result.ERROR, "参数为空");
    }

    @PostMapping("/has")
    public Result<Boolean> has(@RequestParam String username) {
        if (StrUtil.isNotBlank(username)) {
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("username", username);
            return Result.Success(userService.getOne(wrapper) != null);
        }
        return new Result<>(Result.ERROR, "查询失败", false);
    }

    @PostMapping("/save")
    public Result<Boolean> saveUser(@RequestBody User user) {
        if (userService.saveOrUpdate(user)) {
            return Result.Success(true);
        }
        return new Result<>(Result.ERROR, "保存失败");
    }

    @PostMapping("/register")
    public Result<Boolean> register(String username, String password, String nickname) {
        if (StrUtil.isNotBlank(username) && StrUtil.isNotBlank(password) && StrUtil.isNotBlank(nickname)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setNickname(nickname);
            return Result.Success(userService.save(user));
        }
        return new Result<>(Result.ERROR, "注册失败", false);
    }

    @DeleteMapping("/del")
    public Result<Boolean> delUser(@RequestParam Integer id) {
        if (userService.removeById(id)) {
            return Result.Success(true);
        }
        return new Result<>(Result.ERROR, "删除失败");
    }

    @DeleteMapping("del/batch")
    public Result<Boolean> delBatch(@RequestBody List<Integer> ids) {
        if (userService.removeByIds(ids)) {
            return Result.Success(true);
        }
        return new Result<>(Result.ERROR, "删除失败");
    }

    @GetMapping("/query")
    public Result<IPage<User>> queryUser(UserQuery query) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (StrUtil.isNotBlank(query.getName())) {
            wrapper.like("name", query.getName());
        }
        if (StrUtil.isNotBlank(query.getEmail())) {
            wrapper.like("email", query.getEmail());
        }
        if (StrUtil.isNotBlank(query.getAddress())) {
            wrapper.like("address", query.getAddress());
        }
        wrapper.orderByAsc("id");
        IPage<User> page = new Page<>(query.getPageNum(), query.getPageSize());
        return Result.Success(userService.page(page, wrapper));
    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        //查询所有数据
        List<User> users = userService.list();
        ExcelWriter sheet = ExcelUtil.getWriter(true);

        //设置别名
        sheet.addHeaderAlias("id", "编号");
        sheet.addHeaderAlias("account", "账号");
        sheet.addHeaderAlias("nickname", "昵称");
        sheet.addHeaderAlias("email", "邮箱");
        sheet.addHeaderAlias("address", "地址");
        sheet.addHeaderAlias("phone", "电话");
        sheet.addHeaderAlias("createTime", "创建时间");
        //写入数据
        sheet.write(users, true);
        //设置浏览器相应格式
        //Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
        //attachment表示以附件方式下载
        // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付
        String filename = URLEncoder.encode("用户信息.xlsx", StandardCharsets.UTF_8);
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        ServletOutputStream out = response.getOutputStream();
        sheet.flush(out, true);
        out.close();
        sheet.close();
    }
}
