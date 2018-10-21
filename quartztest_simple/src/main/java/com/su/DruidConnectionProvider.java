package com.su;

import com.alibaba.druid.pool.DruidDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import org.quartz.utils.ConnectionProvider;


public class DruidConnectionProvider implements ConnectionProvider
{

  // 数据库最大连接数
  public int maxConnection;

  // 数据库SQL查询每次连接返回执行到连接池，以确保它仍然是有效的。
  public String validationQuery;

  private boolean validateOnCheckout;

  private int idleConnectionValidationSeconds;

  public String maxCachedStatementsPerConnection;

  public static final int DEFAULT_DB_MAX_CONNECTIONS = 10;

  public static final int DEFAULT_DB_MAX_CACHED_STATEMENTS_PER_CONNECTION = 120;

  // Druid连接池
  private DruidDataSource datasource;

  private DataSourcesProperties dataSourcesProperties;

  @Override
  public Connection getConnection()
      throws SQLException
  {
    return datasource.getConnection();
  }

  @Override
  public void shutdown()
      throws SQLException
  {
    datasource.close();
  }

  @Override
  public void initialize()
      throws SQLException
  {

    dataSourcesProperties = SpringContextUtil.getBean(DataSourcesProperties.class);

    if (dataSourcesProperties.getUrl() == null)
    {
      throw new SQLException("DBPool could not be created: DB URL cannot be null");
    }
    if (dataSourcesProperties.getDriverClassName() == null)
    {
      throw new SQLException(
          "DBPool driver could not be created: DB driver class name cannot be null!");
    }
    if (this.maxConnection < 0)
    {
      throw new SQLException(
          "DBPool maxConnectins could not be created: Max connections must be greater than zero!");
    }

    datasource = new DruidDataSource();

    try
    {
      datasource.setDriverClassName(dataSourcesProperties.getDriverClassName());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    datasource.setUrl(dataSourcesProperties.getUrl());
    datasource.setUsername(dataSourcesProperties.getUsername());
    datasource.setPassword(dataSourcesProperties.getPassword());
    datasource.setMaxActive(this.maxConnection);
    datasource.setMinIdle(1);
    datasource.setMaxWait(0);
    datasource.setMaxPoolPreparedStatementPerConnectionSize(this.maxConnection);
    if (this.validationQuery != null)
    {
      datasource.setValidationQuery(this.validationQuery);
      if (!this.validateOnCheckout)
      {
        datasource.setTestOnReturn(true);
      }
      else
      {
        datasource.setTestOnBorrow(true);
      }
      datasource.setValidationQueryTimeout(this.idleConnectionValidationSeconds);
    }
  }

  public int getMaxConnection()
  {

    return maxConnection;
  }

  public void setMaxConnection(int maxConnection)
  {

    this.maxConnection = maxConnection;
  }

  public String getValidationQuery()
  {

    return validationQuery;
  }

  public void setValidationQuery(String validationQuery)
  {

    this.validationQuery = validationQuery;
  }

  public boolean isValidateOnCheckout()
  {

    return validateOnCheckout;
  }

  public void setValidateOnCheckout(boolean validateOnCheckout)
  {

    this.validateOnCheckout = validateOnCheckout;
  }

  public int getIdleConnectionValidationSeconds()
  {

    return idleConnectionValidationSeconds;
  }

  public void setIdleConnectionValidationSeconds(int idleConnectionValidationSeconds)
  {

    this.idleConnectionValidationSeconds = idleConnectionValidationSeconds;
  }

  public String getMaxCachedStatementsPerConnection()
  {

    return maxCachedStatementsPerConnection;
  }

  public void setMaxCachedStatementsPerConnection(String maxCachedStatementsPerConnection)
  {

    this.maxCachedStatementsPerConnection = maxCachedStatementsPerConnection;
  }

}