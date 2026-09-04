package com.example.testvue;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeGenerator {

    // 数据库链接
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&characterEncoding=utf8&allowPublicKeyRetrieval=true";
    // 数据库用户名
    private static final String DATABASE_USERNAME = "admin";
    // 数据库密码
    private static final String DATABASE_PASSWORD = "123456";
    // 包名（根据自己项目修改）
    private static final String PACKAGE_NAME = "com.example.testvue";
    // 模块名称（如果项目中有多个模块需要设置（如：用户模块、商品模块、订单模块），只有一个模块就不用设置（为空就好））
    private static final String SECOND_MODULE = "";
    // 作者
    private static final String AUTHOR = "LIUJIA";
    // 表前缀（org_user表需要去掉前缀时这里填写"org_"）
    private static final String TABLE_PREFIX = "";
    // 生成代码文件的路径
    private static final String PARENT = PACKAGE_NAME + (StringUtils.isNotBlank(SECOND_MODULE) ? "." + SECOND_MODULE : "");
    // 生成xml文件的路径
    private static final String XML_PATH = "/src/main/resources/mappers" + (StringUtils.isNotBlank(SECOND_MODULE) ? "/" + SECOND_MODULE : "");

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        // 设置代码生成路径
        gc.setOutputDir(projectPath + "/src/main/java/");
        // 是否覆盖以前文件
        gc.setFileOverride(true);
        // 是否打开生成目录
        gc.setOpen(false);
        // 设置项目作者名称
        gc.setAuthor(AUTHOR);
        // 设置主键策略
        gc.setIdType(IdType.AUTO);
        // 生成基本ResultMap
        gc.setBaseResultMap(true);
        // 生成基本ColumnList
        gc.setBaseColumnList(true);
        // 去掉服务默认前缀
        gc.setServiceName("%sService");
        // 设置时间类型
        gc.setDateType(DateType.ONLY_DATE);
        // 设置Swagger2
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // 数据库链接
        dsc.setUrl(DATABASE_URL);
        // 数据库驱动
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        // 数据库用户名
        dsc.setUsername(DATABASE_USERNAME);
        // 数据库密码
        dsc.setPassword(DATABASE_PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PARENT);
        pc.setMapper("mapper");
        pc.setXml("mapper");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl(null);
        pc.setController("controller");
        Map<String, String> packageInfo = new HashMap<>();
        String path = gc.getOutputDir() + PARENT.replace(".", "/") + "/";
        String xmlPath = projectPath + XML_PATH;
        System.out.println("XML_PATH:" + xmlPath);
        packageInfo.put(ConstVal.XML_PATH, xmlPath);
        packageInfo.put(ConstVal.ENTITY_PATH, path + "entity");
        packageInfo.put(ConstVal.SERVICE_PATH, path + "service");
//        packageInfo.put(ConstVal.SERVICE_IMPL_PATH, path + "service/impl");
        packageInfo.put(ConstVal.MAPPER_PATH, path + "mapper");
        packageInfo.put(ConstVal.CONTROLLER_PATH, path + "controller");
        pc.setPathInfo(packageInfo);
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动lombok
        sc.setEntityLombokModel(true);
        sc.setRestControllerStyle(true);
        sc.setControllerMappingHyphenStyle(true);
        // 设置逻辑删除
        sc.setLogicDeleteFieldName("deleted");

        // 设置自动填充配置
        TableFill gmt_create = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmt_modified = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmt_create);
        tableFills.add(gmt_modified);
        sc.setTableFillList(tableFills);

        // 乐观锁
        sc.setVersionFieldName("version");
        // 驼峰命名
        sc.setRestControllerStyle(true);

        // 设置表名前缀
        sc.setTablePrefix(TABLE_PREFIX);
        // 设置需要生成的表名
        sc.setInclude(scanner("表名，如果同时输入多个表名，中间用英文逗号分割（例如：user,order,product）").split(","));
        mpg.setStrategy(sc);

        // 自定义配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController("templates/controller.java");
        mpg.setTemplate(templateConfig);

        // 生成代码
        mpg.execute();

    }

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


}
