/**
 * Copyright(C) 2019 Hangzhou zhaoyunxing Technology Co., Ltd. All rights reserved.
 */
package io.github.sunny.dingtalk;

import com.dingtalk.api.DingTalkClient;
import io.github.sunny.dingtalk.embedded.DingTalkProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoyunxing
 * @date: 2019-12-21 11:47
 */
@Configuration
@ConditionalOnClass(DingTalkClient.class)
@EnableConfigurationProperties({DingTalkProperties.class})
public class DingTalkAutoConfiguration {

}
