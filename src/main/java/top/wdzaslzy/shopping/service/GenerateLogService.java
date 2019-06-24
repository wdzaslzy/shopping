package top.wdzaslzy.shopping.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author lizy
 **/
@Service
public class GenerateLogService {

    private Logger logger = LoggerFactory.getLogger("shoppingInfo");

    /**
     * 生成加入购物车的log日志
     */
    public void generateAddShoppingCartLog() {
        //用户id	商品id	操作(加入购物车0 收藏1)	操作时间
        int index = 0;
        while (index < 10000) {
            index++;
            String log = generateLog(0);
            logger.info(log);
        }
    }

    /**
     * 生成收藏商品的log
     */
    public void generateCollectGoodsLog() {
        //用户id	商品id	操作(加入购物车0 收藏1)	操作时间
        int index = 0;
        while (index < 10000) {
            index++;
            String log = generateLog(1);
            logger.info(log);
        }
    }

    private String generateLog(int action) {
        Long userId = (long) (Math.random() * 9000) + 1000;
        Long goodsId = (long) (Math.random() * 900000) + 100000;

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String actionTime = null;
        try {
            Long startTime = dateFormat.parse("2018-01-01 00:00:00").getTime();
            Long endTime = dateFormat.parse("2018-12-31 23:59:59").getTime();
            Date theDate = new Date(startTime + (long) (Math.random() * (endTime - startTime)));
            actionTime = dateFormat.format(theDate);
        } catch (ParseException e) {
            logger.info("时间转换发生错误：" + e.getMessage(), e);
        }

        return userId + "," + goodsId + "," + action + "," + actionTime;
    }

}
