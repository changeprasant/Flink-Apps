package org.cep.monitoring.util;

/**
 * 
 * @author PRASANTA
 *
 *         Jun 9, 2019
 *
 */
public class Constants {

	// PRODUCER

	public static final int MAX_DATACENTER_ID = 5;
	public static final int MAX_RACK_ID = 10;
	public static final long PAUSE = 100;
	public static final double TEMPERATURE_RATIO = 0.5;
	public static final double POWER_STD = 10;
	public static final double POWER_MEAN = 100;
	public static final double TEMP_STD = 20;
	public static final double TEMP_MEAN = 80;
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

	// CONSUMER
	public static final String FALSE = "false";
	public static final double TEMPERATURE_THRESHOLD = 50;
	public static final Integer PARALLELISM = 1;
	public static final String TEMPERATURE = "temperature";

	public static final String FIRST = "first";
	public static final String SECOND = "second";
	public static final String RACK_ID = "rackID";
	public static final String RACK_ID_ = "rackID_";
	public static final String WARNING_QUERY = "INSERT INTO stream.tempwarning (rack_id, first_temp, second_temp, avg_temp, date) VALUES (?, ?, ?, ?, ?)";
	public static final String ALERT_QUERY = "INSERT INTO stream.tempalert (rack_id, first_temp, date) VALUES (?, ?, ?)";

	// Kafka properties
	public static final String RECEIVER_TOPIC = "tempEvent";
	public static final String BOOTSTRAP_SERVER = "bootstrap.servers";
	public static final String BROKERS_URL = "localhost:9092";
	public static final String CONSUMERGROUP = "xyz";
	public static final String GROUP_ID = "group.id";
	public static final String ENABLE_AUTO_COMMIT = "enable.auto.commit";
	public static final String AUTO_OFFSET_RESET = "auto.offset.reset";
	public static final String AUTO_OFFSET_VALUE = "latest";
	public static final String PUBLISHER_WARN_TOPIC = "warnEventPublish";
	public static final String PUBLISHER_ALERT_TOPIC = "alertEventPublish";

	// MySQL
	public static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/stream?user=root&password=root";

	// Redis
	public static final String REDIS_HOST = "127.0.0.1";
	public static final int REDIS_PORT = 6379;

	// MongoDB
	public static final String MONGO_HOST = "127.0.0.1";
	public static final String MONGO_PORT = "27017";
	public static final String MONGO_DATABASE = "EVENT";
	public static final String COLLECTION = "warning";

}
