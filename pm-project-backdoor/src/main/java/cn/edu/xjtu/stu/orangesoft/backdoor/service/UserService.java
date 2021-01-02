package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.LastLoginMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.TodoListMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.LastLogin;
import cn.edu.xjtu.stu.orangesoft.backdoor.core.DIUtil;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.TodoListMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.ResultInfo;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.TodoList;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class UserService {
    @Autowired
    TodoListMapper todoListMapper;
    @Autowired
    LastLoginMapper lastLoginMapper;

    /**
     * 查询用户的待办事项，包括已完成的
     *
     * @param UserID 用户ID
     * @return 用户待办事项列表
     */
    public List<TodoList> GetTodoListByUserID(int UserID) {
        return todoListMapper.GetTodoListByUserID(UserID);
    }

    /**
     * 查询用户最后登录信息
     * @param UserID 查询的用户的id
     * @return 最后登录信息类
     */
    public LastLogin GetLastLoginInfo(int UserID) {
        return lastLoginMapper.GetLastLoginInfo(UserID);
    }
    public ResultInfo AddTodoListItem(Integer UserID, String TodoThings) {
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        if (todoListMapper.AddTodoListItem(UserID, TodoThings) != 0) {
            resultInfo.setResultInfo("成功！！");
        } else {
            resultInfo.setResultInfo("失败！！");
        }
        return resultInfo;
    }

    public ResultInfo UpdateTodoListItem(Integer todoListID, String todoThings, Integer finishState) {
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        if (todoListMapper.UpdateTodoListItem(todoListID, todoThings, finishState) != 0) {
            resultInfo.setResultInfo("成功！！");
        } else {
            resultInfo.setResultInfo("失败！！");
        }
        return resultInfo;
    }

    public ResultInfo DeleteTodoListItem(Integer todoListID) {
        ResultInfo resultInfo = DIUtil.getBean(ResultInfo.class);
        if (todoListMapper.DeleteTodoListItem(todoListID) != 0) {
            resultInfo.setResultInfo("成功！！");
        } else {
            resultInfo.setResultInfo("失败！！");
        }
        return resultInfo;
    }
}
