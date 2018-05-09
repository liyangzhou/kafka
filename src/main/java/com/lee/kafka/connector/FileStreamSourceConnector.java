package com.lee.kafka.connector;

import com.lee.kafka.task.FileStreamSourceTask;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yz.li
 * @date: 2018/5/9
 */
public class FileStreamSourceConnector extends SourceConnector {

    private String topic;
    private String fileName;

    public static String FILE_CONFIG;
    public static String TOPIC_CONFIG;

    private static final ConfigDef CONFIG_DEF = new ConfigDef()
            .define(FILE_CONFIG, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "Source filename.")
            .define(TOPIC_CONFIG, ConfigDef.Type.STRING, ConfigDef.Importance.HIGH, "The topic to publish data to");



    @Override
    public String version() {
        return null;
    }

    @Override
    public void start(Map<String, String> map) {
        // The complete version includes error handling as well.
        fileName = map.get(FILE_CONFIG);
        topic = map.get(TOPIC_CONFIG);

    }

    @Override
    public Class<? extends Task> taskClass() {
        return FileStreamSourceTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int i) {
        ArrayList<Map<String, String>> configs = new ArrayList<>();
        // Only one input stream makes sense.
        Map<String, String> config = new HashMap<>();
        if (fileName != null)
            config.put(FILE_CONFIG, fileName);
        config.put(TOPIC_CONFIG, topic);
        configs.add(config);
        return configs;
    }

    @Override
    public void stop() {
        System.out.println("this is stop");

    }

    @Override
    public ConfigDef config() {
        return CONFIG_DEF;
    }


    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}