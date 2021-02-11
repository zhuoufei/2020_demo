package com.zf.mo.mybatis;

import java.util.HashMap;
import java.util.Map;

public class MappedStatement {

    private String nameSpace;
    private String sourceId;
    private String resultType;
    private String sql;
    private Map<String,MappedStatement> mappedStatementMap = new HashMap<>();

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "MappedStatement{" +
                "nameSpace='" + nameSpace + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", resultType='" + resultType + '\'' +
                ", sql='" + sql + '\'' +
                ", mappedStatementMap=" + mappedStatementMap +
                '}';
    }
}
