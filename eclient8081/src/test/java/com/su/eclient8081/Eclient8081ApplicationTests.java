package com.su.eclient8081;

import com.su.eclient8081.Eclient8081Application;
import com.su.eclient8081.Eclient8081Application.SubThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Eclient8081ApplicationTests {

	@Test
	public void contextLoads() {
	}



	@Test
	public void fn(){
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		SubThread subThread = new Eclient8081Application().new SubThread();
		executorService.execute(subThread);
	}

}
