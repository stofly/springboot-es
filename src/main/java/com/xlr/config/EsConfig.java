package com.xlr.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kingapex on 2018/7/18.
 *
 * @author kingapex
 * @version 1.0
 * @since 7.0.0
 * 2018/7/18
 */
@Configuration
public class EsConfig {

    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;

    @Value("${spring.data.elasticsearch.xpack.security.user:''}")
    private String userPass;

    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String nodes;

    public EsConfig() {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
//        return null;
        System.out.println("init ");
        return new ElasticsearchTemplate(transportClient());
    }


    @Bean
    public TransportClient transportClient() {

        try {
            Settings.Builder settings = Settings.builder().put("cluster.name", clusterName);
            if(!"''".equals(userPass)){
                settings.put("xpack.security.user", userPass);
            }

            TransportClient client = new PreBuiltXPackTransportClient(settings.build());

            Map<String, Integer> nodeMap = parseNodeIpInfo();
            for (Map.Entry<String, Integer> entry : nodeMap.entrySet()) {

                client.addTransportAddress(
                        new InetSocketTransportAddress(InetAddress.getByName(entry.getKey()), entry.getValue()));
            }

            return client;
        }catch (Exception e){

        }
        return null;
    }

    /**
     * 解析节点IP信息,多个节点用逗号隔开,IP和端口用冒号隔开
     *
     * @return
     */
    private Map<String, Integer> parseNodeIpInfo() {
        String[] nodeIpInfoArr = nodes.split(",");
        Map<String, Integer> map = new HashMap<>(nodeIpInfoArr.length);
        for (String ipInfo : nodeIpInfoArr) {
            String[] ipInfoArr = ipInfo.split(":");
            map.put(ipInfoArr[0], Integer.parseInt(ipInfoArr[1]));
        }
        return map;
    }
}
