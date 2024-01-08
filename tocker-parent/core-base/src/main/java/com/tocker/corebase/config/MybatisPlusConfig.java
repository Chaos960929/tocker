package com.tocker.corebase.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.extension.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDbType(DbType.MYSQL);
        paginationInterceptor.setOverflow(true);
        paginationInterceptor.setLimit(1000);
//        List<ISqlParser> sqlParsersList = new ArrayList<>();
//        sqlParsersList.add(this.logicNoDeletedSqlParser());
//        paginationInterceptor.setSqlParserList(sqlParsersList);
        ;
        return paginationInterceptor;
    }

//    private ISqlParser logicNoDeletedSqlParser() {
//        TenantSqlParser logicNoDeletedSqlParser = new TenantSqlParser() {
//
//            @Override
//            public boolean doFilter(MetaObject metaObject, String sql) {
//                MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("");
//                return SqlCommandType.SELECT == mappedStatement.getSqlCommandType();
//            }
//        };
//        logicNoDeletedSqlParser.setTenantHandler(new TenantHandler() {
//            @Override
//            public Expression getTenantId(boolean select) {
//                return new StringValue("0");
//            }
//
//            @Override
//            public String getTenantIdColumn() {
//                return "deleted";
//            }
//
//            @Override
//            public boolean doTableFilter(String tableName) {
//                return false;
//            }
//        });
//        return logicNoDeletedSqlParser;
//    }

    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        OptimisticLockerInterceptor optimisticLockerInterceptor = new OptimisticLockerInterceptor();
        return optimisticLockerInterceptor;
    }

    @Bean
    public IKeyGenerator iKeyGenerator() {
        H2KeyGenerator h2KeyGenerator = new H2KeyGenerator();
        return h2KeyGenerator;
    }
}
