package org.cep.monitoring.publisher;

import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.TypeExtractor;
import org.apache.flink.streaming.util.serialization.DeserializationSchema;
import org.apache.flink.streaming.util.serialization.SerializationSchema;

/**
 * 
 * @author PRASANTA
 *
 * Jun 9, 2019
 *
 */
@SuppressWarnings("deprecation")
public class EventStringSchema implements DeserializationSchema<String>, SerializationSchema<String> {
	private static final long serialVersionUID = 1L;

	public EventStringSchema() {
	}

	public String deserialize(byte[] message) {
		return new String(message);
	}

	public boolean isEndOfStream(String nextElement) {
		return false;
	}

	public byte[] serialize(String element) {
		return element.getBytes();
	}

	public TypeInformation<String> getProducedType() {
		return TypeExtractor.getForClass(String.class);
	}
}