package cn.edu.xjtu.stu.orangesoft.backdoor.service;

import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.FileMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.mapper.UserMapper;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FileContent;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.FileResult;
import cn.edu.xjtu.stu.orangesoft.backdoor.pojo.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

//todo
@Service
public class FileService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    FileMapper fileMapper;

    public  Files getFilesByID(Integer FileID) {
        if( FileID==null ) {
            return null;
        }
        else{
            Files file = fileMapper.GetFileByID(FileID);
            return file;
        }

    }
    public FileResult getFileByTeamID(Integer TeamID){
        FileResult filesResult = new FileResult();
        if(TeamID == null){
            filesResult.setFinish("teamID not found");
        }
        else{
            filesResult.setFinish("success");
            List<Files> files = fileMapper.GetFileByTeamID(TeamID);
            filesResult.setFile(files);
        }
        return filesResult;
    }
    public String postFile(Files file, byte[] bytes) {
        int k;
        if(file == null){
            return "file not found";
        }
        else{
            k= fileMapper.PostFiles(file);
            if(k==0) {
                return "fail when trying to post file";
            }
            else{
                FileContent fileContent = new FileContent();
                fileContent.setFileContent(bytes);
                fileContent.setFileID(file.getFileID());
                k = fileMapper.PostFilesContent(fileContent);
                if(k == 0){
                    return "fail when trying to post filecontent";
                }
                return "post file success";
            }
        }
    }
    public String putFile(Files file) {
        int k;
        if(file==null){
            return "file not found";
        }
        else{
            k= fileMapper.PutFiles(file);
            if(k==0) {
                return "update file failed";
            }
            else{
                return "update file success";
            }
        }
    }
    public String deleteFile(Integer FileID) {
        int k;
        k= fileMapper.DeleteFiles(FileID);
        if(k==0) {
            return "no such file or delete error";
        }
        else{
            return "delete file success";
        }
    }


}
