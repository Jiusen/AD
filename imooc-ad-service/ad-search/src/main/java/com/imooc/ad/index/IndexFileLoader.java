package com.imooc.ad.index;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.dump.DConstant;
import com.imooc.ad.dump.table.*;
import com.imooc.ad.handler.AdLevelDataHandler;
import com.imooc.ad.mysql.constant.OpType;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jiusen Guo
 * @date 2021/2/8 20:34
 * 全量索引的加载
 */
@Component
@DependsOn("dataTable") //控制bean加载顺序
public class IndexFileLoader {

    /**
     * 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。
     * Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法)
     * 初始化，加载文件中的数据
     */
    @PostConstruct
    public void init() {

        //得到文件中每一行 --- 每一条数据
        List<String> adPlanStrings = loadDumpData(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_PLAN));
        //解析每一条数据，随后执行添加方法，添加到对应类的map中
        adPlanStrings.forEach(p -> AdLevelDataHandler.handleLevel2(JSON.parseObject(p, AdPlanTable.class), OpType.ADD));

        adPlanStrings.forEach(p -> AdLevelDataHandler.handleLevel2(JSON.parseObject(p, AdPlanTable.class), OpType.ADD));

        List<String> adCreativeStrings = loadDumpData(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_CREATIVE));
        adCreativeStrings.forEach(c -> AdLevelDataHandler.handleLevel2(JSON.parseObject(c, AdCreativeTable.class), OpType.ADD));

        List<String> adUnitStrings = loadDumpData(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_UNIT));
        adUnitStrings.forEach(u -> AdLevelDataHandler.handleLevel3(JSON.parseObject(u, AdUnitTable.class), OpType.ADD));

        List<String> adCreativeUnitStrings = loadDumpData(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_CREATIVE_UNIT));
        adCreativeUnitStrings.forEach(cu -> AdLevelDataHandler.handleLevel3(JSON.parseObject(cu, AdCreativeUnitTable.class), OpType.ADD));

        List<String> adUnitDistrictStrings = loadDumpData(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_UNIT_DISTRICT));
        adUnitDistrictStrings.forEach(d -> AdLevelDataHandler.handleLevel4(JSON.parseObject(d, AdUnitDistrictTable.class), OpType.ADD));

        List<String> adUnitItStrings = loadDumpData(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_UNIT_IT));
        adUnitItStrings.forEach(i -> AdLevelDataHandler.handleLevel4(JSON.parseObject(i, AdUnitItTable.class), OpType.ADD));

        List<String> adUnitKeywordStrings = loadDumpData(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_UNIT_KEYWORD));
        adUnitKeywordStrings.forEach(k -> AdLevelDataHandler.handleLevel4(JSON.parseObject(k, AdUnitKeywordTable.class), OpType.ADD));
    }

    /**
     * 读取文件中的数据
     * @param fileName
     * @return
     */
    private List<String> loadDumpData(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))){
            return br.lines().collect(Collectors.toList());  //得到所有行数的 数据
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
