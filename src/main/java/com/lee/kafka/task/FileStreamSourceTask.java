package com.lee.kafka.task;

import com.lee.kafka.connector.FileStreamSourceConnector;
import org.apache.kafka.connect.data.Schema;
import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author: yz.li
 * @date: 2018/5/10
 */
public class FileStreamSourceTask extends SourceTask {

    private String fileName;
    private String topic;
    private InputStream stream;


    @Override
    public String version() {
        return null;
    }

    @Override
    public void start(Map<String, String> map) {
        fileName = map.get(FileStreamSourceConnector.FILE_CONFIG);
        stream = openOrThrowError(fileName);
        topic = map.get(FileStreamSourceConnector.TOPIC_CONFIG);
    }

    @Override
    public List<SourceRecord> poll() throws InterruptedException {
        /*try {
            ArrayList<SourceRecord> records = new ArrayList<>();
            while (streamValid(stream) && records.isEmpty()) {
                LineAndOffset line = readToNextLine(stream);
                if (line != null) {
                    Map<String, Object> sourcePartition = Collections.singletonMap("filename", fileName);
                    Map<String, Object> sourceOffset = Collections.singletonMap("position", streamOffset);
                    records.add(new SourceRecord(sourcePartition, sourceOffset, topic, Schema.STRING_SCHEMA, line));
                } else {
                    Thread.sleep(1);
                }
            }
            return records;
        } catch (IOException e) {
            // Underlying stream was killed, probably as a result of calling stop. Allow to return
            // null, and driving thread will handle any shutdown if necessary.
        }*/
        return null;
    }

    @Override
    public synchronized void stop() {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream openOrThrowError(String fileName) {
        InputStream is = null;
        try {
            is = new FileInputStream(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return is;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public InputStream getStream() {
        return stream;
    }

    public void setStream(InputStream stream) {
        this.stream = stream;
    }
}