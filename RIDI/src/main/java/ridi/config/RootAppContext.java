package ridi.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan("ridi.model.books")
@ComponentScan("ridi.model.member")
@ComponentScan("ridi.model.orders")
@ComponentScan("ridi.model.qna")
@ComponentScan("ridi.model.review")
public class RootAppContext {
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@20.196.196.215:1521:xe");
		hikariConfig.setUsername("TEST");
		hikariConfig.setPassword("1234");
		
		// ���μ���
		hikariConfig.setMaximumPoolSize(10);
		hikariConfig.setConnectionTimeout(50000); // 30��
		//hikariConfig.setLeakDetectionThreshold(300000);
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:ridi/mybatis/config.xml"));
//		sqlSessionFactoryBean.setMapperLocations(resolver.getResource("classpath:ridi/mybatis/BookMapper.xml"));
		sqlSessionFactoryBean.setMapperLocations(resolver.getResource("classpath:ridi/mybatis/MemberMapper.xml"));
//		sqlSessionFactoryBean.setMapperLocations(resolver.getResource("classpath:ridi/mybatis/OrdersMapper.xml"));
//		sqlSessionFactoryBean.setMapperLocations(resolver.getResource("classpath:ridi/mybatis/QnaMapper.xml"));
//		sqlSessionFactoryBean.setMapperLocations(resolver.getResource("classpath:ridi/mybatis/ReviewMapper.xml"));
		
		return (SqlSessionFactory)sqlSessionFactoryBean.getObject();
	}
	
}
