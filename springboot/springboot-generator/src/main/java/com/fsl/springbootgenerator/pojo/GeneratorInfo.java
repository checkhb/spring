package com.fsl.springbootgenerator.pojo;

/**
 * @author
 */
public class GeneratorInfo {

    private String tableName;

    private String codePath;

    private String packageParentPath;

    private String packagePath;

    private String keyStrategy;

    private String dtoName;

    private String controllerName;

    private String mapperName;

    private String mapperXmlName;

    private String serviceName;

    private String implName;

    private boolean dtoCreated;
    private boolean dtoCover;

    private boolean controllerCreated;
    private boolean controllerCover;

    private boolean mapperCreated;
    private boolean mapperCover;

    private boolean mapperXmlCreated;
    private boolean mapperXmlCover;

    private boolean serviceCreated;
    private boolean serviceCover;

    private boolean implCreated;
    private boolean implCover;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCodePath() {
        return codePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    public String getPackageParentPath() {
        return packageParentPath;
    }

    public void setPackageParentPath(String packageParentPath) {
        this.packageParentPath = packageParentPath;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }

    public String getKeyStrategy() {
        return keyStrategy;
    }

    public void setKeyStrategy(String keyStrategy) {
        this.keyStrategy = keyStrategy;
    }

    public String getDtoName() {
        return dtoName;
    }

    public void setDtoName(String dtoName) {
        this.dtoName = dtoName;
    }

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getMapperName() {
        return mapperName;
    }

    public void setMapperName(String mapperName) {
        this.mapperName = mapperName;
    }

    public String getMapperXmlName() {
        return mapperXmlName;
    }

    public void setMapperXmlName(String mapperXmlName) {
        this.mapperXmlName = mapperXmlName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getImplName() {
        return implName;
    }

    public void setImplName(String implName) {
        this.implName = implName;
    }

    public boolean isDtoCreated() {
        return dtoCreated;
    }

    public void setDtoCreated(boolean dtoCreated) {
        this.dtoCreated = dtoCreated;
    }

    public boolean isDtoCover() {
        return dtoCover;
    }

    public void setDtoCover(boolean dtoCover) {
        this.dtoCover = dtoCover;
    }

    public boolean isControllerCreated() {
        return controllerCreated;
    }

    public void setControllerCreated(boolean controllerCreated) {
        this.controllerCreated = controllerCreated;
    }

    public boolean isControllerCover() {
        return controllerCover;
    }

    public void setControllerCover(boolean controllerCover) {
        this.controllerCover = controllerCover;
    }

    public boolean isMapperCreated() {
        return mapperCreated;
    }

    public void setMapperCreated(boolean mapperCreated) {
        this.mapperCreated = mapperCreated;
    }

    public boolean isMapperCover() {
        return mapperCover;
    }

    public void setMapperCover(boolean mapperCover) {
        this.mapperCover = mapperCover;
    }

    public boolean isMapperXmlCreated() {
        return mapperXmlCreated;
    }

    public void setMapperXmlCreated(boolean mapperXmlCreated) {
        this.mapperXmlCreated = mapperXmlCreated;
    }

    public boolean isMapperXmlCover() {
        return mapperXmlCover;
    }

    public void setMapperXmlCover(boolean mapperXmlCover) {
        this.mapperXmlCover = mapperXmlCover;
    }

    public boolean isServiceCreated() {
        return serviceCreated;
    }

    public void setServiceCreated(boolean serviceCreated) {
        this.serviceCreated = serviceCreated;
    }

    public boolean isServiceCover() {
        return serviceCover;
    }

    public void setServiceCover(boolean serviceCover) {
        this.serviceCover = serviceCover;
    }

    public boolean isImplCreated() {
        return implCreated;
    }

    public void setImplCreated(boolean implCreated) {
        this.implCreated = implCreated;
    }

    public boolean isImplCover() {
        return implCover;
    }

    public void setImplCover(boolean implCover) {
        this.implCover = implCover;
    }
}
