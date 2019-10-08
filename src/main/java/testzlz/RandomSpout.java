package testzlz;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

import java.util.Map;
import java.util.Random;

/**
 * @Author: zhaolizhi
 * @Date: 2019-09-17 23:12
 */
public class RandomSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;
    private static String[] words = {"Hadoop", "Storm", "Apache", "Linux", "Nginx", "Tomcat", "Spark"};


    @Override
    public void nextTuple() {
        String word = words[new Random().nextInt(words.length)];
        collector.emit(new Values(word));

    }


    @Override
    public void open(Map arg0, TopologyContext arg1, SpoutOutputCollector arg2) {
        this.collector = arg2;
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer arg0) {
        arg0.declare(new Fields("randomstring"));
    }
}

