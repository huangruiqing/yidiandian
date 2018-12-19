package huangruiqing;

import java.io.Serializable;

/**
 * @ClassName DbConfig
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/19 16:30
 */
public class DbConfig implements Serializable {
    private static final long serialVersionUID = 3767584465320251291L;

    private String dbType;
    private String dbName;
    private String dbPassword;

    public  DbConfig(){}
    public  DbConfig(String dbType, String dbName, String dbPassword){
        this.dbName = dbName;
        this.dbType = dbType;
        this.dbPassword = dbPassword;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    @Override
    public String toString() {
        return "DbConfig{" +
                "dbType='" + dbType + '\'' +
                ", dbName='" + dbName + '\'' +
                ", dbPassword='" + dbPassword + '\'' +
                '}';
    }
}
