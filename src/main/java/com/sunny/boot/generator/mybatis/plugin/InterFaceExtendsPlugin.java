package com.sunny.boot.generator.mybatis.plugin;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.util.StringUtility;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * @author sunny
 * @class: com.sunny.boot.generator.mybatis.plugin.InterFaceExtendsPlugin
 * @date: 2018-06-09 21:22
 * @des: mybatis 插件
 */
public class InterFaceExtendsPlugin extends PluginAdapter {
  private String baseMapper;
  private String baseModel;

  @Override
  public void setProperties(Properties properties) {
    super.setProperties(properties);


    /**
     * 添加baseMapper
     */
    baseMapper = this.properties.getProperty("baseMapper");
    /**
     * 添加baseModel
     */
    baseModel = this.properties.getProperty("baseModel");
  }

  /**
   * 生成的mapper接口能够继承基类方法
   *
   * @param interfaze
   * @param topLevelClass
   * @param introspectedTable
   * @return
   */
  @Override
  public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
                                 IntrospectedTable introspectedTable) {
    // 获取实体类
    FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
    // import接口
    if(!StringUtils.isEmpty(baseMapper)){
      interfaze.addImportedType(new FullyQualifiedJavaType(baseMapper));
      interfaze.addSuperInterface(new FullyQualifiedJavaType(baseMapper + "<" + entityType.getShortName() + ">"));
    }
    // import实体类
    interfaze.addImportedType(entityType);

    return true;
  }

  /**
   * 生产实体
   *
   * @param topLevelClass
   * @param introspectedTable
   * @return
   */
  @Override
  public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
                                               IntrospectedTable introspectedTable) {
    addSerialVersionUID(topLevelClass, introspectedTable);
    // topLevelClass.addImportedType(new FullyQualifiedJavaType(mapper + "<" + entityType.getShortName() + ">"));
    String name = topLevelClass.getFields().get(0).getType().getShortName();
    return super.modelBaseRecordClassGenerated(topLevelClass, introspectedTable);
  }

  /**
   * 生成实体中每个属性
   */
  @Override
  public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
                                            IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {


    return true;
  }

  @Override
  public boolean clientInsertMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {

    return false;
  }

  @Override
  public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
    return false;
  }

  @Override
  public boolean validate(List<String> warnings) {
    return true;
  }

  /**
   * 添加序列号id
   *
   * @param topLevelClass
   * @param introspectedTable
   */
  private void addSerialVersionUID(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    CommentGenerator commentGenerator = context.getCommentGenerator();
    Field field = new Field();
    field.setVisibility(JavaVisibility.PRIVATE);
    field.setType(new FullyQualifiedJavaType("long"));
    field.setStatic(true);
    field.setFinal(true);
    field.setName("serialVersionUID");
    field.setInitializationString("1L");
    commentGenerator.addFieldComment(field, introspectedTable);
    topLevelClass.addField(field);
  }
}
