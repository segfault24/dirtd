package dev.pagefault.eve.dirtd.esi;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.evetech.ApiResponse;

public class EsiUtils {

	private static Logger log = LogManager.getLogger();

	public static long esiCalls = 0;
	public static long esiErrors = 0;
	public static long ssoCalls = 0;
	public static long ssoErrors = 0;

	private static volatile int remain = 100;
	private static volatile int reset = 0; // seconds

	public static int extractNumPages(ApiResponse<?> resp) {
		List<String> values = resp.getHeaders().get("X-Pages");
		if (values == null || values.size() == 0) {
			return 1;
		}
		try {
			return Integer.parseInt(values.get(0).trim());
		} catch (NumberFormatException e) {
			return 1;
		}
	}

	public static int extractErrorLimitRemain(ApiResponse<?> resp) {
		List<String> values = resp.getHeaders().get("x-esi-error-limit-remain");
		if (values == null || values.size() == 0) {
			return 50;
		}
		try {
			return Integer.parseInt(values.get(0).trim());
		} catch (NumberFormatException e) {
			return 50;
		}
	}

	public static int extractErrorLimitReset(ApiResponse<?> resp) {
		List<String> values = resp.getHeaders().get("x-esi-error-limit-reset");
		if (values == null || values.size() == 0) {
			return 30;
		}
		try {
			return Integer.parseInt(values.get(0).trim());
		} catch (NumberFormatException e) {
			return 30;
		}
	}

	public static void precall() {
		// if we've been hitting significant errors; enhance calm; sleep this thread for
		// the duration of the previous call's error reset timer (max 60s)
		if (remain <= 20) {
			log.warn("ESI flow warning - precall - error remaining: " + remain + " reset: " + reset);
			try {
				Thread.sleep(Math.min(reset, 60) * 1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void postcall(ApiResponse<?> resp) {
		synchronized (EsiUtils.class) {
			remain = EsiUtils.extractErrorLimitRemain(resp);
			reset = EsiUtils.extractErrorLimitReset(resp);
		}

		// if the error rate is still high, further enhance calm; delay this thread by
		// 5 sec regardless of whether the call was successful
		if (remain <= 20) {
			log.warn("ESI flow warning - postcall - error remaining: " + remain + " reset: " + reset);
			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
			}
		}
	}

}
