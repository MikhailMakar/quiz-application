package com.quiz.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = {"com.quiz.repository"},
        entityManagerFactoryRef = "quizEntityManagerFactory",
        transactionManagerRef = "quizTransactionManager")
public class QuizDataSourceConfig {

    @Bean(name = "quizDataSourceProperties")
    @Primary
    @ConfigurationProperties("app.datasource.quiz")
    public DataSourceProperties quizDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "quizDataSource")
    @Primary
    public DataSource quizDataSource(@Qualifier("quizDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "quizEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean quizEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                              @Qualifier("quizDataSource") DataSource dataSource,
                                                                              HibernateProperties hibernateProperties,
                                                                              JpaProperties jpaProperties) {
        HibernateSettings hibernateSettings = new HibernateSettings();
        return builder
                .dataSource(dataSource)
                .packages("com.quiz.model")
                .persistenceUnit("quizEntityManager")
                .properties(hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), hibernateSettings))
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager quizTransactionManager(@Qualifier("quizEntityManagerFactory") EntityManagerFactory quizEntityManagerFactory) {
        return new JpaTransactionManager(quizEntityManagerFactory);
    }
}
