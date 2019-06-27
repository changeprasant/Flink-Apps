package org.cep.monitoring.connectors;

import java.util.Properties;

import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;
import org.cep.monitoring.util.Constants;

/**
 * 
 * @author PRASANTA
 *
 *         Jun 9, 2019
 *
 */
@SuppressWarnings("deprecation")
public class KafkaConnector {
	public static FlinkKafkaConsumer011<String> createStringConsumer(
			String topic, String borkersUrl, String kafkaGroup) {

		Properties props = new Properties();
		props.setProperty(Constants.BOOTSTRAP_SERVER, borkersUrl);
		props.setProperty(Constants.GROUP_ID, kafkaGroup);
		props.setProperty(Constants.ENABLE_AUTO_COMMIT, Constants.FALSE);
		// props.setProperty(Constants.AUTO_OFFSET_RESET,
		// Constants.AUTO_OFFSET_VALUE);
		FlinkKafkaConsumer011<String> consumer = new FlinkKafkaConsumer011<>(
				topic, new SimpleStringSchema(), props);
		//consumer.setStartFromEarliest();     // start from the earliest record possible
		consumer.setStartFromLatest();       // start from the latest record
		//consumer.setStartFromTimestamp(...); // start from specified epoch timestamp (milliseconds)
		//consumer.setStartFromGroupOffsets(); // the default behaviour
		return consumer;
	}

	public static FlinkKafkaProducer011<String> sinkToKafka(String topic,
			String borkersUrl) {

		FlinkKafkaProducer011<String> producer = new FlinkKafkaProducer011<String>(
				borkersUrl, // broker list
				topic, // target topic
				new SimpleStringSchema()); // serialization schema
		producer.setWriteTimestampToKafka(true);
		return producer;

	}
}
