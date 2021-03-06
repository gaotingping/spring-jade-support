package net.paoding.rose.jade.dataaccess.datasource;

import java.util.Map;

import javax.sql.DataSource;

import net.paoding.rose.jade.dataaccess.DataSourceFactory;
import net.paoding.rose.jade.dataaccess.DataSourceHolder;
import net.paoding.rose.jade.statement.StatementMetaData;

/**
 * 当你的应用程序只需要一个DataSource时候使用这个实现即可！
 */
public class SimpleDataSourceFactory implements DataSourceFactory {

    private DataSourceHolder dataSource;

    public SimpleDataSourceFactory() {
    	
    }

    public SimpleDataSourceFactory(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public void setDataSource(DataSource dataSource) {
        if (dataSource == null) {
            throw new NullPointerException("dataSource");
        }
        this.dataSource = new DataSourceHolder(dataSource);
    }

    @Override
    public DataSourceHolder getHolder(StatementMetaData metaData,
            Map<String, Object> runtimeProperties) {
        return dataSource;
    }
}
