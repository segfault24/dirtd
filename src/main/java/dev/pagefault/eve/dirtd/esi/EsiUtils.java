package dev.pagefault.eve.dirtd.esi;

import java.util.List;

import net.evetech.ApiResponse;

public class EsiUtils {

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

}
