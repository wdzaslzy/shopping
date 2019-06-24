package top.wdzaslzy.shopping.handler;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.SparkSession;

/**
 * @author lizy
 **/
public class LogHandle {

    //将log日志处理为正常日志
    public static void main(String[] args) {
        SparkSession sparkSession = SparkSession.builder()
                .appName("handleLog")
                .getOrCreate();

        JavaRDD<String> lines = sparkSession.read().textFile(args[0]).javaRDD();
        JavaRDD<String> result = lines.flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String s) throws Exception {
                return Collections.singletonList(s.split("-")[3]).iterator();
            }
        });

        result.saveAsTextFile(args[1]);

        sparkSession.stop();
    }

}
