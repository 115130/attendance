package com.bylw.attendance;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.bylw.attendance.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collections;

@SpringBootTest
class AttendanceApplicationTests {
    @Resource
    IUserService userMapper;
    @Test
    void t(){
        userMapper.getById(1);
//        userMapper.getUser(new LoginVo("admin","admin"));
    }

    @Test
    void contextLoads() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/bysj", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("yangjiahui") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/home/miao/IdeaProjects/attendance/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.bylw") // 设置父包名
                            .moduleName("attendance") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/home/miao/IdeaProjects/attendance/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_authority","t_commute_record","t_commute_limit","t_user_info","t_user") // 设置需要生成的表名
                            .addTablePrefix("t_");
//                            .addFieldPrefix("t_","u_");
                    // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
