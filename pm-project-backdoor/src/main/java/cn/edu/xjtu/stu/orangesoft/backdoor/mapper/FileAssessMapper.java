package cn.edu.xjtu.stu.orangesoft.backdoor.mapper;

import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FileAssess;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FileAssessMapper {
    FileAssess GetFileAssessByFileID(
            @Param("Fileid") Integer FileID);

    Integer BuildNewFileAssess(FileAssess fileAssess);
}
