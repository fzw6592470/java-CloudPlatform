package com.genvict.scheduledTasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.genvict.scheduledTasks.service.ScheduledTasks;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduledTasksTest {
	
	@Autowired
	ScheduledTasks scheduledTasks;
	
	@Test
	public void tasksTest()
	{
		scheduledTasks.reportCurrentTime();
	}
}
