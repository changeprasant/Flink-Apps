package org.cep.monitoring.sources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.cep.monitoring.util.Constants;

/**
 * 
 * @author PRASANTA
 *
 *         Jun 9, 2019
 *
 */
public class CharacterEventGenerator implements SourceFunction<String> {
	int i = 0;
	private boolean running = true;

	static SimpleDateFormat formatter = new SimpleDateFormat(
			Constants.DATE_FORMAT);
	private static final String DELIMITER = ":";
	private static final Random random = new Random();
	static String[] s = { "a", "b", "c" };

	private static String generateString() {

		Date date1 = new Date(System.currentTimeMillis());
		String date = formatter.format(date1);
		int number = random.nextInt(3);
		return s[number] + "; date- " + date;
	}

	@Override
	public void run(SourceContext<String> sourceContext) throws Exception {

		while (running) {
			// while (i < 40) {
			sourceContext.collect(generateString());
			Thread.sleep(500);
			// i++;
		}

	}

	@Override
	public void cancel() {
		running = false;
	}
}