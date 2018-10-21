package com.su.quartz;

import com.su.ServiceException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController
{

  @Autowired
  private JobService jobService;

  @GetMapping
  public List<ScheduleJob> getAllJob()
  {
    return jobService.getAllJob();
  }

  @GetMapping("/{id}")
  public ScheduleJob getJob(@PathVariable("id") Long jobId) throws ServiceException
  {
    return jobService.select(jobId);
  }

  @PutMapping("/update/{id}")
  public ScheduleJob updateJob(@PathVariable("id") Long jobId,
      @RequestBody ScheduleJob newScheduleJob) throws ServiceException
  {
    return jobService.update(jobId, newScheduleJob);
  }

  @DeleteMapping("/delete/{id}")
  public Boolean deleteJob(@PathVariable("id") Long jobId) throws ServiceException
  {
    return jobService.delete(jobId);
  }

  @PostMapping("/save")
  public boolean saveJob(@RequestBody ScheduleJob newScheduleJob) throws ServiceException
  {
    return jobService.add(newScheduleJob);
  }


  @GetMapping("/run/{id}")
  public boolean runJob(@PathVariable("id") Long jobId) throws ServiceException
  {
    return jobService.run(jobId);
  }


  @GetMapping("/pause/{id}")
  public boolean pauseJob(@PathVariable("id") Long jobId) throws ServiceException
  {
    return jobService.pause(jobId);
  }

  @GetMapping("/resume/{id}")
  public boolean resumeJob(@PathVariable("id") Long jobId) throws ServiceException
  {
    return jobService.resume(jobId);
  }
}