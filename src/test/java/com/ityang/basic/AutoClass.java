package com.ityang.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AutoClass {

	@Test
	public void AutoCreate() {
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			InputStream is = new FileInputStream("D:\\myproject\\spring\\src\\main\\resources\\generator\\generatorConfig.xml");
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(is);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		}
	}

}
