package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.RBACMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Objects;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Operation;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.PermissionConfig;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RBACService {
    @Autowired
    RBACMapper rbacMapper;
    @Autowired
    UserMapper userMapper;

    public boolean CheckPermission(Integer userID, String userPassword, Objects objects, Operation operation) {
        User user = userMapper.GetUserByIDAndPassword(userID, userPassword);
        if (user == null) {
            return false;
        } else {
            return CheckPermission(user.getRoleID(), objects, operation);
        }
    }

    public boolean CheckPermission(Integer roleID, Objects objects, Operation operation) {
        PermissionConfig config = rbacMapper.CheckPermission(roleID, objects.getObjectName(), operation.getOperationDescription());
        return config.getPermission() != 0;
    }
}
