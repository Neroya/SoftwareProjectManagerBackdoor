package cn.edu.xjtu.stu.orangesoft.backdoor.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class Task {
    private int TaskID;
    private String TaskName;
    private String TaskDeadline;
    private int TaskHandlerID;
    private int TaskFinishType;
    private String TaskStartTime;
    private int TaskPublisherID;
    private String TaskDescription;
}
