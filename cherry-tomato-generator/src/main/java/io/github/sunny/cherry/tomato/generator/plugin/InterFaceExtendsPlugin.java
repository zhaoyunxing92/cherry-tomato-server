package io.github.sunny.cherry.tomato.generator.plugin;

import io.github.sunny.cherry.tomato.generator.util.StringUtils;
import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Document;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.lang.reflect.Field;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sunny
 * @date: 2018-06-09 21:22
 */
public class InterFaceExtendsPlugin extends PluginAdapter {
    /**
     * 根mapper
     */
    private String baseMapper;
    /**
     * 根model型
     */
    private String baseModel;


    /**
     * 主键类型，默认获取数据库表的第一个字段类型
     */
    private String primaryKeyType;

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
     * {@link TopLevelClass} 这个时候是空的
     *
     * @return true
     */
    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //mapper 文件只生成一次
        if (hasInterfaceMapperFile(introspectedTable.getContext().getJavaClientGeneratorConfiguration().getTargetProject(), interfaze.getType().getPackageName(), interfaze.getType().getShortName())) {
            return false;
        }
        // 清空导入
        interfaze.getImportedTypes().clear();
        // import接口
        if (!StringUtils.isEmpty(baseMapper)) {
            // 获取实体类
            FullyQualifiedJavaType entityType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
            interfaze.addImportedType(new FullyQualifiedJavaType(baseMapper));
            interfaze.addImportedType(new FullyQualifiedJavaType(entityType.getFullyQualifiedName()));
            interfaze.addSuperInterface(new FullyQualifiedJavaType(baseMapper + "<" + entityType.getShortName() + "," + primaryKeyType + ">"));
        }
        /*
          设置接口头
         */
        interfaze.addJavaDocLine("/**");
        interfaze.addJavaDocLine(" * @author " + System.getProperty("user.name", "zhaoyunxing"));
        interfaze.addJavaDocLine(" * @date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        interfaze.addJavaDocLine(" */");

        // import实体类
       // interfaze.addImportedType(entityType);
        //添加 @Repository注解
        interfaze.addAnnotation("@Repository");
        interfaze.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Repository"));
        // mapper 去除方法
        interfaze.getMethods().clear();

        return true;
    }

    /**
     * model类方法
     *
     * @param topLevelClass
     * @param introspectedTable
     * @return true
     */
    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

        if (!StringUtils.isEmpty(baseModel)) {
            topLevelClass.addImportedType("lombok.EqualsAndHashCode");
            topLevelClass.addAnnotation("@EqualsAndHashCode(callSuper = true)");
            topLevelClass.addImportedType(baseModel);
            topLevelClass.setSuperClass(new FullyQualifiedJavaType(baseModel + "<" + primaryKeyType + ">"));
            // 剔除公共的字段
            removeRepeatedFields(topLevelClass);
        }
        // 设置头
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * @author " + System.getProperty("user.name", "zhaoyunxing"));
        topLevelClass.addJavaDocLine(" * @date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        topLevelClass.addJavaDocLine(" */");
        // 获取表第一个字段作为主键类型
        primaryKeyType = topLevelClass.getFields().get(0).getType().getShortName();

        //addSerialVersionUID(topLevelClass, introspectedTable);
        // lombok 设置
        topLevelClass.addImportedType("lombok.Data");

        //topLevelClass.addImportedType("lombok.experimental.Accessors");
        topLevelClass.addAnnotation("@Data");
        // 链式调用导致mybats xml报错
        //topLevelClass.addAnnotation("@Accessors(chain = true)");

        //topLevelClass.addImportedType("lombok.Getter");
        //topLevelClass.addImportedType("lombok.Setter");
        //topLevelClass.addImportedType("lombok.ToString");
        //topLevelClass.addAnnotation("@Getter");
        //topLevelClass.addAnnotation("@Setter");
        //topLevelClass.addAnnotation("@ToString");
        return true;
    }

    //剔除公共的字段 Removed
    private void removeRepeatedFields(TopLevelClass clazz) {
        try {
            Class<?> aClass = Class.forName(baseModel);
            Field[] fields = aClass.getDeclaredFields();

            // 去除重复导入
            //Set<String> types = Stream.of(fields).map(Field::getType).map(Class::getName).collect(Collectors.toSet());
           // clazz.getImportedTypes().removeIf(type -> types.contains(type.getFullyQualifiedName()));
            clazz.getImportedTypes().clear();
            // 去除重复字段
            List<String> fieldNames = Stream.of(fields).map(Field::getName).collect(Collectors.toList());
            clazz.getFields().removeIf(field -> fieldNames.contains(field.getName()));
            // 根据去重后字段再import一次(ImportedType 是set集合自动去重)
            clazz.getFields().forEach(field -> clazz.addImportedType(field.getType()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        return true;
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    /**
     * set
     */
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /**
     * get
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /**
     * 添加序列号id
     *
     * @param topLevelClass
     * @param introspectedTable
     */
    private void addSerialVersionUID(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        CommentGenerator commentGenerator = context.getCommentGenerator();
        org.mybatis.generator.api.dom.java.Field field = new org.mybatis.generator.api.dom.java.Field();
        field.setVisibility(JavaVisibility.PRIVATE);
        field.setType(new FullyQualifiedJavaType("long"));
        field.setStatic(true);
        field.setFinal(true);
        field.setName("serialVersionUID");
        field.setInitializationString("1L");
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
    }

    /**
     * 是否有该文件
     *
     * @param targetProject 项目名称
     * @param targetPackage 包名称
     * @param name          文件名称
     * @return true/false
     */
    private boolean hasInterfaceMapperFile(String targetProject, String targetPackage, String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(targetProject);
        StringTokenizer st = new StringTokenizer(targetPackage, ".");
        while (st.hasMoreTokens()) {
            sb.append(File.separatorChar);
            sb.append(st.nextToken());
        }
        sb.append(File.separatorChar);
        sb.append(name);
        sb.append(".java");
        return new File(sb.toString()).exists();
    }
}
