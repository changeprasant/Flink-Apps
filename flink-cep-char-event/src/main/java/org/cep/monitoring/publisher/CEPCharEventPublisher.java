package org.cep.monitoring.publisher;

import java.util.Properties;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;
import org.cep.monitoring.sources.CharacterEventGenerator;
import org.cep.monitoring.util.Constants;

/**
 * 
 * @author PRASANTA
 *
 *         Jun 9, 2019
 *
 */
public class CEPCharEventPublisher {

	public static final String TOPIC = "charEvent";
	public static void main(String[] args) throws Exception {
		StreamExecutionEnvironment env = StreamExecutionEnvironment
				.getExecutionEnvironment();

		Properties properties = new Properties();
		properties.setProperty(Constants.BOOTSTRAP_SERVER,
				Constants.BROKERS_URL);
		DataStream<String> stream = env
				.addSource(new CharacterEventGenerator());
		stream.addSink(new FlinkKafkaProducer011<>(TOPIC,
				new EventStringSchema(), properties));
		env.execute();
	}
}
