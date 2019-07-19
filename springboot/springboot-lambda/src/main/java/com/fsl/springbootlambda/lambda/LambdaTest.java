package com.fsl.springbootlambda.lambda;

import cn.hutool.core.date.DateUtil;
import com.fsl.springbootlambda.pojo.BasketBallPlayer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author 2019年5月29日10:28:59
 * 各种lambda表达式的特性
 */
public class LambdaTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final List<BasketBallPlayer> list = new ArrayList<>();

    static {
        list.add(new BasketBallPlayer(1,"James Harden",30,"Houston Rockets", DateUtil.parseDate("1989-8-26"),36.1f,6.6f,7.5f));
        list.add(new BasketBallPlayer(1,"Paul George",29,"Oklahoma City Thunder", DateUtil.parseDate("1990-5-2"),28f,8.2f,4.1f));
        list.add(new BasketBallPlayer(3,"Giannis Antetokounmpo",25,"Milwaukee Bucks", DateUtil.parseDate("1994-12-6"),27.7f,12.5f,5.9f));
        list.add(new BasketBallPlayer(4,"Joel Embiid",25,"Philadelphia 76ers", DateUtil.parseDate("1994-3-16"),27.5f,13.6f,3.7f));
        list.add(new BasketBallPlayer(5,"Stephen Curry",31,"Golden State Warriors", DateUtil.parseDate("1988-3-14"),27.3f,5.3f,5.2f));
        list.add(new BasketBallPlayer(6,"Kawhi Leonard",28,"Toronto Raptors", DateUtil.parseDate("1991-6-29"),26.6f,7.3f,3.3f));
        list.add(new BasketBallPlayer(7,"kobe bryant",41,"Los Angeles Lakers", DateUtil.parseDate("1978-8-23"),25.8f,4.6f,6.9f));
        list.add(new BasketBallPlayer(8,"king James",35,"Los Angeles Lakers", DateUtil.parseDate("1984-12-30"),23.8f,5f,6.9f));
        list.add(new BasketBallPlayer(9,"Kevin Durant",31,"Golden State Warriors", DateUtil.parseDate("1988-9-29"),22.9f,11.1f,10.7f));
        list.add(new BasketBallPlayer(10,"Damian Lillard",30,"Portland Trail Blazers", DateUtil.parseDate("1990-7-15"),21.5f,3.8f,2.4f));
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * lambda新建一个线程
     */
    @Test
    public  void run1(){
        Thread thread = new Thread(()-> System.out.println("hello world"));
        thread.start();
    }

    @Test
    public void run2(){
        //创建集合
        List<String> collect = Stream.of("a", "b", "c").collect(Collectors.toList());

        //创建一个包含1-100数字的集合
        IntStream intStream = IntStream.rangeClosed(1, 100);
        intStream.forEach(System.out::println);
    }


    /**
     * lambda map相关的操作
     */
    public void run3(){
        //获取name的集合
        List<String> nameList1 = list.stream().map(x->x.getName()).collect(Collectors.toList());
        List<String> nameList2 = list.stream().map(BasketBallPlayer::getName).collect(Collectors.toList());

        //把name信息全部转换成大写
        List<String> nameList3 = list.stream().map(BasketBallPlayer::getName).map(String::toUpperCase).collect(Collectors.toList());

        //计算球员的总平均得分
        Float reduce1 = list.stream().map(BasketBallPlayer::getScore).reduce(0f, (x, y) -> x + y);

        Optional<Float> optional1 = list.stream().map(BasketBallPlayer::getScore).reduce((x, y) -> x + y);
        Float reduce2 = optional1.get();

        //计算最高分和最低分
        Optional<Float> optional2 = list.stream().map(BasketBallPlayer::getScore).reduce(Float::max);
        Optional<Float> optional3 = list.stream().map(BasketBallPlayer::getScore).reduce(Float::min);
        Float reduce3 = optional2.get();
        Float reduce4 = optional3.get();

        //计算平均分
        Float asDouble = (float)list.stream().mapToDouble(BasketBallPlayer::getScore).average().getAsDouble();

        //分数分别减去10分
        List<Float> collect = list.stream().map(x -> x.getScore() - 10f).collect(Collectors.toList());

        /**
         * 把姓名分别按照空格拆开然后组成一个新的List
         */
        List<String> collect1 = list.stream().flatMap(item -> Arrays.stream(item.getName().split(" "))).collect(Collectors.toList());

        /**
         * 按照分数进行排序
         */
        List<Float> collect2 = list.stream().map(BasketBallPlayer::getScore).sorted().collect(Collectors.toList());
    }

    /**
     * fliter相关的操作
     */
    public void run4(){

        //寻找来Los Angeles Lakers的球员
        List<BasketBallPlayer> collect = list.parallelStream().filter(x -> "Los Angeles Lakers".equals(x.getTeam())).collect(Collectors.toList());

        //寻找名字是以K开头的球员
        List<BasketBallPlayer> k = list.parallelStream().filter(x -> x.getName().startsWith("K")).collect(Collectors.toList());

        //寻找场均三双的球员
        List<BasketBallPlayer> collect1 = list.parallelStream().filter(x -> x.getScore() >= 10 && x.getRebound() >= 10 && x.getAssist() >= 10).collect(Collectors.toList());

        //每个球队只保留一名球员，具体保留哪一名不关心
        List<BasketBallPlayer> collect2 = list.parallelStream().filter(distinctByKey(x -> x.getTeam())).collect(Collectors.toList());

    }

    /**
     * collect相关操作
     */
    public void run5(){

        //list 转 set
        Set<BasketBallPlayer> collect = list.parallelStream().collect(Collectors.toSet());

        /**
         * 根据球队对球员进行分组
         */
        Map<String, List<BasketBallPlayer>> collect1 = list.parallelStream().collect(Collectors.groupingBy(x -> x.getTeam()));

        /**
         * 生成球员名称为key  球员球队为value的map
         */
        Map<String, String> collect2 = list.parallelStream().collect(Collectors.toMap(BasketBallPlayer::getName, BasketBallPlayer::getTeam));

        // 嵌套调用groupingBy  先以球队进行分组，分组完成之后再以名称进行分组
        // 这个的作用可以查询某个球队某个名称的球员有多少个
        Map<String, Map<String, List<BasketBallPlayer>>> collect3 = list.parallelStream().collect(Collectors.groupingBy(BasketBallPlayer::getTeam, Collectors.groupingBy(BasketBallPlayer::getName)));

        // 把名称组装成一个字符串
        String collect4 = list.parallelStream().map(x -> x.getName()).collect(Collectors.joining(", "));
    }

    /**
     * Predicate的使用：表达式作为参数
     */
    public void run6(){

        Predicate<BasketBallPlayer> startsWithK = (n) -> n.getName().startsWith("K");
        Predicate<BasketBallPlayer> scoreNum = (n) -> n.getScore() > 25;

        // 根据上面的条件进行数据过滤
        List<BasketBallPlayer> collect = list.parallelStream().filter(startsWithK.and(scoreNum)).collect(Collectors.toList());
    }

}
