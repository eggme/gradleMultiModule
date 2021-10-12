package com.example.samplecore.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.EnvironmentAware
import org.springframework.context.annotation.*
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.spi.PersistenceUnitInfo
import javax.sql.DataSource

@Configuration
@ComponentScan(basePackages = [
    "com.example.samplecore"]
)
@EnableJpaRepositories(basePackages = [
    "com.example.samplecore"
])
@EntityScan("com.example.samplecore")
@PropertySource("classpath:application-sample-core.properties")
class JpaConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "core.jpa")
    fun coreJpaProperties() = JpaProperties()

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "core.datasource")
    fun coreHikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    @Primary
    fun coreHibernateSettings(): HibernateSettings {
        return HibernateSettings()
    }

    @Bean
    @Primary
    fun dataSource(): DataSource {
        val source = HikariDataSource(coreHikariConfig())
        println(source.dataSource)
        return source
    }
}