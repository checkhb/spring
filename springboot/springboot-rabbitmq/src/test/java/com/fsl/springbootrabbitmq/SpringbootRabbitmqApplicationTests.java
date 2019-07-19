package com.fsl.springbootrabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {


	/**
	 * 1. 两个线程分别打印26个英文字母的元音（a,e,i,o,u）和辅音（其他）,按字母顺序输出
	 * 2. 一条N个格子组成的直线道路，每次可以前进1格或2格；设计算法计算有多少种方式走到终点？
	 * 3. 实现一个能够生产不同类型手机（Android，iPhone）的工厂，考虑未来可能的扩展
	 */
	@Test
	public void contextLoads() {
		int n = 5;
		Integer step = getStep(n);
		System.out.println("step = "+ step);
	}


	public Integer getStep(Integer n){
		int result=1;//存放结果
		int b = n/3;
		while(b>0) {
			result *= 3;
			b--;
		}
		int k = n%3;
		return result + k;
	}

}
