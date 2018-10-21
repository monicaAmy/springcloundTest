package com.su.quartz;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * NieSu 2018/9/9
 */
@Mapper
public interface JobDao
{

  @Select("select * from t_quartz_job where enable='true'")
  List<ScheduleJob> getAllEnableJob();

  @Select("select * from t_quartz_job where id=#{jobId}")
  ScheduleJob select(Long jobId);

  @Update("update t_quartz_job set where id=#{jobId}")
  int update(ScheduleJob scheduleJob);

  @Insert("insert into t_quartz_job() values()")
  int insert(ScheduleJob scheduleJob);

  @Delete("delete from t_quartz_job where id=#{jobId}")
  int delete(Long jobId);

  @Select("")
  List<ScheduleJob> getAllJob();
}
