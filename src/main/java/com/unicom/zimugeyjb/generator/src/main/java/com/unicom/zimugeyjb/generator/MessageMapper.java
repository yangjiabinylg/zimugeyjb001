//package com.unicom.zimugeyjb.generator;
//
//import com.unicom.zimugeyjb.generator.Message;
//import com.unicom.zimugeyjb.generator.MessageExample;
//import java.util.List;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface MessageMapper {
//    long countByExample(MessageExample example);
//
//    int deleteByExample(MessageExample example);
//
//    int deleteByPrimaryKey(Long id);
//
//    int insert(Message record);
//
//    int insertSelective(Message record);
//
//    List<Message> selectByExample(MessageExample example);
//
//    Message selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);
//
//    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);
//
//    int updateByPrimaryKeySelective(Message record);
//
//    int updateByPrimaryKey(Message record);
//}